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
import java.util.ArrayList;


/**
 *
 * @author a1609556
 */
public class Dist2_Cliente {
    public static InterfaceServ servidor;
    public static Curriculo curriculo = new Curriculo ();
    public static InterfaceCli cli;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry reg = LocateRegistry.getRegistry(1099);
        InterfaceServ servidor = (InterfaceServ) reg.lookup("Hello World");
        CliImpl cliente = new CliImpl(servidor);
        //curriculo.setCurriculo("nome", "contato", "area", 12, 123);
        //servidor.inserirCurriculo("nome", "contato", "area", 12, 123);
        //abreMenu();
        clrscr();
        Scanner leia = new Scanner(System.in);
        int opt = 1, opt_sub = 0;
        String areaFiltro;
        float salarioFiltro;
        ArrayList<Empresa> empresasFiltered = new ArrayList();

        
        
        while (opt != 5){
            System.out.println("Bem-vindo a Agência de Estágio - CLI Aluno ");
            System.out.println("\nDigite a opção desejada:");
            System.out.println("1 - Cadastre seu Currículo.");
            System.out.println("2 - Consulte as Vagas Disponíveis.");
            System.out.println("3 - Notificações");
            
            opt = Integer.parseInt(leia.nextLine());
            
            if (opt == 1) {
                clrscr();
                Scanner leia2 = new Scanner(System.in);
                String nome, contato, area;
                int cargaHoraria;
                float salario;
                System.out.println("****Cadastro de Currículo*****");
                System.out.println("Insira o seu nome: ");
                nome = leia.nextLine();
                System.out.println("E-mail: ");
                contato = leia.nextLine();
                System.out.println("Área de Interesse: ");
                area = leia.nextLine();
                System.out.println("Carga Horaria Disponível, em número de horas: ");
                cargaHoraria = Integer.parseInt(leia.nextLine());
                System.out.println("Salario: ");
                salario = Float.parseFloat(leia.nextLine());
                servidor.inserirCurriculo(nome, contato, area, cargaHoraria, salario, cliente);
            }
            
            if (opt == 2){
                clrscr();
                System.out.println("****Mostrando vagas disponíveis****");
                System.out.println("Vagas disponíveis, escolha uma opção");
                System.out.println("1 - Vagas filtradas");
                System.out.println("2 - Todas as vagas");
                System.out.println("Opção: ");
                opt_sub = Integer.parseInt(leia.nextLine());
                if (opt_sub == 2) {
                    empresasFiltered = servidor.consultar(opt_sub, "", 0);
                }
                if (opt_sub == 1) {
                    System.out.println("Área de interesse: ");
                    areaFiltro = leia.nextLine();
                    System.out.println("Salário mínimo: ");
                    salarioFiltro = Float.parseFloat(leia.nextLine());
                    empresasFiltered = servidor.consultar(opt_sub, areaFiltro, salarioFiltro);
                }
                for (Empresa empresa : empresasFiltered) {
                    System.out.println("Vaga da empresa: " + empresa.getNomeEmpresa());
                    System.out.println("Area: " + empresa.getAreaVaga());
                    System.out.println("Salario: " + empresa.getSalarioVaga());
                }
                
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
