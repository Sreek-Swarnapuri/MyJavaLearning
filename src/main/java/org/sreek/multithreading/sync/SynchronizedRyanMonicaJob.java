package org.sreek.multithreading.sync;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SynchronizedRyanMonicaJob extends RyanMonicaJob{

    private static final Logger logger = LogManager.getLogger(RyanMonicaJob.class);

    @Override
    protected synchronized void makeWithdrawal(int amount, int threadSleepTime) {
        super.makeWithdrawal(amount, threadSleepTime);
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            makeWithdrawal(30,500);
            if (bankAccount.getBalance() < 0)
                logger.info("Overdrawn!!");
        }
    }

    public static void main(String[] args) {
        SynchronizedRyanMonicaJob job = new SynchronizedRyanMonicaJob();

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
