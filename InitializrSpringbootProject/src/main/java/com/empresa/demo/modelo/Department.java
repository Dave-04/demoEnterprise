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
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_departments;

    @Column(name = "id_enterprise")
    private int id_enterprise;

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

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    public Department() {
    }

    public Department(int id_departments, int id_enterprise, String created_by, Date created_date, String modified_by, Date modified_date, Boolean status, String description, String name, String phone) {
        this.id_departments = id_departments;
        this.id_enterprise = id_enterprise;
        this.created_by = created_by;
        this.created_date = created_date;
        this.modified_by = modified_by;
        this.modified_date = modified_date;
        this.status = status;
        this.description = description;
        this.name = name;
        this.phone = phone;
    }

    public int getId_departments() {
        return id_departments;
    }

    public void setId_departments(int id_departments) {
        this.id_departments = id_departments;
    }

    public int getId_enterprise() {
        return id_enterprise;
    }

    public void setId_enterprise(int id_enterprise) {
        this.id_enterprise = id_enterprise;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
