package com.eturial.esale.common.validator;

import com.eturial.esale.common.annotation.Cid;
import com.eturial.esale.common.annotation.IsMobile;
import com.eturial.esale.common.entity.RegexpConstant;
import com.eturial.esale.common.utils.EsaleUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CidValidator implements ConstraintValidator<Cid, String> {
    @Override
    public void initialize(Cid cid) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.CID_REG;
                return EsaleUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
