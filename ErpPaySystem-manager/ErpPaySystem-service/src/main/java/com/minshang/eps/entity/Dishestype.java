package com.minshang.eps.entity;

public class Dishestype {
    private Integer dishestypeid;

    private String dishestypename;

    public Integer getDishestypeid() {
        return dishestypeid;
    }

    public void setDishestypeid(Integer dishestypeid) {
        this.dishestypeid = dishestypeid;
    }

    public String getDishestypename() {
        return dishestypename;
    }

    public void setDishestypename(String dishestypename) {
        this.dishestypename = dishestypename == null ? null : dishestypename.trim();
    }
}