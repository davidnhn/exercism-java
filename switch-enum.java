public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42),
    UNKNOWN(0);

    private final int codeLevel;

    LogLevel(int codeLevel) {
        this.codeLevel = codeLevel;
    }
    int getCodeLevel() {
        return this.codeLevel;
    }
    
}


public class LogLine {
    String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        
        String code = logLine.substring(1,4);
        LogLevel level = switch(code) {
            case  "TRC" -> LogLevel.TRACE;
            case  "DBG" -> LogLevel.DEBUG;
            case  "INF" -> LogLevel.INFO;
            case  "WRN" -> LogLevel.WARNING;
            case  "ERR" -> LogLevel.ERROR;
            case  "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        } ;

        return level;
    }

    public String getOutputForShortLog() {
         int codeLevel = this.getLogLevel().getCodeLevel();
         int index = logLine.indexOf(": ");
         String message = logLine.substring(index +2);
        return codeLevel + ":" + message;
    }
}
