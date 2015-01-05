package com.epic.app.dao.impl;

import com.epic.app.dao.ItemDao;
import com.epic.app.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pas8sion on 02.01.2015.
 */
@Repository
public class ItemDaoImpl extends AbstractHibernateDAO<Item> implements ItemDao{
    public ItemDaoImpl() {
        super(Item.class);
    }

    @Override
    public Item getItemByNumber(String number) {
       return get("number", number);
    }

    @Override
    public List<Item> getAllItems() {
        return getAll();
    }

    @Override
    public void addItem(Item item) {
        save(item);
    }
}
