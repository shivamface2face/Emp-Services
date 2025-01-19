package com.cvm.week2.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(
        description = "this will emp pojo class"
)
public class Employee {

    @Id
    @NotNull
    @Schema(
            description = "this will be user id"
    )
    private Long id;
    @Schema(
            description = "this will emp name"
    )
    private String name;
    @Schema(
            description = "this will emp email"
    )
    private String email;

}
