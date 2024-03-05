/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.changosuave.entity.User;
import mx.changosuave.integracion.ServiceFacadeLocator;

/**
 *
 * @author J_K1483
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user = new User();
        user = ServiceFacadeLocator.getInstanceUserFacade().login("a","a");
        
        if(user.getIdTeacher() != null){
            System.out.println("Login exitoso con correo: " + user.getUsername());
        } else {
            System.out.println("No se encontraron registros");
        }
    }
    
}
