public class LoggingHandler {
    public static enum LoggingLevel{
        INFO,
        DEBUG,
        ERROR;
    }
    LoggingHandler nxtLoggingHandler;

    public LoggingHandler(LoggingHandler nxtLoggingHandler) {
        this.nxtLoggingHandler = nxtLoggingHandler;
    }

    public void Log(LoggingLevel level, String message) {
        if (this.nxtLoggingHandler != null){
            this.nxtLoggingHandler.Log(level, message);
        }
    }
}
