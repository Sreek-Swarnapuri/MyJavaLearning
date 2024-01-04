package org.sreek.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassUsingThread implements Runnable {

    private static final Logger logger = LogManager.getLogger(ClassUsingThread.class);
    private int threadNum;

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            logger.info("Executing thread with number - " + threadNum + " at number - " + i);
        }
    }
}
