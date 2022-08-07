/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.demo.controllers;

import com.empresa.demo.exceptions.ResourceNotFoundExceptions;
import com.empresa.demo.modelo.Department;
import com.empresa.demo.repository.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Desarrollo
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;

    @GetMapping("/department")
    public List<Department> ListDepartment() {
        return repository.findAll();
    }

    //guardar empresas
    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department) {
        return repository.save(department);
    }

    @GetMapping("/department/{id_department}")
    public ResponseEntity<Department> obtenerDepartmentPorId(@PathVariable int id_department) {
        Department department = repository.findById(id_department)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe el departamento con el ID: " + id_department));
        return ResponseEntity.ok(department);
    }

    @PutMapping("/department/{id_department}")
    public ResponseEntity<Department> actualizarDepartment(@PathVariable int id_department, @RequestBody Department detalleDepartment) {
        Department department = repository.findById(id_department)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe el departamento con el ID: " + id_department));
        department.setId_enterprise(detalleDepartment.getId_enterprise());
        department.setCreated_by(detalleDepartment.getCreated_by());
        department.setCreated_date(detalleDepartment.getCreated_date());
        department.setModified_by(detalleDepartment.getModified_by());
        department.setModified_date(detalleDepartment.getModified_date());
        department.setStatus(detalleDepartment.getStatus());
        department.setDescription(detalleDepartment.getDescription());
        department.setName(detalleDepartment.getName());
        department.setPhone(detalleDepartment.getPhone());

        Department departmentActualizado = repository.save(department);
        return ResponseEntity.ok(departmentActualizado);
    }

}
