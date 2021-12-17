package com.sparta.paweldyjak.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Logger formatter class
 */
public class LoggerFormatter extends Formatter {
    /**
     *
     * @param record Logger data.
     * @return Logger format: date, log level and message.
     */
    @Override
    public String format(LogRecord record) {
        return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))
                + " " + record.getLevel() + " " + record.getMessage() + "\n";
    }
}
