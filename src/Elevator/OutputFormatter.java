package Elevator;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Created by Prit on 10/29/14.
 */
public class OutputFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return record.getMessage()+"\n";
    }
}
