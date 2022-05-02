package calculator.commands;

import calculator.constants.ConstantsStandardSettings;
import calculator.core.CommandContext;
import calculator.core.CommandsClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EmptyStackException;
/**
 * Объект -> Команда Минус
 */
public class Minus implements CommandsClass {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final String FINISH=this.getClass().getSimpleName() + ConstantsStandardSettings.FINISH;
    @Override
    public void returnResultCommand(CommandContext context) {
        LOGGER.info(ConstantsStandardSettings.LOGGER_COMMANDS_1);
        try {
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_3);
            if(context.getStack().size()<ConstantsStandardSettings.SIZE_STACK_2)
                throw new EmptyStackException();
            context.getStack().push(context.getStack().pop() - context.getStack().pop());
            LOGGER.info(ConstantsStandardSettings.LOGGER_COMMANDS_2);
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_4);
            System.out.println(FINISH);
        }
        catch (EmptyStackException e){
            LOGGER.error(ConstantsStandardSettings.LOGGER_COMMANDS_ERROR_1);
            System.err.println(ConstantsStandardSettings.ERROR_VALUES_EMPTY);
        }
    }

}
