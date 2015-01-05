package com.epic.app.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


//http://examples.javacodegeeks.com/enterprise-java/jsf/hello-world-example-with-jsf-2-0/
//http://www.quizful.net/post/jsf2primefaces

@ManagedBean
@SessionScoped
public class MyBean2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
    
    public String myAction() {
		// TODO Auto-generated method stub
    	//login = login + " Hi! Its myAction!";
    	//return "welcome";
//return null;
    	
    	if(login.equals("user") && password.equals("123")){
            return "welcome";
        }else{
            return "loginfailed";
        }
	}

    public String printMsgFromSpring1() {
        return "ERROR 123";
    }
}
