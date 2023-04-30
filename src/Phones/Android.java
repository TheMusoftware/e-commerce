package Phones;

import java.util.Scanner;

public class Android extends Phone{
    private String androidVersion;
    private int totalMemory;

    // Android phones must have to cam
    public Android(String brand, String model, int releaseYear, int storage,int camera, double price, int stock) {
        super(brand, model, releaseYear, storage, camera, price, stock);
        Scanner scan = new Scanner(System.in);
        System.out.println("You are about to add an android phone fill in the following information");
        System.out.println();
        System.out.print("Enter android version: ");
        this.androidVersion = scan.nextLine();
        System.out.println();
        System.out.print("Enter total Memory: ");
        this.totalMemory = scan.nextInt();
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    @Override
    public String toString(){
        String str = "Brand: "+getBrand()+"\nModel: "+getModel()+"\nRelease Year: "+getReleaseYear()+"\nStorage: "+getStorage()+" GB";
        str+="\nMemory: "+getTotalMemory()+" MB";
        str+="\nCamera: "+getCamera();
        str+="\nAndroid version: "+getAndroidVersion();
        str+="\nPrice: $"+getPrice()+"\nStock: "+getStock();
        str+="\n";
        return str;
    }
}
