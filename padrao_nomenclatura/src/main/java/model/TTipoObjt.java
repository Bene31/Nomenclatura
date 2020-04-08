/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author terra
 */
@Entity
@Table(name = "t_tipo_objt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTipoObjt.findAll", query = "SELECT to FROM TTipoObjt to")
    , @NamedQuery(name = "TTipoObjt.findByIdTipoObjt", query = "SELECT to FROM TTipoObjt to WHERE to.idTipoObjt = :idTipoObjt")
    , @NamedQuery(name = "TTipoObjt.findByDsTipoObjt", query = "SELECT to FROM TTipoObjt to WHERE to.dsTipoObjt = :dsTipoObjt")})
public class TTipoObjt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_OBJT")
    private Integer idTipoObjt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DS_TIPO_OBJT")
    private String dsTipoObjt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoObjt")
    private Collection<TSpdcObjt> tSpdcObjtCollection;

    public TTipoObjt() {
    }

    public TTipoObjt(Integer idTipoObjt) {
        this.idTipoObjt = idTipoObjt;
    }

    public TTipoObjt(Integer idTipoObjt, String dsTipoObjt) {
        this.idTipoObjt = idTipoObjt;
        this.dsTipoObjt = dsTipoObjt;
    }

    public Integer getIdTipoObjt() {
        return idTipoObjt;
    }

    public void setIdTipoObjt(Integer idTipoObjt) {
        this.idTipoObjt = idTipoObjt;
    }

    public String getDsTipoObjt() {
        return dsTipoObjt;
    }

    public void setDsTipoObjt(String dsTipoObjt) {
        this.dsTipoObjt = dsTipoObjt;
    }

    @XmlTransient
    public Collection<TSpdcObjt> getTSpdcObjtCollection() {
        return tSpdcObjtCollection;
    }

    public void setTSpdcObjtCollection(Collection<TSpdcObjt> tSpdcObjtCollection) {
        this.tSpdcObjtCollection = tSpdcObjtCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoObjt != null ? idTipoObjt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTipoObjt)) {
            return false;
        }
        TTipoObjt other = (TTipoObjt) object;
        if ((this.idTipoObjt == null && other.idTipoObjt != null) || (this.idTipoObjt != null && !this.idTipoObjt.equals(other.idTipoObjt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TTipoObjt[ idTipoObjt=" + idTipoObjt + " ]";
    }
    
}
