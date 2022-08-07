/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.demo.controllers;

import com.empresa.demo.exceptions.ResourceNotFoundExceptions;
import com.empresa.demo.modelo.DepartEmploy;
import com.empresa.demo.repository.DepartEmployRepository;
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
public class DepartEmployController {

    @Autowired
    private DepartEmployRepository repository;

    @GetMapping("/departEmploy")
    public List<DepartEmploy> ListDepartEmploy() {
        return repository.findAll();
    }

    //guardar empresas
    @PostMapping("/departEmploy")
    public DepartEmploy saveDepartEmploy(@RequestBody DepartEmploy departEmploy) {
        return repository.save(departEmploy);
    }

    @GetMapping("/departEmploy/{id_departEmploy}")
    public ResponseEntity<DepartEmploy> obtenerDepartEmployPorId(@PathVariable int id_departEmploy) {
        DepartEmploy departEmploy = repository.findById(id_departEmploy)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe registro con el ID: " + id_departEmploy));
        return ResponseEntity.ok(departEmploy);
    }

    @PutMapping("/departEmploy/{id_departEmploy}")
    public ResponseEntity<DepartEmploy> actualizarDepartEmploy(@PathVariable int id_departEmploy, @RequestBody DepartEmploy detalleDepartEmploy) {
        DepartEmploy departEmploy = repository.findById(id_departEmploy)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe registro con el ID: " + id_departEmploy));
        departEmploy.setId_departments(detalleDepartEmploy.getId_departments());
        departEmploy.setId_employees(detalleDepartEmploy.getId_employees());
        departEmploy.setCreated_by(detalleDepartEmploy.getCreated_by());
        departEmploy.setCreated_date(detalleDepartEmploy.getCreated_date());
        departEmploy.setModified_by(detalleDepartEmploy.getModified_by());
        departEmploy.setModified_date(detalleDepartEmploy.getModified_date());
        departEmploy.setStatus(detalleDepartEmploy.getStatus());

        DepartEmploy departEmployActualizado = repository.save(departEmploy);
        return ResponseEntity.ok(departEmployActualizado);
    }
    
}
