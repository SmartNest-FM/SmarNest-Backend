package com.smartnest.SmartNest.service.impl;

import com.smartnest.SmartNest.model.dto.AiEvaluateRequest;
import com.smartnest.SmartNest.model.dto.AiEvaluateResponse;
import com.smartnest.SmartNest.service.AiEvaluationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AiEvaluationServiceImpl implements AiEvaluationService {

    private final RestTemplate restTemplate;

    @Value("${ai.service.url:http://localhost:8000}")
    private String aiServiceUrl;

    public AiEvaluationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public AiEvaluateResponse evaluate(AiEvaluateRequest request) {
        String url = aiServiceUrl + "/evaluate";

        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> raw = restTemplate.postForObject(url, request, Map.class);

            if (raw == null) {
                return buildFallback("El servicio de IA no respondió. Intenta de nuevo.");
            }

            String verdict = (String) raw.get("verdict");
            String message = (String) raw.get("message");

            @SuppressWarnings("unchecked")
            Map<String, Object> scoresMap = (Map<String, Object>) raw.get("scores");

            AiEvaluateResponse response = new AiEvaluateResponse();
            response.setVerdict(verdict != null ? verdict : "wrong");
            response.setMessage(message != null ? message : "Intentemos de nuevo.");

            if (scoresMap != null) {
                AiEvaluateResponse.ScoresDto scores = new AiEvaluateResponse.ScoresDto();
                scores.setSemantic(toDouble(scoresMap.get("semantic")));
                scores.setLexical(toDouble(scoresMap.get("lexical")));
                scores.setPhonetic(toDouble(scoresMap.get("phonetic")));
                scores.setFinalScore(toDouble(scoresMap.get("final")));
                response.setScores(scores);
            }

            // Puntaje según veredicto
            if ("correct".equals(verdict)) {
                response.setScorePercentage(100);
            } else if ("partial".equals(verdict)) {
                response.setScorePercentage(60);
            } else {
                response.setScorePercentage(0);
            }

            return response;

        } catch (RestClientException e) {
            return buildFallback("No se pudo conectar con el servicio de IA. Intenta de nuevo.");
        }
    }

    private double toDouble(Object value) {
        if (value instanceof Number) return ((Number) value).doubleValue();
        return 0.0;
    }

    private AiEvaluateResponse buildFallback(String message) {
        AiEvaluateResponse fallback = new AiEvaluateResponse();
        fallback.setVerdict("wrong");
        fallback.setMessage(message);
        fallback.setScorePercentage(0);
        return fallback;
    }
}
