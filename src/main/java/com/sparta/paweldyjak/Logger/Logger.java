package com.sparta.paweldyjak.Logger;

import java.io.IOException;
import java.util.logging.*;

/**
 * Logger configure class
 */
public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Sorters Logger");

    /**
     * Calls logger log method.
     * @param level Level of log to be used.
     * @param message Message of log to be printed.
     */
    public static void log(Level level, String message) {
        logger.log(level, message);
    }

    /**
     * Logger configuration, logger level set to ALL, printing to console turned off, setting format, writing all logs into sortManagerLog.log file.
     */
    public static void configLogger() {
        try {
            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(false);
            Handler fileHandler = new FileHandler("src/main/resources/sortManagerLog.log", true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new LoggerFormatter());
            Logger.log(Level.CONFIG, "Logger configuration finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set logger level.
     * @param level Logger level.
     */
    public static void setLoggerLevel(Level level) {
        logger.setLevel(level);
    }


}
