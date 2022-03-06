package com.company.commands;

import com.company.constants.ConstantsAbsoluteNames;

import java.util.Stack;

/**
 * Объект -> Команда Печать
 */
public class Print extends CommandsClass {
    public Print(String command_name) {
        super(command_name);
    }

    @Override
    public void command(Stack<Double> stack) {
        if (!stack.isEmpty()) System.out.println(stack.peek());
        else{
            final String ERROR=return_command_name() + ": Stack is Empty";
            System.out.println(ERROR);
        }
        final String FINISH="Команда "+return_command_name() + " Успешно выполнена.";
        System.out.println(FINISH);
    }

    @Override
    public String get_nameClass() {
        return get_className();
    }

    static public String get_className() {
        return ConstantsAbsoluteNames.PRINT;
    }
}