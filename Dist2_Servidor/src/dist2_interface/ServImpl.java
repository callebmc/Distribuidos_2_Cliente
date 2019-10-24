/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import dist2_interface.Curriculo;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import dist2_interface.ListaDeCurriculos;
import java.util.List;

/**
 *
 * @author a1609556
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {

    //Lista de vagas cadastradas
    private ArrayList<Empresa> vagasCadastradas;

    //Lista de curriculos
    private ListaDeCurriculos listaDeCurriculos;

    //Lista de registro de interesse de vagas
    private ArrayList<InteressadosVagas> interessadosVagas;

    //Lista de registro de interesse de curriculos
    private ArrayList<InteressadosCurriculos> interessadosCurriculos;

    public ServImpl() throws RemoteException {
        //Inicializa as listas
        this.vagasCadastradas = new ArrayList<>();
        this.listaDeCurriculos = new ListaDeCurriculos();
        this.interessadosCurriculos = new ArrayList<>();
        this.interessadosVagas = new ArrayList<>();
    }

    /*
    Cria novo currículo 
     */
    @Override
    public boolean inserirCurriculo(String a, String b, String e, int c, float d, InterfaceCli cli) throws RemoteException {
        System.out.println("Estou aqui!");

        Curriculo rescu = new Curriculo(a, b, e, c, d);
        /*if (interessadosCurriculos != null){
             String msg = "Novo curriculo na empresa: " + a + "Na área: " + e + "Com salário de : " + d;
             interessadosCurriculos.notifica(msg);
         }*/
        notificaInteresseCurriculo(e, cli);
        return listaDeCurriculos.adicionar(rescu);
    }

    //Registra interesse em Vagas
    @Override
    public void registraInteresseVagas(InterfaceCli cli, String areaInteresse) throws RemoteException {
        InteressadosVagas novoInteresse = new InteressadosVagas(cli, areaInteresse);
        this.interessadosVagas.add(novoInteresse);
    }

    //Registra interesse em Curriculos
    @Override
    public void registraInteresseCurriculos(InterfaceCli cli, String areaInteresse) throws RemoteException {
        InteressadosCurriculos novoInteresse = new InteressadosCurriculos(cli, areaInteresse);
        this.interessadosCurriculos.add(novoInteresse);
    }

    //Empresa consulta currículo
    synchronized public ArrayList<Curriculo> consultarCurriculos(String area) throws RemoteException {
        System.out.println("Consultar CURRICULOS");
        return listaDeCurriculos.consultar(area);

    }

    //Cria nova vaga de estágio
    @Override
    synchronized public void criarVaga(String nomeEmpresa, String emailEmpresa, String areaVaga, String cargaHorariaVaga, float salarioVaga, InterfaceCli cliente) throws RemoteException {
        try {
            Empresa novaEmpresa = new Empresa(nomeEmpresa, emailEmpresa, areaVaga, cargaHorariaVaga, salarioVaga, cliente);
            vagasCadastradas.add(novaEmpresa);
            System.out.println("Nova vaga cadastrada com sucesso");
            notificaInteresseVaga(areaVaga, cliente);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        } //To change body of generated methods, choose Tools | Templates.
    }

    //MÉTODO DE NOTIFICAÇÃO DE INTERESSE DE VAGA
    @Override
    synchronized public void notificaInteresseVaga(String areaInteresse, InterfaceCli cli) throws RemoteException {

        if (interessadosVagas != null) {
            for (InteressadosVagas interesse : interessadosVagas) {
                if (interesse.getAreaInteresse().equals(areaInteresse)) {
                    String msg = "Nova vaga na área: " + areaInteresse;
                    interesse.notifica(msg);
                }
            }
        }
    }

    //MÉTODO DE NOTIFICAÇÃO DE INTERESSE DE CURRICULO
    @Override
    public void notificaInteresseCurriculo(String areaInteresse, InterfaceCli cli) throws RemoteException {
        if (interessadosCurriculos != null) {
            for (InteressadosCurriculos interesse : interessadosCurriculos) {
                if (interesse.getAreaInteresse().equals(areaInteresse)) {
                    String msg = "Novo curriculo na área: " + areaInteresse;
                    interesse.notifica(msg);
                }
            }
        }
    }

    //Consulta vagas de acordo com os filtro e retorna uma lista de Vagas
    @Override
    synchronized public ArrayList<Empresa> consultar(int filtro, String area, float salario) throws RemoteException {
        try {
            ArrayList<Empresa> empresasFiltered;

            empresasFiltered = new ArrayList();
            if (filtro == 1) {
                for (Empresa empresa : vagasCadastradas) {

                    if (empresa.getSalarioVaga() >= salario) {
                        if (empresa.getAreaVaga().equals(area)) {
                            empresasFiltered.add(empresa);
                        }
                    }
                }
            }
            if (filtro == 2) {
                for (Empresa empresa : vagasCadastradas) {
                    empresasFiltered.add(empresa);
                }
            }
            return empresasFiltered;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    //Atualiza vaga de estágio
    @Override
    public void atualizarVaga(int indice, String nomeEmpresa, String emailEmpresa, String areaVaga, String cargaHorariaVaga, float salarioVaga, InterfaceCli cliente) throws RemoteException {
        vagasCadastradas.get(indice).setNomeEmpresa(nomeEmpresa);
        vagasCadastradas.get(indice).setEmailEmpresa(emailEmpresa);
        vagasCadastradas.get(indice).setAreaVaga(areaVaga);
        vagasCadastradas.get(indice).setCargaHoraria(cargaHorariaVaga);
        vagasCadastradas.get(indice).setSalarioVaga(salarioVaga);
    }

    //Atualiza currículo
    @Override
    public void atualizarCurriculo(int indice, String nome, String contato, String area, int CH, float salario) throws RemoteException {
        listaDeCurriculos.atualizar(indice, nome, contato, area, CH, salario);
        System.out.println("Curriculo ATUALIZADO");
    }
}
