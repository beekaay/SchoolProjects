package controllerLayer;
import java.util.*;
import modelLayer.*;

public class ProductController{
    private ProductContainer proCon;

    /**
     * ProductController Constructor
     *
     */
    public ProductController(){
        proCon = ProductContainer.getInstance();
    }

    /**
     * Method getProduct
     *
     * @param id A parameter
     * @return The return value
     */
    public Product getProduct(int id){
        return proCon.getProduct(id);
    }

    /**
     * Method addProduct
     *
     * @param minStock A parameter
     * @param maxStock A parameter
     * @param serialNumber A parameter
     * @param name A parameter
     * @param type A parameter
     * @param description A parameter
     * @param color A parameter
     * @param rentPrice A parameter
     * @param price A parameter
     * @param amount A parameter
     * @param supplierPrice A parameter
     * @param discount A parameter
     */
    public void addProduct(Integer minStock, Integer maxStock, String serialNumber, String name, 
    String type, String description, String color, double rentPrice, double price, double amount, 
    double supplierPrice, double discount){
        proCon.addProduct(minStock, maxStock, serialNumber, name, type, description, 
            color, rentPrice, price, amount, supplierPrice, discount);
    }

    /**
     * Method removeProduct
     *
     * @param id A parameter
     */
    public void removeProduct(int id){
        proCon.removeProduct(id);
    }

    /**
     * Method updateProduct
     *
     * @param id A parameter
     * @param minStock A parameter
     * @param maxStock A parameter
     * @param serialNumber A parameter
     * @param name A parameter
     * @param type A parameter
     * @param description A parameter
     * @param color A parameter
     * @param rentPrice A parameter
     * @param price A parameter
     * @param amount A parameter
     * @param supplierPrice A parameter
     * @param discount A parameter
     */
    public void updateProduct(int id, Integer minStock, Integer maxStock, String serialNumber, String name, 
    String type, String description, String color, double rentPrice, double price, double amount, 
    double supplierPrice, double discount){
        proCon.updateProduct(id, minStock, maxStock, serialNumber, name, type, description, color, rentPrice, price, amount, supplierPrice, discount);
    }

    /**
     * Method toggleActive
     *
     * @param id A parameter
     */
    public void toggleActive(int id){
        proCon.toggleActive(id);
    }

}
