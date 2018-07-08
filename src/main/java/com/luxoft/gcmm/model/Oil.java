package com.luxoft.gcmm.model;

import java.io.Serializable;
import java.util.Objects;

public class Oil implements Serializable {

    private String id;

    private OilType type;

    private int fixedRevenue;

    private Integer variableRevenue;

    private Integer barrelValue;

    public Oil(String id, OilType oilType) {
        super();
        this.id = id;
        this.type = oilType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oil oil = (Oil) o;
        if(type.equals(oil.getType())) {
            return Objects.equals(id, oil.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OilType getType() {
        return type;
    }

    public void setType(OilType type) {
        this.type = type;
    }

    public int getFixedRevenue() {
        return fixedRevenue;
    }

    public void setFixedRevenue(int fixedRevenue) {
        this.fixedRevenue = fixedRevenue;
    }

    public Integer getVariableRevenue() {
        return variableRevenue;
    }

    public void setVariableRevenue(Integer variableRevenue) {
        this.variableRevenue = variableRevenue;
    }

    public Integer getBarrelValue() {
        return barrelValue;
    }

    public void setBarrelValue(Integer barrelValue) {
        this.barrelValue = barrelValue;
    }

}