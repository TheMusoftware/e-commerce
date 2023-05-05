package Users;

import Computers.Computer;
import Phones.Phone;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    String name;
    String mail;
    String userName;
    String passKey;

    private double basketPrice = 0.0;
     List <Computer> basketC = new ArrayList<>();
    List <Phone> basketP = new ArrayList<>();
    public Customer(String name, String mail) throws IOException {
        this.name = name;
        this.mail = mail;
        this.userName = name.replace(" ","");
        this.userName = this.userName.toLowerCase();
        this.passKey = name.replace(" ","");
        this.passKey = this.passKey.toLowerCase();
        this.passKey+="++";
        FileWriter fileWriter = new FileWriter("users.txt",true);
        fileWriter.write(name+"-"+mail+"-");
        fileWriter.write("-<101>-");
        fileWriter.write(this.userName);
        fileWriter.write("-"+this.passKey+"\n");
        fileWriter.close();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassKey() {
        return passKey;
    }

    public void phoneList(List <Phone> list){
        Scanner scan = new Scanner(System.in);
        int index = 1;
        for(Phone phone : list){
            System.out.println(index++);
            System.out.println(phone.getBrand()+ " "+phone.getModel());
        }
        System.out.print("Selection: ");
        index = scan.nextInt();
        Phone phone = list.get(index-1);
        System.out.println("\n\n\t\tTechnical Specs for "+phone.getBrand()+" "+phone.getModel());
        System.out.println(phone.toString());
        System.out.println("\n Press 1 to buy, Press 0 to back");
        index = scan.nextInt();
        if(index == 1) addBasket(phone);
        else phoneList(list);

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
