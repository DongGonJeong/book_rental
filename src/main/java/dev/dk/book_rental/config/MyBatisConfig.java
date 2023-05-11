package dev.dk.book_rental.config;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;


    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();


        sessionFactory.setDataSource(dataSource);

        //맵퍼 xml 파일 경로 설정
        Resource[] res = new PathMatchingResourcePatternResolver()
                .getResources("classpath*:/dev/dk/book_rental/*Mapper.xml");

        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }

    @Bean
    public SqlSession sqlSession() throws Exception {

        return new SqlSessionTemplate(sqlSessionFactoryBean());
    }
}
