/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author ana
 */
//Classe interessados em curriculos (EMPRESAS)
public class InteressadosCurriculos implements Serializable {

    private InterfaceCli interfaceCliente;
    private String areaInteresse;

    //CONSTRUTUOR DE INTERESSE EM CURRICULOS
    public InteressadosCurriculos(InterfaceCli interfaceCliente, String areaInteresse) {
        this.interfaceCliente = interfaceCliente;
        this.areaInteresse = areaInteresse;
    }

    //MÉTODO QUE INVOCA A NOTIFICAÇÃO NA INTERFACE DO CLIENTE
    public void notifica(String msg) throws RemoteException {
        this.interfaceCliente.notificarCurriculos(msg, "123");
    }

    public String getAreaInteresse() {
        return this.areaInteresse;
    }

    public InterfaceCli getInterfaceCli() {
        return this.interfaceCliente;
    }
}
