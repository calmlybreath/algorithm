package algstest.stack;

import algs.stack.INToRPN;
import org.junit.Assert;
import org.junit.Test;

public class INToRPNTest {
    @Test
    public void testInfixExpressionToRPN(){
        INToRPN inToRPN = new INToRPN();
        inToRPN.infixExpressionToRPN("1-(1-2)");
        Assert.assertEquals("112--",inToRPN.toString());
        inToRPN.infixExpressionToRPN("(1-2)*3");
        Assert.assertEquals("12-3*",inToRPN.toString());
        inToRPN.infixExpressionToRPN("1+2*3+(4*5+6)*7");
        Assert.assertEquals("123*+45*6+7*+",inToRPN.toString());
    }

    @Test
    public void testEvaluate(){
        INToRPN inToRPN = new INToRPN();
        inToRPN.infixExpressionToRPN("1-(1-2)");
        Assert.assertEquals(2,inToRPN.evaluate());
        inToRPN.infixExpressionToRPN("(1-2)*3");
        Assert.assertEquals(-3,inToRPN.evaluate());
        inToRPN.infixExpressionToRPN("1+2*3+(4*5+6)*7");
        Assert.assertEquals(189,inToRPN.evaluate());
    }
}
