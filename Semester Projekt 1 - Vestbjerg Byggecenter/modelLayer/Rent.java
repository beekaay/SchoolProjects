package modelLayer;

import java.util.Date;
/**
 * @author (Group 6)
 * @version (v.1.0)
 */
public class Rent{
    private Integer id;
    private String serialNumber;
    private String note;
    private double rentPrice;
    private double deposit;
    private Date startDate;
    private Date endDate;
    private boolean active;

    /**
     * Rent Constructor
     *
     * @param serialNumber A parameter
     * @param note A parameter
     * @param rentPrice A parameter
     * @param deposit A parameter
     */
    public Rent(String serialNumber, String note, double rentPrice, double deposit){
        // sizeArr is the size of the ArrayList inside the RentContainer class, to generate the uniqe ID of Rent.
        int sizeArr = RentContainer.getInstance().size();
        setFields(serialNumber, note, rentPrice, deposit, sizeArr++);
        active = true;
    }

    /**
     * Method setFields
     *
     * @param serialNumber A parameter
     * @param note A parameter
     * @param rentPrice A parameter
     * @param deposit A parameter
     * @param id A parameter
     */
    public void setFields(String serialNumber, String note, double rentPrice, double deposit, Integer id){
        // if ID is equal to null, or not euql to null, ID will then increment 1.
        if(this.id == null || id != null){
            this.id = id;
        }

        if(serialNumber != null){
            this.serialNumber = serialNumber;
        }
        if(note != null){
            this.note = note;
        }
        if(rentPrice != 0){
            this.rentPrice = rentPrice;
        }
        if(deposit != 0){
            this.deposit = deposit;
        }
        if(startDate != null){
            this.startDate = startDate;
        }
        if(endDate != null){
            this.endDate = endDate;
        }
    }

    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString(){
                String act;
        if(active) {
            act = "Aktiv";
        }
        else {
            act = "Ikke aktiv";
        }
        return "ID: " +id + " Serie nummer: " +serialNumber+ " Note: " +note+ 
        " Låne pris: " +rentPrice+ " Depositum: " +deposit+ " Start dato: " +startDate+ 
        " Slut dato: " +endDate+ " Status: " +act+ "\n";
    }

    /**
     * Method getID
     *
     * @return The return value
     */
    public Integer getID(){
        return id;
    }

    /**
     * Method getSerialNumber
     *
     * @return The return value
     */
    public String getSerialNumber(){
        return serialNumber;
    }

    /**
     * Method getNote
     *
     * @return The return value
     */
    public String getNote(){
        return note;
    }

    /**
     * Method getRentPrice
     *
     * @return The return value
     */
    public double getRentPrice(){
        return rentPrice;
    }

    /**
     * Method getDeposit
     *
     * @return The return value
     */
    public double getDeposit(){
        return deposit;
    }

    /**
     * Method getStartDate
     *
     * @return The return value
     */
    public Date getStartDate(){
        return startDate;
    }

    /**
     * Method getEndDate
     *
     * @return The return value
     */
    public Date getEndDate(){
        return endDate;
    }
    

    /**
     * Method toggleActive
     *
     */
    public void toggleActive() {
        if(active) {
            active = false;
        } else {
            active = true;
        }
    }
}