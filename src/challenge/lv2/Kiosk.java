package challenge.lv2;

import java.util.*;
import java.util.stream.IntStream;

public class Kiosk {

    private final List<Cart> cart = new ArrayList<>();
    private final Menu menu;

    public Kiosk(Menu menu) { this.menu = menu; }

    public void start() {
        Scanner sc = new Scanner(System.in);
        List<String> categories = new ArrayList<>(menu.getCategories());

             while (true) {
            //메인메뉴
            System.out.println("\n[ MAIN MENU ]");
            menu.showCategoryItem(categories);
            System.out.println("0. 종료");
            if (!cart.isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문");
                System.out.println("5. Cancel       | 장바구니 비우기");
                System.out.println("6. RemoveItem   | 장바구니에서 특정 메뉴 삭제");
            }

            int selMain = readInt(sc);
            if (selMain == 0) break;

            //주문 취소
            if (!cart.isEmpty()) {
                if (selMain == 4) { showOrderAndPay(sc); continue; }
                if (selMain == 5) { cart.clear(); System.out.println("주문이 취소되었습니다."); continue; }
                if (selMain == 6) { removeItemFlow(sc); continue; }
            }

            //카테고리
            if (selMain < 1 || selMain > categories.size()) { System.out.println("잘못된 번호"); continue; }
            String cat = categories.get(selMain-1);
            List<MenuItem> items = menu.getItems(cat);

            while (true) {
                System.out.println("\n[ "+cat.toUpperCase()+" MENU ]");
                menu.showMenuItem(items);
                System.out.println("0. 뒤로가기");

                int itemNo = readInt(sc);
                if (itemNo == 0) break;
                if (itemNo < 1 || itemNo > items.size()) { System.out.println("잘못된 번호"); continue; }

                MenuItem chosen = items.get(itemNo-1);
                System.out.println("\n선택한 메뉴: "+chosen);
                System.out.println("\""+chosen+"\" 을(를) 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인   2. 취소");
                if (readInt(sc)==1) { addToCart(chosen); System.out.println(chosen.getName()+" 추가됨"); }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    //장바구니

    private void addToCart(MenuItem item) {
        cart.stream()
                .filter(c -> c.getItem().getName().equals(item.getName()))
                .findFirst()
                .ifPresentOrElse(Cart::incQty, () -> cart.add(new Cart(item)));
    }

    //장바구니 메뉴 삭제
    private void removeItemFlow(Scanner sc) {
        if (cart.isEmpty()) { System.out.println("장바구니가 비어 있습니다."); return; }

        System.out.println("\n[ CART ITEMS ]");
        IntStream.range(0, cart.size())
                .forEach(i -> System.out.println((i+1)+". "+cart.get(i)));

        System.out.println("삭제할 메뉴 번호를 입력하세요 (0. 취소)");
        int idx = readInt(sc);
        if (idx == 0) return;

        if (idx < 1 || idx > cart.size()) {
            System.out.println("잘못된 번호"); return;
        }
        String removedName = cart.get(idx-1).getItem().getName();
        cart.removeIf(ci -> ci.getItem().getName().equals(removedName));  // ← 스트림-기반 filter 제거
        System.out.println(removedName+" 가 장바구니에서 제거되었습니다.");
    }

    private void showOrderAndPay(Scanner sc) {
        System.out.println("\n[ Orders ]");
        cart.forEach(System.out::println);
        int total = cart.stream().mapToInt(Cart::getTotalPrice).sum();
        System.out.printf("\n[ Total ]\nW %.1f%n", total/100.0);

        System.out.println("\n1. 주문   2. 메뉴판");
        if (readInt(sc) != 1) return;

        System.out.println("\n할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자  2. 군인  3. 학생  4. 일반");
        int tp = readInt(sc);
        UserType type = switch (tp) {
            case 1 -> UserType.VETERAN;
            case 2 -> UserType.SOLDIER;
            case 3 -> UserType.STUDENT;
            default -> UserType.GENERAL;
        };

        double pay = type.apply(total);
        double disc = (total - pay)/100.0;
        if (disc > 0) System.out.printf("할인 금액: W %.1f%n", disc);
        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n", pay/100.0);
        cart.clear();
    }


    private int readInt(Scanner sc) {
        try { return Integer.parseInt(sc.nextLine()); }
        catch (Exception e) {
            System.out.println("숫자만 입력하세요.");
            return -1; }
    }
}
