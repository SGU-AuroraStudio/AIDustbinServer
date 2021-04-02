//package com.aurora.Test;
//
//import com.aurora.service.impl.MomentServiceImpl;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.util.List;
//
//@ContextConfiguration({"classpath:conf/spring-mvc.xml","classpath:conf/spring-mybatis.xml"})
//public class TestMybatis {
//
//    @Autowired
//    MomentServiceImpl momentService;
//
//    @Test
//    public void  testSelectAll(){
//        List<Moment> moments = momentService.selectAll();
//        for (Moment moment : moments) {
//            System.out.println(moment);
//        }
//    }
//}
