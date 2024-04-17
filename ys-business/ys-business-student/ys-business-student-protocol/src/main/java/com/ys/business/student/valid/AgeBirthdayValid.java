package com.ys.business.student.valid;

import com.ys.business.student.input.StudentInput;
import com.ys.commons.web.valid.CustomValid;
import com.ys.commons.web.valid.DevelopValidHandler;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * 生日和年龄的校验器
 */
@Component
public class AgeBirthdayValid implements DevelopValidHandler<StudentInput> {
    @Override
    public boolean isValid(CustomValid customValid, StudentInput value) {
        Integer age = value.getAge();
        Date birthday = value.getBirthday();
        if (age == null || birthday == null){
            return true;
        }

        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        int nowYear = ca.get(Calendar.YEAR);

        ca.setTime(birthday);
        int birYear = ca.get(Calendar.YEAR);

        return nowYear - birYear == age;
    }
}
