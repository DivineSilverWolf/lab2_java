package com.company.commands_maker;

import com.company.commands.CommandsClass;
import com.company.commands.Division;
/**
 * Объект -> Создатель Команды Делить
 */
public class DivisionMaker extends CommandsMaker {
    public DivisionMaker(String command_name) {
        super(command_name);
    }

    @Override
    public CommandsClass commands_maker() {
        return new Division(return_command_name());
    }
}
