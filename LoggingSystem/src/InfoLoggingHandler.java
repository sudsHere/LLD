public class InfoLoggingHandler extends LoggingHandler{
    LoggingLevel level;

    InfoLoggingHandler(LoggingHandler nxtHandler) {
        super(nxtHandler);
        level = LoggingLevel.INFO;
    }

    public void Log(LoggingLevel level, String message){
        if(this.level == level){
            System.out.printf("Info: " + message + "\n");
        } else {
            super.Log(level, message);
        }
    }
}
