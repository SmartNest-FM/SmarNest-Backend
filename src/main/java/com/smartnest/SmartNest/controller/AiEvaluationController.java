package com.smartnest.SmartNest.controller;

import com.smartnest.SmartNest.model.dto.AiEvaluateRequest;
import com.smartnest.SmartNest.model.dto.AiEvaluateResponse;
import com.smartnest.SmartNest.service.AiEvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AiEvaluationController {

    private final AiEvaluationService aiEvaluationService;

    public AiEvaluationController(AiEvaluationService aiEvaluationService) {
        this.aiEvaluationService = aiEvaluationService;
    }

    /**
     * POST /ai/evaluate
     *
     * Body: { "answer": "...", "expected": "...", "activityType": "phonology" }
     * Responde: { "verdict": "correct|partial|wrong", "message": "...", "scorePercentage": 0|60|100, "scores": {...} }
     */
    @PostMapping("/evaluate")
    public ResponseEntity<AiEvaluateResponse> evaluate(@RequestBody AiEvaluateRequest request) {
        AiEvaluateResponse response = aiEvaluationService.evaluate(request);
        return ResponseEntity.ok(response);
    }
}
