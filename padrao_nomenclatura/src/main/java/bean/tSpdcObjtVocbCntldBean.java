/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import model.TSpdcObjtVocbCntld;
import dao.TSpdcObjtVocbCntldDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import model.TSpdcObjt;
import dao.TSpdcObjtDao;
import model.TSpdcVocbCntld;
import dao.TSpdcVocbCntldDao;

/**
 *
 * @author terra
 */
@ManagedBean
@ViewScoped
public class tSpdcObjtVocbCntldBean{
    
    TSpdcObjtVocbCntld tSpdcObjtVocbCntld = new TSpdcObjtVocbCntld();
    List tSpdcObjtVocbCntlds = new ArrayList();
    private List<TSpdcObjt> tSpdcObjts;
    private List<TSpdcVocbCntld> tSpdcVocbCntlds;
    private TSpdcObjtVocbCntldDao tSpdcObjtVocbCntldDao; //pk 
    private TSpdcObjtDao tSpdcObjtDao;//fk
    private TSpdcVocbCntldDao tSpdcVocbCntldDao;//fk

    public tSpdcObjtVocbCntldBean() {
        tSpdcObjtVocbCntlds = new TSpdcObjtVocbCntldDao().buscarTodas();
        tSpdcObjtVocbCntld = new TSpdcObjtVocbCntld();
        tSpdcObjts = new TSpdcObjtDao().buscarTodas();
        tSpdcVocbCntlds = new TSpdcVocbCntldDao().buscarTodas();
        tSpdcObjtDao = new TSpdcObjtDao();
        tSpdcVocbCntldDao = new TSpdcVocbCntldDao();
        tSpdcObjtVocbCntldDao = new TSpdcObjtVocbCntldDao();
    } 
    
    public void Record(ActionEvent actionEvent)
    {
        new TSpdcObjtVocbCntldDao().persistir(tSpdcObjtVocbCntld);
        tSpdcObjtVocbCntlds = new TSpdcObjtVocbCntldDao().buscarTodas();
        tSpdcObjtVocbCntld = new TSpdcObjtVocbCntld();
    }
    
    public void Exclude(ActionEvent actionEvent)
    {
        new TSpdcObjtVocbCntldDao().excluir(tSpdcObjtVocbCntld);
        tSpdcObjtVocbCntlds = new TSpdcObjtVocbCntldDao().buscarTodas();
        tSpdcObjtVocbCntld = new TSpdcObjtVocbCntld();
    }

    public TSpdcObjtVocbCntld getTSpdcObjtVocbCntld() {
        return tSpdcObjtVocbCntld;
    }

    public void setTSpdcObjtVocbCntld(TSpdcObjtVocbCntld tSpdcObjtVocbCntld) {
        this.tSpdcObjtVocbCntld = tSpdcObjtVocbCntld;
    }

    public List getTSpdcObjtVocbCntlds() {
        return tSpdcObjtVocbCntlds;
    }

    public void settSpdcObjtVocbCntlds(List tSpdcObjtVocbCntlds) {
        this.tSpdcObjtVocbCntlds = tSpdcObjtVocbCntlds;
    }
              
    public List<TSpdcObjt> getTSpdcObjts() {
        tSpdcObjts = tSpdcObjtDao.buscarTodas();
        return tSpdcObjts;
    }

    public void setTSpdcObjts(List<TSpdcObjt> tSpdcObjts) {
        this.tSpdcObjts = tSpdcObjts;
    }
    
    public List<TSpdcVocbCntld> getTSpdcVocbCntlds() {
        tSpdcVocbCntlds = tSpdcVocbCntldDao.buscarTodas();
        return tSpdcVocbCntlds;
    }

    public void setTSpdcVocbCntlds(List<TSpdcVocbCntld> tSpdcVocbCntlds) {
        this.tSpdcVocbCntlds = tSpdcVocbCntlds;
    }

    public TSpdcObjtVocbCntldDao getTSpdcObjtVocbCntldDao() {
        return tSpdcObjtVocbCntldDao;
    }

    public void setTSpdcObjtVocbCntldDao(TSpdcObjtVocbCntldDao tSpdcObjtVocbCntldDao) {
        this.tSpdcObjtVocbCntldDao = tSpdcObjtVocbCntldDao;
    }

    public TSpdcObjtDao getTSpdcObjtDao() {
        return tSpdcObjtDao;
    }

    public void setTSpdcObjtDao(TSpdcObjtDao tSpdcObjtDao) {
        this.tSpdcObjtDao = tSpdcObjtDao;
    }

    public TSpdcVocbCntldDao getTSpdcVocbCntldDao() {
        return tSpdcVocbCntldDao;
    }

    public void setTSpdcVocbCntldDao(TSpdcVocbCntldDao tSpdcVocbCntldDao) {
        this.tSpdcVocbCntldDao = tSpdcVocbCntldDao;
    }

     
}
