package org.hdcd.service;

import jdk.nashorn.internal.runtime.ECMAException;
import org.hdcd.domain.Item;

import java.util.List;

public interface ItemService {

    public void regist(Item item) throws Exception;

    public Item read(Integer itemId) throws Exception;

    public void modify(Item item) throws Exception;

    public void remove(Integer itemId) throws Exception;

    public List<Item> list() throws Exception;

    public String getPicture(Integer itemId) throws Exception;

    public List<String> getAttach(Integer itemId) throws Exception;

}
