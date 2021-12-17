package com.sparta.paweldyjak.Logger;

import java.io.IOException;
import java.util.logging.*;

public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Sorters Logger");

    public static void log(Level level, String message) {
        logger.log(level, message);
    }

    public static void configLogger() {
        try {
            //remove comments from line below to turn on Logger

            setLoggerLevel(Level.OFF);
            Handler fileHandler = new FileHandler("src/main/java/com/sparta/paweldyjak/sortManagerLog.log", true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new LoggerFormatter());
            Logger.log(Level.FINE, "Logger configuration finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setLoggerLevel(Level level) {
        logger.setLevel(level);
    }


}
