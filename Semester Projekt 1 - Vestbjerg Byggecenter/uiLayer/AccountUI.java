package uiLayer;

import controllerLayer.*;
/**
 * Write a description of class AccountUI here.
 *
 * @author (Group 6)
 * @version (V.1.0)
 */
public class AccountUI
{
    private ReaderUtil reader;
    private AccountController accCon;
    private String[] menus = {"Tilføj konto", "Find konto", "Opdater konto", "Fjern konto", "Tilføj ordre", "Tilføj kunde", "Tilbage"};

    public AccountUI(){
        reader = new ReaderUtil();
        accCon = new AccountController();
    }

    private void printAccountMenu(){
        int i = 1;       
        System.out.println("## KONTO ##\n");
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
            printAccountMenu();
            int userChoice = reader.getInt();
            if(userChoice == 1){
                addAccount();
            }
            else if(userChoice == 2){
                findAccount();
            }
            else if(userChoice == 3){
                updateAccount();
            }
            else if(userChoice == 4){
                addOrder();
            }
            else if(userChoice == 5){
                addOrder();
            }
            else if(userChoice == 6){
                addCustomer();
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

    private void addAccount(){
        System.out.println("Indtast betalingsaftale: ");
        String payment = reader.getString();
        System.out.println("Tilskriv håndværkerrabat: ");
        Integer craftD = reader.getInt();
        System.out.println("Tilskriv mængderabat: ");
        Integer ammountD = reader.getInt(); 
        System.out.println("Tilskriv afhentningsrabat: ");
        Integer pickupD = reader.getInt();
        System.out.println("Indtast saldo: ");
        double balance = reader.getDouble();
        accCon.addAccount(payment, craftD, ammountD, pickupD, balance);
    }

    private void findAccount(){
        System.out.println("Indtast konto-ID: ");
        System.out.println(accCon.getAccount(reader.getInt()));
    }

    private void updateAccount(){
        System.out.println("Du er nu i gang med at opdatere oplysninger på et lån");

        System.out.println("Indtast konto-ID: ");
        int id = reader.getInt();
        if(accCon.getAccount(id) != null){
            System.out.println("Nuværende betalingsaftale: " + accCon.getAccount(id).getPaymentAgreement());
            System.out.println("Opdater betalingsaftale: ");
            String payment = reader.getString();
            System.out.println("Nuværende håndværkerrabat: " + accCon.getAccount(id).getCraftmansDiscount());
            System.out.println("Opdater håndværkerrabat: ");
            Integer craftD = reader.getInt();
            System.out.println("Nuværende mængderabat: " + accCon.getAccount(id).getAmountDiscount());
            System.out.println("Opdater mængderabat: ");
            Integer ammountD = reader.getInt(); 
            System.out.println("Nuværende afhentningsrabat: " + accCon.getAccount(id).getPickupDiscount());
            System.out.println("Opdater afhentningsrabat: ");
            Integer pickupD = reader.getInt();
            System.out.println("Nuværende saldo: " + accCon.getAccount(id).getBalance());
            System.out.println("Opdater saldo: ");
            double balance = reader.getDouble(); 

            accCon.updateAccount(id, payment, craftD, ammountD, pickupD, balance);
        }
        else {
            System.out.println("Indtast venligst et korrekt konto-ID");
        }
    }

    private void addOrder(){
        System.out.println("Indtast konto-ID: ");
        int id = reader.getInt();
        if(accCon.getAccount(id) != null){
            System.out.println("Indtast ordre-ID: ");
            int ordId = reader.getInt();
            accCon.addOrder(id, ordId);
        }
    }
    
    private void addCustomer(){
        System.out.println("Indtast konto-ID: ");
        int acc = reader.getInt();
        if(accCon.getAccount(acc) != null){
            System.out.println("Indtast kunde-ID: ");
            int cust = reader.getInt();
            accCon.addCustomer(acc, cust);
        }
    }

    private void printError(){
        System.out.println("Vælg venligst et nummer fra 1 - 5 eller 9");
    }
}