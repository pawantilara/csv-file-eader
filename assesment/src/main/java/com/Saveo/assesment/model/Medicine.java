package com.Saveo.assesment.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @Column(columnDefinition = "unique_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer c_unique_code;
    @Column(columnDefinition = "name")
    String c_name;
    @Column(columnDefinition = "batch_no")
    String c_batch_no;
    @Column(columnDefinition = "expiry_data")
    String d_expiry_date;
    @Column(columnDefinition = "expiry_qty")
    Integer n_balance_qty;
    @Column(columnDefinition = "packaging")
    String c_packaging;
    @Column(columnDefinition = "schemes")
    String c_schemes;
    @Column(columnDefinition = "mrp")
    Integer n_mrp;
    @Column(columnDefinition = "manufacturer;")
    String c_manufacturer;
    @Column(columnDefinition = "code")
    String hsn_code;
}
