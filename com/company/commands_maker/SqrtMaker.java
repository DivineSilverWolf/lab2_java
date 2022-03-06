package com.company.commands_maker;

import com.company.commands.CommandsClass;
import com.company.commands.Sqrt;
/**
 * Объект -> Создатель Команды Взять корень числа
 */
public class SqrtMaker extends CommandsMaker {
    public SqrtMaker(String command_name) {
        super(command_name);
    }

    @Override
    public CommandsClass commands_maker() {
        return new Sqrt(return_command_name());
    }
}
