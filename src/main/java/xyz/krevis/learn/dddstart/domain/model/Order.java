package xyz.krevis.learn.dddstart.domain.model;

import java.util.List;

public class Order {

    private String orderNumber;

    private List<OrderLine> orderLines;

    private Money totalAmounts;

    private ShippingInfo shippingInfo;

    private OrderState state;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOreMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOreMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        int sum = orderLines.stream().mapToInt(l -> l.getAmounts().getValue()).sum();
        this.totalAmounts = new Money(sum);
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        if (!state.isShippingChangeable()) {
            throw new IllegalStateException("can't change shipping in " + state);
        }

        this.shippingInfo = shippingInfo;
    }

    public void changeShipped() {

    }

    // 도메인 모델 엔터티는 도메인 기능도 함께 제공
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("already shipped");
        }
    }

    public void completePayment() {

    }
}
