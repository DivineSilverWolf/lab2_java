package com.company.commands;
import org.junit.Test;
import org.junit.Assert;

import java.util.Stack;
import java.util.TreeMap;

public class TestCommands {
    @Test
    public void test_command_Define() throws Exception{
        CommandsClass define_command=new Define("DEFINE");
        TreeMap<String,Double> define=new TreeMap<>();
        define_command.command_define(define,"a","8");
        define_command.command_define(define,"b","a");
        define_command.command_define(define,"bs","as");
        TreeMap<String,Double> expected=new TreeMap<>();
        expected.put("a",8.0);
        expected.put("b",8.0);

        System.out.println(define_command.return_command_name()+" TEST");
        Assert.assertEquals(expected,define);
    }
    @Test
    public void test_command_Division() throws  Exception{
        CommandsClass division_command=new Division("DIVISION");
        Stack stack=new Stack();
        stack.push(0.0);
        stack.push(2.0);
        stack.push(6.0);
        division_command.command(stack);
        division_command.command(stack);

        Stack expected=new Stack();
        expected.push(0.0);
        expected.push(3.0);

        System.out.println(division_command.return_command_name()+" TEST");
        Assert.assertEquals(expected,stack);
    }
    @Test
    public void test_command_Minus() throws Exception{
        CommandsClass minus_command=new Minus("-");
        Stack stack=new Stack();
        stack.push(3.0);
        stack.push(2.0);
        minus_command.command(stack);
        minus_command.command(stack);

        Stack expected=new Stack();
        expected.push(-1.0);

        System.out.println(minus_command.return_command_name()+" TEST");
        Assert.assertEquals(expected,stack);
    }
    @Test
    public void test_command_Multiplication() throws Exception{
        CommandsClass multiplication_command=new Multiplication("*");
        Stack stack=new Stack();
        stack.push(3.0);
        stack.push(-2.0);
        multiplication_command.command(stack);
        multiplication_command.command(stack);

        Stack expected=new Stack();
        expected.push(-6.0);

        System.out.println(multiplication_command.return_command_name()+" TEST");
        Assert.assertEquals(expected,stack);
    }
    @Test
    public void test_command_Plus() throws Exception{
        CommandsClass plus_command=new Plus("+");
        Stack stack=new Stack();
        stack.push(1.0);
        stack.push(-2.0);
        plus_command.command(stack);
        plus_command.command(stack);

        Stack expected=new Stack();
        expected.push(-1.0);

        System.out.println(plus_command.return_command_name()+" TEST");
        Assert.assertEquals(expected,stack);
    }
    @Test
    public void test_command_Pop() throws Exception{
        CommandsClass pop_command=new Pop("POP");
        Stack stack=new Stack();
        stack.push(1.0);
        pop_command.command(stack);
        pop_command.command(stack);

        Stack expected=new Stack();

        System.out.println(pop_command.return_command_name()+" TEST");
        Assert.assertEquals(expected,stack);
    }
    @Test
    public void test_command_Print() throws Exception{
        CommandsClass print_command=new Print("PRINT");
        Stack stack=new Stack();
        stack.push(1.0);
        print_command.command(stack);

        Stack expected=new Stack();
        expected.push(1.0);

        System.out.println(print_command.return_command_name()+" TEST");
        Assert.assertEquals(expected,stack);
    }
    @Test
    public void test_command_Push() throws Exception{
        CommandsClass push_command=new Push("PUSH");
        TreeMap<String,Double> define=new TreeMap<>();
        define.put("a",2.0);
        Stack stack=new Stack();
        push_command.command_push(stack,define,"1");
        push_command.command_push(stack,define,"b");
        push_command.command_push(stack,define,"a");
        Stack expected=new Stack();
        expected.push(1.0);
        expected.push(2.0);

        System.out.println(push_command.return_command_name()+" TEST");
        Assert.assertEquals(expected,stack);
    }
    @Test
    public void test_command_Sqrt() throws Exception{
        CommandsClass sqrt_command=new Sqrt("SQRT");
        Stack stack=new Stack();
        stack.push(4.0);
        sqrt_command.command(stack);
        stack.push(-1.0);
        sqrt_command.command(stack);

        Stack expected=new Stack();
        expected.push(2.0);
        expected.push(-1.0);

        System.out.println(sqrt_command.return_command_name()+" TEST");
        Assert.assertEquals(expected,stack);
    }
}
