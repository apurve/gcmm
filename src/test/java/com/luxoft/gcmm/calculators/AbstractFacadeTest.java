package com.luxoft.gcmm.calculators;

import com.luxoft.gcmm.model.Transactions;
import com.luxoft.gcmm.testutils.TransactionDataHelper;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractFacadeTest {

    public GCMMOperationsFacade gcmmOperationsFacade;


    @Before
    public void initialize() throws InterruptedException {
        gcmmOperationsFacade = new GCMMOperationsFacade();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFacadeWhenGCMMOperationNull(){
        gcmmOperationsFacade.calculate(null,null, null);
    }

    @Test
    public abstract void testFacadeWithValidInput() throws InterruptedException;

}
