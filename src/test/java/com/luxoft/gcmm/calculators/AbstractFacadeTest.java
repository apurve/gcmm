package com.luxoft.gcmm.calculators;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractFacadeTest {

    GCMMOperationsFacade gcmmOperationsFacade;

    @Before
    public void initialize() {
        gcmmOperationsFacade = new GCMMOperationsFacade();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFacadeWhenGCMMOperationNull(){
        gcmmOperationsFacade.calculate(null,null, null);
    }

    @Test
    public abstract void testFacadeWithValidInput() throws InterruptedException;

}
