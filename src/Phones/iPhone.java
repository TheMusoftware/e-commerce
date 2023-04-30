package Phones;

import java.util.Scanner;

public class iPhone extends Phone {
    private String oSVersion;
    private int totalMemory;
    public iPhone( String model, int releaseYear, int storage, int camera, double price, int stock) {
        super("Apple iPhone", model, releaseYear, storage, camera, price, stock);
        Scanner scan = new Scanner(System.in);
        System.out.println("You are about to add an  iPhone fill in the following information");
        System.out.println();
        System.out.print("Enter iOS version: ");
        this.oSVersion = scan.nextLine();
        System.out.println();
        System.out.print("Enter total Memory: ");
        this.totalMemory = scan.nextInt();
    }
    public iPhone (String model, int releaseYear, int storage, int camera, double price, int stock,String oSVersion,int totalMemory){
        super("Apple iPhone", model, releaseYear, storage, camera, price, stock);
        this.oSVersion = oSVersion;
        this.totalMemory = totalMemory;
    }

    public void setoSVersion(String oSVersion) {
        this.oSVersion = oSVersion;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    public String getoSVersion() {
        return oSVersion;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    @Override
    public String toString(){
        String str = "Brand: "+getBrand()+"\nModel: "+getModel()+"\nRelease Year: "+getReleaseYear()+"\nStorage: "+getStorage()+" GB";
        str+="\nMemory: "+getTotalMemory()+" MB";
        str+="\nCamera: "+getCamera();
        str+="\niOS version: "+getoSVersion();
        str+="\nPrice: $"+getPrice()+"\nStock: "+getStock();
        str+="\n";
        return str;
    }
}
