package calculator.core;

import calculator.сalculators_choice.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

/**
 *
 */

public class DataAnalysis {
    private HashMap<String, CommandsClass> commandsList=new HashMap<>();
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final Integer NUMBER_OF_FILES_TO_READ=1;
    private final Integer FIRST_ELEMENT_ARGS=0;
    private final String LOGGER_ARGS="args: ";
    private final String LOGGER_ABOUT_CHECK="проверка количества параметров args";
    private final String ERROR_ARGS="args должен содержать один элемент командной строки если вы хотите прочитать файл. Если с консоли, то 0. \n У вас элементов: ";

    public void dataAnalysis(String args[]) {
        CommandsList newCommandsList = new CommandsList();
        commandsList=newCommandsList.returnCommandsList();
        LOGGER.info(LOGGER_ABOUT_CHECK);
        if(args.length==NUMBER_OF_FILES_TO_READ){
            LOGGER.info(LOGGER_ARGS + args.length);
            FileCalculator file_calculator=new FileCalculator();
            file_calculator.staringFileCalculator(commandsList,args[FIRST_ELEMENT_ARGS]);
        }
        else if(args.length>NUMBER_OF_FILES_TO_READ){
            LOGGER.warn(LOGGER_ARGS + args.length);
            System.out.print(ERROR_ARGS + args.length);
        }
        else{
            LOGGER.info(LOGGER_ARGS + args.length);
            ConsoleCalculator consoleCalculator = new ConsoleCalculator();
            consoleCalculator.startingConsoleCalculator(commandsList);
        }
    }
}
