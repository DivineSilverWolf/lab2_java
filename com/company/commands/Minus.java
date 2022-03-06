package com.company.commands;

import com.company.constants.ConstantsAbsoluteNames;

import java.util.Stack;
/**
 * Объект -> Команда Минус
 */
public class Minus extends CommandsClass {
    public Minus(String command_name) {
        super(command_name);
    }

    @Override
    public void command(Stack<Double> stack) {
        final Integer FOR_OPERATION_VARIABLES=2;
        if (stack.size() >= FOR_OPERATION_VARIABLES) stack.push(stack.pop() - stack.pop());
        final String FINISH="Команда "+return_command_name() + " Успешно выполнена.";
        System.out.println(FINISH);
    }

    @Override
    public String get_nameClass() {
        return get_className();
    }

    static public String get_className() {
        return ConstantsAbsoluteNames.MINUS;
    }
}
