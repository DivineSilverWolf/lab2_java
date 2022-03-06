package com.company.commands;

import com.company.constants.ConstantsAbsoluteNames;

import java.util.Stack;
/**
 * Объект -> Команда Умножить
 */
public class Multiplication extends CommandsClass {
    public Multiplication(String command_name) {
        super(command_name);
    }

    @Override
    public void command(Stack<Double> stack) {
        final Integer FOR_OPERATION_VARIABLES=2;
        if (stack.size() >= FOR_OPERATION_VARIABLES) stack.push(stack.pop() * stack.pop());
        final String FINISH="Команда "+return_command_name() + " Успешно выполнена.";
        System.out.println(FINISH);
    }

    @Override
    public String get_nameClass() {
        return get_className();
    }

    static public String get_className() {
        return ConstantsAbsoluteNames.MULTIPLICATION;
    }
}
