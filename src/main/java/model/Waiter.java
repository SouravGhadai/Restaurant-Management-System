package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Waiter {

    static Scanner sc = new Scanner(System.in);

    private int id;
    private boolean isFree;
    private int tableNumber;
    private Order order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void placeOrder( ){
        Order order = new Order();
        Map<String, Integer> itemAndQuantity = new HashMap<>();
        this.setOrder( order );
        System.out.println("Item and quantity space separated");
        while(sc.hasNextLine()){
            String orderDtl = sc.nextLine();
            if( orderDtl != null && !orderDtl.isEmpty() ){
                String[] itemQnty = orderDtl.split(" ");
                itemAndQuantity.put(itemQnty[0], Integer.parseInt(itemQnty[1]));
            }else{
                break;
            }
        }
        order.setItemAndQuantity(itemAndQuantity);
    }

    public void checkBill(){
        double totalAmount = 0.00;
        Order order = this.getOrder();
        Map<String, Integer> itemAndQuantity = order.getItemAndQuantity();
        for (Map.Entry<String,Integer> entry : itemAndQuantity.entrySet())
            totalAmount = totalAmount + Menu.valueOf(entry.getKey()).getPrice()*entry.getValue();
        System.out.println("Total Bill : " + totalAmount);
        //post bill generation make free to table and waiter
        this.isFree = true;
        Admin admin = Admin.getAdmin();
        for( Table table : admin.getTables()){
            if(table.getTableNumber() == this.tableNumber){
                table.setAvailable(true);
                break;
            }
        }
    }

    public Waiter(){}

    public Waiter( int id, boolean isFree ){
        this.id = id;
        this.isFree = isFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waiter waiter = (Waiter) o;
        return id == waiter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
