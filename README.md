

# 🍔 Java Kiosk Project

Java 기초 문법, 객체지향 프로그래밍(OOP), 고급 기능(Stream, Enum)을 연습하기 위한 키오스크 프로그램입니다.



---

# 🪜 단계별 기능 정리

## src/lv1 : Lv 1. 기본적인 키오스크를 프로그래밍해보자

- Scanner를 통해 햄버거 메뉴를 출력하고, 입력값에 따라 동작
- 0번 입력 시 프로그램 종료
- 조건문, 반복문, 입력 처리 복습

## src/lv2 : Lv 2. 객체지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기

- MenuItem 클래스를 만들어 메뉴 항목(이름, 가격, 설명) 관리
- List<MenuItem> 사용하여 여러 항목을 저장
- 반복문으로 메뉴 출력

## src/lv3 : Lv 3. Kiosk 클래스를 통해 흐름 제어 통합

- Kiosk 클래스를 생성해 메뉴 출력/입력/종료 제어
- start() 메서드에서 메인 로직 관리
- main()에서는 Kiosk 객체만 실행

## src/lv4 : Lv 4. Menu 클래스를 통해 메뉴 항목 분리 관리

- MenuItem들을 List로 관리하는 Menu 클래스 추가
- 메뉴 카테고리 이름을 저장하는 기능 추가
- 카테고리별 메뉴 관리 가능

## src/lv5 : Lv 5. 캡슐화 적용

- MenuItem, Menu, Kiosk 클래스 필드에 private 적용
- Getter/Setter로 외부 접근 제어
- 객체지향 캡슐화 원칙 준수

---

## challenge/lv1 : Lv 1. 장바구니 및 구매하기 기능 추가

- 장바구니 List<Cart> 추가
- 메뉴 선택 시 "장바구니에 추가" 여부 확인
- 장바구니 출력 및 총 금액 계산
- 주문 확정 시 장바구니 초기화

## challenge/lv2 : Lv 2. Enum, 람다 & 스트림을 활용한 주문 관리

- UserType(Enum) 생성해 할인율 적용
- 주문할 때 사용자 유형에 맞는 할인율 계산
- 메뉴 출력 및 장바구니 관리를 Stream API로 개선
- 장바구니 항목 삭제 기능 (removeIf + Stream)

---

## 📁 디렉터리 구조

```
src/
└── challenge/
    ├── lv1/
    │   ├── Cart.java
    │   ├── Kiosk.java
    │   ├── Main.java
    │   ├── Menu.java
    │   └── MenuItem.java
    ├── lv2/
    │   ├── Cart.java
    │   ├── Kiosk.java
    │   ├── Main.java
    │   ├── Menu.java
    │   ├── MenuItem.java
    │   └── UserType.java
    ├── lv3/
    │   ├── Kiosk.java
    │   ├── Main.java
    │   └── MenuItem.java
    ├── lv4/
    │   ├── Kiosk.java
    │   ├── Main.java
    │   ├── Menu.java
    │   └── MenuItem.java
    └── lv5/
        ├── Kiosk.java
        ├── Main.java
        ├── Menu.java
        └── MenuItem.java

```

---

# 🛠️ 트러블슈팅 기록

## 1. IntStream vs Stream 차이 이해

- 메뉴 리스트 출력 시 인덱스를 쉽게 관리하기 위해 IntStream.range() 사용
- 일반 Stream은 인덱스를 다루기 불편했다.

```java
IntStream.range(0, list.size())
         .forEach(i -> System.out.println((i + 1) + ". " + list.get(i)));
```

| 구분            | IntStream                   | Stream                      |
|:----------------|:-----------------------------|:-----------------------------|
| 타입             | 숫자(int) 스트림              | 객체 스트림                   |
| 인덱스 관리      | 가능 (range로 생성)            | 불편 (counter 직접 관리 필요) |
| 번호 매기기      | 쉬움                          | 복잡함                        |
| 사용 예시        | 번호 출력, 반복 작업           | 데이터 가공, 필터링, 매핑      |

> ✅ 인덱스 기반 작업에는 IntStream을 사용하는 것이 좋다.

---

## 2. HashMap vs LinkedHashMap vs TreeMap 차이

- 메뉴 등록 순서를 유지하기 위해 LinkedHashMap 사용
- HashMap은 순서를 보장해야 하는 프로젝트에 부적합

| 구분              | HashMap                  | LinkedHashMap                  | TreeMap                     |
|:------------------|:--------------------------|:--------------------------------|:-----------------------------|
| 순서 유지 여부     | ❌ 없음                    | ✅ 입력 순서 유지                | ✅ 키 기준 정렬 (오름차순)    |
| 정렬 여부          | ❌ 없음                    | ❌ 없음                         | ✅ 키 정렬 자동                |
| 검색/삽입 속도     | 매우 빠름 (O(1))            | 빠름 (O(1))                     | 느림 (O(log n))              |
| 메모리 사용량      | 가장 적음                  | 약간 많음                       | 중간 수준                    |
| 사용 목적          | 빠른 검색/삽입/삭제         | 순서 유지 + 빠른 검색            | 키 정렬 필요                  |

> ✅ 메뉴 등록 순서 유지를 위해 LinkedHashMap을 썼다.

---

## 3. removeIf + Stream 조합

- 장바구니 메뉴 삭제 시 `removeIf` 사용

```java
String removedName = cart.get(idx - 1).getItem().getName();
cart.removeIf(ci -> ci.getItem().getName().equals(removedName));
System.out.println(removedName + " 가 장바구니에서 제거되었습니다.");
```

- Stream + Predicate 조합으로 코드를 간결하게 만들었다.
- 현업에서도 매우 자주 사용하는 패턴이다. (ex. 조건부 삭제)

---

# 📚 트러블슈팅 기록 링크

- [Velog - IntStream 사용 경험 정리](https://velog.io/@eggtart21/IntStream-사용-경험-정리-기록용) 
- [Velog - HashMap vs LinkedHashMap vs TreeMap](https://velog.io/@eggtart21/Java-HashMap-vs-LinkedHashMap-vs-TreeMap-Kiosk-프로젝트-적용)



---

# 📝 흐름 요약 

1. 프로그램 시작
2. 메인 메뉴 출력 (Burgers / Drinks / Desserts)
3. 메뉴 선택
4. 항목 상세 출력 → 장바구니 담기 여부
5. 장바구니 추가
6. [ORDER MENU] : 주문하기, 취소하기, 특정 메뉴 삭제
7. 주문 시 할인 적용
8. 결제 후 장바구니 초기화
9. 프로그램 종료

