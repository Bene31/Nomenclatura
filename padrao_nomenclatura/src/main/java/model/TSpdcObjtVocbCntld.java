/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author terra
 */
@Entity
@Table(name = "t_spdc_objt_vocb_cntld")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSpdcObjtVocbCntld.findAll", query = "SELECT t FROM TSpdcObjtVocbCntld t")
    , @NamedQuery(name = "TSpdcObjtVocbCntld.findByIdObjtVocb", query = "SELECT t FROM TSpdcObjtVocbCntld t WHERE t.idObjtVocb = :idObjtVocb")})
public class TSpdcObjtVocbCntld implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_OBJT_VOCB")
    private Integer idObjtVocb;
    @JoinColumn(name = "ID_OBJT", referencedColumnName = "ID_OBJT")
    @ManyToOne
    private TSpdcObjt idObjt;
    @JoinColumn(name = "ID_VOCB_CNTLD", referencedColumnName = "ID_VOCB_CNTLD")
    @ManyToOne
    private TSpdcVocbCntld idVocbCntld;

    public TSpdcObjtVocbCntld() {
    }

    public TSpdcObjtVocbCntld(Integer idObjtVocb) {
        this.idObjtVocb = idObjtVocb;
    }

    public Integer getIdObjtVocb() {
        return idObjtVocb;
    }

    public void setIdObjtVocb(Integer idObjtVocb) {
        this.idObjtVocb = idObjtVocb;
    }

    public TSpdcObjt getIdObjt() {
        return idObjt;
    }

    public void setIdObjt(TSpdcObjt idObjt) {
        this.idObjt = idObjt;
    }

    public TSpdcVocbCntld getIdVocbCntld() {
        return idVocbCntld;
    }

    public void setIdVocbCntld(TSpdcVocbCntld idVocbCntld) {
        this.idVocbCntld = idVocbCntld;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObjtVocb != null ? idObjtVocb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSpdcObjtVocbCntld)) {
            return false;
        }
        TSpdcObjtVocbCntld other = (TSpdcObjtVocbCntld) object;
        if ((this.idObjtVocb == null && other.idObjtVocb != null) || (this.idObjtVocb != null && !this.idObjtVocb.equals(other.idObjtVocb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TSpdcObjtVocbCntld[ idObjtVocb=" + idObjtVocb + " ]";
    }
    
}
