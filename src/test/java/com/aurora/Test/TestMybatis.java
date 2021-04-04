package com.aurora.Test;

import com.aurora.service.impl.MomentServiceImpl;
import com.aurora.service.impl.MomentThumbRecordServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring-mvc.xml","classpath:conf/spring-mybatis.xml"})
public class TestMybatis {
    @Autowired
    MomentServiceImpl momentService;
    @Autowired
    MomentThumbRecordServiceImpl momentThumbRecordService;

    @Test
    public void testSelectCount(){
        System.out.println(momentThumbRecordService.selectCountByMomentId(1));
    }
}
