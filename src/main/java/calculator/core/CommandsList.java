package calculator.core;

import calculator.constants.ConstantsStandardSettings;
import calculator.core.CommandsClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Создание списка объектов исполнителей команд.
 * Также тестируется на правильность в пакете commands_maker, а конкретно:
 * в модуле TestCommandsMakers в методе test_commands_makers()
 */

public class CommandsList {
    private static final int BEGIN_OF_LINE =0;
    private static final int STRING_TAIL=1;
    private static final char SPACE = ' ';
    private static final String FILE_NAME="..\\lab2Java\\src\\main\\java\\calculator\\core\\CommandsList.txt";

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final String LOGGER_READER="считывание файла для списка команд";
    private final String LOGGER_OPEN="открытие файла";
    private final String LOGGER_STARTER="запуск считывания";
    private final String LOGGER_END="чтение успешно завершено";
    private final String LOGGER_ERROR_1="!ошибка создания классов,чтения или открытия файла!";
    private final String LOGGER_ERROR_2="более подробная информация: ";
    HashMap<String, CommandsClass> returnCommandsList() {
        HashMap<String, CommandsClass> commandsList = new HashMap<>();
        LOGGER.info(LOGGER_READER);
        LOGGER.warn(LOGGER_OPEN);
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            LOGGER.warn(LOGGER_STARTER);
            String string = reader.readLine();
            while (string != null) {
                String key = string.substring(BEGIN_OF_LINE, string.indexOf(SPACE));
                string = string.substring(string.indexOf(SPACE) + STRING_TAIL);
                Class<?> myClass = Class.forName(string);
                CommandsClass command = (CommandsClass) myClass.getDeclaredConstructor().newInstance();

                commandsList.put(key, command);
                string = reader.readLine();
            }
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_4);
            LOGGER.info(LOGGER_END);
        } catch (IOException | NoSuchMethodException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            LOGGER.fatal(LOGGER_ERROR_1);
            LOGGER.fatal(LOGGER_ERROR_2 + e);
            e.printStackTrace();
        }
        finally {
            return commandsList;
        }
    }
}
