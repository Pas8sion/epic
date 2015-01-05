package com.epic.app.controllers;

import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Pas8sion on 03.01.2015.
 */
@Named
@Scope("request")
public class IndexMB implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }




    public String myAction()  {

      /*  Item item = new Item();

        item.setNumber("125");
        item.setContent("test conyetn 123");
        itemService.addItem(item);*/

    //TODO
        //разобраться с логином/паролем.
        // по правам пользоватеья перенаправлять на струницу админа или юзера

    return "adminPage";
    }
}
