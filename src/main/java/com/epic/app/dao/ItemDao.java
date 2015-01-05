package com.epic.app.dao;

import com.epic.app.model.Item;

import java.util.List;

/**
 * Created by Pas8sion on 02.01.2015.
 */
public interface ItemDao extends BasicCrudDao<Item>{

    public Item getItemByNumber(String number);
    public List<Item> getAllItems();

    public void addItem(Item item);

}
