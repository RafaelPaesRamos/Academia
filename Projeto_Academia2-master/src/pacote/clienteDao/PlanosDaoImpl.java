/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote.clienteDao;


import br.entidade.academia.Cliente;
import br.entidade.academia.Planos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Rafael&Lais
 */
public class PlanosDaoImpl implements PlanosDao {
    
     private Connection conexao;
    private PreparedStatement preparaInstrucao;
    private ResultSet resultado;

    

    

    

  

  

    @Override
    public void salvarPlanos(Object object) throws SQLException {
         Planos entidadePlanos = (Planos) object;
        preparaInstrucao = null;
        resultado = null;
        Integer matricula = null;

        String instrucao = "SELECT cod_plano, nm_plano,vigencia,treino"
                + "FROM public.planos;";

        try {

            conexao = FabricaConexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(instrucao, Statement.RETURN_GENERATED_KEYS);
            preparaInstrucao.setString(1, entidadePlanos.getTipoPlano());
            preparaInstrucao.setString(2, entidadePlanos.getTipoVigencia());
            preparaInstrucao.setString(3, entidadePlanos.getTipoTreinos());
            
            

            preparaInstrucao.executeUpdate();

            //código para pegar a chave primaria do BD
            resultado = preparaInstrucao.getGeneratedKeys();
            resultado.next();
            entidadePlanos.setCod_plano(resultado.getInt(1));

        } catch (Exception e) {

            System.out.println("Erro ao salvar Plano! " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }
    }

    @Override
    public void alterarPlanos(Object object) throws SQLException {
          Planos planos = (Planos) object;
           String instrucao = "UPDATE public.planos"
                   + "SET cod_plano=?, nm_plano=?, vigencia=? treino=?"
                   + "WHERE cod_plano=?";
           try {
         conexao = FabricaConexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(instrucao);
            preparaInstrucao.setString(1, planos.getTipoPlano());
            preparaInstrucao.setString(2, planos.getTipoVigencia());
            preparaInstrucao.setString(3, planos.getTipoTreinos());
           

            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao alterar Planos" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }   
    }

    @Override
    public void excluirPlanos(int cod_plano) throws SQLException {
         try {
            conexao = FabricaConexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement("DELETE FROM public.cod_plano WHERE cod_plano = ?");
            preparaInstrucao.setInt(1, cod_plano);
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao excluir Planos " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }

    }

    @Override
    public List<Planos> pesquisarcod_Planos(int cod_plano) throws SQLException {
        Planos planos = null;
        String sql = "SELECT cod_plano, nm_plano, vigencia, treino"
                + "FROM public.planos WHERE cod_plano=?;";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setInt(1, cod_plano);
            resultado = preparaInstrucao.executeQuery();

            if (resultado.next()) {

                planos = new Planos();
                planos.setCod_plano(resultado.getInt("cod_plano"));
                planos.setTipoPlano(resultado.getString("nm_plano"));
                planos.setTipoVigencia(resultado.getString("vigencia"));
                planos.setTipoTreinos(resultado.getString("treino"));
                
            }

        } catch (Exception e) {
            System.err.println("Erro ao pesquisarId do plano");
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }

        return (List<Planos>) planos;
    }
    
}
