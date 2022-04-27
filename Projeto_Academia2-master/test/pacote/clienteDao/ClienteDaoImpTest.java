///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pacote.clienteDao;
//
//import br.entidade.academia.Cliente;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Date;
//import java.util.List;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Lucas Denofrio
// */
//public class ClienteDaoImpTest {
//    
//    private Cliente cliente;
//    private ClienteDao clienteDao;
//    
//    public ClienteDaoImpTest() {
//        clienteDao = new ClienteDaoImp();
//    }
//
////    @Test
////    public void testSalvarCliente() throws Exception {
////        System.out.println("salvarCliente");
////        cliente = new Cliente(null,"Fagner","Rodrigues", "M", "50kg", "1.57m", "blablabla", "Palhoça SC",);
////        clienteDao.salvarCliente(cliente);
////        assertNotNull(cliente.getMatricula());
////        
////     
//    }
////    @Test
//    public Cliente buscarClienteBD() throws Exception{
//            Connection conn = null;
//            PreparedStatement psmt = null;
//            ResultSet resultado = null;
//        
//        try {
//             conn = FabricaConexao.abrirConexao();
//            psmt = conn.prepareStatement("SELECT * FROM cliente");
//            resultado = psmt.executeQuery();
//            
//            if(resultado.next()){
//                
//                cliente = new Cliente();
//                
//                cliente.setMatricula(resultado.getInt("matricula"));
//                cliente.setNomeCliente(resultado.getString("nome"));
//                cliente.setSobreNomeCliente(resultado.getString("sobrenome"));
//                cliente.setSexoCliente(resultado.getString("sexo"));
//                cliente.setPesoCliente(resultado.getString("peso"));
//                cliente.setAlturaCliente(resultado.getString("altura"));
//                cliente.setEndereçoCliente(resultado.getString("endereco"));
//                cliente.setCidadeEstadoCliente(resultado.getString("cidade_estado"));
//                
//            }else{
//                testSalvarCliente();
//            }
//            
//        } catch (Exception e) {
//            System.out.println("Errou ao pesquisar BD"+e.getMessage());
//        }finally{
//            
//            conn.close();
//            psmt.close();
//            resultado.close();
//            
//        }
//   
//        return cliente;
//    }
//
//  
//
////    @Test
////    public void testAlterar() throws Exception {
////        System.out.println("alterar");
////        Object object = null;
////        ClienteDaoImp instance = new ClienteDaoImp();
////        instance.alterar(object);
////        fail("The test case is a prototype.");
////    }
//
////    @Test
//    public void testPesquisarPorMatricula() throws Exception {
//        System.out.println("pesquisarPorMatricula");
//        buscarClienteBD();
//        Cliente clienteNovo = (Cliente) clienteDao.pesquisarPorMatricula(cliente.getMatricula());
//        mostrarCliente(cliente);
//    }
//    private void mostrarCliente(Cliente cliente){
//        System.out.println("id: "+cliente.getMatricula());
//        System.out.println("nome: "+cliente.getNomeCliente());
//        System.out.println("sobreNome: "+cliente.getSobreNomeCliente());
//        System.out.println("sexo: "+cliente.getSexoCliente());
//        System.out.println("peso: "+cliente.getPesoCliente());
//        System.out.println("altura: "+cliente.getAlturaCliente());
//        System.out.println("endereco: "+cliente.getEndereçoCliente());
//        System.out.println("cidadeEstado: "+cliente.getCidadeEstadoCliente());
//        System.out.println("");
//    }
//    
//    
//    @Test
//    public void testPesquisarPorNome() throws Exception {
//        System.out.println("pesquisarPorMatricula");
////        buscarClienteBD();
//List<Cliente> cli = clienteDao.pesquisarNomes("Lari");
//        for (Cliente cliente : cli) {
//            mostrarCliente(cliente);
//        }
//
//    }
//    
//}
