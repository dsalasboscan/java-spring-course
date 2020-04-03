package com.eduit.springbootdata.model.dto;

import java.util.List;

public class CompraDto {

    private List<ItemDto> items;

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
