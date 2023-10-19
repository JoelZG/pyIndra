package com.pyIndra.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Conexion connectInstance; 
	private Connection connection;
	private final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    //Nombre de usuario autorizado para conectarse
    private final String USER = "sa";
    //Contraseña para conectarnos
    private final String PASSWORD = "password";
    

    private Conexion() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            System.out.println("OK ");
        }
    }
    
    //Implementación del patrón singleton para acceder a una instancia única de la clase
    public static Conexion getInstance(){
        if (connectInstance == null ){
            connectInstance = new Conexion();
        }
        return connectInstance;
    }
       
    public Connection getConnection(){
        return connection;
    }
}
