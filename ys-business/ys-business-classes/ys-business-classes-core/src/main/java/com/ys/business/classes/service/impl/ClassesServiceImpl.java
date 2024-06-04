package com.ys.business.classes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ys.business.classes.service.ClassesService;
import com.ys.data.entity.Classes;
import com.ys.data.mapper.dao.ClassesDao;
import org.springframework.stereotype.Service;

/**
 * class table(Classes)表服务实现类
 *
 * @author makejava
 * @since 2024-06-04 20:56:15
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesDao, Classes> implements ClassesService {

}
