package com.example.paraum.services;

import com.example.paraum.dto.PersonDTO;
import com.example.paraum.dto.PersonDepartmentDTO;
import com.example.paraum.entities.Department;
import com.example.paraum.entities.Person;
import com.example.paraum.repositories.DepartmentRepository;
import com.example.paraum.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public  List<PersonDepartmentDTO> getAllPerson(){
        List<Person> person = personRepository.findAll();
        return person.stream().map(PersonDepartmentDTO::new).toList();
    }
    public PersonDepartmentDTO insert(PersonDepartmentDTO dto){
        Person entity = new Person();
        copyDtoForEntity(dto,entity);
        Department dep = departmentRepository.
                  getReferenceById(dto.getDepartmentDTO().getId());
        entity.setDepartment(dep);

        entity = personRepository.save(entity);
        return new PersonDepartmentDTO(entity);
    }

    public PersonDTO insert(PersonDTO dto){
        Person entity = new Person();
        copyDtoForEntity(dto,entity);

        Department dep = departmentRepository.getReferenceById(dto.getDepartmentId());
        entity.setDepartment(dep);

        entity = personRepository.save(entity);
        return  new PersonDTO(entity);
    }

    public void copyDtoForEntity(PersonDepartmentDTO dto, Person entity){
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
    }
    public void copyDtoForEntity(PersonDTO dto, Person entity){
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
    }
}
