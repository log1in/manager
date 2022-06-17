package com.xyha.manager.student_manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyha.manager.student_manager.entity.Proportion;
import com.xyha.manager.student_manager.mapper.ProportionMapper;
import com.xyha.manager.student_manager.service.IProportionService;
import org.springframework.stereotype.Service;

@Service
public class ProportionServiceImpl extends ServiceImpl<ProportionMapper, Proportion> implements IProportionService {
}
