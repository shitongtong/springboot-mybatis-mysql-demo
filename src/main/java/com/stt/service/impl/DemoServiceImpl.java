package com.stt.service.impl;

import com.stt.mapper.DemoMapper;
import com.stt.po.Demo;
import com.stt.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shitt7 on 2018/5/29.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> findAll() {
        return demoMapper.findAll();
    }
}
