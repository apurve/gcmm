package com.luxoft.gcmm.model;


import com.luxoft.gcmm.model.types.OilID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OilTest {

    private Oil acc = null;
    private Oil rew = null;

    @Before
    public void initializeOils() {
        acc = OilID.ACC.getOil();
        rew = OilID.REW.getOil();
    }

    @Test
    public void testHashCodeOnSameOils() {
        Assert.assertEquals(acc.hashCode(), acc.hashCode());
    }

    @Test
    public void testHashCodeOnDifferentOils() {
        Assert.assertNotEquals(acc.hashCode() , rew.hashCode());
    }

    @Test
    public void testEqualsOnDifferentOils() {
        Assert.assertFalse(acc.equals(rew));
    }

}