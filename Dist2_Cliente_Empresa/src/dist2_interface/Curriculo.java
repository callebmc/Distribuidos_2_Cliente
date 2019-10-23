/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;
import java.io.Serializable;

/**
 *
 * @author ana
 */
public class Curriculo implements Serializable {
    
    
    /*um currículo. */
    
    private String nome;
    private String contato;
    private String area;
    private int carga_horaria;
    private float salario_pretendido;
    
    public Curriculo(String nome, String contato, String area, int CH, float salario) {
    this.nome = nome;
        this.contato = contato;
        this.area = area;
        this.carga_horaria = CH;
        this.salario_pretendido = salario;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getContato() {
        return contato;
    }
    
    public String getArea(){
        return area;
      
    }
    
    public int getCH(){
        return carga_horaria;
    }
    
    public double getSalario(){
        return salario_pretendido;
    }
    
    public void setCurriculo(String nome, String contato, String area, int CH, float salario){
        this.nome = nome;
        this.contato = contato;
        this.area = area;
        this.carga_horaria = CH;
        this.salario_pretendido = salario;
    }
}
