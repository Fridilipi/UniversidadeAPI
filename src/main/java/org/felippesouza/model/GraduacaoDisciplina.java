package org.felippesouza.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class GraduacaoDisciplina extends PanacheEntityBase {

    @OneToMany
    @JoinColumn(name = "IdGraduacao")
    private Graduacao graduacao;

    @OneToMany
    @JoinColumn(name = "IdDisciplina")
    private Disciplina disciplina;

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
