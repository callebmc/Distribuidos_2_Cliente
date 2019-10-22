/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author a1609556
 */
public class Dist2_Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(1099);
        InterfaceServ servidor = (InterfaceServ) reg.lookup("Hello World");
        CliImpl cliente = new CliImpl(servidor);
        abreMenu();
    }

    public static void abreMenu() {

        System.out.println("Bem vindo ao Portal do Aluno de Estágio");

        Scanner leia = new Scanner(System.in);
        int opt = 1;
        while (opt != 5) {
            System.out.println("Escolha uma opção abaixo");
            System.out.println("1 - Cadastrar Aluno");
            opt = Integer.parseInt(leia.nextLine());

            if (opt == 1) {
                cadastroMenu();
            }
        }
    }
    
    public static void cadastroMenu(){
        clrscr();
        Scanner leia = new Scanner(System.in);
        System.out.println("Olá");
    }
    
    public static void clrscr(){
    //Clears Screen in java
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
}

}
