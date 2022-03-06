package com.company.commands_maker;

import com.company.constants.ConstantsStandardSettings;
import com.company.CommandsList;
import com.company.commands.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TestCommandsMakers {
    @Test
    public void test_commands_makers() throws Exception{
        CommandsList CommandsList = new CommandsList();
        HashMap<String, CommandsClass> commands_list = CommandsList.return_commands_list();
        String[] expected = new String[]{Plus.get_className(),Minus.get_className(),Multiplication.get_className(),
        Division.get_className(),Sqrt.get_className(),Print.get_className(),
                Pop.get_className(),Push.get_className(),Define.get_className()
        };


        String[] commands_array=new String[]{commands_list.get(ConstantsStandardSettings.PLUS).get_nameClass(),commands_list.get(ConstantsStandardSettings.MINUS).get_nameClass(),
                commands_list.get(ConstantsStandardSettings.MULTIPLICATION).get_nameClass(), commands_list.get(ConstantsStandardSettings.DIVISION).get_nameClass(),
                commands_list.get(ConstantsStandardSettings.SQRT).get_nameClass(),commands_list.get(ConstantsStandardSettings.PRINT).get_nameClass(),
                commands_list.get(ConstantsStandardSettings.POP).get_nameClass(),commands_list.get(ConstantsStandardSettings.PUSH).get_nameClass(),
                commands_list.get(ConstantsStandardSettings.DEFINE).get_nameClass()};

        System.out.println("COMMANDS TEST");
        Assert.assertArrayEquals(expected,commands_array);
    }
}
