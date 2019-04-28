package controllerLayer;
import modelLayer.*;
import java.util.*;

public class EmployeeController{
    private EmployeeContainer empCon;

    /**
     * EmployeeController Constructor
     *
     */
    public EmployeeController()
    {
        empCon = EmployeeContainer.getInstance();
    }

    /**
     * Method getEmployee
     *
     * @param id A parameter
     * @return The return value
     */
    public Employee getEmployee(int id){
        return empCon.getEmployee(id);
    }

    /**
     * Method addEmployee
     *
     * @param name A parameter
     * @param address A parameter
     * @param zip A parameter
     * @param city A parameter
     * @param phone A parameter
     * @param bankInfo A parameter
     * @param salery A parameter
     * @param isLeader A parameter
     */
    public void addEmployee(String name, String address, String zip, String city, String phone, String bankInfo, double salery, boolean isLeader){
        empCon.addEmployee(name, address, zip, city, phone, bankInfo, salery, isLeader);
    }

    /**
     * Method removeEmployee
     *
     * @param id A parameter
     */
    public void removeEmployee(int id){
        empCon.removeEmployee(id);
    }

    /**
     * Method updateEmployee
     *
     * @param id A parameter
     * @param name A parameter
     * @param address A parameter
     * @param zip A parameter
     * @param city A parameter
     * @param phone A parameter
     * @param bankInfo A parameter
     * @param salery A parameter
     * @param isLeader A parameter
     */
    public void updateEmployee(int id, String name, String address, String zip, String city, 
    String phone, String bankInfo, double salery, boolean isLeader){
        empCon.updateEmployee(id, name, address, zip, city, phone, bankInfo, salery, isLeader);
    }
}
