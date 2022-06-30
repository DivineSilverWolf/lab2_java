package calculator.core;

import java.util.Stack;
import java.util.TreeMap;

public class CommandContext {
    private Stack<Double> stack;
    private TreeMap<String,Double> define;
    private Stack<String> values;

    public Stack<Double> getStack() {
        return stack;
    }

    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    public TreeMap<String, Double> getDefine() {
        return define;
    }

    public void setDefine(TreeMap<String, Double> define) {
        this.define = define;
    }

    public Stack<String> getValues() {
        return values;
    }

    public void setValues(Stack<String> values) {
        this.values = values;
    }
}
