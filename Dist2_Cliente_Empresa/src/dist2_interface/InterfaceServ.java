/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author a1609556
 */
public interface InterfaceServ extends Remote{
    void chamar(String mensagem, InterfaceCli interfaceCli) throws RemoteException;
    public boolean inserirAluno(Aluno a) throws RemoteException;    
    public void criarVaga(String nomeEmpresa, String emailEmpresa, String areaVaga, String cargaHorariaVaga, float salarioVaga, InterfaceCli cliente) throws RemoteException;
}
