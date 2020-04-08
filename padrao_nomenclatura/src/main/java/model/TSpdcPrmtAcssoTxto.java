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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author terra
 */
@Entity
@Table(name = "t_spdc_prmt_acsso_txto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSpdcPrmtAcssoTxto.findAll", query = "SELECT t FROM TSpdcPrmtAcssoTxto t")
    , @NamedQuery(name = "TSpdcPrmtAcssoTxto.findByIdPrmtAcssoTxto", query = "SELECT t FROM TSpdcPrmtAcssoTxto t WHERE t.idPrmtAcssoTxto = :idPrmtAcssoTxto")
    , @NamedQuery(name = "TSpdcPrmtAcssoTxto.findByDsPrmtAcssoTxto", query = "SELECT t FROM TSpdcPrmtAcssoTxto t WHERE t.dsPrmtAcssoTxto = :dsPrmtAcssoTxto")
    , @NamedQuery(name = "TSpdcPrmtAcssoTxto.findByNuInicAcssoTxto", query = "SELECT t FROM TSpdcPrmtAcssoTxto t WHERE t.nuInicAcssoTxto = :nuInicAcssoTxto")
    , @NamedQuery(name = "TSpdcPrmtAcssoTxto.findByNuFimAcssoTxto", query = "SELECT t FROM TSpdcPrmtAcssoTxto t WHERE t.nuFimAcssoTxto = :nuFimAcssoTxto")
    , @NamedQuery(name = "TSpdcPrmtAcssoTxto.findByFlInicAcssoTxto", query = "SELECT t FROM TSpdcPrmtAcssoTxto t WHERE t.flInicAcssoTxto = :flInicAcssoTxto")
    , @NamedQuery(name = "TSpdcPrmtAcssoTxto.findByFlFimAcssoTxto", query = "SELECT t FROM TSpdcPrmtAcssoTxto t WHERE t.flFimAcssoTxto = :flFimAcssoTxto")
    , @NamedQuery(name = "TSpdcPrmtAcssoTxto.findByIcTipoAcssoTxto", query = "SELECT t FROM TSpdcPrmtAcssoTxto t WHERE t.icTipoAcssoTxto = :icTipoAcssoTxto")})
public class TSpdcPrmtAcssoTxto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRMT_ACSSO_TXTO")
    private Integer idPrmtAcssoTxto;
    @Size(max = 100)
    @Column(name = "DS_PRMT_ACSSO_TXTO")
    private String dsPrmtAcssoTxto;
    @Size(max = 10)
    @Column(name = "NU_INIC_ACSSO_TXTO")
    private String nuInicAcssoTxto;
    @Size(max = 10)
    @Column(name = "NU_FIM_ACSSO_TXTO")
    private String nuFimAcssoTxto;
    @Size(max = 5)
    @Column(name = "FL_INIC_ACSSO_TXTO")
    private String flInicAcssoTxto;
    @Size(max = 5)
    @Column(name = "FL_FIM_ACSSO_TXTO")
    private String flFimAcssoTxto;
    @Size(max = 100)
    @Column(name = "IC_TIPO_ACSSO_TXTO")
    private String icTipoAcssoTxto;

    public TSpdcPrmtAcssoTxto() {
    }

    public TSpdcPrmtAcssoTxto(Integer idPrmtAcssoTxto) {
        this.idPrmtAcssoTxto = idPrmtAcssoTxto;
    }

    public Integer getIdPrmtAcssoTxto() {
        return idPrmtAcssoTxto;
    }

    public void setIdPrmtAcssoTxto(Integer idPrmtAcssoTxto) {
        this.idPrmtAcssoTxto = idPrmtAcssoTxto;
    }

    public String getDsPrmtAcssoTxto() {
        return dsPrmtAcssoTxto;
    }

    public void setDsPrmtAcssoTxto(String dsPrmtAcssoTxto) {
        this.dsPrmtAcssoTxto = dsPrmtAcssoTxto;
    }

    public String getNuInicAcssoTxto() {
        return nuInicAcssoTxto;
    }

    public void setNuInicAcssoTxto(String nuInicAcssoTxto) {
        this.nuInicAcssoTxto = nuInicAcssoTxto;
    }

    public String getNuFimAcssoTxto() {
        return nuFimAcssoTxto;
    }

    public void setNuFimAcssoTxto(String nuFimAcssoTxto) {
        this.nuFimAcssoTxto = nuFimAcssoTxto;
    }

    public String getFlInicAcssoTxto() {
        return flInicAcssoTxto;
    }

    public void setFlInicAcssoTxto(String flInicAcssoTxto) {
        this.flInicAcssoTxto = flInicAcssoTxto;
    }

    public String getFlFimAcssoTxto() {
        return flFimAcssoTxto;
    }

    public void setFlFimAcssoTxto(String flFimAcssoTxto) {
        this.flFimAcssoTxto = flFimAcssoTxto;
    }

    public String getIcTipoAcssoTxto() {
        return icTipoAcssoTxto;
    }

    public void setIcTipoAcssoTxto(String icTipoAcssoTxto) {
        this.icTipoAcssoTxto = icTipoAcssoTxto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrmtAcssoTxto != null ? idPrmtAcssoTxto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSpdcPrmtAcssoTxto)) {
            return false;
        }
        TSpdcPrmtAcssoTxto other = (TSpdcPrmtAcssoTxto) object;
        if ((this.idPrmtAcssoTxto == null && other.idPrmtAcssoTxto != null) || (this.idPrmtAcssoTxto != null && !this.idPrmtAcssoTxto.equals(other.idPrmtAcssoTxto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TSpdcPrmtAcssoTxto[ idPrmtAcssoTxto=" + idPrmtAcssoTxto + " ]";
    }
    
}
