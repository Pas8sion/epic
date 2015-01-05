package com.epic.app.controllers;

import org.springframework.context.annotation.Scope;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Pas8sion on 03.01.2015.
 */
@Named
@Scope("session")
public class ItemListMB implements Serializable {

    private static final long serialVersionUID = 2L;

}