/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.changosuave.DAO.UserDAO;
import mx.changosuave.entity.User;

/**
 *
 * @author J_K1483
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<User> listaUsuarios = new ArrayList();
        UserDAO usuarioDao = new UserDAO();
        listaUsuarios = usuarioDao.findAll();
        
        for(User us:listaUsuarios){
            System.out.println(us.getUsername() + " " + us.getPassword());
        }
    }
    
}
