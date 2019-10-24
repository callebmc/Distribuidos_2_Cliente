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
//INTERESSADOS EM VAGAS (ALUNOS)
public class InteressadosVagas implements Serializable {

    private InterfaceCli interfaceCliente;
    private String areaInteresse;

    //CONSTRUTOR DE INTERESSE EM VAGA
    public InteressadosVagas(InterfaceCli interfaceCliente, String areaInteresse) {
        this.interfaceCliente = interfaceCliente;
        this.areaInteresse = areaInteresse;
    }

    //INVOCA O MÉTODO DE NOTIFICAÇÃO DA INTERFACE
    public void notifica(String msg) throws RemoteException {
        this.interfaceCliente.notificarVagas(msg, "123");
    }

    public String getAreaInteresse() {
        return this.areaInteresse;
    }

    public InterfaceCli getInterfaceCli() {
        return this.interfaceCliente;
    }
}
