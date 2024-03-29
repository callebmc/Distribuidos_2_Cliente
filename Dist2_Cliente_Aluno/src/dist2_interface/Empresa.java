/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Calleb Malinoski
 */
public class Empresa implements Serializable {

    private String nomeEmpresa;
    private String emailEmpresa;
    private String areaVaga;
    private String cargaHorariaVaga;
    private float salarioVaga;
    public InterfaceCli ref;

    //CONSTRUTOR DE VAGAS
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

    public void setNomeEmpresa(String n) {
        this.nomeEmpresa = n;
    }

    public void setEmailEmpresa(String e) {
        this.emailEmpresa = e;
    }

    public void setAreaVaga(String a) {
        this.areaVaga = a;
    }

    public void setCargaHoraria(String c) {
        this.cargaHorariaVaga = c;
    }

    public void setSalarioVaga(float s) {
        this.salarioVaga = s;
    }
}
