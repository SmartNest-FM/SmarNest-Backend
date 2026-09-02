package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.model.dto.TranscriptionResponse;
import com.smartnest.SmartNest.service.TranscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TranscriptionController {

    private final TranscriptionService transcriptionService;

    public TranscriptionController(TranscriptionService transcriptionService) {
        this.transcriptionService = transcriptionService;
    }

    @PostMapping("/transcription")
    public ResponseEntity<TranscriptionResponse> transcribe(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(transcriptionService.transcribe(file));
    }
}
