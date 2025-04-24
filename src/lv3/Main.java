package lv3;


public class Main {
    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk();
        kiosk.start();

        // 프로그램을 종료
        System.out.println("프로그램을 종료합니다.");
        // 선택한 메뉴 : 이름, 가격, 설명
        System.out.print("선택한 메뉴: ");
        for (MenuItem item : kiosk.selectedItems) {
            System.out.println("- " + item);
        }
    }


}
