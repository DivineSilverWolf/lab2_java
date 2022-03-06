package com.company;

import com.company.commands.CommandsClass;
import com.company.сalculators_choice.*;

import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 */

public class DataAnalysis {
    private TreeMap<String,Double> define = new TreeMap<>();
    private Stack<Double> stack = new Stack<>();
    private HashMap<String, CommandsClass> commands_list=new HashMap<>();


    public void data_analysis(String args[]) {



        CommandsList new_commands_list=new CommandsList();
        commands_list=new_commands_list.return_commands_list();

        final Integer NUMBER_OF_FILES_TO_READ=1;
        if(args.length==NUMBER_OF_FILES_TO_READ){
            FileCalculator file_calculator=new FileCalculator();
            final Integer FIRST_ELEMENT_ARGS=0;
            file_calculator.file_calculator(commands_list,args[FIRST_ELEMENT_ARGS]);
        }
        else if(args.length>NUMBER_OF_FILES_TO_READ){
            final String ERROR_ARGS="args должен содержать один элемент командной строки если вы хотите прочитать файл. Если с консоли, то 0. У вас: " + args.length + " элементов";
            System.out.print(ERROR_ARGS);
        }
        else{
            ConsoleCalculator console_calculator=new ConsoleCalculator();
            console_calculator.console_calculator(commands_list);
        }
    }
}
