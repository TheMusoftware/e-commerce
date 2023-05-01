import Computers.Computer;
import Phones.Android;
import Phones.Phone;
import Phones.iPhone;
import Users.Customer;
import Users.Seller;

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            File myObj = new File("users.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        FileWriter fileWriter = new FileWriter("users.txt");
        Seller asus = new Seller("Asus","Computer","asus.com");
        /*Seller apple = new Seller("Apple","Technology","support@apple.com");
        Seller samsung = new Seller("Samsung","Technology","help@samsung.com");
        Seller allInOne = new Seller("AllinOne","Everything","033333333");*/
        Customer customer = new Customer("Sinem ****","mkazi@mustafakazi.com");
        //Phone iphoneX = new iPhone("X",2016,128,12,2000,2);
        //Phone s23 = new Android("Samsung","S23",2023,256,24,3000,3);
        Phone nokia3310 = new Phone("Nokia","3310",1990,12,200,2);
       //asus.addPhone();
        customer.phoneList(asus.phones);
        customer.buyAllBasket();




    }
}
