/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
    private TSpdcObjtDao tSpdcObjtDao; 
    private TSpdcPrfxDao tSpdcPrfxDao;
    private TTipoObjtDao tTipoObjtDao;

    public tSpdcObjtBean() {
        tSpdcObjts = new TSpdcObjtDao().buscarTodas();
        tSpdcObjt = new TSpdcObjt();
        tSpdcPrfxs = new TSpdcPrfxDao().buscarTodas();
        tTipoObjts = new TTipoObjtDao().buscarTodas();
        tSpdcPrfxDao = new TSpdcPrfxDao();
        tTipoObjtDao = new TTipoObjtDao();
        tSpdcObjtDao = new TSpdcObjtDao();
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


    public TSpdcObjtDao getTSpdcObjtDao() {
        return tSpdcObjtDao;
    }

    public void setTSpdcObjtDao(TSpdcObjtDao tSpdcObjtDao) {
        this.tSpdcObjtDao = tSpdcObjtDao;
    }

    public TSpdcPrfxDao getTSpdcPrfxDao() {
        return tSpdcPrfxDao;
    }

    public void setTSpdcPrfxDao(TSpdcPrfxDao tSpdcPrfxDao) {
        this.tSpdcPrfxDao = tSpdcPrfxDao;
    }

    public TTipoObjtDao getTTipoObjtDao() {
        return tTipoObjtDao;
    }

    public void setTTipoObjtDao(TTipoObjtDao tTipoObjtDao) {
        this.tTipoObjtDao = tTipoObjtDao;
    }
    
     
}
