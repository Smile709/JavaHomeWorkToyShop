
public  class Main {
    public static void main(String[] args){
        ToyShop toyShop = new ToyShop();
        toyShop.put("1 2 конструктор");
        toyShop.put("2 2 робот");
        toyShop.put("3 6 кукла");
        toyShop.writeResultsToFile("result.txt",10);
    }
}