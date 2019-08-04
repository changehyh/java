package com.hyh.controller;


import com.hyh.vo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Handler3 {

    @RequestMapping(value = "/showItemsList.action")
    public ModelAndView showItemsList() {
        List<Items> itemsList = new ArrayList<Items>();
        Items items1 = new Items();
        items1.setItemsId(1);
        items1.setItemsName("arvin");
        items1.setItemsPrice(200);

        Items items2 = new Items();
        items2.setItemsId(2);
        items2.setItemsName("arvin2");
        items2.setItemsPrice(200);
        Items items3 = new Items();
        items3.setItemsId(3);
        items3.setItemsName("arvin3");
        items3.setItemsPrice(200);

        itemsList.add(items1);
        itemsList.add(items2);
        itemsList.add(items3);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsListKey", itemsList);
        modelAndView.setViewName("showItemList");
        return modelAndView;
    }
}
