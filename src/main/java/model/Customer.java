package model;

public class Customer {

    private String name;
    private Table bookedTable;

    public int bookTable(){
        if(this.bookedTable != null){
            System.out.println("Alraedy Booked..! Table Number : "+this.bookedTable.getTableNumber());
            return this.bookedTable.getTableNumber();
        }
        //check available tables
        Admin admin = Admin.getAdmin();
        for(Table table : admin.getTables()){
            if(table.isAvailable()){
                table.setAvailable(false);
                this.bookedTable = table;
                System.out.println("Booked successfully..! Table Number : "+table.getTableNumber());
                return table.getTableNumber();
            }
        }
        System.out.println("All tables are occupied. Please wait for sometime.");
        return -1;
    }

    public void checkMenu(){

        Menu menu[] = Menu.values();
        System.out.println("Contents of the enum are: ");
        for(Menu item: menu) {
            System.out.println( item +" - "+item.getPrice());
        }
    }
}
