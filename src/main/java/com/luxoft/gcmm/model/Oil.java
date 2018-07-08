package com.luxoft.gcmm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Oil implements Serializable {

    private String id;

    private OilType type;

    private BigDecimal fixedRevenue;

    private BigDecimal variableRevenue;

    private BigDecimal barrelValue;

    public Oil(String id, OilType oilType) {
        super();
        this.id = id;
        this.type = oilType;
        this.fixedRevenue = BigDecimal.ZERO;
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

    public BigDecimal getFixedRevenue() {
        return fixedRevenue;
    }

    public void setFixedRevenue(BigDecimal fixedRevenue) {
        this.fixedRevenue = fixedRevenue;
    }

    public BigDecimal getVariableRevenue() {
        return variableRevenue;
    }

    public void setVariableRevenue(BigDecimal variableRevenue) {
        this.variableRevenue = variableRevenue;
    }

    public BigDecimal getBarrelValue() {
        return barrelValue;
    }

    public void setBarrelValue(BigDecimal barrelValue) {
        this.barrelValue = barrelValue;
    }

}