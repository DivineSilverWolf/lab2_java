import calculator.commands.*;
import calculator.core.CommandContext;
import calculator.core.CommandsClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;

import java.util.Stack;
import java.util.TreeMap;

public class TestCommands {
    static private final Logger LOGGER = LogManager.getLogger(TestCommands.class.getName());
    private final String LOGGER_TEST="TEST";

    private final String DEFINE_a="a";
    private final String DEFINE_8_STR="8";
    private final String DEFINE_b="b";
    private final String DEFINE_bs="bs";
    private final String DEFINE_as="as";
    private final double DEFINE_8_DOUBLE=8.0;


    @Test
    public void testCommandDefine() {
        CommandsClass defineCommand=new Define();
        TreeMap<String,Double> define=new TreeMap<>();
        CommandContext context = new CommandContext();
        context.setDefine(define);

        Stack<String> values = new Stack<>();
        context.setValues(values);

        context.getValues().push(PUSH_a);
        context.getValues().push(DEFINE_8_STR);
        defineCommand.returnResultCommand(context);

        context.getValues().push(DEFINE_b);
        context.getValues().push(PUSH_a);
        defineCommand.returnResultCommand(context);

        context.getValues().push(DEFINE_bs);
        context.getValues().push(DEFINE_as);
        defineCommand.returnResultCommand(context);

        TreeMap<String,Double> expected=new TreeMap<>();
        expected.put(PUSH_a,DEFINE_8_DOUBLE);
        expected.put(DEFINE_b,DEFINE_8_DOUBLE);
        LOGGER.info(defineCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,define);
    }
    private final double DIVISION_MINUS_ZERO=-0.0;
    private final double DIVISION_2=2.0;
    private final double DIVISION_6=6.0;
    private final double DIVISION_3=3.0;

    @Test
    public void testCommandDivision() throws  Exception{
        CommandsClass divisionCommand=new Division();
        Stack stack=new Stack();
        stack.push(DIVISION_MINUS_ZERO);
        stack.push(DIVISION_2);
        stack.push(DIVISION_6);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        divisionCommand.returnResultCommand(context);
        divisionCommand.returnResultCommand(context);

        Stack expected=new Stack();
        expected.push(DIVISION_MINUS_ZERO);
        expected.push(DIVISION_3);

        LOGGER.info(divisionCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double MINUS_3 = 3.0;
    private final double MINUS_2 = 2.0;
    private final double MINUS_MINUS_1 = -1.0;
    @Test
    public void testCommandMinus() {
        CommandsClass minusCommand=new Minus();
        Stack stack=new Stack();
        stack.push(MINUS_3);
        stack.push(MINUS_2);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        minusCommand.returnResultCommand(context);
        minusCommand.returnResultCommand(context);

        Stack expected=new Stack();
        expected.push(MINUS_MINUS_1);

        LOGGER.info(minusCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double MULTIPLICATION_3=3.0;
    private final double MULTIPLICATION_MINUS_2=-2.0;
    private final double MULTIPLICATION_MINUS_6=-6.0;
    @Test
    public void testCommandMultiplication() {
        CommandsClass multiplicationCommand=new Multiplication();
        Stack stack=new Stack();
        stack.push(MULTIPLICATION_3);
        stack.push(MULTIPLICATION_MINUS_2);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        multiplicationCommand.returnResultCommand(context);;
        multiplicationCommand.returnResultCommand(context);;

        Stack expected=new Stack();
        expected.push(MULTIPLICATION_MINUS_6);

        LOGGER.info(multiplicationCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double PLUS_1=1.0;
    private final double PLUS_MINUS_2=-2.0;
    private final double PLUS_MINUS_1=-1.0;
    @Test
    public void testCommandPlus() {
        CommandsClass plusCommand=new Plus();
        Stack stack=new Stack();
        stack.push(PLUS_1);
        stack.push(PLUS_MINUS_2);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        plusCommand.returnResultCommand(context);;
        plusCommand.returnResultCommand(context);;

        Stack expected=new Stack();
        expected.push(PLUS_MINUS_1);

        LOGGER.info(plusCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double POP_1=1.0;
    @Test
    public void testCommandPop() {
        CommandsClass popCommand=new Pop();
        Stack stack=new Stack();
        stack.push(POP_1);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        popCommand.returnResultCommand(context);;
        popCommand.returnResultCommand(context);;

        Stack expected=new Stack();

        LOGGER.info(popCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double PRINT_1=1.0;
    @Test
    public void testCommandPrint() {
        CommandsClass printCommand=new Print();
        Stack stack=new Stack();
        stack.push(PRINT_1);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        printCommand.returnResultCommand(context);;

        Stack expected=new Stack();
        expected.push(PRINT_1);

        LOGGER.info(printCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final String PUSH_a="a";
    private final double PUSH_2=2.0;
    private final String PUSH_b="b";
    private final String PUSH_1_STR="1";
    private final Double PUSH_1_DOUBLE=1.0;
    @Test
    public void testCommandPush() {
        CommandsClass pushCommand=new Push();
        TreeMap<String,Double> define=new TreeMap<>();
        define.put(PUSH_a,PUSH_2);
        Stack stack=new Stack();

        CommandContext context=new CommandContext();
        context.setStack(stack);
        context.setDefine(define);

        Stack<String> values = new Stack<>();
        context.setValues(values);

        context.getValues().push(PUSH_1_STR);
        pushCommand.returnResultCommand(context);
        context.getValues().push(PUSH_b);
        pushCommand.returnResultCommand(context);
        context.getValues().push(PUSH_a);
        pushCommand.returnResultCommand(context);
        Stack expected=new Stack();
        expected.push(PUSH_1_DOUBLE);
        expected.push(PUSH_2);

        LOGGER.info(pushCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double SQRT_4=4.0;
    private final double SQRT_MINUS_1=-1.0;
    private final double SQRT_MINUS_ZERO=-0.0;
    private final double SQRT_2=2.0;
    @Test
    public void testCommandSqrt() {
        CommandsClass sqrtCommand=new Sqrt();
        Stack stack=new Stack();
        CommandContext context=new CommandContext();
        context.setStack(stack);
        stack.push(SQRT_4);
        sqrtCommand.returnResultCommand(context);;
        stack.push(SQRT_MINUS_1);
        sqrtCommand.returnResultCommand(context);;
        stack.push(SQRT_MINUS_ZERO);
        sqrtCommand.returnResultCommand(context);;

        Stack expected=new Stack();
        expected.push(SQRT_2);
        expected.push(SQRT_MINUS_1);
        expected.push(SQRT_MINUS_ZERO);

        LOGGER.info(sqrtCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
}
