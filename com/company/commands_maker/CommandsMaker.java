package com.company.commands_maker;

import com.company.commands.*;

/**
 * Совет: просмотреть сначала класс CommandsClass в пакете commands.
 * CommandsMaker является образцом для создателей команд. Состоит из:
 * command_name -> имя продукта, который создаёт(т.е. имя команды).
 * CommandsMaker -> Образец конструктора, который принимает имя будущего продукта
 * (Если вы просмотрели CommandsClass и решили, что вам не нужно название
 * (или вы хотите как-то менять его содержание),
 * уберите конструктор CommandsMaker(в том числе конструкторы и у наследников)
 * и command_name, а так же в классах наследниках в методе commands_maker, а именно
 * в конструкторе убрать return_command_name())
 *
 * Так же CommandsMaker содержит метод, который
 * возвращает имя будущего продукта -> return_command_name()(сделано для наследников)
 */

public abstract class CommandsMaker {
    private String command_name;
    CommandsMaker(String command_name){this.command_name=command_name;}
    public abstract CommandsClass commands_maker();
    public String return_command_name(){
        return command_name;
    }
}

