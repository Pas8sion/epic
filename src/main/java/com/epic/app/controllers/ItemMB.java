package com.epic.app.controllers;

import javax.inject.Inject;
import javax.inject.Named;

import com.epic.app.model.Item;
import com.epic.app.service.ItemService;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;


/**
 * Created by Pas8sion on 02.01.2015.
 */

//@ManagedBean
//@SessionScoped
@Named
@Scope("session")
public class ItemMB implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    @Inject
    private ItemService itemService;

    private String number;
    private String content;

    public ItemService getItemService() {
        return itemService;
    }

    public String addItem() {
        System.out.println(getContent());

        try {
            Item item = new Item();

            item.setNumber(getNumber());
            item.setContent(getContent());
            //item.setContent("тесповый");
            getItemService().addItem(item);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }


    public void reset() {
        this.setNumber("");
        this.setContent("");
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
