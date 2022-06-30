package calculator.commands;
import calculator.constants.ConstantsStandardSettings;
import calculator.core.CommandContext;
import calculator.core.CommandsClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.Math;
import java.util.EmptyStackException;

/**
 * Объект -> Команда Взять корень числа
 */
public class Sqrt implements CommandsClass {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final String FINISH = this.getClass().getSimpleName() + ConstantsStandardSettings.FINISH;
    private final String ERROR_MINUS="Exception: ";
    private final Double ZERO = 0.0;
    @Override
    public void returnResultCommand(CommandContext context) {
        LOGGER.info(ConstantsStandardSettings.LOGGER_COMMANDS_1);
        try {
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_3);
            if(context.getStack().peek()<ZERO)
                throw new IllegalArgumentException();
            context.getStack().push(Math.sqrt(context.getStack().pop()));
            LOGGER.info(ConstantsStandardSettings.LOGGER_COMMANDS_2);
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_4);
            System.out.println(FINISH);
        }
        catch (EmptyStackException e){
            LOGGER.error(ConstantsStandardSettings.LOGGER_COMMANDS_ERROR_1);
            System.err.println(ConstantsStandardSettings.ERROR_VALUES_EMPTY);
        } catch (IllegalArgumentException e){
            System.err.println(ERROR_MINUS + e);
        }
    }

}
