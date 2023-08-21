package org.example;

import org.apache.ibatis.session.SqlSessionFactory;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        MySessionFactory mySessionFactory = MySessionFactory.getInstance();
        User newUser = new User();
        newUser.setNombre("Juan");
        newUser.setEdad(25);

        //Debo crear un nuevo usuario
        UserMapper userMapper = new UserMapperImpl(mySessionFactory.getFactory());

    }
}