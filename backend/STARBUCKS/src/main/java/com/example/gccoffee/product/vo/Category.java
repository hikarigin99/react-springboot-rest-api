package com.example.gccoffee.product.vo;

public enum Category {
    ESPRESSO("에스프레소"),
    COLD_BREW("콜드브루"),
    BLENDED("블렌디드"),
    FRAPPUCCINO("프라푸치노"),
    TEA("티");

    private final String koreanName;

    Category(String name) {
        this.koreanName = name;
    }

    public String getKoreanName() {
        return koreanName;
    }
}
