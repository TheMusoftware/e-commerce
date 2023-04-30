import Computers.Computer;
import Users.Seller;

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
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
        Seller apple = new Seller("Apple","Technology","support@apple.com");
        Seller samsung = new Seller("Samsung","Technology","help@samsung.com");
        Seller allInOne = new Seller("All in One","Everything","033333333");

        //asus.addComputer();
       // asus.addComputer();
       // asus.addComputer();
        for(Computer cpt : asus.computers ){
            System.out.println(cpt.toString());
        }




    }
}
