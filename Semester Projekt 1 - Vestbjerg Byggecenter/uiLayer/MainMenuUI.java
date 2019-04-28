package uiLayer;

/**
 * @author (Group 6)
 * @version (V.1.0)
 */
public class MainMenuUI{
    private ReaderUtil reader;
    private OrderUI order;
    private SupplierUI supplier;
    private ProductUI product;
    private CustomerUI customer;
    private EmployeeUI employee;
    private AccountUI account;
    private SaleUI sale;
    private RentUI rent;
    private String[] menus = {"Salg", "Udlej", "Produkt", "Kunde", "Konto", "Leverandør", "Ordre", "Medarbejder", "Afslut"};

    public MainMenuUI(){
        reader = new ReaderUtil();

        supplier = new SupplierUI();
        order = new OrderUI();        
        product = new ProductUI();
        customer = new CustomerUI();
        employee = new EmployeeUI();
        account = new AccountUI();
        sale = new SaleUI();
        rent = new RentUI();
    }

    private void printMainMenu(){
        int i = 1;       
        System.out.println("## VESTBJERG BYGGECENTER ##\n");
        for(String menu: menus) {
            System.out.println("Tryk "+ i + " for " + menu +  " \n ");
            i++;
        }
        System.out.println("###################\n");
    }

    /**
     * Method mainMenu
     *
     */
    public void mainMenu(){
        boolean running = true;
        while(running){
            printMainMenu();
            int userChoice = reader.getInt();
            if(userChoice == 1){
                sale.menu();
            }
            else if(userChoice == 2){
                rent.menu();
            }
            else if(userChoice == 3){
                product.menu();
            }
            else if(userChoice == 4){
                customer.menu();
            }
            else if(userChoice == 5){
                account.menu();
            }
            else if(userChoice == 6){
                supplier.menu();
            }
            else if(userChoice == 7){
                order.menu();
            }
            else if(userChoice == 8){
                employee.menu();
            }
            else if(userChoice == 9){
                running = false;
                System.out.println("Program afsluttet");
            }
            else {
                printError();
            }
        }
    }

    private void printError(){
        System.out.println("Indtast venligst et nummer mellem 1-9");
    }
}