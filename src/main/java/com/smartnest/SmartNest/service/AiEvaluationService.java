package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.dto.AiEvaluateRequest;
import com.smartnest.SmartNest.model.dto.AiEvaluateResponse;

public interface AiEvaluationService {

    /**
     * Envía la respuesta del niño al servicio Python de IA y retorna
     * el veredicto (correct / partial / wrong), mensaje pedagógico y puntuación.
     */
    AiEvaluateResponse evaluate(AiEvaluateRequest request);
}
