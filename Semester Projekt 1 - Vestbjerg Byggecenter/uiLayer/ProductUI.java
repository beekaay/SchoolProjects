package uiLayer;

import controllerLayer.ProductController;
/**
 * Write a description of class ProductUI here.
 *
 * @author (Group 6)
 * @version (V.1.0)
 */
public class ProductUI{
    private ReaderUtil reader;
    private ProductController proCon;
    private String[] menus = {"Opret produkt", "Søg produkt", "Opdater produkt", "Fjern produkt", "Tilbage"};

    public ProductUI(){
        reader = new ReaderUtil();
        proCon = new ProductController();
    }

    private void printProductMenu(){
        int i = 1;       
        System.out.println("## PRODUKT ##\n");
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
        boolean programRunning = true;
        while(programRunning){
            printProductMenu();
            int userChoice = reader.getInt();
            if(userChoice == 1){
                addProduct();
            }
            else if(userChoice == 2){
                getProduct();
            }
            else if(userChoice == 3){
                updateProduct();
            }
            else if(userChoice == 4){
                removeProduct();
            }
            else if(userChoice == 9){
                reader.clear();
                programRunning = false;
            }
            else {
                printError();
            }

        }
    }

    private void getProduct(){
        System.out.println("Indtast produkt-ID:");
        System.out.println(proCon.getProduct(reader.getInt()));
        
    }

    private void addProduct(){
        System.out.println("Du er nu i gang med at tilføje et produkt.");

        System.out.println("Angiv minimum lagerbeholdning:");
        int minStock = reader.getInt();
        System.out.println("Angiv maksimum lagerbeholdning:");
        int maxStock = reader.getInt();
        System.out.println("Indtast serienummer:");
        String serialNumber = reader.getString();
        System.out.println("Indtast navn:");
        String name = reader.getString();
        System.out.println("Angiv type:");
        String type = reader.getString();
        System.out.println("Angiv beskrivelse:");
        String description = reader.getString();
        System.out.println("Angiv farve:");
        String color = reader.getString();
        System.out.println("Angiv udlejningspris:");
        double rentPrice = reader.getDouble();
        System.out.println("Angiv pris:");
        double price = reader.getDouble();
        System.out.println("Angiv mængde:");
        double amount = reader.getDouble();
        System.out.println("Angiv indkøbspris:");
        double supplierPrice = reader.getDouble();
        System.out.println("Angiv rabat:");
        double discount = reader.getDouble();

        proCon.addProduct(minStock, maxStock, serialNumber, name, type, description, 
            color, rentPrice, price, amount, supplierPrice, discount);
    }

    private void updateProduct(){
        System.out.println("Du er ved at redigere et produkt.");

        System.out.println("Indtast produkt-ID:");
        int id = reader.getInt();
        if(proCon.getProduct(id) != null){
            System.out.println("Nuværende minimum lagerbeholdning: " + proCon.getProduct(id).getMinStock());
            System.out.println("Opdater minimum lagerbeholdning:");
            int minStock = reader.getInt();
            System.out.println("Nuværende maksimum lagerbeholdning: " + proCon.getProduct(id).getMaxStock());
            System.out.println("Opdater maksimum lagerbeholdning:");
            int maxStock = reader.getInt();
            System.out.println("Nuværende serienummer: " + proCon.getProduct(id).getSerialNumber());
            System.out.println("Opdater serienummer:");
            String serialNumber = reader.getString();
            System.out.println("Nuværende navn: " + proCon.getProduct(id).getName());
            System.out.println("Opdater navn:");
            String name = reader.getString();
            System.out.println("Nuværende type: " + proCon.getProduct(id).getType());
            System.out.println("Opdater type:");
            String type = reader.getString();
            System.out.println("Nuværende beskrivelse: " + proCon.getProduct(id).getDescription());
            System.out.println("Opdater beskrivelse:");
            String description = reader.getString();
            System.out.println("Nuværende farve: " + proCon.getProduct(id).getColor());
            System.out.println("Opdater farve:");
            String color = reader.getString();
            System.out.println("Nuværende udlejningspris: " + proCon.getProduct(id).getRentPrice());
            System.out.println("Opdater udlejningspris:");
            double rentPrice = reader.getDouble();
            System.out.println("Nuværende pris: " + proCon.getProduct(id).getPrice());
            System.out.println("Opdater pris:");
            double price = reader.getDouble();
            System.out.println("Nuværende mængde: " + proCon.getProduct(id).getAmount());
            System.out.println("Opdater mængde:");
            double amount = reader.getDouble();
            System.out.println("Nuværende indkøbspris: " + proCon.getProduct(id).getSupplierPrice());
            System.out.println("Opdater indkøbspris:");
            double supplierPrice = reader.getDouble();
            System.out.println("Nuværende rabat: " + proCon.getProduct(id).getDiscount());
            System.out.println("Opdater rabat:");
            double discount = reader.getDouble();

            proCon.updateProduct(id, minStock, maxStock, serialNumber, name, type, description, 
                color, rentPrice, price, amount, supplierPrice, discount);
        }
        else {
            System.out.println("Indtast venligst et korrekt produkt-ID");
        }
    }

    private void removeProduct(){
        System.out.println("Indtast produkt-ID");
        proCon.toggleActive(reader.getInt());
    }

    private void printError(){
        System.out.println("Vælg venligst et nummer fra 1 - 4 eller 9");
    }
}