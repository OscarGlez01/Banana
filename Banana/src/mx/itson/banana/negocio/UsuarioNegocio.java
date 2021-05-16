/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.banana.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mx.itson.banana.entidades.Usuario;

/**
 *
 * @author adriana
 */
public class UsuarioNegocio {

    /**
     * Crea una lista que contiene solamente los nombres (Nickname) de registro
     * de los usuarios
     * @param usuarios Lista objetos de tipo Usuario
     * @return Lista de tipo String
    */ 
    public List<String> separarNombres(List<Usuario> usuarios) {
        List<String> nicknames = new ArrayList();

        for (Usuario usu : usuarios) {
            String nick = usu.getNickname();
            nicknames.add(nick);
        }

        return nicknames;
    }
    
   
    /**
     * Crea una lista que contiene solamente las contraseñas de los usuarios
     * registrados
     *
     * @param usuarios Lista de objetos de tipo Usuario
     * @return Lista de tipo String
    */ 
    public List<String> separarCorreos(List<Usuario> usuarios) {
        List<String> emails = new ArrayList();

        for (Usuario usu : usuarios) {
            String email = usu.getEmail();
            emails.add(email);
        }

        return emails;
    }

    /**
     * Valida que la contraseña ingresada sea la correspondiente a la del registro del Usuario registrado
     * @param nickname Nombre del Usuario en la aplicación
     * @param contraseña Contraseña de registro del Usuario
     * @param usuarios Lista de Objetos de tipo Usuario
     * @return booleano que indica el estado del inicio de sesión
     */
    public boolean validarEntrada(String nickname, String contraseña, List<Usuario> usuarios, int indice) {
        boolean estado = false;

        if (separarNombres(usuarios).contains(nickname)) {

            if (contraseña.equals(usuarios.get(indice).getPassword())) {
                estado = true;
                
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "El usuario " + nickname + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return estado;

    }

    /**
     * 
     * @param usuarios
     * @param nickname
     * @return 
    */ 
    public int localizarIndice(List<Usuario> usuarios, String nickname) {
        int index = 0 ;

        for (int i = 0; i < usuarios.size(); i++) {
            if (nickname.equals(usuarios.get(i).getNickname())) {
                index = i;
                break;
            }
        }
        return index;
    }
    /*
    public boolean buscarCorreo(List<Usuario> usuarios, String correo){
        boolean encontrado = false;
        
        for (int i = 0; i < usuarios.size(); i++) {
          if (correo.equals(usuarios.get(i).getNickname())) {
                encontrado = true;
                break;
            }  
        }
        
        return encontrado;
    }
    
    public boolean buscarNickname(List<Usuario> usuarios, String nickname){
        boolean encontrado = false;
        
        for (int i = 0; i < usuarios.size(); i++) {
          if (nickname.equals(usuarios.get(i).getNickname())) {
                encontrado = true;
                break;
            }  
        }
        
        return encontrado;
    }*/
}
