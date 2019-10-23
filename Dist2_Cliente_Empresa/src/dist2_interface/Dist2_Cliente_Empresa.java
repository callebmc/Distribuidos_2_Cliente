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
        String nomeEmpresa, emailEmpresa, areaVaga, cargaHorariaVaga;
        float salario;

        Scanner leia = new Scanner(System.in);
        int opt = 1, opt_sub = 0, cont=1;
        String areaFiltro;
        float salarioFiltro;
        ArrayList<Empresa> empresasFiltered = new ArrayList();
        ArrayList<Curriculo> curriculoFiltered = new ArrayList();

        while (opt != 5) {
            System.out.println("Escolha uma opção abaixo");
            System.out.println("1 - Cadastrar Vaga");
            System.out.println("2 - Consultar Vagas");
            System.out.println("3 - Consultar Currículos");
            System.out.println("4 - Atualiar Vagas");
            opt = Integer.parseInt(leia.nextLine());

            //CADASTRO DE VAGAS
            if (opt == 1) {
                System.out.println("");
                Scanner leia2 = new Scanner(System.in);
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
            
            //CONSULTAR VAGAS
            if (opt == 2) {
                System.out.println("");
                System.out.println("Vagas disponíveis, escolha uma opção");
                System.out.println("1 - Vagas filtradas");
                System.out.println("2 - Todas as vagas");
                System.out.println("Opção: ");
                opt_sub = Integer.parseInt(leia.nextLine());
                if (opt_sub == 2) {
                    empresasFiltered = servidor.consultar(opt_sub, "", 0);
                }
                if (opt_sub == 1) {
                    System.out.println("");
                    System.out.println("Área de interesse: ");
                    areaFiltro = leia.nextLine();
                    System.out.println("Salário mínimo: ");
                    salarioFiltro = Float.parseFloat(leia.nextLine());
                    empresasFiltered = servidor.consultar(opt_sub, areaFiltro, salarioFiltro);
                }
                for (Empresa empresa : empresasFiltered) {
                    System.out.println("");
                    System.out.println("Vaga da empresa: " + empresa.getNomeEmpresa());
                    System.out.println("Area: " + empresa.getAreaVaga());
                    System.out.println("Salario: " + empresa.getSalarioVaga());
                    System.out.println("");
                }
            }

            //CONSULTAR CURRICULOS CADASTRADOS
            if (opt == 3) {
                System.out.println("");
                System.out.println("********* Currículos Cadastrados ***********");
                System.out.println("1 - Filtrar por área de interesse");
                System.out.println("2 - Todas as vagas");
                System.out.println("Opção: ");
                opt_sub = Integer.parseInt(leia.nextLine());
                if (opt_sub == 2) {

                    curriculoFiltered = servidor.consultarCurriculos(" ");
                } else {
                    System.out.println("Área de interesse: ");
                    String area_curriculo = leia.nextLine();
                    curriculoFiltered = servidor.consultarCurriculos(area_curriculo);
                }

                for (Curriculo curriculo : curriculoFiltered) {
                    System.out.println("");
                    System.out.println("Vaga da empresa: " + curriculo.getNome());
                    System.out.println("Area: " + curriculo.getArea());
                    System.out.println("Disponibilidade: " + curriculo.getCH() + " horas.");
                    System.out.println("Salario pretendido: " + curriculo.getSalario());
                    System.out.println("");
                }
            }

            //ATUALIZAR UMA VAGA
            if (opt == 4) {
                empresasFiltered = servidor.consultar(2, "", 0);
                System.out.println("Escolha o número da vaga para editar");
                for (Empresa empresa : empresasFiltered) {
                    System.out.println("");
                    System.out.println("Vaga Número: " + cont++);
                    System.out.println("Vaga da empresa: " + empresa.getNomeEmpresa());
                    System.out.println("");
                }
                opt_sub = Integer.parseInt(leia.nextLine());
                System.out.println("Insira o novo nome da empresa: ");
                nomeEmpresa = leia.nextLine();
                System.out.println("Email: ");
                emailEmpresa = leia.nextLine();
                System.out.println("Área da vaga: ");
                areaVaga = leia.nextLine();
                System.out.println("Carga Horaria Total: ");
                cargaHorariaVaga = leia.nextLine();
                System.out.println("Salario: ");
                salario = Float.parseFloat(leia.nextLine());
                servidor.atualizarVaga(opt_sub - 1, nomeEmpresa, emailEmpresa, areaVaga, cargaHorariaVaga, salario, cliente);
            }

            cont = 1;
        }
    }
}
