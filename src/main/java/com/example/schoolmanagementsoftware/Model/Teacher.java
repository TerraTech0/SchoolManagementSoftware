package com.example.schoolmanagementsoftware.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "teacher name can't be empty!")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotNull(message = "age can't be null!")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @Email
    @NotEmpty(message = "email can't be empty!")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;

    @NotNull(message = "salary can't be null!")
    @Column(columnDefinition = "int not null")
    private Integer salary;


    @OneToOne( cascade = CascadeType.ALL, mappedBy = "teacher" )//teacher >> address
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")//teacher >> course
    private Set<Course> courses;
}
