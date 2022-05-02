package calculator.core;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    private static final String LOGGER_START = "start";
    private static final String LOGGER_FINISH = "finish";
    public static void main(String[] args) {
        LOGGER.info(LOGGER_START);
        DataAnalysis rd=new DataAnalysis();
        rd.dataAnalysis(args);
        LOGGER.info(LOGGER_FINISH);
    }
}