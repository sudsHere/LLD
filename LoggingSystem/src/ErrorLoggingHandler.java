public class ErrorLoggingHandler extends LoggingHandler{
    LoggingLevel level;

    ErrorLoggingHandler(LoggingHandler nxtHandler){
        super(nxtHandler);
        level = LoggingLevel.ERROR;
    }

    public void Log(LoggingLevel level, String message){
        if (this.level == level){
            System.out.printf("Error: " + message + "\n");
        } else {
            super.Log(level, message);
        }
    }
}
