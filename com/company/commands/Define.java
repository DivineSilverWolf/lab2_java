package com.company.commands;

import com.company.constants.ConstantsAbsoluteNames;

import java.util.Stack;
import java.util.TreeMap;

/**
 * Объект -> Команда Добавить переменную
 */
public class Define extends CommandsClass {
    @Override
    public void command(Stack<Double> stack) {
    }

    public Define(String command_name) {
        super(command_name);
    }

    @Override
    public void command_define(TreeMap<String, Double> define, String variable, String value) {
        if (define.containsKey(value))
            define.put(variable, define.get(value));
        else if (isNumeric(value))
            define.put(variable, Double.parseDouble(value));
        else {
            final String ERROR="Error " + return_command_name() + ". Возможные причины:\n1.Число слишком большое\n2.Вы используете не обозначенную переменную.";
            System.out.println(ERROR);
            return;
        }
        final String FINISH="Команда "+return_command_name() + " Успешно выполнена.";
        System.out.println(FINISH);
    }

    @Override
    public String get_nameClass() {
        return get_className();
    }

    static public String get_className() {
        return ConstantsAbsoluteNames.DEFINE;
    }
}
