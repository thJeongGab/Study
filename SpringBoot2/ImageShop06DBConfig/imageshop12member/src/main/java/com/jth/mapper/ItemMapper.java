package com.jth.mapper;

import com.jth.domain.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    public void create(Item item) throws Exception;

    public Item read(Integer itemId) throws Exception;

    public void update(Item item) throws Exception;

    public void delete(Integer itemId) throws Exception;

    public List<Item> list() throws Exception;

    public String getPicture(Integer itemId) throws Exception;

    public String getPreview(Integer itemId) throws Exception;

}