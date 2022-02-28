package hello.core.singleton;

public class StateFulService {
    private int price;

    public void oder(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
}
