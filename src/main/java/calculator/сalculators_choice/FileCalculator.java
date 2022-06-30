package calculator.сalculators_choice;

import calculator.core.CommandContext;
import calculator.core.CommandsClass;
import calculator.commands.Define;
import calculator.commands.Push;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

import static calculator.constants.ConstantsCalculatorChoice.*;

public class FileCalculator {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final String FINISH = "метод класса FileCalculator успешно завершен.";
    private final String ERROR_COMMAND = "Запрос аргументов превысил лимит слов тестового файла";

    private final Integer STARTER_READER=0;
    private final String FOR_SPLIT_METHOD = " ";
    private final String LOGGER_START="start file calculator processing";
    private final String LOGGER_SUCCESS_1="создание данных успешно завершено";
    private final String LOGGER_SUCCESS_2="анализ успешно завершен";
    private final String LOGGER_ERROR_ANALYSIS="!ошибка анализа!";
    public void staringFileCalculator(HashMap<String, CommandsClass> commandsList,String fileInArgs){
        LOGGER.info(LOGGER_START);

        LOGGER.warn(LOGGER_CREATION);
        TreeMap<String,Double> define = new TreeMap<>();
        Stack<Double> stack = new Stack<>();
        ReaderСalculatorFile read = new ReaderСalculatorFile();

        Scanner scannerFilesNames=new Scanner(fileInArgs);
        String[] calculatorWords;
        calculatorWords=read.reading(scannerFilesNames).split(FOR_SPLIT_METHOD);
        scannerFilesNames.close();

        CommandContext context = new CommandContext();
        context.setStack(stack);
        context.setDefine(define);
        Stack<String> values = new Stack<>();
        context.setValues(values);
        LOGGER.info(LOGGER_SUCCESS_1);
        LOGGER.warn(LOGGER_RUNNER_ANALYSIS);
        try {
            for (int i = STARTER_READER; i < calculatorWords.length; i++) {
                if (commandsList.containsKey(calculatorWords[i])) {
                    LOGGER.info(COMMAND_YES_LOG);
                    int flagCommand = i;
                    for (int j = STARTER_COUNTING_ARGUMENTS; j < commandsList.get(calculatorWords[flagCommand]).returnNumberOfArgumentsForTheCommand(); j++) {
                        if (calculatorWords.length <= ++i)
                            throw new Exception(ERROR_COMMAND);
                        values.push(calculatorWords[i]);
                    }
                    commandsList.get(calculatorWords[flagCommand]).returnResultCommand(context);
                } else {
                    LOGGER.info(COMMAND_NOT_LOG);
                    System.out.println(NOT_FOUND);
                }
            }
            LOGGER.info(LOGGER_SUCCESS_2);
            System.out.println(FINISH);
        }
        catch (Exception e){
            LOGGER.error(LOGGER_ERROR_ANALYSIS);
            e.printStackTrace(System.err);
        }
    }
}
