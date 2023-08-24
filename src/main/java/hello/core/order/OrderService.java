package hello.core.order;

public interface OrderService {
// 클라이언트는 주문을 생성할 때 회원id, 상품명, 상품가격을 주문 서비스 역할에 넘겨야한다.
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
