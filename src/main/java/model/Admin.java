package model;

import java.util.Set;
import java.util.stream.Collectors;

public class Admin {

    public static Admin admin;

    private Set<Table> tables;
    private Set<Waiter> waiters;

    public Set<Table> getTables() {
        return tables;
    }

    public void setTables(Set<Table> tables) {
        this.tables = tables;
    }

    public Set<Waiter> getWaiters() {
        return waiters;
    }

    public void setWaiters(Set<Waiter> waiters) {
        this.waiters = waiters;
    }

    public void addTable(Table table){
        this.tables.add(table);
    }

    public void assignWaiterToTable( int waiterId, int tableNumber ){
        Waiter waiter = this.waiters.stream().filter(a -> a.getId() == waiterId).collect(Collectors.toList()).get(0);
        waiter.setTableNumber( tableNumber );
        waiter.setFree(false);
    }

    public Waiter assignWaiterToTable( int tableNumber){
        for(Waiter waiter : this.getWaiters()){
            if(waiter.isFree()){
                waiter.setFree(false);
                //Table table = this.tables.stream().filter(a -> a.getTableNumber() == tableNumber).collect(Collectors.toList()).get(0);
                waiter.setTableNumber(tableNumber);
                System.out.println("Waiter with id : "+ waiter.getId() + " assigned to table : " + tableNumber );
                return waiter;
            }
        }
        System.out.println("No waiter is free");
        return null;
    }

    private Admin(){

    }

    public static Admin getAdmin(){
        if ( admin == null )
            admin = new Admin();
        return admin;
    }
}
