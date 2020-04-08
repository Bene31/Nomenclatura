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

/**
 *
 * @author terra
 */
@ManagedBean
@ViewScoped
public class tSpdcPrpdObjtBean {
    TSpdcPrpdObjt tSpdcPrpdObjt = new TSpdcPrpdObjt();
    
    List tSpdcPrpdObjts = new ArrayList();

    public tSpdcPrpdObjtBean() {
        tSpdcPrpdObjts = new TSpdcPrpdObjtDao().buscarTodas();
        tSpdcPrpdObjt = new TSpdcPrpdObjt();
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
}
