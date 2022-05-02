package calculator.сalculators_choice;
import calculator.commands.Define;
import calculator.core.CommandContext;
import calculator.core.CommandsClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

import static calculator.constants.ConstantsCalculatorChoice.*;

public class ConsoleCalculator {

    private final String ERROR_FINISH = "метод класса ConsoleCalculator успешно завершен.";
    private final int BEGINNING = 0;
    private final String END_CONSOLE_CALCULATOR = "CalcOFF";
    private final String HELLO = "Вы используете метод класса ConsoleCalculator, если хотите завершить работу напишите " + END_CONSOLE_CALCULATOR;


    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final String LOGGER_START="start console calculator processing";
    private final String LOGGER_FINISH="принудительное завершение работы по требованию пользователя";
    private final String LOGGER_ERROR_E="ошибка e: ";

    public void startingConsoleCalculator(HashMap<String, CommandsClass> commandsList) {
        LOGGER.info(LOGGER_START);
        LOGGER.warn(LOGGER_CREATION);
        TreeMap<String, Double> define = new TreeMap<>();
        Stack<Double> stack = new Stack<>();
        Scanner scannerSystem = new Scanner(System.in);


        CommandContext context = new CommandContext();
        context.setStack(stack);
        context.setDefine(define);
        Stack<String> values = new Stack<>();
        context.setValues(values);
        LOGGER.info(LOGGER_SUCCESS_1);
        LOGGER.warn(LOGGER_RUNNER_ANALYSIS);
        try {
            System.out.println(HELLO);
            StringBuilder calculatorText = new StringBuilder(scannerSystem.next());
            while (!calculatorText.toString().equals(END_CONSOLE_CALCULATOR)) {
                if (commandsList.containsKey(calculatorText.toString())) {
                    LOGGER.info(COMMAND_YES_LOG);
                    for (int i = STARTER_COUNTING_ARGUMENTS; i < commandsList.get(calculatorText.toString()).returnNumberOfArgumentsForTheCommand(); i++) {
                        values.push(scannerSystem.next());
                        if(values.peek().equals(END_CONSOLE_CALCULATOR))
                            throw new Exception(ERROR_FINISH);
                    }
                    commandsList.get(calculatorText.toString()).returnResultCommand(context);
                }
                else {
                    LOGGER.info(COMMAND_NOT_LOG);
                    System.out.println(NOT_FOUND);
                }

                calculatorText.delete(BEGINNING, calculatorText.length());
                calculatorText.append(scannerSystem.next());
            }
            System.out.println(ERROR_FINISH);;
            LOGGER.info(LOGGER_SUCCESS_2);
        }
        catch (Exception e){
            LOGGER.error(LOGGER_FINISH);
            LOGGER.error(LOGGER_ERROR_E+e);
            e.printStackTrace(System.err);
        }
    }
}

