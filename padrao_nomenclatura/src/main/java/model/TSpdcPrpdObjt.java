/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "t_spdc_prpd_objt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSpdcPrpdObjt.findAll", query = "SELECT t FROM TSpdcPrpdObjt t")
    , @NamedQuery(name = "TSpdcPrpdObjt.findByIdPrpdObjt", query = "SELECT t FROM TSpdcPrpdObjt t WHERE t.idPrpdObjt = :idPrpdObjt")
    , @NamedQuery(name = "TSpdcPrpdObjt.findByNmPrpdObjt", query = "SELECT t FROM TSpdcPrpdObjt t WHERE t.nmPrpdObjt = :nmPrpdObjt")
    , @NamedQuery(name = "TSpdcPrpdObjt.findByDcPrpdObjt", query = "SELECT t FROM TSpdcPrpdObjt t WHERE t.dcPrpdObjt = :dcPrpdObjt")})
public class TSpdcPrpdObjt implements Serializable, Comparable<TSpdcPrpdObjt> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRPD_OBJT")
    private Integer idPrpdObjt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NM_PRPD_OBJT")
    private String nmPrpdObjt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DC_PRPD_OBJT")
    private String dcPrpdObjt;
    @ManyToMany(mappedBy = "tSpdcPrpdObjtCollection")
    private Collection<TSpdcVocbCntld> tSpdcVocbCntldCollection;
    @JoinColumn(name = "ID_OBJT", referencedColumnName = "ID_OBJT")
    @ManyToOne(optional = false)
    private TSpdcObjt idObjt;
    @JoinColumn(name = "ID_PRFX", referencedColumnName = "ID_PRFX")
    @ManyToOne(optional = false)
    private TSpdcPrfx idPrfx;

    public TSpdcPrpdObjt() {
    }

    public TSpdcPrpdObjt(Integer idPrpdObjt) {
        this.idPrpdObjt = idPrpdObjt;
    }

    public TSpdcPrpdObjt(Integer idPrpdObjt, String nmPrpdObjt, String dcPrpdObjt) {
        this.idPrpdObjt = idPrpdObjt;
        this.nmPrpdObjt = nmPrpdObjt;
        this.dcPrpdObjt = dcPrpdObjt;
    }

    public Integer getIdPrpdObjt() {
        return idPrpdObjt;
    }

    public void setIdPrpdObjt(Integer idPrpdObjt) {
        this.idPrpdObjt = idPrpdObjt;
    }

    public String getNmPrpdObjt() {
        return nmPrpdObjt;
    }

    public void setNmPrpdObjt(String nmPrpdObjt) {
        this.nmPrpdObjt = nmPrpdObjt;
    }

    public String getDcPrpdObjt() {
        return dcPrpdObjt;
    }

    public void setDcPrpdObjt(String dcPrpdObjt) {
        this.dcPrpdObjt = dcPrpdObjt;
    }

    @XmlTransient
    public Collection<TSpdcVocbCntld> getTSpdcVocbCntldCollection() {
        return tSpdcVocbCntldCollection;
    }

    public void setTSpdcVocbCntldCollection(Collection<TSpdcVocbCntld> tSpdcVocbCntldCollection) {
        this.tSpdcVocbCntldCollection = tSpdcVocbCntldCollection;
    }

    public TSpdcObjt getIdObjt() {
        return idObjt;
    }

    public void setIdObjt(TSpdcObjt idObjt) {
        this.idObjt = idObjt;
    }

    public TSpdcPrfx getIdPrfx() {
        return idPrfx;
    }

    public void setIdPrfx(TSpdcPrfx idPrfx) {
        this.idPrfx = idPrfx;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrpdObjt != null ? idPrpdObjt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSpdcPrpdObjt)) {
            return false;
        }
        TSpdcPrpdObjt other = (TSpdcPrpdObjt) object;
        if ((this.idPrpdObjt == null && other.idPrpdObjt != null) || (this.idPrpdObjt != null && !this.idPrpdObjt.equals(other.idPrpdObjt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TSpdcPrpdObjt[ idPrpdObjt=" + idPrpdObjt + " ]";
    }
    
    @Override
    public int compareTo(TSpdcPrpdObjt tSpdcPrpdObjt) {
        return this.nmPrpdObjt.toLowerCase().compareTo(tSpdcPrpdObjt.getNmPrpdObjt().toLowerCase());
    }
}
