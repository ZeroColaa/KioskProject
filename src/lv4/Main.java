package lv4;

public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성을 통해 이름 설정
        Menu menu = new Menu();
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        menu.menuMap.get("Burgers").add(new MenuItem("ShackBurger",6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menu.menuMap.get("Burgers").add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menu.menuMap.get("Burgers").add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menu.menuMap.get("Burgers").add(new MenuItem("Hamburger ", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        menu.menuMap.get("Drinks").add(new MenuItem("milkshake", 4800, "밀크 쉐이크"));
        menu.menuMap.get("Drinks").add(new MenuItem("cola", 2500, "콜라"));
        menu.menuMap.get("Drinks").add(new MenuItem("zerocola", 2800, "제로콜라"));
        menu.menuMap.get("Drinks").add(new MenuItem("water", 1000, "물"));



        menu.menuMap.get("Desserts").add(new MenuItem("applepie", 2800, "애플파이"));
        menu.menuMap.get("Desserts").add(new MenuItem("icecream", 2000, "아이스크림"));
        menu.menuMap.get("Desserts").add(new MenuItem("chocopie", 2000, "초코파이"));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menu);
        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }

}
