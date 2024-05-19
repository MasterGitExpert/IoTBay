/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krish
 */
public class RegisterServletTest {
    
    public RegisterServletTest() {
    }
    
    // @BeforeClass
    // public static void setUpClass() {
    // }
    
    // @AfterClass
    // public static void tearDownClass() {
    // }
    
    // @Before
    // public void setUp() {
    // }
    
    // @After
    // public void tearDown() {
    // }

    @Test
    public void testDBQuery() throws Exception {
        System.out.println("DBQuery");
        int expResult = 1;
        int result = RegisterServlet.DBQuery("coAdmin", "coAdmin", "co_admin@mail.com", "co2admin143", "2020-1-1", "0123 456 789", "2020-1-1 00:00:00", "ADMIN");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    // /**
    //  * Test of processRequest method, of class RegisterServlet.
    //  */
    // @Test
    // public void testProcessRequest() throws Exception {
    //     System.out.println("processRequest");
    //     HttpServletRequest request = null;
    //     HttpServletResponse response = null;
    //     RegisterServlet instance = new RegisterServlet();
    //     boolean expResult = false;
    //     boolean result = instance.processRequest(request, response);
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     fail("The test case is a prototype.");
    // }    
}
