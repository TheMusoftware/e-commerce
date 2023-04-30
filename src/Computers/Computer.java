package Computers;

public class Computer {
    private  String brand;
    private  String model;
    private String processor;
    private String videoCard;
    private int storage;
    private  int memory;
    private double price;
    public Computer(){

    };
    public Computer(String brand, String model, String processor, String videoCard, int storage, int memory) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.videoCard = videoCard;
        this.storage = storage;
        this.memory = memory;
        this.price = calcPrice();
    }
    //None Video card
    public Computer(String brand, String model, String processor, int storage, int memory) {
        this.brand = brand;
        this.model = model;
        this.videoCard ="-";
        this.processor = processor;
        this.storage = storage;
        this.memory = memory;
        this.price = calcPrice();
    }
    double calcPrice(){
        double price = 0.0;
        if(storage<100) price+=800;
        else if(storage<300) price+=1000;
        else if(storage<500) price+=1200;
        else if(storage<1000) price += 1400;
        else price +=1750;
        if(memory<2048) price+=100;
        else if (memory<4096) price+=300;
        else if(memory<8192) price+=500;
        else price+=750;
        if(videoCard.equals("-")) price = price*0.87;
        return price;
    }
    public String toString(){
        String str ="";
        str+="Brand: "+ getBrand()+"\t\tModel: "+getModel();
        str+="\nProcessor: "+getProcessor()+"\t\t Video Card: "+getVideoCard();
        str+="\nStorage: "+getStorage()+"GB"+"\t\tMemory: "+getMemory()+"MB\n";
        str+="Price: $"+ getPrice()+"\n";
        return str;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProcessor() {
        return processor;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public int getStorage() {
        return storage;
    }

    public int getMemory() {
        return memory;
    }

    public static void main(String[] args) {
        Computer cpt = new Computer("Apple","Lisa","i3-3100KF","HD4000",512,8096);
        Computer nv = new Computer("as","sa","i7",512,8096);
        System.out.println(cpt.toString());
        System.out.println(nv.toString());
        Computer laptop = new Laptop("Ali","Veli","i9",210,3323);
        System.out.println(laptop.toString());
    }
}
