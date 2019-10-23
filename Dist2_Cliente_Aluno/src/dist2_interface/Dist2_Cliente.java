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
    //public static Curriculo curriculo = new Curriculo();
    public static InterfaceCli cli;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry reg = LocateRegistry.getRegistry(1099);
        InterfaceServ servidor = (InterfaceServ) reg.lookup("Hello World");
        CliImpl cliente = new CliImpl(servidor);
        Scanner leia = new Scanner(System.in);
        int opt = 1, opt_sub = 0, cont = 1;
        String areaFiltro;
        float salarioFiltro;
        ArrayList<Empresa> empresasFiltered = new ArrayList();
        ArrayList<Curriculo> curriculoFiltered = new ArrayList();
        String nome, contato, area;
        int cargaHoraria;
        float salario;

        while (opt != 5) {
            System.out.println("Bem-vindo a Agência de Estágio - CLI Aluno ");
            System.out.println("\nDigite a opção desejada:");
            System.out.println("1 - Cadastre seu Currículo.");
            System.out.println("2 - Consulte as Vagas Disponíveis.");
            System.out.println("3 - Atualizar Curriculo");

            opt = Integer.parseInt(leia.nextLine());

            //CADASTRA CURRICULO
            if (opt == 1) {
                System.out.println("");
                Scanner leia2 = new Scanner(System.in);
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

            //CONSULTA VAGAS DISPONÍVEIS
            if (opt == 2) {
                System.out.println("");
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

            //ATUALIZA CURRICULO
            if (opt == 3) {
                curriculoFiltered = servidor.consultarCurriculos(" ");
                System.out.println("Escolha o número do curriculo para editar");
                for (Curriculo curriculo : curriculoFiltered) {
                    System.out.println("");
                    System.out.println("Curriculo Número: " + cont++);
                    System.out.println("Nome do Aluno: " + curriculo.getNome());
                    System.lineSeparator();
                }

                System.out.print("Opção: ");
                opt_sub = Integer.parseInt(leia.nextLine());
                System.out.println("Insira o novo nome: ");
                nome = leia.nextLine();
                System.out.println("E-mail: ");
                contato = leia.nextLine();
                System.out.println("Área de Interesse: ");
                area = leia.nextLine();
                System.out.println("Carga Horaria Disponível, em número de horas: ");
                cargaHoraria = Integer.parseInt(leia.nextLine());
                System.out.println("Salario: ");
                salario = Float.parseFloat(leia.nextLine());
                servidor.atualizarCurriculo(opt_sub - 1, nome, contato, area, opt, salario);
            }

            cont = 1;

        }
    }
}
