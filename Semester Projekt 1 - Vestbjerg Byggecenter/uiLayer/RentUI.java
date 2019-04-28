package uiLayer;

import controllerLayer.RentController;
/**
 * Write a description of class RentUI here.
 *
 * @author (Group 6)
 * @version (V.1.0)
 */
public class RentUI{
    private ReaderUtil reader;
    private RentController renCon;
    private String[] menus = {"Opret lån", "Søg lån", "Opdater lån", "Aflever lån", "Tilbage"};

    public RentUI(){
        reader = new ReaderUtil();
        renCon = new RentController();
    }

    private void printRentMenu(){
        int i = 1;       
        System.out.println("## UDLEJNING ##\n");
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
            printRentMenu();
            int userChoice = reader.getInt();
            if(userChoice == 1){
                addRent();
            }
            else if(userChoice == 2){
                findRent();
            }
            else if(userChoice == 3){
                updateRent();
            }
            else if(userChoice == 4){
                removeRent();
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

    private void findRent(){
        System.out.println("Indtast låne-ID:");
        System.out.println(renCon.getRent(reader.getInt()));
    }

    private void addRent(){
        System.out.println("Du er nu i gang med at oprette et lån.");

        System.out.println("Indtast serienummer:");
        String serialNumber = reader.getString();
        System.out.println("Indtast note:");
        String note = reader.getString();
        System.out.println("Indtast pris:");
        double rentPrice = reader.getDouble();
        System.out.println("Indtast depositum:");
        double deposit = reader.getDouble();

        renCon.addRent(serialNumber, note, rentPrice, deposit);
    }

    private void removeRent(){
        System.out.println("Indtast låne-ID:");
        renCon.toggleActive(reader.getInt());
    }

    private void updateRent(){
        System.out.println("Du er nu i gang med at opdatere oplysninger på et lån");
        System.out.println("Indtast låne-ID:");
        int id = reader.getInt();
        if(renCon.getRent(id) != null){
            System.out.println("Nuværende serienummer: " + renCon.getRent(id).getSerialNumber());
            System.out.println("Opdater serienummer:");
            String serialNumber = reader.getString();
            System.out.println("Nuværende note: " + renCon.getRent(id).getNote());
            System.out.println("Opdater note:");
            String note = reader.getString();
            System.out.println("Nuværende lånepris: " + renCon.getRent(id).getRentPrice());
            System.out.println("Opdater lånepris:");
            double rentPrice = reader.getDouble();
            System.out.println("Nuværende depositum: " + renCon.getRent(id).getDeposit());
            System.out.println("Opdater depositum for produkt:");
            double deposit = reader.getDouble();

            renCon.updateRent(id, serialNumber, note, rentPrice, deposit);
        }
        else {
            System.out.println("Indtast venligst et korrekt låne-ID");
        }
    }

    private void printError(){
        System.out.println("Vælg venligst et nummer fra 1 - 4 eller 9");
    }
}