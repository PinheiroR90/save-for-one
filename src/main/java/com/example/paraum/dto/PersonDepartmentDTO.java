package com.example.paraum.dto;


import com.example.paraum.entities.Person;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PersonDepartmentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double salary;
    private DepartmentDTO departmentDTO;

    public PersonDepartmentDTO(){}

    public PersonDepartmentDTO(Long id, String name, Double salary, DepartmentDTO departmentDTO) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departmentDTO = departmentDTO;
    }
    public PersonDepartmentDTO(Person entity) {
        id = entity.getId();
        name = entity.getName();
        salary = entity.getSalary();
        departmentDTO = new DepartmentDTO(entity.getDepartment());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }
}
