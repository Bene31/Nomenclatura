/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TSpdcPrpdObjtDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import model.TSpdcPrpdObjt;
import model.TSpdcPrfx;
import dao.TSpdcPrfxDao;
import model.TSpdcObjt;
import dao.TSpdcObjtDao;

/**
 *
 * @author terra
 */
@ManagedBean
@ViewScoped
public class tSpdcPrpdObjtBean {
    TSpdcPrpdObjt tSpdcPrpdObjt = new TSpdcPrpdObjt();
    List tSpdcPrpdObjts = new ArrayList();
    private List<TSpdcPrfx> tSpdcPrfxs;
    private TSpdcPrfxDao tSpdcPrfxDao;
    private List<TSpdcObjt> tSpdcObjts;
    private TSpdcObjtDao tSpdcObjtDao;
    private TSpdcPrpdObjtDao tSpdcPrpdObjtDao;

    public tSpdcPrpdObjtBean() {
        tSpdcPrpdObjts = new TSpdcPrpdObjtDao().buscarTodas();
        tSpdcPrpdObjt = new TSpdcPrpdObjt();
        tSpdcPrfxs = new TSpdcPrfxDao().buscarTodas();
        tSpdcPrfxDao = new TSpdcPrfxDao();
        tSpdcObjts = new TSpdcObjtDao().buscarTodas();
        tSpdcObjtDao = new TSpdcObjtDao();
        tSpdcPrpdObjtDao = new TSpdcPrpdObjtDao();
    }
    
    public void Record(ActionEvent actionEvent)
    {
        new TSpdcPrpdObjtDao().persistir(tSpdcPrpdObjt);
        tSpdcPrpdObjts = new TSpdcPrpdObjtDao().buscarTodas();
        tSpdcPrpdObjt = new TSpdcPrpdObjt();
    }
    
    public void Exclude(ActionEvent actionEvent)
    {
        new TSpdcPrpdObjtDao().excluir(tSpdcPrpdObjt);
        tSpdcPrpdObjts = new TSpdcPrpdObjtDao().buscarTodas();
        tSpdcPrpdObjt = new TSpdcPrpdObjt();
    }
    
    public TSpdcPrpdObjt getTSpdcPrpdObjt()
    {
        return tSpdcPrpdObjt;
    }
    
    public void setTSpdcPrpdObjt(TSpdcPrpdObjt tSpdcPrpdObjt)
    {
        this.tSpdcPrpdObjt = tSpdcPrpdObjt;
    }
    
    public List getTSpdcPrpdObjts()
    {
        return tSpdcPrpdObjts;
    }
    
    public void setTSpdcPrpdObjts(List tSpdcPrpdObjts) {
        this.tSpdcPrpdObjts = tSpdcPrpdObjts;
    }
    
    public List<TSpdcPrfx> getTSpdcPrfxs() {
        tSpdcPrfxs = tSpdcPrfxDao.buscarTodas();
        return tSpdcPrfxs;
    }

    public void setTSpdcPrfxs(List<TSpdcPrfx> tSpdcPrfxs) {
        this.tSpdcPrfxs = tSpdcPrfxs;
    }
    
    public TSpdcPrfxDao getTSpdcPrfxDao() {
        return tSpdcPrfxDao;
    }

    public void setTSpdcPrfxDao(TSpdcPrfxDao tSpdcPrfxDao) {
        this.tSpdcPrfxDao = tSpdcPrfxDao;
    }
    
    
    public List<TSpdcObjt> getTSpdcObjts() {
        tSpdcObjts = tSpdcObjtDao.buscarTodas();
        return tSpdcObjts;
    }

    public void setTSpdcObjts(List<TSpdcObjt> tSpdcObjts) {
        this.tSpdcObjts = tSpdcObjts;
    }
    
    
    public TSpdcObjtDao getTSpdcObjtDao() {
        return tSpdcObjtDao;
    }

    public void setTSpdcObjtDao(TSpdcObjtDao tSpdcObjtDao) {
        this.tSpdcObjtDao = tSpdcObjtDao;
    }
    
    public TSpdcObjtDao getTSpdcPrpdObjtDao() {
        return tSpdcObjtDao;
    }

    public void setTSpdcPrpdObjtDao(TSpdcPrpdObjtDao tSpdcPrpdObjtDao) {
        this.tSpdcPrpdObjtDao = tSpdcPrpdObjtDao;
    }
    
}
