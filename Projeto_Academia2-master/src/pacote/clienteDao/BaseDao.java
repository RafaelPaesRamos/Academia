/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pacote.clienteDao;

import java.sql.SQLException;

/**
 *
 * @author arthu
 */
public interface BaseDao {
    
    void salvarCliente(Object object)throws SQLException;
    
    void alterarCliente(Object object) throws SQLException;
    
    void excluirCliente(int matricula) throws SQLException;
    
    Object pesquisarPorMatricula(int matricula) throws SQLException;
    
}
