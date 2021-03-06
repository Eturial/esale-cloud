package com.eturial.esale.common.validator;

import com.eturial.esale.common.annotation.IsMobile;
import com.eturial.esale.common.entity.RegexpConstant;
import com.eturial.esale.common.utils.EsaleUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return EsaleUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
