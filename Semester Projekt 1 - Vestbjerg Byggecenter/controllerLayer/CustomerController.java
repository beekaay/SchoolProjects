package controllerLayer;

import modelLayer.*;
import java.util.*;

public class CustomerController {
    private CustomerContainer cusCon;
    private OrderContainer odrCon;
    
    /**
     * CustomerController Constructor
     *
     */
    public CustomerController(){
        cusCon = CustomerContainer.getInstance();
        odrCon = OrderContainer.getInstance();
    }
    /**
     * Method getCustomer
     *
     * @param id A parameter
     * @return The return value
     */
    public Customer getCustomer(int id){
        return cusCon.getCustomer(id);
    }
    
    /**
     * Method addCustomer
     *
     * @param name A parameter
     * @param address A parameter
     * @param zip A parameter
     * @param city A parameter
     * @param phone A parameter
     * @param discount A parameter
     */
    public void addCustomer(String name, String address, String zip, String city, String phone){
        cusCon.addCustomer(name, address, zip, city, phone);
    }
    /**
     * Method removeCustomer
     *
     * @param id A parameter
     */
    public void removeCustomer(int id){
        cusCon.removeCustomer(id);
    }
    /**
     * Method updateCustomer
     *
     * @param id A parameter
     * @param name A parameter
     * @param address A parameter
     * @param zip A parameter
     * @param city A parameter
     * @param phone A parameter
     * @param discount A parameter
     */
    public void updateCustomer(int id, String name, String address, String zip, String city, String phone){
        cusCon.updateCustomer(id, name, address, zip, city, phone);
    }
    /**
     * Method addOrder
     *
     * @param cust A parameter
     * @param odr A parameter
     */
    public void addOrder(int cust, int odr){
        cusCon.addOrder(cust, odrCon.getOrder(odr));
    }
}


