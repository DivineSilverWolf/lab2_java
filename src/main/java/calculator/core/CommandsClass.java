package calculator.core;

import calculator.constants.ConstantsStandardSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  Это класс-стандарт для всех команд
 *  Используется для задания характеристик всех производных от него команд.
*/

public interface CommandsClass{
    Logger LOGGER = LogManager.getLogger(CommandsClass.class.getName());
    String ERROR_COMMAND = "Command not found";
    default void returnResultCommand(CommandContext context){
        System.out.println(ERROR_COMMAND);
    };

    /**
     * Метод позволяющий проверить является ли строка числом. Полезно на данный момент только
     * для Define и Push.
     */
    String LOGGER_CHECK="проверка parseDouble(значение)";
    default boolean isNumeric(String numeric) throws NumberFormatException {
        LOGGER.info(LOGGER_CHECK);
            try {
                Double.parseDouble(numeric);
                return true;
            }
            catch (NumberFormatException e) {
                return false;
            }
    }
    String LOGGER_OUTPUT="вывод количества аргументов";
    default Integer returnNumberOfArgumentsForTheCommand(){
        LOGGER.info(LOGGER_OUTPUT);
        return ConstantsStandardSettings.NUMBER_OF_ARGUMENTS_FOR_THE_COMMAND;
    }
}