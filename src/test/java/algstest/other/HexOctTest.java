package algstest.other;

import algs.other.HexOct;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HexOctTest {
    @Test
    public void testOct2Bin(){
        assertEquals("111",HexOct.oct2Bin(7));
        assertEquals("1",HexOct.oct2Bin(1));
        assertEquals("0",HexOct.oct2Bin(0));
        assertEquals("1000",HexOct.oct2Bin(8));
    }

    @Test
    public void testCommonTransform(){
        assertEquals("0",HexOct.commonTransform(3,0));
        assertEquals("10",HexOct.commonTransform(3,3));
        assertEquals("111",HexOct.commonTransform(3,13));
        assertEquals("10",HexOct.commonTransform(1,10));
        assertEquals("10",HexOct.commonTransform(4,4));
        assertEquals("22",HexOct.commonTransform(4,10));
        assertEquals("111",HexOct.commonTransform(2,7));
        assertEquals("1",HexOct.commonTransform(2,1));
        assertEquals("0",HexOct.commonTransform(2,0));
        assertEquals("1000",HexOct.commonTransform(2,8));
    }
}
