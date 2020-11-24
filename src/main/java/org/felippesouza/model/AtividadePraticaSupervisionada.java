package org.felippesouza.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class AtividadePraticaSupervisionada extends PanacheEntityBase {

    @Id
    @Column(name = "Id")
    private String id;

    @OneToOne
    @JoinColumn(name = "IdAluno")
    private Aluno aluno;

    @OneToOne
    @JoinColumn(name = "IdDisciplina")
    private Disciplina disciplina;

    @OneToOne
    @JoinColumn(name = "IdNota")
    private Nota nota;

    @Column(name = "ValorNota")
    private Double valorNota;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Double getValorNota() {
        return valorNota;
    }

    public void setValorNota(Double valorNota) {
        this.valorNota = valorNota;
    }
}
