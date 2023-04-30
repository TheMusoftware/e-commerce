package Users;

import Accessories.Headphones;
import Computers.Computer;
import Computers.Laptop;
import Phones.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Seller {
   public List <Computer> computers = new ArrayList<>();
    List <Phone> phones = new ArrayList<>();
    List <Headphones> headphones = new ArrayList<>();
    String company;
    String sector;
    String contact;
    private String userName;
    private String passKey;


    public Seller(String company, String sector, String contact) throws IOException {
        Scanner scan = new Scanner(System.in);
        this.company = company;
        this.sector = sector;
        this.contact = contact;
        this.userName = company.toLowerCase();
        this.passKey = company.toLowerCase()+"00";
        FileWriter fileWriter = new FileWriter("users.txt",true);
        fileWriter.write(getUserName());
        fileWriter.write("\n"+getPassKey()+"\n\n");
        fileWriter.close();
        updateList();
    }
    public void addComputer() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to add ?");
        System.out.print("1-Computer \n2-Laptop\n");
        int selection = scan.nextInt();
        System.out.print("The computer has any video card (y/n)\n");
        String ch = scan.next();
        scan.nextLine();
        boolean hasVideoCard = ch.equals("y") || ch.equals("Y");
        System.out.print("Brand: ");
        String brand = scan.nextLine();
        System.out.print("\nModel: ");
        String model =scan.nextLine();
        System.out.print("\nProcessor: ");
        String processor = scan.nextLine();
        String videoCard="";
        if(hasVideoCard){
            System.out.print("\nVideo Card: ");
            videoCard = scan.nextLine();
        }
        System.out.print("\nStorage (GB): ");
        int storage = scan.nextInt();
        System.out.print("\nMemory (MB):");
        int memory = scan.nextInt();
        double battery =0;
        int webCam = 0;

        Computer computer = new Computer();
        switch (selection){
            case 1:

                if(hasVideoCard) {
                    computer = new Computer(brand, model, processor, videoCard, storage, memory);
                }
                else {
                     computer = new Computer(brand,model,processor,storage,memory);
                }
                computers.add(computer);
                break;
            case 2:
                Computer laptop;
                System.out.print("Battery: ");
                battery = scan.nextDouble();
                System.out.println("\nWebCam: ");
                webCam = scan.nextInt();
                if(hasVideoCard) {
                    laptop = new Laptop(brand, model, processor, videoCard, storage, memory,battery,webCam);
                }
                else {
                    laptop = new Laptop(brand,model,processor,storage,memory,battery,webCam);
                }
                computers.add(laptop);
                break;
            default:
                break;
        }
        FileWriter fileWriter = new FileWriter(getUserName()+".txt",true);
        fileWriter.write(selection+" "+brand+" "+model+" "+processor+" "+hasVideoCard+" "+videoCard+" "+storage+" "+memory+" "+battery+" "+webCam+"\n");
        fileWriter.close();
        System.out.println("Added");
    }
    public void updateList() throws FileNotFoundException {
        try {
            File myObj = new File(getUserName()+".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(getUserName()+".txt"));
            String line = reader.readLine();
            System.out.println("now read first line");

            while (line != null) {
                String[] lines = line.split(" ");
                if(lines[0].equals("1")){
                    if(lines[4].equals("true")){
                        Computer computer = new Computer(lines[1],lines[2],lines[3],lines[5],Integer.parseInt(lines[6]),Integer.parseInt(lines[7]));
                        computers.add(computer);
                        System.out.println("added");
                    }
                    else {
                        Computer computer = new Computer(lines[1],lines[2],lines[3],Integer.parseInt(lines[6]),Integer.parseInt(lines[7]));
                        computers.add(computer);
                    }

                } else if (lines[0].equals("2")) {
                    if(lines[4].equals("true")){
                        Computer laptop = new Laptop(lines[1],lines[2],lines[3],lines[5],Integer.parseInt(lines[6]),Integer.parseInt(lines[7]),Double.parseDouble(lines[8]),Integer.parseInt(lines[9]));
                        computers.add(laptop);
                    }
                    else {
                        Computer laptop = new Laptop(lines[1],lines[2],lines[3],Integer.parseInt(lines[6]),Integer.parseInt(lines[7]),Double.parseDouble(lines[8]),Integer.parseInt(lines[9]));
                        computers.add(laptop);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void addPhones(){

    }
    protected void addAccessories(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassKey() {
        return passKey;
    }

    public void setPassKey(String passKey) {
        this.passKey = passKey;
    }
}
