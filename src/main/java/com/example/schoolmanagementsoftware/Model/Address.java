package com.example.schoolmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "area can't be empty!")
    @Column(columnDefinition = "varchar(50) not null")
    private String area;

    @NotEmpty(message = "street can't be empty!")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;

    @NotNull(message = "building number can't be null!")
    @Column(columnDefinition = "int not null unique")
    private Integer buildingNumber;


    @OneToOne // address >> teacher
    @MapsId //reveive the PK of teacher and make it the PK and FK in address entity or table!
    @JsonIgnore // to avoid the invinity loop
    private Teacher teacher;


}
