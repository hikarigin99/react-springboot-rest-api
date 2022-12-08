package com.example.gccoffee.order.vo;

public enum OrderStatus {
    PAYMENT_CONFIRMED("결제 완료"),
    CANCELLED("결제 취소"),
    PROVISION_COMPLETED("제공 완료");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
