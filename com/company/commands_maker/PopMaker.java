package com.company.commands_maker;

import com.company.commands.CommandsClass;
import com.company.commands.Pop;
/**
 * Объект -> Создатель Команды Убрать из стека
 */
public class PopMaker extends CommandsMaker {
    public PopMaker(String command_name) {
        super(command_name);
    }

    @Override
    public CommandsClass commands_maker() {
        return new Pop(return_command_name());
    }
}
