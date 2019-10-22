/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author a1609556
 */
public class Dist2_Cliente_Empresa {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(1099);
        InterfaceServ servidor = (InterfaceServ) reg.lookup("Hello World");
        CliImpl cliente = new CliImpl(servidor);
    }
    
}
