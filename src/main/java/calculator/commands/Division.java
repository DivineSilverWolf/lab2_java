package calculator.commands;

import calculator.constants.ConstantsStandardSettings;
import calculator.core.CommandContext;
import calculator.core.CommandsClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EmptyStackException;
import java.util.Stack;


/**
 * Объект -> Команда Делить
 */
public class Division implements CommandsClass {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final Double ZERO_FOR_DIVISION_P=0.0;
    private final Double ZERO_FOR_DIVISION_M=-0.0;
    private final String FINISH=this.getClass().getSimpleName() + ConstantsStandardSettings.FINISH;
    private final String ERROR_DIVISION_ZERO="Can't divide by zero";
    @Override
    public void returnResultCommand(CommandContext context) {
        LOGGER.info(ConstantsStandardSettings.LOGGER_COMMANDS_1);
        try {
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_3);
            Double numerator = context.getStack().pop();
            if (context.getStack().peek().equals(ZERO_FOR_DIVISION_P) || context.getStack().peek().equals(ZERO_FOR_DIVISION_M)) {
                context.getStack().push(numerator);
                throw new ArithmeticException(ERROR_DIVISION_ZERO);
            }
            context.getStack().push(numerator / context.getStack().pop());
            LOGGER.info(ConstantsStandardSettings.LOGGER_COMMANDS_2);
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_4);
            System.out.println(FINISH);
        }
        catch (EmptyStackException e){
            LOGGER.error(ConstantsStandardSettings.LOGGER_COMMANDS_ERROR_1);
            System.err.println(ConstantsStandardSettings.ERROR_VALUES_EMPTY);
        } catch (ArithmeticException e){
            LOGGER.error(e);
            e.printStackTrace();
        }
    }
}
