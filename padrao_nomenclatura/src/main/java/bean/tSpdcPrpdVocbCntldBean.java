/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TSpdcPrpdObjtDao;
import dao.TSpdcPrpdVocbCntldDao;
import dao.TSpdcVocbCntldDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import model.TSpdcPrpdObjt;
import model.TSpdcPrpdVocbCntld;
import model.TSpdcVocbCntld;

/**
 *
 * @author terra
 */

@ManagedBean
@ViewScoped
public class tSpdcPrpdVocbCntldBean {
    TSpdcPrpdVocbCntld tSpdcPrpdVocbCntld = new TSpdcPrpdVocbCntld();
    List tSpdcPrpdVocbCntlds = new ArrayList();
    private TSpdcPrpdVocbCntldDao tSpdcPrpdVocbCntldDao;
    private List<TSpdcVocbCntld> tSpdcVocbCntlds;
    private TSpdcVocbCntldDao tSpdcVocbCntldDao;
    private List<TSpdcPrpdObjt> tSpdcPrpdObjts;
    private TSpdcPrpdObjtDao tSpdcPrpdObjtDao;    
    
    public tSpdcPrpdVocbCntldBean() {
        tSpdcPrpdVocbCntlds = new TSpdcPrpdVocbCntldDao().buscarTodas();
        tSpdcPrpdVocbCntld = new TSpdcPrpdVocbCntld();
        tSpdcVocbCntlds = new TSpdcVocbCntldDao().buscarTodas();
        tSpdcVocbCntldDao = new TSpdcVocbCntldDao();
        tSpdcPrpdObjts = new TSpdcPrpdObjtDao().buscarTodas();
        tSpdcPrpdObjtDao = new TSpdcPrpdObjtDao();
        tSpdcPrpdVocbCntldDao = new TSpdcPrpdVocbCntldDao();
    }
    
    public void Record(ActionEvent actionEvent)
    {
        new TSpdcPrpdVocbCntldDao().persistir(tSpdcPrpdVocbCntld);
        tSpdcPrpdVocbCntlds = new TSpdcPrpdVocbCntldDao().buscarTodas();
        tSpdcPrpdVocbCntld = new TSpdcPrpdVocbCntld();
    }
    
    public void Exclude(ActionEvent actionEvent)
    {
        new TSpdcPrpdVocbCntldDao().excluir(tSpdcPrpdVocbCntld);
        tSpdcPrpdVocbCntlds = new TSpdcPrpdVocbCntldDao().buscarTodas();
        tSpdcPrpdVocbCntld = new TSpdcPrpdVocbCntld();
    }

    public TSpdcPrpdVocbCntld getTSpdcPrpdVocbCntld() {
        return tSpdcPrpdVocbCntld;
    }

    public void setTSpdcPrpdVocbCntld(TSpdcPrpdVocbCntld tSpdcPrpdVocbCntld) {
        this.tSpdcPrpdVocbCntld = tSpdcPrpdVocbCntld;
    }

    public List getTSpdcPrpdVocbCntlds() {
        return tSpdcPrpdVocbCntlds;
    }

    public void setTSpdcPrpdVocbCntlds(List tSpdcPrpdVocbCntlds) {
        this.tSpdcPrpdVocbCntlds = tSpdcPrpdVocbCntlds;
    }
    
    public List<TSpdcVocbCntld> getTSpdcVocbCntlds() {
        tSpdcVocbCntlds = tSpdcVocbCntldDao.buscarTodas();
        return tSpdcVocbCntlds;
    }

    public void setTSpdcVocbCntlds(List<TSpdcVocbCntld> tSpdcVocbCntlds) {
        this.tSpdcVocbCntlds = tSpdcVocbCntlds;
    }
    
    public TSpdcVocbCntldDao getTSpdcVocbCntldDao() {
        return tSpdcVocbCntldDao;
    }

    public void setTSpdcVocbCntldDao(TSpdcVocbCntldDao tSpdcVocbCntldDao) {
        this.tSpdcVocbCntldDao = tSpdcVocbCntldDao;
    }

    public List<TSpdcPrpdObjt> getTSpdcPrpdObjts() {
        tSpdcPrpdObjts = tSpdcPrpdObjtDao.buscarTodas();
        return tSpdcPrpdObjts;
    }

    public void setTSpdcPrpdObjts(List<TSpdcPrpdObjt> tSpdcPrpdObjts) {
        this.tSpdcPrpdObjts = tSpdcPrpdObjts;
    }
    
    
    public TSpdcPrpdObjtDao getTSpdcPrpdObjtDao() {
        return tSpdcPrpdObjtDao;
    }

    public void setTSpdcPrpdObjtDao(TSpdcPrpdObjtDao tSpdcPrpdObjtDao) {
        this.tSpdcPrpdObjtDao = tSpdcPrpdObjtDao;
    }

    public TSpdcPrpdVocbCntldDao getTSpdcPrpdVocbCntldDao() {
        return tSpdcPrpdVocbCntldDao;
    }

    public void setTSpdcPrpdVocbCntldDao(TSpdcPrpdVocbCntldDao tSpdcPrpdVocbCntldDao) {
        this.tSpdcPrpdVocbCntldDao = tSpdcPrpdVocbCntldDao;
    }
    
}
