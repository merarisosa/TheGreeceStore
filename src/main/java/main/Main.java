/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import database.Conexion;

import vista.Login;
import vista.Inicio;


/**
 *
 * @author merarimaysosa
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        Conexion con = new Conexion();
        System.out.println(con.conectar() ? "Si se pudo!" : "Fail..");


        Login login = new Login();

        Inicio wallpaper_inicio = new Inicio();
        wallpaper_inicio.setVisible(true);


    }
}
