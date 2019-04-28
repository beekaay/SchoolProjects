package uiLayer;

import controllerLayer.*;

/**
 * Write a description of class SupplierUI here.
 *
 * @author (Group 6)
 * @version (V.1.0)
 */
public class SupplierUI
{
    private ReaderUtil reader;
    private SupplierController supCon;

    private String[] menus = { "Opret leverandør", "Søg leverandør", "Opdater leverandør", "Fjern leverandør", "Tilbage"};

    public SupplierUI(){
        reader = new ReaderUtil();
        supCon = new SupplierController();
    }

    private void printSupplierMenu(){
        int i = 1;
        System.out.println("## LEVERANDØR ## \n");
        for(String menu : menus) {
            if(i != menus.length){
                System.out.println("Tryk "+ i + " for " + menu +  " \n ");
                i++;
            }
            else {
                System.out.println("Tryk 9 for " + menu + " \n ");
            }

        }
        System.out.println("###################\n");
    }

    public void menu(){
        boolean running = true;
        while(running){
            printSupplierMenu();
            int userChoice = reader.getInt();
            if(userChoice == 1){
                createSupplier();
            }
            else if(userChoice == 2){
                getSupplier();
            }
            else if(userChoice == 3){
                updateSupplier();
            }
            else if(userChoice == 4){
                deactivateSupplier();
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

    private void getSupplier() {
        System.out.println("Indtast leverandør-ID:");
        int id = reader.getInt();
        System.out.println(supCon.getSupplier(id));
    }

    private void createSupplier() {
        System.out.println("Indtast navn: ");
        String name = reader.getString();
        System.out.println("Indtast beskrivelse: ");
        String description = reader.getString();
        System.out.println("Indtast bankoplysninger: ");
        String bankInfo = reader.getString();
        supCon.createSupplier(name, description, bankInfo);
    }

    private void updateSupplier() {
        System.out.println("Indtast leverandør-ID: ");
        int id = reader.getInt();
        if(supCon.getSupplier(id) != null){
            System.out.println("Nuværende navn: " + supCon.getSupplier(id).getName());
            System.out.println("Opdater navn: ");
            String name = reader.getString();
            System.out.println("Nuværende beskrivelse: " + supCon.getSupplier(id).getDescription());
            System.out.println("Opdater beskrivelse: ");
            String description = reader.getString();
            System.out.println("Nuværende bankoplysninger: " + supCon.getSupplier(id).getBankInfo());
            System.out.println("Opdater bankoplysninger: ");
            String bankInfo = reader.getString();
            supCon.updateSupplier(id, name, description, bankInfo);
        }
        else {
            System.out.println("Indtast venligst et korrekt leverandør-ID");
        }
    }

    private void deactivateSupplier() {
        System.out.println("Indtast leverandør-ID: ");
        int id = reader.getInt();
        supCon.toggleActive(id);
    }

    private void printError(){
        System.out.println("Vælg venligst et nummer fra 1 - 4 eller 9");
    }
}
