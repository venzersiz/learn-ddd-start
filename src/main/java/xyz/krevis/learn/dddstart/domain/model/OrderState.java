package xyz.krevis.learn.dddstart.domain.model;

public enum OrderState {

    /**
     * 주문 대기 중
     */
    PAYMENT_WAITING {
        @Override
        public boolean isShippingChangeable() {
            return true;
        }
    },
    /**
     * 상품 준비 중
     */
    PREPARING {
        @Override
        public boolean isShippingChangeable() {
            return true;
        }
    },

    SHIPPED, DELIVERING, DELIVERY_COMPLETED, CANCELED;

    public boolean isShippingChangeable() {
        return false;
    }
}
