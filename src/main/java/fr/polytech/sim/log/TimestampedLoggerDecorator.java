package fr.polytech.sim.log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampedLoggerDecorator implements Logger {

    private final Logger logger;
    private final SimpleDateFormat dateFormat;

    public TimestampedLoggerDecorator(Logger logger) {
        this.logger = logger;
        this.dateFormat = new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    public void log(String format, Object... args) {
        String message = String.format(format, args);
        String timestamp=dateFormat.format(new Date());
        logger.log("[%s] %s", timestamp, message);
    }
}