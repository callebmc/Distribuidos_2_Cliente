/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

/**
 *
 * @author Calleb Malinoski
 */
public class Aluno {

    private String nome;
    private String email;
    private String areaInteresse;
    private int cargaHoraria;
    private float salarioPretendido;
    public InterfaceCli ref;

    public Aluno(String nome, String email, String areaInteresse, int cargaHoraria, float salarioPretendido, InterfaceCli ref) {
        this.nome = nome;
        this.email = email;
        this.areaInteresse = areaInteresse;
        this.cargaHoraria = cargaHoraria;
        this.salarioPretendido = salarioPretendido;
        this.ref = ref;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getAreaInteresse() {
        return areaInteresse;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public float getSalarioPretendido() {
        return salarioPretendido;
    }
}
