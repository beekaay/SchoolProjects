package uiLayer;

import controllerLayer.*;
/**
 * Write a description of class EmployeeUI here.
 *
 * @author (Group 6)
 * @version (V.1.0)
 */
public class EmployeeUI
{
    private ReaderUtil reader;
    private EmployeeController empCon;
    private String[] menus = {"Tilføj medarbejder", "Find medarbejder", "Updatere medarbejder",
            "Slet medarbejder", "Tilbage"};

    public EmployeeUI(){
        reader = new ReaderUtil();
        empCon = new EmployeeController();
    }

    private void printEmployeeMenu(){
        int i = 1;       
        System.out.println("## MEDARBEJDER ##\n");
        for(String menu: menus) {
            if(i != menus.length){
                System.out.println("Tryk "+ i + " for " + menu +  " \n ");
                i++;
            }
            else{
                System.out.println("Tryk 9 for " + menu + " \n " );
            }

        }    
        System.out.println("###################\n");
    }

    public void menu(){
        boolean running = true;
        while(running){
            printEmployeeMenu();
            int userChoice = reader.getInt();
            if(userChoice == 1){
                addEmployee();
            }
            else if(userChoice == 2){
                getEmployee();
            }
            else if(userChoice == 3){
                updateEmployee();
            }
            else if(userChoice == 4){
                removeEmployee();
            }
            else if(userChoice == 9){
                reader.clear();    
                running = false;
            }  
            else {
                printError();
            }
        }
    }

    private void getEmployee(){
        System.out.println("Indtast medarbejder-ID: ");
        System.out.println(empCon.getEmployee(reader.getInt()));
    }

    private void addEmployee(){
        System.out.println("Du er nu i gang med at oprette en medarbejder.");

        System.out.println("Indtast navn:");
        String name = reader.getString();
        System.out.println("Indtast addresse:");
        String address = reader.getString();
        System.out.println("Indtast postnummer:");
        String zip = reader.getString();
        System.out.println("Indtast by:");
        String city = reader.getString();
        System.out.println("Indtast tlf:");
        String phone = reader.getString();
        System.out.println("Indtast bank information:");
        String bankInfo = reader.getString();
        System.out.println("Indtast løn:");
        Double salery = reader.getDouble();
        System.out.println("Leder:");
        boolean isLeader = reader.getBool();

        empCon.addEmployee(name, address, zip, city, phone, bankInfo, salery, isLeader);
    }

    private void removeEmployee(){
        System.out.println("Indtast medarbejder-ID: ");
        empCon.removeEmployee(reader.getInt());
    }

    private void updateEmployee(){
        System.out.println("Indtast medarbejder-ID: ");
        int id = reader.getInt();
        if(empCon.getEmployee(id) != null)
        {
            System.out.println("Nuværende navn: " + empCon.getEmployee(id).getName());
            System.out.println("Opdater navn:");
            String name = reader.getString();
            System.out.println("Nuværende adresse: " + empCon.getEmployee(id).getAddress());
            System.out.println("Opdater adresse:");
            String address = reader.getString();
            System.out.println("Nuværende postnummer: " + empCon.getEmployee(id).getZip());
            System.out.println("Opdater postnummer:");
            String zip = reader.getString();
            System.out.println("Nuværende by: " + empCon.getEmployee(id).getCity());
            System.out.println("Opdater by:");
            String city = reader.getString();
            System.out.println("Nuværende telefonnummer: " + empCon.getEmployee(id).getPhone());
            System.out.println("Opdater telefonnummer:");
            String phone = reader.getString();
            System.out.println("Nuværende bankinformation: " + empCon.getEmployee(id).getBankInfo());
            System.out.println("Opdater bankinformation:");
            String bankInfo = reader.getString();
            System.out.println("Nuværende løn: " + empCon.getEmployee(id).getSalery());
            System.out.println("Opdater løn:");
            Double salery = reader.getDouble();
            System.out.println("Leder: " + empCon.getEmployee(id).getIsLeader());
            System.out.println("Leder:");
            Boolean isLeader = reader.getBool();

            empCon.updateEmployee(id, name, address, zip, city, phone, bankInfo, salery, isLeader);
        }
        else
        {
            System.out.println("Indtast venligst et korrekt medarbejder-ID");
        }
    }

    private void printError(){
        System.out.println("Vælg venligst et nummer fra 1 - 4 eller 9");
    }
}
