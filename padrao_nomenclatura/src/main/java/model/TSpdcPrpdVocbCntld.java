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
@Table(name = "t_spdc_prpd_vocb_cntld")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSpdcPrpdVocbCntld.findAll", query = "SELECT t FROM TSpdcPrpdVocbCntld t")
    , @NamedQuery(name = "TSpdcPrpdVocbCntld.findByIdPrpdobjtVocb", query = "SELECT t FROM TSpdcPrpdVocbCntld t WHERE t.idPrpdobjtVocb = :idPrpdobjtVocb")})
public class TSpdcPrpdVocbCntld implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRPDOBJT_VOCB")
    private Integer idPrpdobjtVocb;
    @JoinColumn(name = "ID_VOCB_CNTLD", referencedColumnName = "ID_VOCB_CNTLD")
    @ManyToOne
    private TSpdcVocbCntld idVocbCntld;
    @JoinColumn(name = "ID_PRPD_OBJT", referencedColumnName = "ID_PRPD_OBJT")
    @ManyToOne
    private TSpdcPrpdObjt idPrpdObjt;

    public TSpdcPrpdVocbCntld() {
    }

    public TSpdcPrpdVocbCntld(Integer idPrpdobjtVocb) {
        this.idPrpdobjtVocb = idPrpdobjtVocb;
    }

    public Integer getIdPrpdobjtVocb() {
        return idPrpdobjtVocb;
    }

    public void setIdPrpdobjtVocb(Integer idPrpdobjtVocb) {
        this.idPrpdobjtVocb = idPrpdobjtVocb;
    }

    public TSpdcVocbCntld getIdVocbCntld() {
        return idVocbCntld;
    }

    public void setIdVocbCntld(TSpdcVocbCntld idVocbCntld) {
        this.idVocbCntld = idVocbCntld;
    }

    public TSpdcPrpdObjt getIdPrpdObjt() {
        return idPrpdObjt;
    }

    public void setIdPrpdObjt(TSpdcPrpdObjt idPrpdObjt) {
        this.idPrpdObjt = idPrpdObjt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrpdobjtVocb != null ? idPrpdobjtVocb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSpdcPrpdVocbCntld)) {
            return false;
        }
        TSpdcPrpdVocbCntld other = (TSpdcPrpdVocbCntld) object;
        if ((this.idPrpdobjtVocb == null && other.idPrpdobjtVocb != null) || (this.idPrpdobjtVocb != null && !this.idPrpdobjtVocb.equals(other.idPrpdobjtVocb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TSpdcPrpdVocbCntld[ idPrpdobjtVocb=" + idPrpdobjtVocb + " ]";
    }
    
}
