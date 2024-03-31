package com.example.paraum.dto;

import com.example.paraum.entities.Department;

public class DepartmentDTO {
    private Long id;
    private String name;
    private DepartmentDTO departmentDTO;

    public DepartmentDTO(Long id, String name, DepartmentDTO departmentDTO) {
        this.id = id;
        this.name = name;
        this.departmentDTO = departmentDTO;
    }
    public DepartmentDTO(Department entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
