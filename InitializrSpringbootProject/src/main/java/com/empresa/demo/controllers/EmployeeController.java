/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.demo.controllers;

import com.empresa.demo.exceptions.ResourceNotFoundExceptions;
import com.empresa.demo.modelo.Employee;

import com.empresa.demo.repository.EmployeeRepository;

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
public class EmployeeController {

@Autowired
    private EmployeeRepository repository;
//Listar empresas

    @GetMapping("/employee")
    public List<Employee> ListEmployee() {
        return repository.findAll();
    }

    //guardar empresas
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @GetMapping("/employee/{id_employee}")
    public ResponseEntity<Employee> obtenerEmployeePorId(@PathVariable int id_employee) {
        Employee employee = repository.findById(id_employee)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe el empleado con el ID: " + id_employee));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employee/{id_employee}")
    public ResponseEntity<Employee> actualizarEmployee(@PathVariable int id_employee, @RequestBody Employee detalleEmployee) {
        Employee employee = repository.findById(id_employee)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe el empleado con el ID: " + id_employee));
        employee.setCreated_by(detalleEmployee.getCreated_by());
        employee.setCreated_date(detalleEmployee.getCreated_date());
        employee.setModified_by(detalleEmployee.getModified_by());
        employee.setModified_date(detalleEmployee.getModified_date());
        employee.setStatus(detalleEmployee.getStatus());
        employee.setAge(detalleEmployee.getAge());
        employee.setEmail(detalleEmployee.getEmail());
        employee.setName(detalleEmployee.getName());
        employee.setPosition(detalleEmployee.getPosition());
        employee.setSurname(detalleEmployee.getSurname());

        Employee employeeActualizado = repository.save(employee);
        return ResponseEntity.ok(employeeActualizado);
    }
    
}
