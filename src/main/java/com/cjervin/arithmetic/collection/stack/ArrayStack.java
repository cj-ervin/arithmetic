package com.cjervin.arithmetic.collection.stack;

/**
 * 栈 数组实现
 *
 * @author ervin
 * @Date 2021/4/20
 */
public class ArrayStack<T> {
    private Object[] data;
    //栈顶
    private int top;

    public ArrayStack(int size) {
        this.data = new Object[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == data.length - 1;
    }

    public void push(T t) throws Exception {
        if (isFull()) {
//            throw new Exception("stack full");
            //扩容
            Object[] newDate = new Object[top * 2];
            for (int i = 0; i <= top; i++) {
                newDate[i] = this.data[i];
            }
            data = newDate;
        }
        data[++top] = t;
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack empty");
        }
        return (T) data[top--];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            builder.append("index:" + i + "value:" + data[i]).append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        ArrayStack<String> stack = new ArrayStack(8);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");
        stack.push("g");
        stack.push("h");

        System.out.println(stack.toString());

        stack.push("x");
        stack.push("y");
        stack.push("z");
        System.out.println(stack.toString());

        //isFull
//        stack.push("xx");
        for (int i = 0; i < 11; i++) {
            System.out.println("pop:" + stack.pop());
        }

        System.out.println(stack.toString());

    }
}
