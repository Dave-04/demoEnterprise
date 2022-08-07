/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.empresa.demo.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Desarrollo
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_employees;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "created_date")
    //@Temporal(TemporalType.DATE)
    private Date created_date;
    //private String created_date;

    @Column(name = "modified_by")
    private String modified_by;

    @Column(name = "modified_date")
    private Date modified_date;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    @Column(name = "surname")
    private String surname;

    public Employee() {
    }

    public Employee(int id_employees, String created_by, Date created_date, String modified_by, Date modified_date, Boolean status, int age, String email, String name, String position, String surname) {
        this.id_employees = id_employees;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modified_by = modified_by;
        this.modified_date = modified_date;
        this.status = status;
        this.age = age;
        this.email = email;
        this.name = name;
        this.position = position;
        this.surname = surname;
    }

    public int getId_employees() {
        return id_employees;
    }

    public void setId_employees(int id_employees) {
        this.id_employees = id_employees;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
