package com.smartnest.SmartNest.service;

import com.smartnest.SmartNest.model.dto.TranscriptionResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TranscriptionService {

    TranscriptionResponse transcribe(MultipartFile file);
}
