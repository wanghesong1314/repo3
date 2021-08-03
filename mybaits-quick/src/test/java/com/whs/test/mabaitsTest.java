package com.whs.test;

import com.whs.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mabaitsTest {
    @Test
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数namespace+id
        List<User> userList= sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }
    @Test
    public void test2() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数namespace+id
        //模拟user对象
        User user=new User();
        user.setId(14);
        user.setUsername("dage");
        user.setPassword("abc");
        int insert = sqlSession.insert("userMapper.save", user);
        //mybaits要执行插入，要进行事物提交，jdbc是默认自己提交的，但是mybaits是默认不提交的，要手动用代码提交
        sqlSession.commit();
        //打印数据
        System.out.println(insert);
        //释放资源
        sqlSession.close();
    }
@Test
    public void test3() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数namespace+id
        //模拟user对象
        User user=new User();
        user.setId(13);
        user.setUsername("li");
        user.setPassword("def");
        int insert = sqlSession.update("userMapper.update", user);
        //mybaits要执行插入，要进行事物提交，jdbc是默认自己提交的，但是mybaits是默认不提交的，要手动用代码提交
        sqlSession.commit();
        //打印数据
        System.out.println(insert);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数namespace+id
        int insert = sqlSession.delete("userMapper.del", 13);
        //mybaits要执行插入，要进行事物提交，jdbc是默认自己提交的，但是mybaits是默认不提交的，要手动用代码提交
        sqlSession.commit();
        //打印数据
        System.out.println(insert);
        //释放资源
        sqlSession.close();
    }
}
