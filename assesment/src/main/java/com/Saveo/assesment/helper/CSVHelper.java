package com.Saveo.assesment.helper;

import com.Saveo.assesment.model.Medicine;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id", "Title", "Description", "Published" };

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Medicine> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Medicine> medicines = new ArrayList<Medicine>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                Medicine medicine = Medicine.builder().c_batch_no(csvRecord.get("c_name")).c_manufacturer(csvRecord.get("c_manufacturer")).
                        c_packaging(csvRecord.get("c_packaging")).c_schemes(csvRecord.get("c_schemes")).
                        d_expiry_date(csvRecord.get("d_expiry_date")).hsn_code(csvRecord.get("hsn_code")).
                        n_balance_qty(Integer.parseInt(csvRecord.get("n_balance_qty"))).n_mrp(Integer.parseInt(csvRecord.get("n_mrp"))).
                        build();

                medicines.add(medicine);
            }

            return medicines;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
