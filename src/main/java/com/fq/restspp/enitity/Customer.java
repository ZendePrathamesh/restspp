package com.fq.restspp.enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is required")
  @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters.")
  private String name;

  @Email(message = "Email should be valid.")
  @NotBlank(message = "Email is required")
  private String email;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Product> products;
}
