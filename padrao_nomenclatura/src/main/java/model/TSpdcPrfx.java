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
@Table(name = "t_spdc_prfx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSpdcPrfx.findAll", query = "SELECT t FROM TSpdcPrfx t")
    , @NamedQuery(name = "TSpdcPrfx.findByIdPrfx", query = "SELECT t FROM TSpdcPrfx t WHERE t.idPrfx = :idPrfx")
    , @NamedQuery(name = "TSpdcPrfx.findBySgPrfx", query = "SELECT t FROM TSpdcPrfx t WHERE t.sgPrfx = :sgPrfx")
    , @NamedQuery(name = "TSpdcPrfx.findByDsTipoDadoPrfx", query = "SELECT t FROM TSpdcPrfx t WHERE t.dsTipoDadoPrfx = :dsTipoDadoPrfx")
    , @NamedQuery(name = "TSpdcPrfx.findByDsCntdPrfx", query = "SELECT t FROM TSpdcPrfx t WHERE t.dsCntdPrfx = :dsCntdPrfx")
    , @NamedQuery(name = "TSpdcPrfx.findByDsExploPrfx", query = "SELECT t FROM TSpdcPrfx t WHERE t.dsExploPrfx = :dsExploPrfx")
    , @NamedQuery(name = "TSpdcPrfx.findByDsDfncPrfx", query = "SELECT t FROM TSpdcPrfx t WHERE t.dsDfncPrfx = :dsDfncPrfx")})
public class TSpdcPrfx implements Serializable, Comparable<TSpdcPrfx> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRFX")
    private Integer idPrfx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SG_PRFX")
    private String sgPrfx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "DS_TIPO_DADO_PRFX")
    private String dsTipoDadoPrfx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "DS_CNTD_PRFX")
    private String dsCntdPrfx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "DS_EXPLO_PRFX")
    private String dsExploPrfx;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "DS_DFNC_PRFX")
    private String dsDfncPrfx;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrfx")
    private Collection<TSpdcObjt> tSpdcObjtCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrfx")
    private Collection<TSpdcPrpdObjt> tSpdcPrpdObjtCollection;

    public TSpdcPrfx() {
    }

    public TSpdcPrfx(Integer idPrfx) {
        this.idPrfx = idPrfx;
    }

    public TSpdcPrfx(Integer idPrfx, String sgPrfx, String dsTipoDadoPrfx, String dsCntdPrfx, String dsExploPrfx, String dsDfncPrfx) {
        this.idPrfx = idPrfx;
        this.sgPrfx = sgPrfx;
        this.dsTipoDadoPrfx = dsTipoDadoPrfx;
        this.dsCntdPrfx = dsCntdPrfx;
        this.dsExploPrfx = dsExploPrfx;
        this.dsDfncPrfx = dsDfncPrfx;
    }

    public Integer getIdPrfx() {
        return idPrfx;
    }

    public void setIdPrfx(Integer idPrfx) {
        this.idPrfx = idPrfx;
    }

    public String getSgPrfx() {
        return sgPrfx;
    }

    public void setSgPrfx(String sgPrfx) {
        this.sgPrfx = sgPrfx;
    }

    public String getDsTipoDadoPrfx() {
        return dsTipoDadoPrfx;
    }

    public void setDsTipoDadoPrfx(String dsTipoDadoPrfx) {
        this.dsTipoDadoPrfx = dsTipoDadoPrfx;
    }

    public String getDsCntdPrfx() {
        return dsCntdPrfx;
    }

    public void setDsCntdPrfx(String dsCntdPrfx) {
        this.dsCntdPrfx = dsCntdPrfx;
    }

    public String getDsExploPrfx() {
        return dsExploPrfx;
    }

    public void setDsExploPrfx(String dsExploPrfx) {
        this.dsExploPrfx = dsExploPrfx;
    }

    public String getDsDfncPrfx() {
        return dsDfncPrfx;
    }

    public void setDsDfncPrfx(String dsDfncPrfx) {
        this.dsDfncPrfx = dsDfncPrfx;
    }

    @XmlTransient
    public Collection<TSpdcObjt> getTSpdcObjtCollection() {
        return tSpdcObjtCollection;
    }

    public void setTSpdcObjtCollection(Collection<TSpdcObjt> tSpdcObjtCollection) {
        this.tSpdcObjtCollection = tSpdcObjtCollection;
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
        hash += (idPrfx != null ? idPrfx.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSpdcPrfx)) {
            return false;
        }
        TSpdcPrfx other = (TSpdcPrfx) object;
        if ((this.idPrfx == null && other.idPrfx != null) || (this.idPrfx != null && !this.idPrfx.equals(other.idPrfx))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TSpdcPrfx[ idPrfx=" + idPrfx + " ]";
    }
    
    @Override
    public int compareTo(TSpdcPrfx tSpdcPrfx) {
        return this.sgPrfx.toLowerCase().compareTo(tSpdcPrfx.getSgPrfx().toLowerCase());
    }
    
}
