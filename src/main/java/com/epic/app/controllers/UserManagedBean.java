package com.epic.app.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by Pas8sion on 03.01.2015.
 */
@ManagedBean//(name="userMB")
@RequestScoped
public class UserManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private int id = 1987;
    private String name = "Mr";
    private String surname = "Luch";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

}