/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pacote.clienteDao;

import br.entidade.academia.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author arthu
 */
public interface UsuarioDao {
    
    Usuario logar(String login,String senha)throws Exception;
}
