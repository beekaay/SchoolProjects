package modelLayer;

import java.util.*;

public class ProductContainer
{
    private static ProductContainer instance;
    private static ArrayList<Product> product; 

    /**
     * ProductContainer Constructor
     *
     */
    private ProductContainer()
    {
        product = new ArrayList<Product>();
    }

    /**
     * Method getInstance
     *
     * @return The return value
     */
    public static ProductContainer getInstance(){
        if(instance == null){
            instance = new ProductContainer();
        }
        return instance;
    }

    /**
     * Method getProduct
     *
     * @param id A parameter
     * @return The return value
     */
    public Product getProduct(int id){
        return product.get(id);
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
        Product pro = new Product(minStock, maxStock, serialNumber, name, type, description, 
                color, rentPrice, price, amount, supplierPrice, discount);
        product.add(pro);
    }

    /**
     * Method removeProduct
     *
     * @param id A parameter
     */
    public void removeProduct(int id){
        product.remove(id);
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
    double supplierPrice, double discount)
    {  
        Product o = getProduct(id);
        o.setFields(null, minStock, maxStock, serialNumber, name, type, description, 
            color, rentPrice, price, amount, supplierPrice, discount);
    }

    /**
     * Method size
     *
     * @return The return value
     */
    public int size(){
        return product.size();
    }

    /**
     * Method toggleActive
     *
     * @param id A parameter
     */
    public void toggleActive(int id) {
        product.get(id).toggleActive();
    }
}
