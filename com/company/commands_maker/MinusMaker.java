package com.company.commands_maker;

import com.company.commands.CommandsClass;
import com.company.commands.Minus;
/**
 * Объект -> Создатель Команды Минус
 */
public class MinusMaker extends CommandsMaker {
    public MinusMaker(String command_name) {
        super(command_name);
    }

    @Override
    public CommandsClass commands_maker() {
        return new Minus(return_command_name());
    }
}
