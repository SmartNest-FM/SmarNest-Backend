package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.dto.TranscriptionResponse;
import com.smartnest.SmartNest.service.TranscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Map;

@Service
public class TranscriptionServiceImpl implements TranscriptionService {

    private static final Logger logger = LoggerFactory.getLogger(TranscriptionServiceImpl.class);
    private static final String GROQ_TRANSCRIPTION_URL = "https://api.groq.com/openai/v1/audio/transcriptions";
    private static final String WHISPER_MODEL = "whisper-large-v3-turbo";
    private static final String LANGUAGE = "es";

    private final RestTemplate groqRestTemplate;

    @Value("${groq.api.key:}")
    private String groqApiKey;

    public TranscriptionServiceImpl(@Qualifier("groqRestTemplate") RestTemplate groqRestTemplate) {
        this.groqRestTemplate = groqRestTemplate;
    }

    @Override
    public TranscriptionResponse transcribe(MultipartFile file) {
        if (groqApiKey == null || groqApiKey.isBlank()) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Transcription service is not configured.");
        }

        if (file == null || file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Audio file is required.");
        }

        try {
            ResponseEntity<Map> response = groqRestTemplate.exchange(
                    GROQ_TRANSCRIPTION_URL,
                    HttpMethod.POST,
                    buildGroqRequest(file),
                    Map.class
            );

            Map<?, ?> body = response.getBody();
            Object text = body != null ? body.get("text") : null;
            logger.info("Groq transcription completed with status {}", response.getStatusCode());

            return new TranscriptionResponse(text instanceof String ? (String) text : "");
        } catch (HttpStatusCodeException e) {
            logger.warn("Groq transcription request failed with status {}", e.getStatusCode());
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Could not transcribe the audio. Please try again.");
        } catch (ResourceAccessException e) {
            logger.warn("Groq transcription request timed out or could not be reached: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT, "Transcription service timed out. Please try again.");
        } catch (IOException e) {
            logger.warn("Could not read uploaded audio file: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not read the audio file.");
        } catch (RestClientException e) {
            logger.warn("Groq transcription request failed: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Could not transcribe the audio. Please try again.");
        }
    }

    private HttpEntity<MultiValueMap<String, Object>> buildGroqRequest(MultipartFile file) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.setBearerAuth(groqApiKey);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", buildFilePart(file));
        body.add("model", WHISPER_MODEL);
        body.add("language", LANGUAGE);

        return new HttpEntity<>(body, headers);
    }

    private HttpEntity<ByteArrayResource> buildFilePart(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String filename = originalFilename != null && !originalFilename.isBlank() ? originalFilename : "audio.wav";

        ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return filename;
            }
        };

        HttpHeaders partHeaders = new HttpHeaders();
        MediaType contentType = parseMediaType(file.getContentType());
        if (contentType != null) {
            partHeaders.setContentType(contentType);
        }

        return new HttpEntity<>(resource, partHeaders);
    }

    private MediaType parseMediaType(String contentType) {
        if (contentType == null || contentType.isBlank()) {
            return null;
        }

        try {
            return MediaType.parseMediaType(contentType);
        } catch (IllegalArgumentException e) {
            logger.warn("Ignoring invalid uploaded audio content type: {}", contentType);
            return null;
        }
    }
}
