
public  class Main {
    public static void main(String[] args){
        ToyShop toyShop = new ToyShop();
        toyShop.put("1 конструктор 2");
        toyShop.put("2 робот 2");
        toyShop.put("3 кукла 6");
        toyShop.writeResultsToFile("result.txt",10);
    }
}