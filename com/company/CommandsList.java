package com.company;

import com.company.constants.ConstantsStandardSettings;
import com.company.commands.*;
import com.company.commands_maker.*;

import java.util.HashMap;

/**
 * Создание списка объектов исполнителей команд.
 * Также тестируется на правильность в пакете commands_maker, а конкретно:
 * в модуле TestCommandsMakers в методе test_commands_makers()
 */

public class CommandsList {
    private static HashMap<String, CommandsClass> commands_list = new HashMap<>();
    public HashMap<String, CommandsClass> return_commands_list() {
        CommandsMaker[] commands = {
                new PlusMaker(ConstantsStandardSettings.PLUS), new MinusMaker(ConstantsStandardSettings.MINUS), new MultiplicationMaker(ConstantsStandardSettings.MULTIPLICATION),
                new DivisionMaker(ConstantsStandardSettings.DIVISION),
                new SqrtMaker(ConstantsStandardSettings.SQRT), new PrintMaker(ConstantsStandardSettings.PRINT),
                new PopMaker(ConstantsStandardSettings.POP),
                new PushMaker(ConstantsStandardSettings.PUSH), new DefineMaker(ConstantsStandardSettings.DEFINE)
        };
        for (CommandsMaker creator : commands) {
            CommandsClass product = creator.commands_maker();
            commands_list.put(product.return_command_name(), product);
            System.out.println(product.return_command_name());
        }
        return commands_list;
    }
}
