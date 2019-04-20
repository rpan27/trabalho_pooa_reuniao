/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reuniao.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ronny
 */
@Entity
@Table(name = "Equipamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamento.findAll", query = "SELECT e FROM Equipamento e"),
    @NamedQuery(name = "Equipamento.findByIdEquipamento", query = "SELECT e FROM Equipamento e WHERE e.idEquipamento = :idEquipamento"),
    @NamedQuery(name = "Equipamento.findByDescricao", query = "SELECT e FROM Equipamento e WHERE e.descricao = :descricao")})
public class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipamento")
    private Integer idEquipamento;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @JoinTable(name = "ReservaEquipamento", joinColumns = {
        @JoinColumn(name = "idEquipamento", referencedColumnName = "idEquipamento")}, inverseJoinColumns = {
        @JoinColumn(name = "idReserva", referencedColumnName = "idReserva")})
    @ManyToMany
    private List<Reserva> reservaList;

    public Equipamento() {
    }

    public Equipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public Equipamento(Integer idEquipamento, String descricao) {
        this.idEquipamento = idEquipamento;
        this.descricao = descricao;
    }

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipamento != null ? idEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipamento)) {
            return false;
        }
        Equipamento other = (Equipamento) object;
        if ((this.idEquipamento == null && other.idEquipamento != null) || (this.idEquipamento != null && !this.idEquipamento.equals(other.idEquipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reuniao.model.Equipamento[ idEquipamento=" + idEquipamento + " ]";
    }
    
}
