package lv4;

public class MenuItem {
    // 이름, 가격, 설명 필드 선언하여 관리
    String name;
    int price;
    String description;


    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.

    MenuItem(String name, int price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " | W " + price + " | " + description;
    }
}
