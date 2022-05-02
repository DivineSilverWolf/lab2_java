package calculator.commands;

import calculator.constants.ConstantsStandardSettings;
import calculator.core.CommandContext;
import calculator.core.CommandsClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EmptyStackException;


/**
 * Объект -> Команда Добавить переменную
 */
public class Define implements CommandsClass {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final String FINISH = this.getClass().getSimpleName() + ConstantsStandardSettings.FINISH;
    private final String ERROR_ELSE = "Error " + this.getClass().getSimpleName() + ". Возможные причины: 1.Не число 2.Не обозначенная переменная. 3.Число слишком большое для преобразования в Double";
    @Override
    public void returnResultCommand(CommandContext context) {
        LOGGER.info(ConstantsStandardSettings.LOGGER_COMMANDS_1);
        try {
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_3);
            if(context.getValues().size()<ConstantsStandardSettings.SIZE_STACK_2)
                throw new EmptyStackException();
            String value = context.getValues().pop();
            String variable = context.getValues().pop();
            if (context.getDefine().containsKey(value))
                context.getDefine().put(variable, context.getDefine().get(value));
            else if (isNumeric(value))
                context.getDefine().put(variable, Double.parseDouble(value));
            else
                throw new Exception(ERROR_ELSE);
            LOGGER.info(ConstantsStandardSettings.LOGGER_COMMANDS_2);
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_4);
            System.out.println(FINISH);
        }
        catch (EmptyStackException e){
            LOGGER.error(ConstantsStandardSettings.LOGGER_COMMANDS_ERROR_1);
            System.err.println(ConstantsStandardSettings.ERROR_VALUES_EMPTY);
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
    }
    final Integer NUMBER_OF_ARGUMENTS_FOR_THE_COMMAND=2;
    @Override
    public Integer returnNumberOfArgumentsForTheCommand(){
        return NUMBER_OF_ARGUMENTS_FOR_THE_COMMAND;
    }
}
