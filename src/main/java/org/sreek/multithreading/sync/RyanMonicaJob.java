package org.sreek.multithreading.sync;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RyanMonicaJob implements Runnable{

    private static final Logger logger = LogManager.getLogger(RyanMonicaJob.class);

    // Only one instance of the account shared between Ryan and Monica to demonstrate concurrency issue in accessing a common data between multiple threads.
    protected final BankAccount bankAccount = new BankAccount();

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            makeWithdrawal(30,100);
            if (bankAccount.getBalance() < 0)
                logger.info("Overdrawn!!");
        }
    }

    protected void makeWithdrawal(int amount, int threadSleepTime) {
        String threadName = Thread.currentThread().getName();
        if(bankAccount.getBalance() > amount) {
            logger.info(threadName + " is about to withdraw. Amount to Withdraw: " + amount+ ".Current balance: " + bankAccount.getBalance());
            try {
                logger.info(threadName + " is going to sleep");
                Thread.sleep(threadSleepTime);
            } catch (InterruptedException exception) {
                logger.error(exception);
            }
            logger.info(threadName + " has woke up. Current balance: " + bankAccount.getBalance());
            bankAccount.withdraw(amount);
            logger.info(threadName + " completes the withdrawal. New balance: " + bankAccount.getBalance());
        } else {
            logger.info("Sorry, not enough for " + threadName + ". Balance: " + bankAccount.getBalance());
        }
    }

    public static void main(String[] args) {
        RyanMonicaJob job = new RyanMonicaJob();

        Thread one = new Thread(job);
        Thread two = new Thread(job);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();

        /**
         * At some point below logs would come up where Monica or Ryan would have overdrawn as they are not sure other person is withdrawing.
         * 07:36:16.688 [Monica] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Monica is about to withdraw. Amount to Withdraw: 30.Current balance: 40
         * 07:36:16.688 [Monica] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Monica is going to sleep
         * 07:36:16.688 [Ryan] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Ryan is about to withdraw. Amount to Withdraw: 30.Current balance: 40
         * 07:36:16.689 [Ryan] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Ryan is going to sleep
         * 07:36:16.796 [Ryan] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Ryan has woke up. Current balance: 40
         * 07:36:16.796 [Monica] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Monica has woke up. Current balance: 40
         * 07:36:16.796 [Ryan] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Ryan completes the withdrawal. New balance: 10
         * 07:36:16.796 [Monica] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Monica completes the withdrawal. New balance: -20
         * 07:36:16.796 [Ryan] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Overdrawn!!
         * 07:36:16.796 [Monica] INFO  org.sreek.multithreading.sync.RyanMonicaJob - Overdrawn!!
         */

    }

}
