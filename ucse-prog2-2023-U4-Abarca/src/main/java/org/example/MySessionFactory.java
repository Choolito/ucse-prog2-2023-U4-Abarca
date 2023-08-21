package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MySessionFactory {

    private static MySessionFactory instance;
    private SqlSessionFactory factory;

    private MySessionFactory() {
        String recurso = "mybatis-config.xml";
        Reader lector = null;
        try{
            lector = Resources.getResourceAsReader(recurso);
            factory = new SqlSessionFactoryBuilder().build(lector);
            lector.close();
        }catch(Exception e){
            System.out.println(e);        }
    }

    public static MySessionFactory getInstance(){
        if(instance == null){
            instance = new MySessionFactory();
        }
        return instance;
    }

    public SqlSessionFactory getFactory(){
        return factory;
    }
}
