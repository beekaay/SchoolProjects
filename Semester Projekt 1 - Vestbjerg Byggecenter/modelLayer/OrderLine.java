package modelLayer;

import java.util.*;

public class OrderLine {
    // instance variables

    private LinkedList<Product> products;
    private OrderContainer odrCon;
    private ProductContainer prodCon;

    public OrderLine() {
        // initialise instance variables
        products = new LinkedList();
        odrCon = OrderContainer.getInstance();
        prodCon = ProductContainer.getInstance();
    }

    //Get method

    //Set methods
    public void addProduct(int p, int a){
        for(int i=1;i<=a;i++){
            products.add(prodCon.getProduct(p));
        }        
    }

    public void addProduct(int p){
        products.add(prodCon.getProduct(p));
    }    

    //Other methods
    public void finishOrder(int id, int disc){
        Order o = odrCon.getOrder(id);
        double total = 0;
        if(disc > 20)
            disc = 20;
        System.out.println("## KVITTERING ##");
        for(Product p : products){
            o.addProduct(p);
            System.out.println(p.getName() + ": " + p.getPrice() );
            total = total + p.getPrice();
        }   
        System.out.println("Total: " + (double)total * (double)((100d - disc)/100d) );
        System.out.println("###########\n");
        products.clear();
    }
    
    public void finishOrder(int id){
        Order o = odrCon.getOrder(id);
        double total = 0;
        System.out.println("## KVITTERING ##");
        for(Product p : products){
            o.addProduct(p);
            System.out.println(p.getName() + ": " + p.getPrice() );
            total = total + p.getPrice();
        }   
        System.out.println("Total: " + total);
        System.out.println("###########\n");
        products.clear();
    }

    public void finishOrder(){
        double total = 0;
        System.out.println("## KVITTERING ##");
        for(Product p : products){
            System.out.println(p.getName()+ ": " + p.getPrice());
            total = total + p.getPrice();
        }    
        System.out.println("Total: " + total);
        System.out.println("###########\n");
        products.clear();

    }
}