/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import converter.PrefixoConverter;
import converter.TpObjtConverter;
import model.TSpdcObjt;
import dao.TSpdcObjtDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import model.TSpdcPrfx;
import dao.TSpdcPrfxDao;
import model.TTipoObjt;
import dao.TTipoObjtDao;

/**
 *
 * @author terra
 */
@ManagedBean
@ViewScoped
public class tSpdcObjtBean{
    
    TSpdcObjt tSpdcObjt = new TSpdcObjt();
    List tSpdcObjts = new ArrayList();
    private List<TSpdcPrfx> tSpdcPrfxs;
    private List<TTipoObjt> tTipoObjts;
    private TSpdcPrfx idPrfx;
    private TTipoObjt idTipoObjt;
    private TSpdcObjtDao tSpdcObjtDao; 
    private TSpdcPrfxDao tSpdcPrfxDao;
    private TTipoObjtDao tTipoObjtDao;
    private PrefixoConverter prfxConv;
    private TpObjtConverter tpObjtConv;

    public tSpdcObjtBean() {
        tSpdcObjts = new TSpdcObjtDao().buscarTodas();
        tSpdcObjt = new TSpdcObjt();
        tSpdcPrfxs = new TSpdcPrfxDao().buscarTodas();
        tTipoObjts = new TTipoObjtDao().buscarTodas();
        tSpdcPrfxDao = new TSpdcPrfxDao();
        tTipoObjtDao = new TTipoObjtDao();
        tSpdcObjtDao = new TSpdcObjtDao();
        prfxConv = new PrefixoConverter();
        tpObjtConv = new TpObjtConverter();
    } 
    
    public void Record(ActionEvent actionEvent)
    {
        new TSpdcObjtDao().persistir(tSpdcObjt);
        tSpdcObjts = new TSpdcObjtDao().buscarTodas();
        tSpdcObjt = new TSpdcObjt();
    }
    
    public void Exclude(ActionEvent actionEvent)
    {
        new TSpdcObjtDao().excluir(tSpdcObjt);
        tSpdcObjts = new TSpdcObjtDao().buscarTodas();
        tSpdcObjt = new TSpdcObjt();
    }
    
    public TSpdcObjt getTSpdcObjt()
    {
        return tSpdcObjt;
    }
    
    public void setTSpdcObjt(TSpdcObjt tSpdcObjt)
    {
        this.tSpdcObjt = tSpdcObjt;
    }
    
    public List getTSpdcObjts()
    {
        return tSpdcObjts;
    }
    
    public void setTSpdcObjts(List tSpdcObjts) {
        this.tSpdcObjts = tSpdcObjts;
    }
    
    public TSpdcObjt gettSpdcObjt() {
        return tSpdcObjt;
    }

    public void settSpdcObjt(TSpdcObjt tSpdcObjt) {
        this.tSpdcObjt = tSpdcObjt;
    }


    public List<TSpdcPrfx> getTSpdcPrfxs() {
        tSpdcPrfxs = tSpdcPrfxDao.buscarTodas();
        return tSpdcPrfxs;
    }

    public void setTSpdcPrfxs(List<TSpdcPrfx> tSpdcPrfxs) {
        this.tSpdcPrfxs = tSpdcPrfxs;
    }
    
    public List<TTipoObjt> getTTipoObjts() {
        tTipoObjts = tTipoObjtDao.buscarTodas();
        return tTipoObjts;
    }

    public void setTTipoObjts(List<TTipoObjt> tTipoObjts) {
        this.tTipoObjts = tTipoObjts;
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

    public TSpdcObjtDao gettSpdcObjtDao() {
        return tSpdcObjtDao;
    }

    public void settSpdcObjtDao(TSpdcObjtDao tSpdcObjtDao) {
        this.tSpdcObjtDao = tSpdcObjtDao;
    }

    public TSpdcPrfxDao gettSpdcPrfxDao() {
        return tSpdcPrfxDao;
    }

    public void settSpdcPrfxDao(TSpdcPrfxDao tSpdcPrfxDao) {
        this.tSpdcPrfxDao = tSpdcPrfxDao;
    }

    public TTipoObjtDao gettTipoObjtDao() {
        return tTipoObjtDao;
    }

    public void settTipoObjtDao(TTipoObjtDao tTipoObjtDao) {
        this.tTipoObjtDao = tTipoObjtDao;
    }
    
    public PrefixoConverter getPrfxConv() {
        return prfxConv;
    }

    public void setPrfxConv(PrefixoConverter prfxConv) {
        this.prfxConv = prfxConv;
    }

    public TpObjtConverter getTpObjtConv() {
        return tpObjtConv;
    }

    public void setTpObjtConv(TpObjtConverter tpObjtConv) {
        this.tpObjtConv = tpObjtConv;
    }
     
}
