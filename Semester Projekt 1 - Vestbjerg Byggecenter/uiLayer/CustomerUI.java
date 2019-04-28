package uiLayer;

import controllerLayer.CustomerController;
/**
 * Write a description of class CustomerUI here.
 *
 * @author (Group 6)
 * @version (V.1.0)
 */
public class CustomerUI{
    private ReaderUtil reader;
    private CustomerController cusCon;
    private String[] menus = { "Opret kunde", "Søg kunde", "Opdater kunde", "Tilbage"};

    public CustomerUI(){
        reader = new ReaderUtil();
        cusCon = new CustomerController();
    }

    private void printCustomerMenu(){
        int i = 1;       
        System.out.println("## KUNDE ##\n");
        for(String menu: menus) {
            if(i != menus.length){
                System.out.println("Tryk "+ i + " for " + menu +  " \n ");
                i++;
            }
            else{
                System.out.println("Tryk 9 for " + menu + " \n ");
            }

        }
        System.out.println("###################\n");
    }

    public void menu(){
        boolean running = true;
        while(running){
            printCustomerMenu();
            int userChoice = reader.getInt();
            if(userChoice == 1){
                addCustomer();
            }
            else if(userChoice == 2){
                getCustomer();
            }
            else if(userChoice == 3){
                updateCustomer();
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

    private void getCustomer(){
        System.out.println("Indtast kunde-ID:");
        System.out.println(cusCon.getCustomer(reader.getInt()));
    }

    private void addCustomer(){
        System.out.println("Du er nu i gang med at oprette en kunde.");

        System.out.println("Indtast navn:");
        String name = reader.getString();
        System.out.println("Indtast adresse:");
        String address = reader.getString();
        System.out.println("Indtast postnr:");
        String zip = reader.getString();
        System.out.println("Indtast by:");
        String city = reader.getString();
        System.out.println("Indtast telefonnummer:");
        String phone = reader.getString();

        cusCon.addCustomer(name, address, zip, city, phone);
    }

    private void updateCustomer(){
        System.out.println("Indtast kunde-ID:");
        int id = reader.getInt();
        if(cusCon.getCustomer(id) != null){
            System.out.println("Nuværende navn: " + cusCon.getCustomer(id).getName());
            System.out.println("Opdater navn:");
            String name = reader.getString();
            System.out.println("Nuværende adresse: " + cusCon.getCustomer(id).getAddress());
            System.out.println("Opdater adresse:");
            String address = reader.getString();
            System.out.println("Nuværende postnr: " + cusCon.getCustomer(id).getZip());
            System.out.println("Opdater postnr:");
            String zip = reader.getString();
            System.out.println("Nuværende by: " + cusCon.getCustomer(id).getCity());
            System.out.println("Opdater by:");
            String city = reader.getString();
            System.out.println("Nuværende telefonnummer: " + cusCon.getCustomer(id).getPhone());
            System.out.println("Opdater telefonnummer:");
            String phone = reader.getString();
            cusCon.updateCustomer(id, name, address, zip, city, phone);
        }
        else {
            System.out.println("Indtast venligst et korrekt kunde-ID");
        }
    }

    private void printError(){
        System.out.println("Vælg venligst et nummer fra 1 - 3 eller 9");
    }
}
