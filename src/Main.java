import Computers.Computer;
import Phones.Android;
import Phones.Phone;
import Phones.iPhone;
import Users.Customer;
import Users.Seller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Seller seller;
    static Customer customer;
    static List <Seller> sellerList = new ArrayList<>();
    static List <Customer> customerList = new ArrayList<>();
    static void updateUsers() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        String line = reader.readLine();
        String firstLine = line;
        while(true){
            String [] lineElements = line.split("-");
            if(lineElements[3].equals("<101>")){
                Customer customer1 = new Customer(lineElements[0],lineElements[1]);
                customerList.add(customer1);
            }
            else{
                Seller seller1 = new Seller(lineElements[0],lineElements[1],lineElements[2]);
                if(!sellerList.contains(seller1)) {
                    sellerList.add(seller1);
                }
            }
            line = reader.readLine();
            if(firstLine.equals(line)) break;

        }
        reader.close();
    }

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
       updateUsers();


        FileWriter fileWriter = new FileWriter("users.txt",true);
       // Seller apple = new Seller("Apple","Technology","support@apple.com");
       // Seller samsung = new Seller("Samsung","Technology","help@samsung.com");
        //Seller allInOne = new Seller("AllinOne","Everything","033333333");
        //Customer customer = new Customer("Mustafa Kazı" ,"mkazi@mustafakazi.com");
        //Phone iphoneX = new iPhone("X",2016,128,12,2000,2);
        //Phone s23 = new Android("Samsung","S23",2023,256,24,3000,3);
        //Phone nokia3310 = new Phone("Nokia","3310",1990,12,200,2);
       //asus.addPhone();

        // LOGIN PANEL
       // updateUsers();

        Scanner scan = new Scanner(System.in);
        //BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        System.out.println("Welcome to address of the e-commerce");
        System.out.println("1-Customer Login");
        System.out.println("2-Seller Login");
        boolean customerStatus = scan.nextLine().equals("1");
        System.out.print("Enter your username: ");
        String username = scan.nextLine();
        String password ="";
        //String line = reader.readLine();

       /* while (true){ // Get and Set Pass
            String [] lineElements  = line.split("-");
            if(lineElements[3].equals(username)){
                password = lineElements[4];
                reader.close();
                if(customerStatus){
                    customer = new Customer(lineElements[0],lineElements[1]);
                }
                else{
                    seller = new Seller(lineElements[0],lineElements[1],lineElements[2]);
                }
                break;
            }
            line = reader.readLine();
        }*/
        for(Seller customer1 : sellerList){
            if(customer1.getUserName().equals(username)){
                password = customer1.getPassKey();
                System.out.println(password );
                seller = customer1;
                System.out.println("wel");
            }
        }


        System.out.print("\nEnter your password: ");
        String userEnteredPass = scan.nextLine();
        if(userEnteredPass.equals(password)){
            System.out.println("You're right");
            customer.buyAllBasket();
        }
        else System.out.println("You are wrong");





    }
}
