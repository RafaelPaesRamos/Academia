
package pacote.clienteDao;

import br.entidade.academia.Cliente;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author arthu
 */
public interface ClienteDao extends BaseDao {
    
    List<Cliente> pesquisarNomes(String nome) throws  Exception;
}
