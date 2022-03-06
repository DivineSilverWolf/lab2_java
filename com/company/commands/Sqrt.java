package com.company.commands;
import com.company.constants.ConstantsAbsoluteNames;

import java.lang.Math;
import java.util.Stack;
/**
 * Объект -> Команда Взять корень числа
 */
public class Sqrt extends CommandsClass {
    public Sqrt(String command_name) {
        super(command_name);
    }

    @Override
    public void command(Stack<Double> stack) {
        final Double ZERO_FOR_SQRT=0.0;
        if (!stack.isEmpty() && stack.peek() >= ZERO_FOR_SQRT) stack.push(Math.sqrt(stack.pop()));
        else if (!stack.isEmpty() && stack.peek() < ZERO_FOR_SQRT) {
            final String ERROR="Error " + return_command_name() +
                    ":\nкалькулятор не может брать квадратный корень из отрицательных чисел";
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
        return ConstantsAbsoluteNames.SQRT;
    }
}
