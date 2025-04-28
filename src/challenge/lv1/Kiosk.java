package challenge.lv1;

import java.util.*;

public class Kiosk {

    private final List<Cart> cart = new ArrayList<>();
    private final Menu menu;

    public Kiosk(Menu menu) {
        this.menu = menu;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int customerInput = -1;
        List<String> categories = new ArrayList<>(menu.getCategories());

        do {
            // 메인 메뉴 출력
            System.out.println("\n[ MAIN MENU ]");
            menu.showCategoryItem(categories);
            System.out.println("0. 종료");

            if (!cart.isEmpty()) {
                System.out.println("\n[ ORDER MENU ]");
                System.out.println("4. Orders | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel | 진행중인 주문을 취소합니다.");
            }

            customerInput = readInt(sc);

            // 주문/취소 처리
            if (!cart.isEmpty()) {
                if (customerInput == 4) {
                    showOrderAndPay(sc);
                    continue;
                }
                if (customerInput == 5) {
                    cart.clear();
                    System.out.println("주문이 취소되었습니다.");
                    continue;
                }
            }

            if (customerInput == 0) break;
            if (customerInput < 1 || customerInput > categories.size()) {
                System.out.println("잘못된 카테고리 번호입니다.");
                continue;
            }

            // 카테고리별 메뉴 출력
            String selectedCategory = categories.get(customerInput - 1);
            List<MenuItem> selectedList = menu.getItems(selectedCategory);
            int itemInput = -1;

            do {
                System.out.println("\n[ " + selectedCategory.toUpperCase() + " MENU ]");
                menu.showMenuItem(selectedList);
                System.out.println("0. 뒤로가기");

                itemInput = readInt(sc);

                if (itemInput == 0) break;

                if (itemInput >= 1 && itemInput <= selectedList.size()) {
                    MenuItem chosenItem = selectedList.get(itemInput - 1);
                    System.out.println("\n선택한 메뉴: " + chosenItem);
                    System.out.println("\"" + chosenItem + "\" 을(를) 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인   2. 취소");
                    int confirm = readInt(sc);
                    if (confirm == 1) {
                        addToCart(chosenItem);
                        System.out.println(chosenItem.getName() + " 이(가) 장바구니에 추가되었습니다.");
                    }
                } else {
                    System.out.println("잘못된 메뉴 번호입니다.");
                }
            } while (itemInput != 0);

        } while (customerInput != 0);

        System.out.println("프로그램을 종료합니다.");
    }

    private void addToCart(MenuItem item) {
        for (Cart ci : cart) {
            if (ci.getItem().getName().equals(item.getName())) {
                ci.incQty();
                return;
            }
        }
        cart.add(new Cart(item));
    }

    private void showOrderAndPay(Scanner sc) {
        System.out.println("\n[ Orders ]");
        int total = 0;
        for (Cart ci : cart) {
            System.out.println(ci);
            total += ci.getTotalPrice();
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f%n", total / 100.0);

        int sel = -1;
        while (sel != 1 && sel != 2) {
            System.out.println("\n1. 주문   2. 메뉴판");
            sel = readInt(sc);
        }

        if (sel == 1) {
            System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.%n", total / 100.0);
            cart.clear();
        }
        //sel == 2이면 아무것도 실행하지 않고, 메인메뉴로 돌아감
    }

    private int readInt(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해 주세요.");
            return -1;
        }
    }
}