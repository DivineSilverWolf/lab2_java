package com.company.сalculators_choice;

import com.company.commands.CommandsClass;
import com.company.commands.Define;
import com.company.commands.Push;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class ConsoleCalculator {
    public void console_calculator(HashMap<String, CommandsClass> commands_list){
        TreeMap<String,Double> define = new TreeMap<>();
        Stack<Double> stack = new Stack<>();
        Scanner scanner_system=new Scanner(System.in);

        final String END_CONSOLE_CALCULATOR="CalcOFF";
        final String HELLO="Вы используете метод класса ConsoleCalculator, если хотите завершить работу напишите "+END_CONSOLE_CALCULATOR;
        System.out.println(HELLO);
        StringBuilder calculator_text=new StringBuilder(scanner_system.next());

        while(!calculator_text.toString().equals(END_CONSOLE_CALCULATOR)){
            if(commands_list.containsKey(calculator_text.toString())){
            if(commands_list.get(calculator_text.toString()).get_nameClass() == Define.get_className()){
                String variable=scanner_system.next(); if(variable.equals(END_CONSOLE_CALCULATOR)) break;
                String value=scanner_system.next(); if(value.equals(END_CONSOLE_CALCULATOR)) break;
                commands_list.get(calculator_text.toString()).command_define(define,variable,value);
            }
            else if(commands_list.get(calculator_text.toString()).get_nameClass() == Push.get_className()){
                String push_number=scanner_system.next(); if(push_number.equals(END_CONSOLE_CALCULATOR)) break;
                commands_list.get(calculator_text.toString()).command_push(stack,define,push_number);
                }
            else commands_list.get(calculator_text.toString()).command(stack);
            }
            else{
                final String ERROR="Command not found";
                System.out.println(ERROR);}

            final Integer BEGINNING=0;
            calculator_text.delete(BEGINNING,calculator_text.length());
            calculator_text.append(scanner_system.next());
        }
        final String FINISH="метод класса ConsoleCalculator успешно завершен.";
        System.out.println(FINISH);
    }
}
