package com.company.сalculators_choice;

import com.company.commands.CommandsClass;
import com.company.commands.Define;
import com.company.commands.Push;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class FileCalculator {
    public void file_calculator(HashMap<String, CommandsClass> commands_list,String file_in_args){
        TreeMap<String,Double> define = new TreeMap<>();
        Stack<Double> stack = new Stack<>();
        ReadСalculatorFile read = new ReadСalculatorFile();

        Scanner scanner_files_names=new Scanner(file_in_args);
        read.reading(scanner_files_names);
        scanner_files_names.close();
        String[] calculator_words;
        calculator_words=read.give_file_text().split(" ");

        final Integer START=0;
        for(int i=START; i<calculator_words.length; i++){
            if(commands_list.containsKey(calculator_words[i])){
                if(commands_list.get(calculator_words[i]).get_nameClass() == Define.get_className()){
                    final Integer END_STRING_EXAMINATION=2;
                    if(i+END_STRING_EXAMINATION!=calculator_words.length)
                        commands_list.get(calculator_words[i]).command_define(define,calculator_words[++i],calculator_words[++i]);
                    else{
                        final String ERROR="Error "+commands_list.get(calculator_words[i]).return_command_name()+":не до конца заполнили данные";
                        System.out.println(ERROR);
                    }
                }
                else if(commands_list.get(calculator_words[i]).get_nameClass() == Push.get_className()){
                    final Integer END_STRING_EXAMINATION=1;
                    if(i+END_STRING_EXAMINATION!=calculator_words.length)
                        commands_list.get(calculator_words[i]).command_push(stack,define,calculator_words[++i]);
                    else{
                        final String ERROR="Error "+commands_list.get(calculator_words[i]).return_command_name()+":не до конца заполнили данные";
                        System.out.println(ERROR);
                    }
                }
                else commands_list.get(calculator_words[i]).command(stack);
            }
            else{
                final String ERROR="Command not found";
                System.out.println(ERROR);
            }
        }
    }
}
