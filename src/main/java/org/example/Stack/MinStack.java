package org.example.Stack;

import java.util.*;

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    // Main method to demonstrate the usage of MinStack
    public static void main(String[] args) {
        List<Object> outputs = new ArrayList<>();
        MinStack minStack = new MinStack();

        outputs.add(null); // For MinStack initialization
        minStack.push(-2);
        outputs.add(null); // For push(-2)
        minStack.push(0);
        outputs.add(null); // For push(0)
        minStack.push(-3);
        outputs.add(null); // For push(-3)
        outputs.add(minStack.getMin()); // For getMin(), should be -3
        minStack.pop();
        outputs.add(null); // For pop()
        outputs.add(minStack.top()); // For top(), should be 0
        outputs.add(minStack.getMin()); // For getMin(), should be -2

        // Print the outputs
        System.out.println(outputs);
    }
}
