package com.cpjc_cs112_miracosta.edu.capstonecs112.model;

import java.io.Serializable;
import java.util.Objects;

public class Soshin extends Blacksmith implements Serializable{
    private String mNotes;

    public Soshin(String model, double price, String notes) {
        super(model, price);
        mNotes = notes;
    }

    public String getNotes() {
        return mNotes;
    }

    public void setNotes(String notes) {
        mNotes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Soshin ohkazan = (Soshin) o;
        return Objects.equals(mNotes, ohkazan.mNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mNotes);
    }

    @Override
    public String toString() {
        return "Soshin{" +
                "Model='" + mModel + '\'' +
                ", Price=" + currency.format(mPrice) +
                ", Notes='" + mNotes + '\'' +
                '}';
    }
}
