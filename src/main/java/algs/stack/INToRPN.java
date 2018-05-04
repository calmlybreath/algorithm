package algs.stack;

import java.util.Stack;

/**
 * The type In to rpn.
 * 实现中缀表达式转后缀表达式,以及后缀表达式求值
 *
 * @author lrq
 * @date 2018 /5/3
 */
public class INToRPN {
    /**
     * 后缀表达式
     */
    private Stack<Character> rpn = new Stack<>();

    /**
     * Instantiates a new In to rpn.
     */
    public INToRPN() {

    }

    /**
     * Infix expression to rpn.
     *
     * @param expression the expression
     */
    public void infixExpressionToRPN(String expression) {
        char[] infixExpression = expression.toCharArray();
        Stack<Character> tempRPN = new Stack<>();
        Stack<Character> operation = new Stack<>();
        for (char item : infixExpression) {
            if (Character.isDigit(item)) {
                //如果是数字，直接输出
                tempRPN.push(item);
                continue;
            }
            /*
             * 如果是运算符或括号
             * */
            if (operation.empty()) {
                //如果栈为空，直接入栈
                operation.push(item);
                continue;
            }
            //栈不为空时
            //如果遇到')'，弹出操作符直到遇到'('
            if (item == ')') {
                while (true) {
                    //不判断栈是否为空了
                    char op = operation.pop();
                    if (op == '(') {
                        break;
                    } else {
                        tempRPN.push(op);
                    }
                }
                continue;
            }

            while (true) {
                if (operation.isEmpty()) {
                    operation.push(item);
                    break;
                }
                Character peek = operation.peek();
                if (isPriority(item, peek)) {
                    operation.push(item);
                    break;
                } else {
                    tempRPN.push(operation.pop());
                }
            }

        }
        //循环结束后，如果操作符栈还有元素，全部弹出
        while (!operation.isEmpty()) {
            tempRPN.push(operation.pop());
        }
        while (!tempRPN.isEmpty()) {
            rpn.push(tempRPN.pop());
        }
    }

    /**
     * 如果遇到操作符，则我们将其放入到栈中，遇到左括号时我们也将其放入栈中，
     * 如果遇到任何其他的操作符，如（“+”， “*”，“（”）等，从栈中弹出元素直到遇到发现更低优先级的元素(或者栈为空)为止，弹出完这些元素后，
     * 才将遇到的操作符压入到栈中。有一点需要注意，只有在遇到" ) "的情况下我们才弹出" ( "，其他情况我们都不会弹出" ( "
     *
     * @param item the operation
     * @param peek the operation
     * @return boolean the result
     * @throws IllegalArgumentException the IllegalArgumentException
     */
    private boolean isPriority(Character item, Character peek) {
        if (peek == '(') {
            return true;
        }
        if (item == '(') {
            return true;
        }
        if (item == '+' || item == '-') {
            return false;
        }
        if (item == '*' || item == '/') {
            return peek != '*' && peek != '/';
        }
        throw new IllegalArgumentException("参数错误");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        while (!rpn.isEmpty()) {
            builder.append(rpn.pop());
        }
        return builder.toString();
    }
}
