package com.example.wwmd.enums;

public enum UserStatusEnum {
    NORMAL(0, "正常"),

    STATUS_LOCK(1, "注销");

    private Integer value;
    private String message;

    public Integer getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    UserStatusEnum(Integer value, String message) {

        this.value = value;
        this.message = message;
    }

    public static UserStatusEnum getByValue(Integer value) {
        if (value != null) {
            for (UserStatusEnum enu : values()) {
                if (enu.value.equals(value)) {
                    return enu;
                }
            }
        }
        return null;
    }
}
