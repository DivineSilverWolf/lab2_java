package com.company.commands_maker;

import com.company.commands.CommandsClass;
import com.company.commands.Print;

/**
 * Объект -> Создатель Команды Печать
 */

public class PrintMaker extends CommandsMaker {
    public PrintMaker(String command_name) {
        super(command_name);
    }

    @Override
    public CommandsClass commands_maker() {
        return new Print(return_command_name());
    }
}
