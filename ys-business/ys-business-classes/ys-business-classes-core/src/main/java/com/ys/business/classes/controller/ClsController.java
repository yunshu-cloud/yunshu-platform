package com.ys.business.classes.controller;

import com.ys.business.classes.service.ClassesService;
import com.ys.commons.web.r.R;
import com.ys.commons.web.r.RUtils;
import com.ys.data.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/cls")
@Validated
public class ClsController {

    @Autowired
    private ClassesService classesService;

    @RequestMapping("/getById")
    public R getClsByCid(@NotNull(message = "班级id不能为空！") Integer cId){
        Classes cls = classesService.getById(cId);
        return RUtils.create(cls);
    }
}
