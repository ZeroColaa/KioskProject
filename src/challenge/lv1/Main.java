package challenge.lv1;


public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성
        Menu menu = new Menu();

        // addItem() 메서드로 메뉴 항목 추가 (캡슐화 유지)
        menu.addItem("Burgers", new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.addItem("Burgers", new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.addItem("Burgers", new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.addItem("Burgers", new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        menu.addItem("Drinks", new MenuItem("milkshake", 4800, "밀크 쉐이크"));
        menu.addItem("Drinks", new MenuItem("cola", 2500, "콜라"));
        menu.addItem("Drinks", new MenuItem("zerocola", 2800, "제로콜라"));
        menu.addItem("Drinks", new MenuItem("water", 1000, "물"));

        menu.addItem("Desserts", new MenuItem("applepie", 2800, "애플파이"));
        menu.addItem("Desserts", new MenuItem("icecream", 2000, "아이스크림"));
        menu.addItem("Desserts", new MenuItem("chocopie", 2000, "초코파이"));

        // Kiosk 실행
        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();
    }
}
