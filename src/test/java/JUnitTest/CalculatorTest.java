package JUnitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private static Calculator cal=new Calculator();

    @BeforeClass
    public static void setClass() throws Exception {
        System.out.println("开始初始化类");
    }
    @Before
    public void setUp() throws Exception {
        System.out.println("开始初始化");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        cal.add(2,2);
        assertEquals(4,cal.getResult());
        cal.add(3,3);
        assertEquals(5,cal.getResult());
        //fail("Not yet implemented");
    }

    @Test
    public void subtract() {
        cal.subtract(100, 10);
        assertEquals(90, cal.getResult());
    }

    @Test
    public void multipe() {
    }

    @Test
    public void divide() {
    }

    @Test
    public void getResult() {
    }
}