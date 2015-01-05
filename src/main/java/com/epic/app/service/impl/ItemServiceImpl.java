package com.epic.app.service.impl;

import com.epic.app.dao.ItemDao;
import com.epic.app.model.Item;
import com.epic.app.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Pas8sion on 02.01.2015.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Inject
    private ItemDao itemDao;

    @Override
    public List<Item> getAllItems() {
       return itemDao.getAllItems();
    }

    @Transactional(readOnly = false)
    @Override
    public void addItem(Item item) {
        itemDao.addItem(item);
    }
}
