package com.luxoft.gcmm.integration;

import com.luxoft.gcmm.calculators.AbstractFacadeTest;
import com.luxoft.gcmm.calculators.GCMMOperations;
import com.luxoft.gcmm.model.Transaction;
import com.luxoft.gcmm.testutils.TransactionDataHelper;

import java.math.BigDecimal;
import java.util.List;

public class IntegrationTest extends AbstractFacadeTest {

    @Override
    public void testFacadeWithValidInput() throws InterruptedException {
        System.out.println(gcmmOperationsFacade.calculate(GCMMOperations.COMPUTE_REVENUE_YIELD, BigDecimal.valueOf(100), null));
        System.out.println(gcmmOperationsFacade.calculate(GCMMOperations.COMPUTE_PRICE_EARNING_RATIO, BigDecimal.valueOf(100), null));

        List<Transaction> transactionList = TransactionDataHelper.getFiveDummyTransactions();
        transactionList.forEach(transaction -> {
            gcmmOperationsFacade.calculate(GCMMOperations.TRANSACT, null, transaction);
        });

        System.out.println(gcmmOperationsFacade.calculate(GCMMOperations.COMPUTE_VOLUME_WEIGHTED_PRICE, null, null));
        System.out.println(gcmmOperationsFacade.calculate(GCMMOperations.COMPUTE_INVENTORY_INDEX, null, null));
    }

}
