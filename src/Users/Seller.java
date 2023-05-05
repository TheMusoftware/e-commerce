package Users;

import Accessories.Headphones;
import Computers.Computer;
import Computers.Laptop;
import Phones.Android;
import Phones.Phone;
import Phones.iPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Seller {
   public List <Computer> computers = new ArrayList<>();
   public List <Phone> phones = new ArrayList<>();
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
        this.userName = this.userName.replace(" ","");
        this.passKey = company.toLowerCase()+"00";
        FileWriter fileWriter = new FileWriter("users.txt",true);
        fileWriter.write(company+"-"+sector+"-"+contact+"-");
        fileWriter.write(getUserName());
        fileWriter.write("-"+getPassKey()+"\n");
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
        FileWriter fileWriter = new FileWriter(getUserName()+"C.txt",true);
        fileWriter.write(selection+" "+brand+" "+model+" "+processor+" "+hasVideoCard+" "+videoCard+" "+storage+" "+memory+" "+battery+" "+webCam+"\n");
        fileWriter.close();
        System.out.println("Added");
    }
    public void addPhone() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to add ?");
        System.out.println("1-Android\n2-iPhone\n3-Other");
        int selection = scan.nextInt();
        String brand,model;
        int releaseYear,camera = 0,storage,stock;
        double price;
        scan.nextLine();
        System.out.print("Brand: ");
        brand = scan.nextLine();
        System.out.print("\nModel: ");
        model = scan.nextLine();
        System.out.print("\nRelease year: ");
        releaseYear = scan.nextInt();
        System.out.print("\nStorage: ");
        storage = scan.nextInt();
        System.out.println("Does it has any camera(y / n)");
        scan.nextLine();
        String camStat = scan.nextLine();
        boolean hasCam = camStat.equals("y") || camStat.equals("Y");
        if(hasCam){
            System.out.print("\nCamera: ");
            camera = scan.nextInt();
        }
        System.out.print("\nPrice: ");
        price = scan.nextDouble();
        System.out.print("\nStock: ");
        stock = scan.nextInt();
        String osVersion ="";
        int memory = 0;
        switch (selection){
            case 1:
                Android android = new Android(brand,model,releaseYear,storage,camera,price,stock);
                phones.add(android);
                osVersion = android.getAndroidVersion();
                memory = android.getTotalMemory();
                break;
            case 2:
                iPhone iphone = new iPhone(model,releaseYear,storage,camera,price,stock);
                phones.add(iphone);
                osVersion = iphone.getoSVersion();
                memory = iphone.getTotalMemory();
                break;
            case 3:
                if(hasCam){
                    Phone phone = new Phone(brand,model,releaseYear,storage,camera,price,stock);
                    phones.add(phone);
                }
                else {
                    Phone phone = new Phone(brand,model,releaseYear,storage,price,stock);
                    phones.add(phone);
                }
                break;
            default:
                break;

        }
        FileWriter fileWriter = new FileWriter(getUserName()+"P.txt",true);
        fileWriter.write(selection+" "+brand+" "+model+" "+releaseYear+" "+hasCam+" "+camera+" "+storage+" "+price+" "+stock+" "+ osVersion+" "+memory+"\n");
        fileWriter.close();
        System.out.println("Added");



    }
    public void updateList() throws IOException {
        //Update Computer
        try {
            File myObj = new File(getUserName()+"C.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(getUserName()+"C.txt"));
            String line = reader.readLine();
            //System.out.println("now read first line");

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


        // Update Phones
        try {
            File myObj = new File(getUserName()+"P.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            reader = new BufferedReader(new FileReader(getUserName() + "P.txt"));
            String line = reader.readLine();
            //System.out.println("now read first line");

            while (line != null) {
                String[] lines = line.split(" ");
                if(lines[0].equals("1")){
                    Phone android = new Android(lines[1],lines[2],Integer.parseInt(lines[3]),Integer.parseInt(lines[6]),Integer.parseInt(lines[5]),Double.parseDouble(lines[7]),Integer.parseInt(lines[8]),lines[9],Integer.parseInt(lines[10]));
                    phones.add(android);
                }
                else if(lines[0].equals("2")){
                    Phone iphone = new iPhone(lines[2],Integer.parseInt(lines[3]),Integer.parseInt(lines[6]),Integer.parseInt(lines[5]),Double.parseDouble(lines[7]),Integer.parseInt(lines[8]),lines[9],Integer.parseInt(lines[10]));
                    phones.add(iphone);
                }
                else if(lines[0].equals("3")){
                    if (lines[4].equals("true")){
                        Phone phone = new Phone(lines[1],lines[2],Integer.parseInt(lines[3]),Integer.parseInt(lines[5]),Integer.parseInt(lines[6]),Double.parseDouble(lines[7]),Integer.parseInt(lines[8]));
                        phones.add(phone);
                    }
                    else {
                        Phone phone = new Phone(lines[1],lines[2],Integer.parseInt(lines[3]),Integer.parseInt(lines[6]),Double.parseDouble(lines[7]),Integer.parseInt(lines[8]));
                        phones.add(phone);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
