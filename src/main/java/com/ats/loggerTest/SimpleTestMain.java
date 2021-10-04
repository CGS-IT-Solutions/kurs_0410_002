package com.ats.loggerTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleTestMain {

    private static final Logger logger = LogManager.getLogger(SimpleTestMain.class);

    public static void main(String[] args) {
        logger.debug("Hello from Log4j 2");
        logger.error("Hello form Log4J 2 - ERROR Log");
    }

    public static String echo(String input ) {
        logger.debug("Hello from Log4j 2");
        return input;

    }

}
