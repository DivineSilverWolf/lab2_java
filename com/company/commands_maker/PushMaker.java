package com.company.commands_maker;

import com.company.commands.CommandsClass;
import com.company.commands.Push;
/**
 * Объект -> Создатель Команды Добавить в стек
 */
public class PushMaker extends CommandsMaker {
    public PushMaker(String command_name) {
        super(command_name);
    }

    @Override
    public CommandsClass commands_maker() {
        return new Push(return_command_name());
    }
}
