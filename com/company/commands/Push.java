package com.company.commands;

import com.company.constants.ConstantsAbsoluteNames;

import java.util.Stack;
import java.util.TreeMap;
/**
 * Объект -> Команда Добавить в стек
 */
public class Push extends CommandsClass {
    @Override
    public void command(Stack<Double> stack) {
    }

    public Push(String command_name) {
        super(command_name);
    }

    @Override
    public void command_push(Stack<Double> stack, TreeMap<String, Double> define, String push_number) {
        if (define.containsKey(push_number)) {
            stack.push(define.get(push_number));
        } else if (isNumeric(push_number))
            stack.push(Double.parseDouble(push_number));
        else {
            final String ERROR="Error " + return_command_name() + ". Возможные причины:\n1.Число слишком большое\n2.Вы используете не обозначенную переменную.";
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
        return ConstantsAbsoluteNames.PUSH;
    }
}
