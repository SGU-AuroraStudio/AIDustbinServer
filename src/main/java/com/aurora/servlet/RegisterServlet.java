package com.aurora.servlet;

import com.aurora.dao.IUserDao;
import com.aurora.domain.User;
import com.mysql.cj.util.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        if (StringUtils.isNullOrEmpty(account) || StringUtils.isNullOrEmpty(password)|| StringUtils.isNullOrEmpty(name)) {
            session.setAttribute("error", "请正确填写信息");
            System.out.println("请正确填写信息");
            try {
                resp.getWriter().println("请正确填写信息");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        try {
            InputStream in = Resources.getResourceAsStream("conf/mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = factory.openSession();
            IUserDao dao = sqlSession.getMapper(IUserDao.class);
            User user = dao.findById(account);
            if(user!=null){
                session.setAttribute("error","用户名已存在");
                System.out.println("用户名已存在");
                resp.getWriter().println("用户名已存在");
            }else{
                if(dao.saveUser(account,password,name)) {
                    sqlSession.commit();
                    sqlSession.close();
                    session.setAttribute("msg", "注册成功");
                    System.out.println("注册成功");
                    resp.getWriter().println("true");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
