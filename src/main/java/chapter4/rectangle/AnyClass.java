package chapter4.rectangle;

public class AnyClass {
    void anyMethod(Rectangle rectangle, int multiple) {
        // 또다른 anyMethod에서 중복 코드의 사용 가능성
        // 변경에 취약
        rectangle.setRight(rectangle.getRight() * multiple);
        rectangle.setBottom(rectangle.getBottom() * multiple);
    }
}
