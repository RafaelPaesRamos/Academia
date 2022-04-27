/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote.clienteDao;

import br.entidade.academia.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arthu
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private Connection conexao;
    private PreparedStatement preparaInstrucao;
    private ResultSet resultado;
    
    @Override
    public Usuario logar(String login, String senha) throws Exception {
        
        String sql = "SELECT * FROM usuario_adm WHERE login = ? and senha = ?";
        Usuario usuario = null;
        try {
            conexao = FabricaConexao.abrirConexao();
            
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setString(1, login);
            preparaInstrucao.setString(2, senha);
            resultado = preparaInstrucao.executeQuery();
            
            if(resultado.next()){
                usuario = new Usuario();
                usuario.setId(resultado.getInt("id_usu"));
                usuario.setLogin(login);
                usuario.setSenha(senha);
                
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao logar! ");
        }finally{
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
            
        }
            return usuario;    
    }

    



    
}
