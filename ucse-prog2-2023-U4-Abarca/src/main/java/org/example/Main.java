package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.UserMapper;
import org.example.model.User;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        // Configura y obtén la sesión de MyBatis
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        try (SqlSession session = factory.openSession()) {
            // Obtén el Mapper
            UserMapper userMapper = session.getMapper(UserMapper.class);
            // Usa los métodos del Mapper para interactuar con la base de datos
            List<User> users = userMapper.getAllUsers();
            // Imprimir nombre y edad de cada usuario
            for (User user : users) {
                System.out.println(user.getNombre() + " " + user.getEdad());
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        /*try (SqlSession session = factory.openSession()) {
            // Obtén el Mapper
            UserMapper userMapper = session.getMapper(UserMapper.class);
            // Crear usuario
            User user = new User();
            user.setNombre("Julian");
            user.setEdad(40);
            // Insertar usuario
            userMapper.insertUser(user);
            //commit
            session.commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        try (SqlSession session = factory.openSession()) {
            // Obtén el Mapper
            UserMapper userMapper = session.getMapper(UserMapper.class);
            // Modificar usuario
            User user = userMapper.getUserById(2);
            user.setNombre("Julian Modificado");
            user.setEdad(40);
            // Modificar usuario
            userMapper.updateUser(user);
            //commit
            session.commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}