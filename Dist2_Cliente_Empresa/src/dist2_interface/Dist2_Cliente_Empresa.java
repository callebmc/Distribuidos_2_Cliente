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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author a1609556
 */
public class Dist2_Cliente_Empresa {

    /**
     * @param args the command line arguments
     */
    public static InterfaceServ servidor;
    public static CliImpl cliente;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(1099);
        InterfaceServ servidor = (InterfaceServ) reg.lookup("Hello World");
        CliImpl cliente = new CliImpl(servidor);
        System.out.println("Bem vindo ao Portal do Empresa de Estágio");

        Scanner leia = new Scanner(System.in);
        int opt = 1, opt_sub = 0;
        String areaFiltro;
        float salarioFiltro;
        ArrayList<Empresa> empresasFiltered = new ArrayList();
        ArrayList<Curriculo> curriculoFiltered = new ArrayList();

        while (opt != 5) {
            System.out.println("Escolha uma opção abaixo");
            System.out.println("1 - Cadastrar Vaga");
            System.out.println("2 - Consultar Vagas");
            System.out.println("3 - Consultar Currículos");
            opt = Integer.parseInt(leia.nextLine());

            if (opt == 1) {
                clrscr();
                Scanner leia2 = new Scanner(System.in);
                String nomeEmpresa, emailEmpresa, areaVaga, cargaHorariaVaga;
                float salario;
                System.out.println("Cadastro de Vaga");
                System.out.println("Insira o nome da empresa: ");
                nomeEmpresa = leia.nextLine();
                System.out.println("Email: ");
                emailEmpresa = leia.nextLine();
                System.out.println("Área da vaga: ");
                areaVaga = leia.nextLine();
                System.out.println("Carga Horaria Total: ");
                cargaHorariaVaga = leia.nextLine();
                System.out.println("Salario: ");
                salario = Float.parseFloat(leia.nextLine());
                servidor.criarVaga(nomeEmpresa, emailEmpresa, areaVaga, cargaHorariaVaga, salario, cliente);
            }
            if (opt == 2) {
                clrscr();
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
            
            if (opt == 3){
                clrscr();
                System.out.println("********* Currículos Cadastrados ***********");
                System.out.println("1 - Filtrar por área de interesse");
                System.out.println("2 - Todas as vagas");
                System.out.println("Opção: ");
                opt_sub = Integer.parseInt(leia.nextLine());
                if (opt_sub == 2) {
               
                    curriculoFiltered = servidor.consultarCurriculos(" ");
                }
                
                else {
                    System.out.println("Área de interesse: ");
                    String area_curriculo = leia.nextLine();
                    curriculoFiltered = servidor.consultarCurriculos(area_curriculo);
                }
                
                for (Curriculo curriculo : curriculoFiltered) {
                    System.out.println("Vaga da empresa: " + curriculo.getNome());
                    System.out.println("Area: " + curriculo.getArea());
                    System.out.println("Disponibilidade: " + curriculo.getCH() + " horas.");
                    System.out.println("Salario pretendido: " + curriculo.getSalario());
                }
                
            }
        }
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
