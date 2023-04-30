package Computers;

import java.util.Scanner;

public class Laptop extends Computer{
    private double battery;
    private int webCam;
    private double price;

    public Laptop(String brand, String model, String processor, String videoCard, int storage, int memory) {
        super(brand, model, processor, videoCard, storage, memory);
        Scanner scan = new Scanner(System.in);
        System.out.print("Battery: ");
        this.battery = scan.nextDouble();
        System.out.print("\nWebCam(MP): ");
        this.webCam = scan.nextInt();
        this.price = addComponentsPrice(super.getPrice());
    }

    public Laptop(String brand, String model, String processor, int storage, int memory) {
        super(brand, model, processor, storage, memory);
        Scanner scan = new Scanner(System.in);
        System.out.print("Battery: ");
        this.battery = scan.nextDouble();
        System.out.print("\nWebCam(MP): ");
        this.webCam = scan.nextInt();
        this.price = addComponentsPrice(super.getPrice());
    }
    double addComponentsPrice(double price){
        if(battery<25) price+=100;
        else if(battery<50) price+=200;
        else if(battery<75) price+=300;
        else price+=500;
        if(webCam<2) price+=50;
        else if(webCam<8) price+=100;
        else price+=250;
        return price;
    }

    public double getBattery() {
        return battery;
    }

    public int getWebCam() {
        return webCam;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        String str ="";
        str+="Brand: "+ getBrand()+"\t\tModel: "+getModel();
        str+="\nProcessor: "+getProcessor()+"\t\t Video Card: "+getVideoCard();
        str+="\nStorage: "+getStorage()+"GB"+"\t\tMemory: "+getMemory()+"MB";
        str+="\nBattery: "+getBattery()+"mAh\t\tWebCam: "+getWebCam()+" MP\n";
        str+="Price: $"+ getPrice()+"\n";
        return str;
    }

}
