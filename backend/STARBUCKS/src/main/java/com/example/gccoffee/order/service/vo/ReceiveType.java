package com.example.gccoffee.order.service.vo;

public enum ReceiveType {
    TAKEOUT("포장"),
    STORE("매장");

    private final String value;

    ReceiveType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
