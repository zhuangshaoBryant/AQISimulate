package com.zhuang.jackyli.aqysimulate.bean;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
    private static final long serialVersionUID = 1l;
    public List<Card> cards;
    public PageBase base;

    public List<Card> getCards() {
        return cards;
    }

    public PageBase getBase() {
        return base;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setBase(PageBase base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Page{" +
                "cards=" + cards +
                ", base=" + base +
                '}';
    }
}