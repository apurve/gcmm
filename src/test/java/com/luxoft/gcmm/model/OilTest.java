package com.luxoft.gcmm.model;


import org.junit.Before;
import org.junit.Test;

public class OilTest {

    private Oil acc = null;
    //private Oil accPremium = null;
    private Oil rew = null;

    @Before
    public void initializeOils() {
        acc = OilFactory.ACC.get();
        //accPremium = OilFactory.ACC.get();
        rew = OilFactory.REW.get();
    }

    @Test
    public void testHashCodeOnSameOils() {
        assert acc.hashCode() == acc.hashCode();
    }

    @Test
    public void testHashCodeOnDifferentOils() {
        assert acc.hashCode() != rew.hashCode();
    }

    /*@Test
    public void testEqualsOnDifferentOilTypes() {
        assert !acc.equals(accPremium);
    }*/

    @Test
    public void testEqualsOnDifferentOils() {
        assert !acc.equals(rew);
    }

}