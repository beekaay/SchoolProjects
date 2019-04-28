package modelLayer;

import java.util.*;

public class EmployeeContainer
{
    private static EmployeeContainer instance;
    private static ArrayList<Employee> employee; 
    
    /**
     * EmployeeContainer Constructor
     *
     */
    private EmployeeContainer()
    {
        employee = new ArrayList<Employee>();
    }

    /**
     * Method getInstance
     *
     * @return The return value
     */
    public static EmployeeContainer getInstance(){
        if(instance == null){
            instance = new EmployeeContainer();
        }
        return instance;
    }
    
    /**
     * Method getEmployee
     *
     * @param id A parameter
     * @return The return value
     */
    public Employee getEmployee(int id){
        return employee.get(id);
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
    public void addEmployee(String name, String address, String zip, String city, 
    String phone, String bankInfo, double salery, boolean isLeader){
        Employee e = new Employee(name, address, zip, city, phone, bankInfo, salery, isLeader);
        employee.add(e);
    }
    
    /**
     * Method removeEmployee
     *
     * @param id A parameter
     */
    public void removeEmployee(int id){
        employee.remove(id);
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
    public void updateEmployee(Integer id, String name, String address, String zip, String city, 
    String phone, String bankInfo, double salery, boolean isLeader){
        Employee o = getEmployee(id);
        o.setFields(null, name, address, zip, city, phone, bankInfo, salery, isLeader);
    }
    
    /**
     * Method size
     *
     * @return The return value
     */
    public int size(){
        return employee.size();
    }
    
}
