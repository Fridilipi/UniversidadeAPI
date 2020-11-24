package org.felippesouza.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Aluno extends PanacheEntityBase {

    @Id
    @Column(name = "Id")
    private String id;

    @OneToOne
    @JoinColumn(name = "IdGraduacao")
    private Graduacao graduacao;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "DataNascimento")
    private Date dataNascimento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
