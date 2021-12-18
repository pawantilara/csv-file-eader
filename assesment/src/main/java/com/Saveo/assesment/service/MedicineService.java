package com.Saveo.assesment.service;

import com.Saveo.assesment.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface MedicineService {
    ResponseEntity<Response> uploadCSVFile(MultipartFile file);
    Object getMedicineDetails(Integer id);
}
