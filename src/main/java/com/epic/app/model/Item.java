package com.epic.app.model;

import javax.persistence.*;

/**
 * Created by Pas8sion on 02.01.2015.
 */

@Entity
//@Table
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String number;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Item() {
    }
    public Item(String number, String content) {
        this.number = number;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
