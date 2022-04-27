/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pacote.clienteDao;

import br.entidade.academia.Planos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rafael&Lais
 */
public interface PlanosDao {
    
    List<Planos> pesquisarcod_Planos (int cod_plano) throws SQLException;
    
    void salvarPlanos(Object object)throws SQLException;
    
    void alterarPlanos(Object object) throws SQLException;
    
    void excluirPlanos(int cod_plano) throws SQLException;
    
}
