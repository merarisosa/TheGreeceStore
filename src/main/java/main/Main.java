/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import database.Conexion;

/**
 *
 * @author merarimaysosa
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Conexion con = new Conexion();
        System.out.println(con.conectar() ? "Si se pudo!" : "Fail..");
    }
}
