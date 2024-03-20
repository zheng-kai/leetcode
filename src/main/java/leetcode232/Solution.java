package leetcode232;

import java.util.Stack;

class MyQueue {

    public Stack<Integer> s1 = new Stack<>();
    public Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        s2.push(x);
    }

    public int pop() {
        if (s1.isEmpty()) {
            load();
        }
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            load();
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void load() {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */