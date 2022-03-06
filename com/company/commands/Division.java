package com.company.commands;

import com.company.constants.ConstantsAbsoluteNames;

import java.util.Stack;
/**
 * Объект -> Команда Делить
 */
public class Division extends CommandsClass {
    public Division(String command_name) {
        super(command_name);
    }

    @Override
    public void command(Stack<Double> stack) {
        final Integer FOR_OPERATION_VARIABLES=2;
        if (stack.size() >= FOR_OPERATION_VARIABLES) {
            Double numerator = stack.pop();
            final Double ZERO_FOR_DIVISION_P=0.0;
            final Double ZERO_FOR_DIVISION_M=-0.0;
            if (stack.peek().equals(ZERO_FOR_DIVISION_P) || stack.peek().equals(ZERO_FOR_DIVISION_M)) {
                stack.push(numerator);

                final String ERROR="Error " + return_command_name() +
                        ":\nНа 0 делить нельзя";
                System.out.println(ERROR);
                return;
            }
            stack.push(numerator / stack.pop());
        }
        final String FINISH="Команда "+return_command_name() + " Успешно выполнена.";
        System.out.println(FINISH);
    }

    @Override
    public String get_nameClass() {
        return get_className();
    }

    static public String get_className() {
        return ConstantsAbsoluteNames.DIVISION;
    }
}
