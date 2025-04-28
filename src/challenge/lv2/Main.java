package challenge.lv2;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        // Burgers
        menu.addItem("Burgers", new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.addItem("Burgers", new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.addItem("Burgers", new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.addItem("Burgers", new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Drinks
        menu.addItem("Drinks", new MenuItem("Milkshake", 4800, "밀크 쉐이크"));
        menu.addItem("Drinks", new MenuItem("Cola", 2500, "콜라"));
        menu.addItem("Drinks", new MenuItem("ZeroCola", 2800, "제로콜라"));
        menu.addItem("Drinks", new MenuItem("Water", 1000, "물"));

        // Desserts
        menu.addItem("Desserts", new MenuItem("ApplePie", 2800, "애플파이"));
        menu.addItem("Desserts", new MenuItem("IceCream", 2000, "아이스크림"));
        menu.addItem("Desserts", new MenuItem("ChocoPie", 2000, "초코파이"));

        new Kiosk(menu).start();
    }
}
