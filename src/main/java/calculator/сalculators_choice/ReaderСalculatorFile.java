package calculator.сalculators_choice;

import calculator.constants.ConstantsStandardSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Предназначен для модуля FileCalculator в методе file_calculator
 */

public class ReaderСalculatorFile {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final String ERROR_NOT_FOUND="Error while reading file: ";
    private final String SPACE=" ";
    private final char COMMENTS='#';
    private final Integer COMMENT_ELEMENT=0;
    private final String LOGGER_START="запуск считывания";
    private final String LOGGER_READER_START="запуск считывания";
    private final String LOGGER_READER_FILE="считывание файла для пользователя";
    private final String LOGGER_READER_ARGV="считывание аргумента argv для открытия файла";
    private final String LOGGER_FINAL="чтение успешно завершено";
    private final String ERROR_LOGGER="!ошибка чтения или открытия файла!";

    public String reading(java.util.Scanner scannerFilesNames){
        StringBuilder fileText = new StringBuilder();

        LOGGER.warn(LOGGER_READER_ARGV);
        String fileName=scannerFilesNames.next();

        LOGGER.info(LOGGER_READER_FILE);
        LOGGER.warn(LOGGER_START);
        try(BufferedReader read =  new BufferedReader(new FileReader(fileName))){
            LOGGER.warn(LOGGER_READER_START);
            String string = read.readLine();
            while (string != null) {
                if(string.charAt(COMMENT_ELEMENT)!=COMMENTS)
                    fileText.append(string+SPACE);
                string = read.readLine();
            }
            System.out.print(fileText);
            LOGGER.info(LOGGER_FINAL);
            LOGGER.warn(ConstantsStandardSettings.LOGGER_COMMANDS_4);
        }
        catch (IOException e) {
            LOGGER.fatal(ERROR_LOGGER);
            System.err.println(ERROR_NOT_FOUND + e.getLocalizedMessage());
        }
        return fileText.toString();
            }
}
