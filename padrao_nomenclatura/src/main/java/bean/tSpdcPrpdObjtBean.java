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
import converter.PrefixoConverter;
import model.TSpdcObjt;
import dao.TSpdcObjtDao;
import converter.ObjetoConverter;

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
    private TSpdcPrfx idPrfx;
    private TSpdcPrfxDao tSpdcPrfxDao;
    private PrefixoConverter prfxConv;
    private List<TSpdcObjt> tSpdcObjts;
    private TSpdcObjt idObjt;
    private TSpdcObjtDao tSpdcObjtDao;
    private ObjetoConverter objtConv;

    public tSpdcPrpdObjtBean() {
        tSpdcPrpdObjts = new TSpdcPrpdObjtDao().buscarTodas();
        tSpdcPrpdObjt = new TSpdcPrpdObjt();
        tSpdcPrfxs = new TSpdcPrfxDao().buscarTodas();
        tSpdcPrfxDao = new TSpdcPrfxDao();
        prfxConv = new PrefixoConverter();
        tSpdcObjts = new TSpdcObjtDao().buscarTodas();
        tSpdcObjtDao = new TSpdcObjtDao();
        objtConv = new ObjetoConverter();
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
        return tSpdcPrfxs;
    }

    public void setTSpdcPrfxs(List<TSpdcPrfx> tSpdcPrfxs) {
        this.tSpdcPrfxs = tSpdcPrfxs;
    }
    
    public TSpdcPrfx getIdPrfx() {
        return idPrfx;
    }

    public void setIdPrfx(TSpdcPrfx idPrfx) {
        this.idPrfx = idPrfx;
    }
    
    public TSpdcPrfxDao gettSpdcPrfxDao() {
        return tSpdcPrfxDao;
    }

    public void settSpdcPrfxDao(TSpdcPrfxDao tSpdcPrfxDao) {
        this.tSpdcPrfxDao = tSpdcPrfxDao;
    }
    
    public PrefixoConverter getPrfxConv() {
        return prfxConv;
    }

    public void setPrfxConv(PrefixoConverter prfxConv) {
        this.prfxConv = prfxConv;
    }
    
    public List<TSpdcObjt> getTSpdcObjts() {
        return tSpdcObjts;
    }

    public void setTSpdcObjts(List<TSpdcObjt> tSpdcObjts) {
        this.tSpdcObjts = tSpdcObjts;
    }
    
    public TSpdcObjt getIdObjt() {
        return idObjt;
    }

    public void setIdPrfx(TSpdcObjt idObjt) {
        this.idObjt = idObjt;
    }
    
    public TSpdcObjtDao gettSpdcObjtDao() {
        return tSpdcObjtDao;
    }

    public void settSpdcObjtDao(TSpdcObjtDao tSpdcObjtDao) {
        this.tSpdcObjtDao = tSpdcObjtDao;
    }
    
    public ObjetoConverter getObjtConv() {
        return objtConv;
    }

    public void setObjtConv(ObjetoConverter objtConv) {
        this.objtConv = objtConv;
    }
}
