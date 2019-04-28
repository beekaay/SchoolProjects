package controllerLayer;

import modelLayer.*;
import java.util.*;

public class RentController {
    private RentContainer rentCon;

    /**
     * RentController Constructor
     *
     */
    public RentController()
    {
        rentCon = RentContainer.getInstance();
    }

    /**
     * Method getRent
     *
     * @param id A parameter
     * @return The return value
     */
    public Rent getRent(int id){
        return rentCon.getRent(id);
    }

    /**
     * Method addRent
     *
     * @param serialNumber A parameter
     * @param note A parameter
     * @param rentPrice A parameter
     * @param deposit A parameter
     */
    public void addRent(String serialNumber, String note, double rentPrice, 
    double deposit){
        rentCon.addRent(serialNumber, note, rentPrice, deposit);
    }

    /**
     * Method removeRent
     *
     * @param id A parameter
     */
    public void removeRent(int id){
        rentCon.removeRent(id);
    }

    /**
     * Method updateRent
     *
     * @param id A parameter
     * @param serialNumber A parameter
     * @param note A parameter
     * @param rentPrice A parameter
     * @param deposit A parameter
     */
    public void updateRent(int id, String serialNumber, String note, double rentPrice, double deposit){
        rentCon.updateRent(id, serialNumber, note, rentPrice, deposit);
    }

    /**
     * Method toggleActive
     *
     * @param id A parameter
     */
    public void toggleActive(int id){
        rentCon.toggleActive(id);
    }
}
