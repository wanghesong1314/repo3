package com.whs.service.impl;

import com.whs.dao.UserMapper;
import com.whs.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserServiceImpl {

    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
       User user=userMapper.findById(13);
        System.out.println(user);

    }
}
