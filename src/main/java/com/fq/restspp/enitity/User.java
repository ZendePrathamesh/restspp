package com.fq.restspp.enitity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(name ="name")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age should not less than 18")
    @Max(value = 60, message = "Age should not greater than 60")
    @Column(name ="age")
    private Integer age;

    @NotBlank(message = "Email is required")
    @Email(message =  "Email is invalid")
    @Column(name ="email")
    private String email;
}
