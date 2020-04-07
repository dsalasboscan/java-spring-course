package com.eduit.springbootdata.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CompraDto {

    @JsonProperty("articulos")
    private List<ItemDto> items;

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
