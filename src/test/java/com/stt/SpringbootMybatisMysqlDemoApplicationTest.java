package com.stt;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stt.mapper.DemoMapper;
import com.stt.po.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * 执行test，需设置jvm：-Dspring.profiles.active=dev
 * Created by shitt7 on 2018/5/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootMybatisMysqlDemoApplicationTest {

    @Autowired
    private DemoMapper demoMapper;

    @Test
    public void MybatisTest() {
        //查询表所有数据
        findAll();
        //插入新数据
        add("stt");
        findAll();
        //删除数据
        deleteById(2);
        findAll();
        //修改数据
        updateById(1,"tt");
        findAll();
    }

    /**
     * 查询全部
     */
    public void findAll(){
        List<Demo> demoList = demoMapper.findAll();
        System.out.println(demoList);
        System.out.println("--------------------------");
    }

    public void add(String content){
        System.out.println("-----------add---------------");
        Demo demo = new Demo();
        demo.setContent(content);
        demoMapper.insertSelective(demo);
    }

    public void updateById(int id,String content){
        System.out.println("-----------update-----------");
        Demo demo = new Demo();
        demo.setId(id);
        demo.setContent(content);
        demo.setUpdateTime(new Date());
        demoMapper.updateByPrimaryKeySelective(demo);
    }

    public void deleteById(int id){
        System.out.println("-----------delete------------");
        demoMapper.deleteByPrimaryKey(id);
    }

    @Test
    public void testFindByPage(){
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        findAll();
        findAllByPage(1, 5);
        findAllByPage(2, 5);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     */
    public void findAllByPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Demo> demoList = demoMapper.findAll();
        PageInfo result = new PageInfo(demoList);
        System.out.println(result);
        System.out.println("--------------------------");
    }
}