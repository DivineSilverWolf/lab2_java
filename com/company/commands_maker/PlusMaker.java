package com.company.commands_maker;

import com.company.commands.CommandsClass;
import com.company.commands.Plus;
/**
 * Объект -> Создатель Команды Плюс
 */
public class PlusMaker extends CommandsMaker {
    public PlusMaker(String command_name) {
        super(command_name);
    }

    @Override
    public CommandsClass commands_maker() {
        return new Plus(return_command_name());
    }
}
