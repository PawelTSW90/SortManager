package com.sparta.paweldyjak.Logger;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Sorters Logger");

    public static void log(Level level, String message){
        logger.log(level, message);
    }
    public static void configLogger(){
        try {
            setLoggerLevel(Level.ALL);
            Handler fileHandler = new FileHandler("src/main/java/com/sparta/paweldyjak/sorters/myLog.log", true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new LoggerFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setLoggerLevel(Level level){
        logger.setLevel(level);
    }
}
