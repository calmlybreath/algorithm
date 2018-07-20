package algs.offer;

import java.util.Stack;

/*
 *  题目描述
 *  用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * */
public class QueueByUseTwoStack {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    /**
     * Pop int.
     *
     * @return the int
     */
    public int pop() {
        if (stack1.empty() && !stack2.empty()) {
            return stack2.pop();
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
