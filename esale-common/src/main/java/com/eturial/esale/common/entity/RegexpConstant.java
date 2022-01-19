package com.eturial.esale.common.entity;

public class RegexpConstant {

    // 手机号正则
    public static final String MOBILE_REG = "/^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$/";

    // 身份证号正则
    public static final String CID_REG = "(^[1-9]\\\\d{5}(19|([23]\\\\d))\\\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\\\d{3}[0-9Xx]$)|(^[1-9]\\\\d{5}\\\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\\\d{2}[0-9Xx]$)";
}
