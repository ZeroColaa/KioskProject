package challenge.lv1;



public class MenuItem {
    // 이름, 가격, 설명 필드 선언하여 관리
    private String name;
    private int price;
    private String description;




    //생성자
    public MenuItem(String name, int price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }


    public String getName(){return name;}
    public int getPrice(){return price;}



    @Override
    public String toString() {
        return name + " | W " + price/100.0 + " | " + description;
    }
}
