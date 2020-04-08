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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "t_spdc_objt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSpdcObjt.findAll", query = "SELECT t FROM TSpdcObjt t")
    , @NamedQuery(name = "TSpdcObjt.findByIdObjt", query = "SELECT t FROM TSpdcObjt t WHERE t.idObjt = :idObjt")
    , @NamedQuery(name = "TSpdcObjt.findByNmObjt", query = "SELECT t FROM TSpdcObjt t WHERE t.nmObjt = :nmObjt")
    , @NamedQuery(name = "TSpdcObjt.findByDcObjt", query = "SELECT t FROM TSpdcObjt t WHERE t.dcObjt = :dcObjt")})
public class TSpdcObjt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OBJT")
    private Integer idObjt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NM_OBJT")
    private String nmObjt;
    @Size(max = 1000)
    @Column(name = "DC_OBJT")
    private String dcObjt;
    @JoinTable(name = "t_spdc_objt_vocb_cntld", joinColumns = {
        @JoinColumn(name = "ID_OBJT", referencedColumnName = "ID_OBJT")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_VOCB_CNTLD", referencedColumnName = "ID_VOCB_CNTLD")})
    @ManyToMany
    private Collection<TSpdcVocbCntld> tSpdcVocbCntldCollection;
    @JoinColumn(name = "ID_PRFX", referencedColumnName = "ID_PRFX")
    @ManyToOne(optional = false)
    private TSpdcPrfx idPrfx;
    @JoinColumn(name = "ID_TIPO_OBJT", referencedColumnName = "ID_TIPO_OBJT")
    @ManyToOne(optional = false)
    private TTipoObjt idTipoObjt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idObjt")
    private Collection<TSpdcPrpdObjt> tSpdcPrpdObjtCollection;

    public TSpdcObjt() {
    }

    public TSpdcObjt(Integer idObjt) {
        this.idObjt = idObjt;
    }

    public TSpdcObjt(Integer idObjt, String nmObjt) {
        this.idObjt = idObjt;
        this.nmObjt = nmObjt;
    }

    public Integer getIdObjt() {
        return idObjt;
    }

    public void setIdObjt(Integer idObjt) {
        this.idObjt = idObjt;
    }

    public String getNmObjt() {
        return nmObjt;
    }

    public void setNmObjt(String nmObjt) {
        this.nmObjt = nmObjt;
    }

    public String getDcObjt() {
        return dcObjt;
    }

    public void setDcObjt(String dcObjt) {
        this.dcObjt = dcObjt;
    }

    @XmlTransient
    public Collection<TSpdcVocbCntld> getTSpdcVocbCntldCollection() {
        return tSpdcVocbCntldCollection;
    }

    public void setTSpdcVocbCntldCollection(Collection<TSpdcVocbCntld> tSpdcVocbCntldCollection) {
        this.tSpdcVocbCntldCollection = tSpdcVocbCntldCollection;
    }

    public TSpdcPrfx getIdPrfx() {
        return idPrfx;
    }

    public void setIdPrfx(TSpdcPrfx idPrfx) {
        this.idPrfx = idPrfx;
    }

    public TTipoObjt getIdTipoObjt() {
        return idTipoObjt;
    }

    public void setIdTipoObjt(TTipoObjt idTipoObjt) {
        this.idTipoObjt = idTipoObjt;
    }

    @XmlTransient
    public Collection<TSpdcPrpdObjt> getTSpdcPrpdObjtCollection() {
        return tSpdcPrpdObjtCollection;
    }

    public void setTSpdcPrpdObjtCollection(Collection<TSpdcPrpdObjt> tSpdcPrpdObjtCollection) {
        this.tSpdcPrpdObjtCollection = tSpdcPrpdObjtCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObjt != null ? idObjt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSpdcObjt)) {
            return false;
        }
        TSpdcObjt other = (TSpdcObjt) object;
        if ((this.idObjt == null && other.idObjt != null) || (this.idObjt != null && !this.idObjt.equals(other.idObjt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TSpdcObjt[ idObjt=" + idObjt + " ]";
    }
    
}
