package uiLayer;

import controllerLayer.*;
/**
 * Write a description of class OrderUI here.
 *
 * @author (Group 6)
 * @version (V.1.0)
 */
public class OrderUI
{
    private ReaderUtil reader;
    private OrderController orderCon;
    private String[] menus = {"Opret ordre", "Søg ordre", "Opdater order", "Gå tilbage"};

    public OrderUI(){
        reader = new ReaderUtil();
        orderCon = new OrderController();
    }

    private void printOrderMenu(){
        int i = 1;       
        System.out.println("## ORDRE ##\n");
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
            printOrderMenu();
            int userChoice = reader.getInt();
            if(userChoice == 1){
                addOrder();
            }
            else if(userChoice == 2){
                getOrder();
            }
            else if(userChoice == 3){
                updateOrder();
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

    private void getOrder(){
        System.out.println("Indtast ordre-ID:");
        System.out.println(orderCon.getOrder(reader.getInt()));
    }

    private void addOrder(){
        System.out.println("Du er nu i gang med at oprette en ordre.");

        System.out.println("Indtast Track & Trace:");
        String trackAndTrace = reader.getString();
        System.out.println("Indtast vægt:");
        Double weight = reader.getDouble();
        System.out.println("Indtast coli:");
        Double coli = reader.getDouble();        

        orderCon.addOrder(trackAndTrace, weight, coli);
    }

    private void removeOrder(){
        System.out.println("Indtast ordre-ID");
        orderCon.toggleActive(reader.getInt());
    }

    private void updateOrder(){
        System.out.println("Indtast ordre-ID:");
        int id = reader.getInt();
        if(orderCon.getOrder(id) != null){
            System.out.println("Nuværende Track & Trace: " + orderCon.getOrder(id).getTrackAndTrace());
            System.out.println("Opdater Track & Trace:");
            String trackAndTrace = reader.getString();
            System.out.println("Nuværende vægt: " + orderCon.getOrder(id).getWeight());
            System.out.println("Opdater vægt:");
            double weight = reader.getDouble();
            System.out.println("Nuværende coli: " + orderCon.getOrder(id).getColi());
            System.out.println("Opdater coli:");
            double coli = reader.getDouble();
            orderCon.updateOrder(id, trackAndTrace, weight, coli);
        }
        else
        {
            System.out.println("Indtast venligst et korrekt ordre-ID");
        }

    }

    private void printError(){
        System.out.println("Vælg venligst et nummer fra 1 - 3 eller 9");

    }
}