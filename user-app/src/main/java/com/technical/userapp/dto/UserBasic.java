package com.technical.userapp.dto;

import com.technical.userapp.enumeration.Gender;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * A POJO class.
 */
@Data
public class UserBasic {

    private Long id;

    @NotNull
    private String name;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private String country;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phone;

}
