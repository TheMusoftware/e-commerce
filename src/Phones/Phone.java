package Phones;

public class Phone {
    private static int totalPhone = 0;
    private String brand;
    private String model;
    private int releaseYear;
    private int storage;
    private double price;
    private int stock;
    private int camera = 0;
    boolean isHasCam;
   public Phone(String brand, String model, int releaseYear, int storage,double price,int stock){
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.storage = storage;
        this.price = price;
        this.stock = stock;
        this.isHasCam = false;
        totalPhone++;
    }
    public Phone(String brand, String model, int releaseYear, int storage, int camera, double price, int stock){
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.storage = storage;
        this.camera = camera;
        this.price = price;
        this.stock = stock;
        this.isHasCam = true;
        totalPhone++;

    }

    public static int getTotalPhone() {
        return totalPhone;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getStorage() {
        return storage;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getCamera() {
        return camera;
    }

    public boolean isHasCam() {
        return isHasCam;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString(){
        String str = "Brand: "+getBrand()+"\nModel: "+getModel()+"\nRelease Year: "+getReleaseYear()+"\nStorage: "+getStorage()+" MB";
        if(isHasCam) str+="\nCamera: "+getCamera();
        str+="\nPrice: $"+getPrice()+"\nStock: "+getStock();
        str+="\n";
        return str;
    }

    public static void main(String[] args) {
        Phone nokia = new Phone("Nokia","1110",1995,128,100,1);
        Phone s4 = new Android("Samsung","S4",2014,32,13,2000,99);
        Phone i3gs = new iPhone("3GS",2009,8,2,1000,31);
        Android s5 = new Android("Samsung","S5",2016,32,13,1000,10);
        iPhone iphoneX = new iPhone("X",2016,128,13,3900,10);

    }
}
