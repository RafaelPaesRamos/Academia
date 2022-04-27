

package pacote.clienteDao;

import br.entidade.academia.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthu
 */
public class ClienteDaoImp implements ClienteDao {

    private Connection conexao;
    private PreparedStatement preparaInstrucao;
    private ResultSet resultado;

    /*TÁ DIZENDO QUE ISSO AQUI TÁ RETORNANDO NULL*/

    @Override
    public void salvarCliente(Object object) throws SQLException {

        Cliente entidadeCliente = (Cliente) object;
        preparaInstrucao = null;
        resultado = null;
        Integer matricula = null;

        String instrucao = "INSERT INTO public.cliente(\n"
                + "	nome, sobrenome, sexo, peso, altura, endereco, cidade_estado, email)"
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conexao = FabricaConexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(instrucao, Statement.RETURN_GENERATED_KEYS);
            preparaInstrucao.setString(1, entidadeCliente.getNomeCliente());
            preparaInstrucao.setString(2, entidadeCliente.getSobreNomeCliente());
            preparaInstrucao.setString(3, entidadeCliente.getSexoCliente());
            preparaInstrucao.setString(4, entidadeCliente.getAlturaCliente());
            preparaInstrucao.setString(5, entidadeCliente.getPesoCliente());
            preparaInstrucao.setString(6, entidadeCliente.getEndereçoCliente());
            preparaInstrucao.setString(7, entidadeCliente.getCidadeEstadoCliente());
            preparaInstrucao.setString(8, entidadeCliente.getEmail());

            preparaInstrucao.executeUpdate();

            //código para pegar a chave primaria do BD
            resultado = preparaInstrucao.getGeneratedKeys();
            resultado.next();
            entidadeCliente.setMatricula(resultado.getInt(1));

        } catch (Exception e) {

            System.out.println("Erro ao salvar cliente! " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }

    }

    @Override
    public void alterarCliente(Object object) throws SQLException {
           Cliente cliente = (Cliente) object;
           String instrucao = "UPDATE public.cliente" +
"	SET matricula=?, nome=?, sobrenome=?, sexo=?, peso=?, altura=?, endereco=?, cidade_estado=?, email=?" +
"	WHERE matricula = ?";
           try {
         conexao = FabricaConexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(instrucao);
            preparaInstrucao.setString(1, cliente.getNomeCliente());
            preparaInstrucao.setString(2, cliente.getSobreNomeCliente());
            preparaInstrucao.setString(3, cliente.getSexoCliente());
            preparaInstrucao.setString(4, cliente.getAlturaCliente());
            preparaInstrucao.setString(5, cliente.getPesoCliente());
            preparaInstrucao.setString(6, cliente.getEndereçoCliente());
            preparaInstrucao.setString(7, cliente.getCidadeEstadoCliente());
            preparaInstrucao.setString(8, cliente.getEmail());

            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao alterar cliente" + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }   
    }

    @Override
    public Object pesquisarPorMatricula(int matricula) throws SQLException {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE matricula = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            preparaInstrucao.setInt(1, matricula);
            resultado = preparaInstrucao.executeQuery();

            if (resultado.next()) {

                cliente = new Cliente();
                cliente.setMatricula(resultado.getInt("matricula"));
                cliente.setNomeCliente(resultado.getString("nome"));
                cliente.setSobreNomeCliente(resultado.getString("sobrenome"));
                cliente.setSexoCliente(resultado.getString("sexo"));
                cliente.setPesoCliente(resultado.getString("peso"));
                cliente.setAlturaCliente(resultado.getString("altura"));
                cliente.setEndereçoCliente(resultado.getString("endereco"));
                cliente.setCidadeEstadoCliente(resultado.getString("cidade_estado"));
                cliente.setEmail(resultado.getString("email"));
            }

        } catch (Exception e) {
            System.err.println("Erro ao pesquisarId do cliente");
        } finally {
            conexao.close();
            preparaInstrucao.close();
            resultado.close();
        }

        return cliente;
    }

    @Override
    public List<Cliente> pesquisarNomes(String nome) throws Exception {

        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement(sql);
            
            preparaInstrucao.setString(1, "%" + nome + "%");
            resultado = preparaInstrucao.executeQuery();
            Cliente cliente;
            
            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setMatricula(resultado.getInt("matricula"));
                cliente.setNomeCliente(resultado.getString("nome"));
                cliente.setSobreNomeCliente(resultado.getString("sobrenome"));
                cliente.setSexoCliente(resultado.getString("sexo"));
                cliente.setPesoCliente(resultado.getString("peso"));
                cliente.setAlturaCliente(resultado.getString("altura"));
                cliente.setEndereçoCliente(resultado.getString("endereco"));
                cliente.setCidadeEstadoCliente(resultado.getString("cidade_estado"));
                cliente.setEmail(resultado.getString("email"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.err.println("Erro ao pesquisar nome do cliente");
        } finally {
            resultado.close();
            preparaInstrucao.close();
            conexao.close();
        }
        return clientes;
    } 
    
    
    @Override
    public void excluirCliente(int matricula) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaInstrucao = conexao.prepareStatement("DELETE FROM public.cliente WHERE matricula = ?");
            preparaInstrucao.setInt(1, matricula);
            preparaInstrucao.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao excluir cliente " + e.getMessage());
        } finally {
            conexao.close();
            preparaInstrucao.close();
        }
        

    }

    
}
