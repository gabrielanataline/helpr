package org.soulcodeacademy.helpr.domain;
import javax.persistence.*;

@Entity   // IRÁ TRANSFORMAR A CLASSE de uma entidade EM UMA TABELA
public class Cargo {
    @Id        //PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Integer idCargo;     // será a chave primária da tabela
    @Column (nullable = false, length = 50)    //NOT NULL, e máximo de 50 caracteres
    private String nome;
    @Column(nullable = false, length = 120)     //@Column, serve para customizar a coluna!
    private String descricao;
    @Column(nullable = false)
    private Double salario;

    // a ORM  irá usar este cosntrutor em conjuntos de getters/setters
    public Cargo (){}     //NECESSÁRIO CRIAR CONSTRUTOR VAZIO

    public Cargo(Integer idCargo, String nome, String descricao, Double salario) {
        this.idCargo = idCargo;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
