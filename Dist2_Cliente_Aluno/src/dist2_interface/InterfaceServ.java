/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import dist2_interface.Curriculo;

/**
 *
 * @author a1609556
 */
public interface InterfaceServ extends Remote{    
    /*
    Método para consultar curriculos
    */
    public ArrayList<Curriculo> consultarCurriculos(String area) throws RemoteException ;
    
    /*
    Método que cria um novo currículo
    */
    public boolean inserirCurriculo(String a, String b, String e, int c, float d, InterfaceCli cli)throws RemoteException;
    
    /*
    Método que atualiza curriculo
    */
    public void atualizarCurriculo(int indice, String nome, String contato, String area, int CH, float salario) throws RemoteException;
    
    /*
    Método que registra interesse em Vagas
    */
    public void registraInteresseVagas(InterfaceCli cli, String areaInteresse) throws RemoteException;    
    
    /********************************/
    /********************************/
    /********************************/
    
    /*
    Método que cria uma nova vaga de estágio
    */
    public void criarVaga(String nomeEmpresa, String emailEmpresa, String areaVaga, String cargaHorariaVaga, float salarioVaga, InterfaceCli cliente) throws RemoteException;
    
    /*
    Método que consulta vagas de estágio
    */
    public ArrayList<Empresa> consultar(int filtro, String area, float salario) throws RemoteException ;
    
    /*
    Método que atualiza vaga de estágio
    */
    public void atualizarVaga(int indice,String nomeEmpresa, String emailEmpresa, String areaVaga, String cargaHorariaVaga, float salarioVaga, InterfaceCli cliente) throws RemoteException;
    
    /*
    Método que registra interesse em Curriculos
    */
    public void registraInteresseCurriculos(InterfaceCli cli, String areaInteresse) throws RemoteException;    
}