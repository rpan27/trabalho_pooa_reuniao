/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reuniao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ronny
 */
@Entity
@Table(name = "Participante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participante.findAll", query = "SELECT p FROM Participante p"),
    @NamedQuery(name = "Participante.findByIdReserva", query = "SELECT p FROM Participante p WHERE p.participantePK.idReserva = :idReserva"),
    @NamedQuery(name = "Participante.findByIdFuncionario", query = "SELECT p FROM Participante p WHERE p.participantePK.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Participante.findByAceitouAta", query = "SELECT p FROM Participante p WHERE p.aceitouAta = :aceitouAta")})
public class Participante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticipantePK participantePK;
    @Column(name = "AceitouAta")
    private Short aceitouAta;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    @JoinColumn(name = "idReserva", referencedColumnName = "idReserva", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reserva reserva;

    public Participante() {
    }

    public Participante(ParticipantePK participantePK) {
        this.participantePK = participantePK;
    }

    public Participante(int idReserva, int idFuncionario) {
        this.participantePK = new ParticipantePK(idReserva, idFuncionario);
    }

    public ParticipantePK getParticipantePK() {
        return participantePK;
    }

    public void setParticipantePK(ParticipantePK participantePK) {
        this.participantePK = participantePK;
    }

    public Short getAceitouAta() {
        return aceitouAta;
    }

    public void setAceitouAta(Short aceitouAta) {
        this.aceitouAta = aceitouAta;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participantePK != null ? participantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.participantePK == null && other.participantePK != null) || (this.participantePK != null && !this.participantePK.equals(other.participantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reuniao.model.Participante[ participantePK=" + participantePK + " ]";
    }
    
}
