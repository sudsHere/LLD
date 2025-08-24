public class DebugLoggingHandler extends LoggingHandler{
    LoggingLevel level;

    DebugLoggingHandler(LoggingHandler nxtHandler){
        super(nxtHandler);
        this.level = LoggingLevel.DEBUG;
    }

    public void Log(LoggingLevel level, String message){
        if(this.level == level){
            System.out.printf("Debug: " + message + "\n");
        } else {
            super.Log(level, message);
        }
    }
}
