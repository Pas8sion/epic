package com.epic.app.service;

import com.epic.app.model.Item;

import java.util.List;

/**
 * Created by Pas8sion on 02.01.2015.
 */
public interface ItemService {
    public List<Item> getAllItems();

    public void addItem(Item item);

    public Item getItemByNumber(String number);
    public void removeItem(Item item);
}
