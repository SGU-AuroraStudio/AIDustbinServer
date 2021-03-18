package com.aurora.servlet;

import com.aurora.dao.IUserDao;
import com.aurora.domain.User;
import com.mysql.cj.util.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("utf-8");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if (StringUtils.isNullOrEmpty(account) || StringUtils.isNullOrEmpty(password)) {
            session.setAttribute("error", "请输入用户名和密码");
            System.out.println("请输入用户名和密码");
            try {
                resp.getWriter().println("请输入用户名和密码");
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
            User user = dao.findByIdPassword(account, password);
            if (user == null) {
                session.setAttribute("error", "用户名或密码错误");
                System.out.println("用户名或密码错误");
                resp.getWriter().println("用户名或密码错误");
            } else {
                session.setAttribute("user", user);
                session.setAttribute("msg", "登录成功");
                System.out.println("登录成功");
                resp.getWriter().println("true");
            }
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
