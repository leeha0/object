package chapter4.rectangle;

public class AnyClass {

    void anyMethod(Rectangle rectangle, int multiple) {
        // 또다른 메서드에서 중복 코드를 작성할 가능성이 존재
        // 변경에 취약
        rectangle.setRight(rectangle.getRight() * multiple);
        rectangle.setBottom(rectangle.getBottom() * multiple);
    }
}
