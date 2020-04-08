/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TSpdcVocbCntldDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import model.TSpdcVocbCntld;

/**
 *
 * @author terra
 */
@ManagedBean
@ViewScoped
public class tSpdcVocbCntldBean {
    TSpdcVocbCntld tSpdcVocbCntld = new TSpdcVocbCntld();
    
    List tSpdcVocbCntlds = new ArrayList();

    public tSpdcVocbCntldBean() {
        tSpdcVocbCntlds = new TSpdcVocbCntldDao().buscarTodas();
        tSpdcVocbCntld = new TSpdcVocbCntld();
    }
    
    public void Record(ActionEvent actionEvent)
    {
        new TSpdcVocbCntldDao().persistir(tSpdcVocbCntld);
        tSpdcVocbCntlds = new TSpdcVocbCntldDao().buscarTodas();
        tSpdcVocbCntld = new TSpdcVocbCntld();
    }
    
    public void Exclude(ActionEvent actionEvent)
    {
        new TSpdcVocbCntldDao().excluir(tSpdcVocbCntld);
        tSpdcVocbCntlds = new TSpdcVocbCntldDao().buscarTodas();
        tSpdcVocbCntld = new TSpdcVocbCntld();
    }
    
    public TSpdcVocbCntld getTSpdcVocbCntld()
    {
        return tSpdcVocbCntld;
    }
    
    public void setTSpdcVocbCntld(TSpdcVocbCntld tSpdcVocbCntld)
    {
        this.tSpdcVocbCntld = tSpdcVocbCntld;
    }
    
    public List getTSpdcVocbCntlds()
    {
        return tSpdcVocbCntlds;
    }
    
    public void setTSpdcVocbCntlds(List tSpdcVocbCntlds) {
        this.tSpdcVocbCntlds = tSpdcVocbCntlds;
    }
}
