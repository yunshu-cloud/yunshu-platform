package com.ys.business.student.input;

import com.ys.business.student.valid.AgeBirthdayValid;
import com.ys.commons.web.valid.CustomValid;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生实体的入参对象
 */
@Data
@CustomValid(message = "生日与年龄不匹配", handler = AgeBirthdayValid.class)
public class StudentInput implements Serializable {
    @NotBlank(message = "学生姓名不能为空")
    private String name;
    @Min(value = 10, message = "年龄不能小于10岁")
    @Max(value = 20, message = "年龄不能超过20岁")
    @NotNull(message = "年龄不能为空")
    private Integer age;
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String email;
    @NotNull(message = "生日不能为空")
    @Past(message = "生日范围不正确")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @NotNull(message = "性别不能为空")
    private Integer sex;
}
