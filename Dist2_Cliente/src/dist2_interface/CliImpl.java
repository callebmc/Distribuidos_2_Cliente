/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author a1609556
 */
public class CliImpl extends UnicastRemoteObject implements InterfaceCli {

    private InterfaceServ teste;
    public CliImpl (InterfaceServ servidor) throws RemoteException{
        teste = servidor;
        teste.chamar("Oi", this);
    }
    @Override
    public void echo(String mensagem) throws RemoteException {
        System.out.println(mensagem);
       
    }    
}
