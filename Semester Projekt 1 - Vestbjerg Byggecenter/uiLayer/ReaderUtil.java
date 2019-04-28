package uiLayer;

import java.util.Scanner;
/**
 * @author (Group 6)
 * @version (V.1.0)
 */
public class ReaderUtil{
    private Scanner keyboard;

    /**
     * ReaderUtil Constructor
     *
     */
    public ReaderUtil(){
        keyboard = new Scanner(System.in);
    }

    /**
     * Method getInt
     *
     * @return The return value
     */
    public int getInt(){
        try{
            return keyboard.nextInt();
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }

    /**
     * Method getDouble
     *
     * @return The return value
     */
    public double getDouble(){
        try{
            return keyboard.nextDouble();
        }
        catch(Exception e){
            System.out.println(e);
            return -1d;
        }
    }

    /**
     * Method getString
     *
     * @return The return value
     */
    public String getString(){
        try{
            return keyboard.next();
        } 
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    /**
     * Method getBool
     *
     * @return The return value
     */
    public boolean getBool(){
        try{
            return keyboard.nextBoolean();
        }
        catch(Exception e){
            System.out.println(e);
            return true;
        }
    }

    /**
     * Method clear
     *
     */
    public void clear(){
        keyboard.reset();
    }
}
