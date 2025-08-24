//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LoggingHandler handler = new ErrorLoggingHandler(new DebugLoggingHandler(new InfoLoggingHandler(null)));

        handler.Log(LoggingHandler.LoggingLevel.INFO, "this is information");
        handler.Log(LoggingHandler.LoggingLevel.DEBUG, "this is debug");
        handler.Log(LoggingHandler.LoggingLevel.ERROR, "this is error");
    }
}