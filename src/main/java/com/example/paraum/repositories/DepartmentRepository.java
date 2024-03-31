package com.example.paraum.repositories;

import com.example.paraum.entities.Department;
import com.example.paraum.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
