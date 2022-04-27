/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pacote.clienteDao;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arthu
 */
public class FabricaConexaoTest {
    
    public FabricaConexaoTest() {
    }

    @Test
    public void testAbrirConexao() throws Exception {
        System.out.println("abrirConexao");
        Connection expResult = null;
        Connection result = FabricaConexao.abrirConexao();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
