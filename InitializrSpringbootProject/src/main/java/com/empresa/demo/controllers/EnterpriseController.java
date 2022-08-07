/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.demo.controllers;

import com.empresa.demo.exceptions.ResourceNotFoundExceptions;
import com.empresa.demo.modelo.Enterprise;
import com.empresa.demo.repository.EnterpriseRepository;
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
public class EnterpriseController {

    @Autowired
    private EnterpriseRepository repository;
//Listar empresas

    @GetMapping("/enterprise")
    public List<Enterprise> ListEnterprise() {
        return repository.findAll();
    }

    //guardar empresas
    @PostMapping("/enterprise")
    public Enterprise saveEnterprise(@RequestBody Enterprise enterprise) {
        return repository.save(enterprise);
    }

    @GetMapping("/enterprise/{id_enterprise}")
    public ResponseEntity<Enterprise> obtenerEnterprisePorId(@PathVariable int id_enterprise) {
        Enterprise enterprise = repository.findById(id_enterprise)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe la empresa con el ID: " + id_enterprise));
        return ResponseEntity.ok(enterprise);
    }

    @PutMapping("/enterprise/{id_enterprise}")
    public ResponseEntity<Enterprise> actualizarEnterprise(@PathVariable int id_enterprise, @RequestBody Enterprise detalleEnterprise) {
        Enterprise enterprise = repository.findById(id_enterprise)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe la empresa con el ID: " + id_enterprise));
        enterprise.setCreated_by(detalleEnterprise.getCreated_by());
        enterprise.setCreated_date(detalleEnterprise.getCreated_date());
        enterprise.setModified_by(detalleEnterprise.getModified_by());
        enterprise.setModified_date(detalleEnterprise.getModified_date());
        enterprise.setStatus(detalleEnterprise.getStatus());
        enterprise.setAddress(detalleEnterprise.getAddress());
        enterprise.setName(detalleEnterprise.getName());
        enterprise.setPhone(detalleEnterprise.getPhone());

        Enterprise enterpriseActualizado = repository.save(enterprise);
        return ResponseEntity.ok(enterpriseActualizado);
    }

   

}
