/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.empresa.demo.repository;

import com.empresa.demo.modelo.DepartEmploy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Desarrollo
 */
@Repository
public interface DepartEmployRepository extends JpaRepository<DepartEmploy,Integer>{
    
}
