package com.Saveo.assesment.controller;

import com.Saveo.assesment.model.Response;
import com.Saveo.assesment.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @PostMapping("/uploadCSV")
    public ResponseEntity<Response> uploadCSVFile(@RequestParam("file") MultipartFile file) {
        return medicineService.uploadCSVFile(file);
    }
    @GetMapping("/getMedicineDetails/{id}")
    public Object getMedicineDetails(@PathVariable(value = "id") Integer id) {
    return medicineService.getMedicineDetails(id);
    }
    @GetMapping("/")
    public String hello() {
        return  "hi there";
    }
}
