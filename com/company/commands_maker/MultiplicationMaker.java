package com.company.commands_maker;

import com.company.commands.CommandsClass;
import com.company.commands.Multiplication;
/**
 * Объект -> Создатель Команды Умножить
 */
public class MultiplicationMaker extends CommandsMaker {
    public MultiplicationMaker(String command_name) {
        super(command_name);
    }

    @Override
    public CommandsClass commands_maker() {
        return new Multiplication(return_command_name());
    }
}
