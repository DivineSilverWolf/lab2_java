package com.company.commands_maker;

import com.company.commands.CommandsClass;
import com.company.commands.Define;
/**
 * Объект -> Создатель Команды Добавить переменную
 */
public class DefineMaker extends CommandsMaker {
    public DefineMaker(String command_name) {
        super(command_name);
    }

    @Override
    public CommandsClass commands_maker() {
        return new Define(return_command_name());
    }
}
