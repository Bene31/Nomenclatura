/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import model.TTipoObjt;
import dao.TTipoObjtDao;
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
public class tTipoObjtBean {
    TTipoObjt tTipoObjt = new TTipoObjt();
    
    List tTipoObjts = new ArrayList();

    public tTipoObjtBean() {
        tTipoObjts = new TTipoObjtDao().buscarTodas();
        tTipoObjt = new TTipoObjt();
    }
    
    public void Record(ActionEvent actionEvent)
    {
        new TTipoObjtDao().persistir(tTipoObjt);
        tTipoObjts = new TTipoObjtDao().buscarTodas();
        tTipoObjt = new TTipoObjt();
    }
    
    public void Exclude(ActionEvent actionEvent)
    {
        new TTipoObjtDao().excluir(tTipoObjt);
        tTipoObjts = new TTipoObjtDao().buscarTodas();
        tTipoObjt = new TTipoObjt();
    }
    
    public TTipoObjt getTTipoObjt()
    {
        return tTipoObjt;
    }
    
    public void setTTipoObjt(TTipoObjt tTipoObjt)
    {
        this.tTipoObjt = tTipoObjt;
    }
    
    public List getTTipoObjts()
    {
        return tTipoObjts;
    }
    
    public void setTTipoObjts(List tTipoObjts) {
        this.tTipoObjts = tTipoObjts;
    }
}
