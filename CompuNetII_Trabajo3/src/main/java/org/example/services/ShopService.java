package org.example.services;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShopService {
    private ArrayList<String> shoplist = new ArrayList<>();

    public void addItem(String item) {
        shoplist.add(item);
    }

    public ArrayList<String> getItems() {
        return shoplist;
    }

}