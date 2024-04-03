package com.example.schoolmanagementsoftware.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "fill teacher id!")
    private Integer teacher_id;

    @NotEmpty(message = "fill area!")
    private String area;

    @NotEmpty(message = "fill street!")
    private String street;

    @NotNull(message = "fill building number!")
    private Integer buildingNumber;
}
