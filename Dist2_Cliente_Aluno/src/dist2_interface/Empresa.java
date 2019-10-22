/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.util.ArrayList;

/**
 *
 * @author Calleb Malinoski
 */
public class Empresa {

    private String nomeEmpresa;
    private String emailEmpresa;
    private String areaVaga;
    private String cargaHorariaVaga;
    private float salarioVaga;
    private ArrayList<Aluno> interessados;
    public InterfaceCli ref;

    public Empresa(String nomeEmpresa, String emailEmpresa, String areaVaga, String cargaHorarioVaga, float salarioVaga, InterfaceCli ref) {
        this.nomeEmpresa = nomeEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.areaVaga = areaVaga;
        this.cargaHorariaVaga = cargaHorarioVaga;
        this.salarioVaga = salarioVaga;
        this.ref = ref;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public String getAreaVaga() {
        return areaVaga;
    }

    public String getCargaHorarioVaga() {
        return cargaHorariaVaga;
    }

    public float getSalarioVaga() {
        return salarioVaga;
    }
    
    public ArrayList<Aluno> getInteressados() {
        return interessados;
    }
    
    public void addInteressado(Aluno a){
        this.interessados.add(a);
    }
}
