package controllerLayer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class test
{
    /**
     * Default constructor for test class test
     */
    public test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testProduct()
    {
        controllerLayer.ProductController productC1 = new controllerLayer.ProductController();
        productC1.addProduct(10, 10, "100102010", "Hammer", "Gummi", "Gummi hammer", "Sort", 10, 100, 10, 10, 0);
        assertNotNull(productC1.getProduct(0));
    }

    @Test
    public void testCustomer()
    {
        controllerLayer.CustomerController customer1 = new controllerLayer.CustomerController();
        customer1.addCustomer("Hans Hansen", "Lærkevej 9", "9000", "Aalborg", "88888888");
        assertNotNull(customer1.getCustomer(0));
    }

    @Test
    public void testAccount()
    {
        controllerLayer.AccountController accountC1 = new controllerLayer.AccountController();
        accountC1.addAccount("Løbende", 10, 0, 10, 10000);
        assertNotNull(accountC1.getAccount(0));
    }
}



