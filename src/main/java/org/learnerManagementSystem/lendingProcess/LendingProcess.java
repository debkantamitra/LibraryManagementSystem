package org.learnerManagementSystem.lendingProcess;

public interface LendingProcess {
    void checkoutItem(long productId, long lenderId);
    void returnItem(long productId, long lenderId);
}
