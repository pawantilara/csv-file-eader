package com.Saveo.assesment.service.impl;

import com.Saveo.assesment.helper.CSVHelper;
import com.Saveo.assesment.model.Medicine;
import com.Saveo.assesment.model.Response;
//import com.Saveo.assesment.repository.MedicineRepository;
import com.Saveo.assesment.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class MedicineServiceServiceImpl implements MedicineService {
//    @Autowired
//    MedicineRepository medicineRepository;

    @Override
    public ResponseEntity<Response> uploadCSVFile(MultipartFile file) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                List<Medicine> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
//                medicineRepository.saveAll(tutorials);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new Response(message, true));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Response(message, false));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(message, false));
    }
    @Override
    public  Object getMedicineDetails(Integer id) {
        try {
            Medicine medicine = new Medicine();//medicineRepository.getById(id);
            return medicine;
        }catch (Exception e) {
            return  new ResponseEntity<Response>(new Response("id does not exit ", false), HttpStatus.BAD_REQUEST);
        }
//        return null;

    }
}
