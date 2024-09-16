package com.fq.restspp.enitity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Street is required")
    @Column(name ="street")
    private String street;

    @NotBlank(message = "City is required")
    @Column(name ="city")
    private String city;

    @NotBlank(message = "State is required")
    @Column(name ="state")
    private String state;

    @NotBlank(message = "Zipcode is required")
    @Pattern(regexp = "\\d{6}", message = "Zipcode should be a 6-digit number")
    @Column(name ="zipcode")
    private String zipcode;
}