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
public class LoginServletTest {
    
    public LoginServletTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }


@Test
public void testDBQuery() throws Exception {
    System.out.println("DBQuery");
    int expResult = 1;
    int result = RegisterServlet.DBQuery("co_admin@mail.com", "co2admin143");
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
}

    // /**
    //  * Test of processRequest method, of class LoginServlet.
    //  */
    // @Test
    // public void testProcessRequest() throws Exception {
    //     System.out.println("processRequest");
    //     HttpServletRequest request = null;
    //     HttpServletResponse response = null;
    //     LoginServlet instance = new LoginServlet();
    //     instance.processRequest(request, response);
    //     // TODO review the generated test code and remove the default call to fail.
    //     fail("The test case is a prototype.");
    // }

    /**
     * Test of doPost method, of class LoginServlet.
     */
//    @Test
//    public void testDoPost() throws Exception {
//        System.out.println("doPost");
//        HttpServletRequest request = null;
//        HttpServletResponse response = null;
//        LoginServlet instance = new LoginServlet();
//        instance.doPost(request, response);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of getServletInfo method, of class LoginServlet.
//     */
//    @Test
//    public void testGetServletInfo() {
//        System.out.println("getServletInfo");
//        LoginServlet instance = new LoginServlet();
//        String expResult = "";
//        String result = instance.getServletInfo();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
