package algstest.stack;

import algs.stack.INToRPN;
import org.junit.Test;

public class INToRPNTest {
    @Test
    public void testInfixExpressionToRPN(){
        INToRPN inToRPN = new INToRPN();
        inToRPN.infixExpressionToRPN("1-(1-2)");
        System.out.println("inToRPN.toString() = " + inToRPN.toString());
    }
}
