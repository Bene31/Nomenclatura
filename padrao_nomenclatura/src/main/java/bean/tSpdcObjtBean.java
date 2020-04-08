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

/**
 *
 * @author terra
 */
@ManagedBean
@ViewScoped
public class tSpdcObjtBean {
    TSpdcObjt tSpdcObjt = new TSpdcObjt();
    
    List tSpdcObjts = new ArrayList();

    public tSpdcObjtBean() {
        tSpdcObjts = new TSpdcObjtDao().buscarTodas();
        tSpdcObjt = new TSpdcObjt();
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
}
