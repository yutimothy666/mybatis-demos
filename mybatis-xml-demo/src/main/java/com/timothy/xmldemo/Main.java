package com.timothy.xmldemo;

import com.timothy.xmldemo.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        final SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        final SqlSession sqlSession = sessionFactory.openSession();
        final List<Student> listStudent = sqlSession.selectList("listStudent");
        listStudent.forEach(System.out::println);
    }
}
