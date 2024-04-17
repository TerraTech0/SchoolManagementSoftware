package com.example.schoolmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.transaction.reactive.GenericReactiveTransaction;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can't be emtpy!")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "age can't be null!")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "major can't be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String major;


    //ManyToMany >> many courses to many students!
    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Course> courses;
}
