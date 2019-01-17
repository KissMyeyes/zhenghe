package com.example.wwmd.common;

import lombok.Data;

@Data
public class ValidateCodeProperties {

    // 验证码图片宽度
    private int width = 146;
    // 验证码图片高度
    private int height = 33;
    // 验证码字符位数
    private int length = 4;
}