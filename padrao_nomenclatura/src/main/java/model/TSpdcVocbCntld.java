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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "t_spdc_vocb_cntld")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSpdcVocbCntld.findAll", query = "SELECT t FROM TSpdcVocbCntld t")
    , @NamedQuery(name = "TSpdcVocbCntld.findByIdVocbCntld", query = "SELECT t FROM TSpdcVocbCntld t WHERE t.idVocbCntld = :idVocbCntld")
    , @NamedQuery(name = "TSpdcVocbCntld.findBySgVocbCntld", query = "SELECT t FROM TSpdcVocbCntld t WHERE t.sgVocbCntld = :sgVocbCntld")
    , @NamedQuery(name = "TSpdcVocbCntld.findByDsVocbCntld", query = "SELECT t FROM TSpdcVocbCntld t WHERE t.dsVocbCntld = :dsVocbCntld")
    , @NamedQuery(name = "TSpdcVocbCntld.findByFlTipoVocbCntld", query = "SELECT t FROM TSpdcVocbCntld t WHERE t.flTipoVocbCntld = :flTipoVocbCntld")})
public class TSpdcVocbCntld implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VOCB_CNTLD")
    private Integer idVocbCntld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SG_VOCB_CNTLD")
    private String sgVocbCntld;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DS_VOCB_CNTLD")
    private String dsVocbCntld;
    @Size(max = 1)
    @Column(name = "FL_TIPO_VOCB_CNTLD")
    private String flTipoVocbCntld;
    @OneToMany(mappedBy = "idVocbCntld")
    private Collection<TSpdcObjtVocbCntld> tSpdcObjtVocbCntldCollection;
    @OneToMany(mappedBy = "idVocbCntld")
    private Collection<TSpdcPrpdVocbCntld> tSpdcPrpdVocbCntldCollection;

    public TSpdcVocbCntld() {
    }

    public TSpdcVocbCntld(Integer idVocbCntld) {
        this.idVocbCntld = idVocbCntld;
    }

    public TSpdcVocbCntld(Integer idVocbCntld, String sgVocbCntld, String dsVocbCntld) {
        this.idVocbCntld = idVocbCntld;
        this.sgVocbCntld = sgVocbCntld;
        this.dsVocbCntld = dsVocbCntld;
    }

    public Integer getIdVocbCntld() {
        return idVocbCntld;
    }

    public void setIdVocbCntld(Integer idVocbCntld) {
        this.idVocbCntld = idVocbCntld;
    }

    public String getSgVocbCntld() {
        return sgVocbCntld;
    }

    public void setSgVocbCntld(String sgVocbCntld) {
        this.sgVocbCntld = sgVocbCntld;
    }

    public String getDsVocbCntld() {
        return dsVocbCntld;
    }

    public void setDsVocbCntld(String dsVocbCntld) {
        this.dsVocbCntld = dsVocbCntld;
    }

    public String getFlTipoVocbCntld() {
        return flTipoVocbCntld;
    }

    public void setFlTipoVocbCntld(String flTipoVocbCntld) {
        this.flTipoVocbCntld = flTipoVocbCntld;
    }

    @XmlTransient
    public Collection<TSpdcObjtVocbCntld> getTSpdcObjtVocbCntldCollection() {
        return tSpdcObjtVocbCntldCollection;
    }

    public void setTSpdcObjtVocbCntldCollection(Collection<TSpdcObjtVocbCntld> tSpdcObjtVocbCntldCollection) {
        this.tSpdcObjtVocbCntldCollection = tSpdcObjtVocbCntldCollection;
    }

    @XmlTransient
    public Collection<TSpdcPrpdVocbCntld> getTSpdcPrpdVocbCntldCollection() {
        return tSpdcPrpdVocbCntldCollection;
    }

    public void setTSpdcPrpdVocbCntldCollection(Collection<TSpdcPrpdVocbCntld> tSpdcPrpdVocbCntldCollection) {
        this.tSpdcPrpdVocbCntldCollection = tSpdcPrpdVocbCntldCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVocbCntld != null ? idVocbCntld.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSpdcVocbCntld)) {
            return false;
        }
        TSpdcVocbCntld other = (TSpdcVocbCntld) object;
        if ((this.idVocbCntld == null && other.idVocbCntld != null) || (this.idVocbCntld != null && !this.idVocbCntld.equals(other.idVocbCntld))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TSpdcVocbCntld[ idVocbCntld=" + idVocbCntld + " ]";
    }
    
}
