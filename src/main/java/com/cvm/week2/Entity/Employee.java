package com.cvm.week2.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "week2")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @NotNull
    private Long id;
    @NotNull
    @Min(2)
    @Max(10)
    private String name;
    @Email
    private String email;

}
