package com.cpjc_cs112_miracosta.edu.capstonecs112.Model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

public abstract class Blacksmith implements Serializable, Comparable<Blacksmith> {

    protected static NumberFormat currency = NumberFormat.getCurrencyInstance();
    protected static NumberFormat number = NumberFormat.getCurrencyInstance();
    protected String mModel;
    protected int mPrice;

    @Override
    public int compareTo(Blacksmith other) {
        // Compare name country followers n world
        // Find difference in name, if same 0, else 1
        int modelComp = this.mModel.compareTo(other.mModel);
        if (modelComp != 0) return modelComp;

        int priceComp = Integer.compare(this.mPrice, other.mPrice);
        if (priceComp != 0) return priceComp;

        return 0;
    }

    public Blacksmith(String model, int price) {
        mModel = model;
        mPrice = price;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        mPrice = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blacksmith that = (Blacksmith) o;
        return mPrice == that.mPrice && Objects.equals(mModel, that.mModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mModel, mPrice);
    }
}
