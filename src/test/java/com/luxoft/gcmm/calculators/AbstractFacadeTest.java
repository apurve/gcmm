package com.luxoft.gcmm.calculators;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractFacadeTest {

    protected GCMMOperationsFacade gcmmOperationsFacade;

    @Before
    public void initialize() {
        gcmmOperationsFacade = new GCMMOperationsFacade();
    }

    @Test
    public abstract void testFacadeWithValidInput() throws InterruptedException;

}
