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
import dist2_interface.Curriculo;


/**
 *
 * @author a1609556
 */
public class Dist2_Cliente {
    public static InterfaceServ servidor;
    public static Curriculo curriculo = new Curriculo ();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry reg = LocateRegistry.getRegistry(1099);
        InterfaceServ servidor = (InterfaceServ) reg.lookup("Hello World");
        CliImpl cliente = new CliImpl(servidor);
        //curriculo.setCurriculo("nome", "contato", "area", 12, 123);
        servidor.inserirCurriculo("nome", "contato", "area", 12, 123);
        //abreMenu();
    }

    public static void abreMenu() throws InterruptedException, RemoteException, NotBoundException {

        System.out.println("Bem vindo ao Portal do Aluno de Estágio");

        Scanner leia = new Scanner(System.in);
        int opt = 1;
        while (opt != 5) {
            System.out.println("Escolha uma opção abaixo");
            System.out.println("1 - Cadastrar Curriculo");
            opt = Integer.parseInt(leia.nextLine());
                clrscr();
                Scanner leia2 = new Scanner(System.in);
                String nome, contato, area;
                int cargaHoraria;
                float salario;
                System.out.println("Cadastro de Curriculo");
                System.out.println("Insira seu nome: ");
                nome = leia.nextLine();
                System.out.println("Digite E-mail, Celular ou WhatsApp: ");
                contato = leia.nextLine();
                System.out.println("Digite sua área: ");
                area = leia.nextLine();
                System.out.println("Digite Carga Horária Disponível (somente numeros, em horas): ");
                cargaHoraria = leia.nextInt();
                System.out.println("Digite Pretenção de Salario (somente numeros, sem vírgulas ou pontos): ");
                salario = leia.nextFloat();
                
                curriculo.setCurriculo(nome, contato, area, cargaHoraria, salario);
                Thread.sleep(2222);
                //servidor.inserirCurriculo2(nome, contato, area, cargaHoraria, salario);
                
            if (opt == 2){
                clrscr();
                System.out.println("Vagas disponíveis");
            
                    }
                }
    }

    public static void cadastroMenu() {
        clrscr();
        Scanner leia = new Scanner(System.in);
        System.out.println("Olá");
        
    }

    public static void clrscr() {
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

}
