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
public interface InterfaceCli extends Remote {
    void echo(String mensagem) throws RemoteException;   
    public void notificarCurriculos(String msg, String titulo) throws RemoteException;
    public void notificarVagas(String msg, String titulo) throws RemoteException;
}
