/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reuniao.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ronny
 */
@Embeddable
public class ParticipantePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idReserva")
    private int idReserva;
    @Basic(optional = false)
    @Column(name = "idFuncionario")
    private int idFuncionario;

    public ParticipantePK() {
    }

    public ParticipantePK(int idReserva, int idFuncionario) {
        this.idReserva = idReserva;
        this.idFuncionario = idFuncionario;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idReserva;
        hash += (int) idFuncionario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantePK)) {
            return false;
        }
        ParticipantePK other = (ParticipantePK) object;
        if (this.idReserva != other.idReserva) {
            return false;
        }
        if (this.idFuncionario != other.idFuncionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reuniao.model.ParticipantePK[ idReserva=" + idReserva + ", idFuncionario=" + idFuncionario + " ]";
    }
    
}
