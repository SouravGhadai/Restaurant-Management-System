import model.Admin;
import model.Customer;
import model.Table;
import model.Waiter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestaurantManagement {

    public static void main(String[] args){
        Admin admin = Admin.getAdmin();
        //initialize tables and waiter for restaurant
        Table t1 = new Table( 1, true);
        Table t2 = new Table( 2, true);
        Table t3 = new Table( 3, true);
        Table t4 = new Table( 4, true);
        Table t5 = new Table( 5, true);

        Set<Table> tableList = new HashSet<>();
        tableList.add(t1); tableList.add(t2); tableList.add(t3); tableList.add(t4); tableList.add(t5);
        admin.setTables(tableList);

        Waiter w1 = new Waiter( 1, true);
        Waiter w2 = new Waiter( 2, true);
        Waiter w3 = new Waiter( 3, true);
        Waiter w4 = new Waiter( 4, true);
        Waiter w5 = new Waiter( 5, true);

        Set<Waiter> waiterList = new HashSet<>();
        waiterList.add(w1); waiterList.add(w2); waiterList.add(w3); waiterList.add(w4); waiterList.add(w5);
        admin.setWaiters(waiterList);


        //Here operations
        Customer customer = new Customer();
        int tableNumber = customer.bookTable();
        customer.checkMenu();

        Waiter waiter = admin.assignWaiterToTable(tableNumber);

        waiter.placeOrder();
        waiter.checkBill();


        Table t10 = new Table( 10, true);
        admin.addTable(t10);

    }
}
