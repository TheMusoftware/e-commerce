package Users;

import Computers.Computer;
import Phones.Phone;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    String name;
    String mail;
    private double basketPrice = 0.0;
     List <Computer> basketC = new ArrayList<>();
    List <Phone> basketP = new ArrayList<>();
    public Customer(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }
    public void addBasket(Computer computer){
        basketC.add(computer);
    }
    public void addBasket(Phone phone){
        if(phone.getStock() > 0){
            basketP.add(phone);
            phone.setStock(phone.getStock()-1);
        }
        else System.out.println("Stock out....");

    }
    public void buyAllBasket(){
        for(Computer computer : basketC){
            basketPrice+=computer.getPrice();
            //System.out.printf("1X\t\t%s15",computer.getBrand()+" "+computer.getModel()+"Price: $"+computer.getPrice()+"%n");
            System.out.printf("1X %5s %-10s %1s %-10s Price: $ %.1f%n"," ",computer.getBrand()," ",computer.getModel(),computer.getPrice());
        }
        basketC.clear();
        for(Phone phone : basketP){
            basketPrice+=phone.getPrice();
            System.out.printf("1X %5s %-10s %1s %-10s Price: $ %.1f%n"," ",phone.getBrand()," ",phone.getModel(),phone.getPrice());
        }
        basketP.clear();
        System.out.println("Total paid $"+basketPrice);
        System.out.println("Have a nice day "+name);
    }
}
