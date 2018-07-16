package com.luxoft.gcmm.calculators.results;

import com.luxoft.gcmm.model.types.OilID;

import java.math.BigDecimal;
import java.util.EnumMap;

public class InventoryIndexes {

    EnumMap<OilID, BigDecimal> inventoryIndexMap = new EnumMap<OilID, BigDecimal>(OilID.class);

    public InventoryIndexes addInventoryIndexes(EnumMap<OilID, BigDecimal> inventoryIndexMap) {
        this.inventoryIndexMap.clear();
        this.inventoryIndexMap.putAll(inventoryIndexMap);
        return this;
    }

    public EnumMap<OilID, BigDecimal> getInventoryIndexMap() {
        return inventoryIndexMap;
    }

    @Override
    public String toString() {
        return "InventoryIndexes{" +
                "inventoryIndexMap=" + inventoryIndexMap +
                '}';
    }

}