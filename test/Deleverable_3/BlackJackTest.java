package Deleverable_3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gurjo
 */
public class BlackJackTest {
    
    public BlackJackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BlackJack.
     */
    /*@Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BlackJack.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of checkValue method, of class BlackJack.
     */
    /*@Test
    public void testCheckValue() {
        System.out.println("checkValue");
        String res = "";
        boolean expResult = false;
        boolean result = BlackJack.checkValue(res);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
    @Test
    public void testCheckValueGood() {
        System.out.println("checkValue good");
        String res = "1";
        boolean expResult = true;
        boolean result = BlackJack.checkValue(res);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCheckValueBad() {
        System.out.println("checkValue bad");
        String res = "a";
        boolean expResult = false;
        boolean result = BlackJack.checkValue(res);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCheckValueBoundary() {
        System.out.println("checkValue boundary");
        String res = "";
        boolean expResult = false;
        boolean result = BlackJack.checkValue(res);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
