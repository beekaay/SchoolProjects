package uiLayer;

import controllerLayer.*;
/**
 * Write a description of class SaleUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaleUI
{
    private ReaderUtil reader;
    private CustomerController custCtrl;
    private OrderController odrCtrl;
    private AccountController accCtrl;
    private boolean running;
    private String[] menus = {"Kunde: kontant", "Kunde: Konto", "Uden konto", "Tilbage"};
    public SaleUI()
    {
        reader = new ReaderUtil();
        custCtrl = new CustomerController();
        odrCtrl = new OrderController();
        accCtrl = new AccountController();
        running = true;

    }

    public void menu(){
        running = true;
        while(running){
            printAccountMenu();
            int userChoice = reader.getInt();
            if(userChoice == 1){
                addCustomerSale();              
            }
            else if(userChoice == 2){
                addAccountSale();
            }
            else if(userChoice == 3){
                addNoCusSale();
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

    private void printAccountMenu(){
        int i = 1;       
        System.out.println("## SALG ##\n");
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

    private void addAccountSale(){
        System.out.println("Vil du oprette en ny ordre? J/n?");
        String response = reader.getString();
        if(response.toLowerCase().trim().equals("j")) {
            System.out.println("Du er nu i gang med at oprette en ordre");

            System.out.println("Indtast Track & Trace:");
            String trackAndTrace = reader.getString();
            System.out.println("Indtast vægt:");
            Double weight = reader.getDouble();
            System.out.println("Indtast coli:");
            Double coli = reader.getDouble();        
            odrCtrl.addOrder(trackAndTrace, weight, coli);
            System.out.println("Ordre oprettet\nIndtast venligst konto-ID");
            int acc = reader.getInt();
            if(accCtrl.getAccount(acc) != null){
                accCtrl.addOrder(acc, odrCtrl.getLastOrder()-1);
            }

            boolean looping = true;
            while(looping){
                addProducts();
                System.out.println("Vil du tilføje flere produkter? J/n");
                String responsez = reader.getString();
                if(!responsez.toLowerCase().equals("j")){
                    looping = false;
                }
            }

            odrCtrl.finishOrder(acc, (int)accCtrl.getAccount(acc).getTotalDiscount());
        }

        else if (response.toLowerCase().trim().equals("n")){
            running = false;
        }
        else{
            System.out.println("Ugyldig indtastning!");
            addAccountSale();
        }
    }

    private void addCustomerSale(){
        System.out.println("Vil du oprette en ny ordre? J/n?");
        String response = reader.getString();
        if(response.toLowerCase().trim().equals("j")) {
            System.out.println("Du er nu i gang med at oprette en ordre");

            System.out.println("Indtast Track & Trace:");
            String trackAndTrace = reader.getString();
            System.out.println("Indtast vægt:");
            Double weight = reader.getDouble();
            System.out.println("Indtast coli:");
            Double coli = reader.getDouble();        
            odrCtrl.addOrder(trackAndTrace, weight, coli);
            System.out.println("Ordre oprettet\nIndtast venligst kunde-ID");
            int cust = reader.getInt();
            if(custCtrl.getCustomer(cust) != null){
                custCtrl.addOrder(cust, odrCtrl.getLastOrder()-1);
            }
            boolean looping = true;
            while(looping){
                addProducts();
                System.out.println("Vil du tilføje flere produkter? J/n");
                String responsez = reader.getString();
                if(!responsez.toLowerCase().equals("j")){
                    looping = false;
                }
            }
            odrCtrl.finishOrder(cust);
        }
        else if (response.toLowerCase().trim().equals("n")){
            running = false;
        }
        else{
            System.out.println("Ugyldig indtastning!");
            addCustomerSale();
        }
    }

    private void addNoCusSale(){
        System.out.println("Du er nu i gang med at oprette en ordre");

        System.out.println("Indtast Track & Trace:");
        String trackAndTrace = reader.getString();
        System.out.println("Indtast vægt:");
        Double weight = reader.getDouble();
        System.out.println("Indtast coli:");
        Double coli = reader.getDouble();        
        odrCtrl.addOrder(trackAndTrace, weight, coli);

        boolean looping = true;
        while(looping){
            addProducts();
            System.out.println("Vil du tilføje flere produkter? J/n");
            String responsez = reader.getString();
            if(!responsez.toLowerCase().equals("j")){
                looping = false;
            }
        }
        odrCtrl.finishOrder();
    }


    private void printError(){
        System.out.println("Vælg venligst et nummer fra 1 - 3 eller 9");
    }

    private void addProducts(){
        System.out.println("Indtast produkt-ID");
        int product = reader.getInt();
        System.out.println("Mængde: ");
        odrCtrl.addProduct(product, reader.getInt());
    }

    private void addProductsNo(){
        System.out.println("Indtast produkt-ID");
        int product = reader.getInt();
        System.out.println("Mængde: ");
        odrCtrl.addProduct(product, reader.getInt());
    }

}
