/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import model.TSpdcPrfx;
import dao.TSpdcPrfxDao;
import java.io.Serializable;
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
public class tSpdcPrfxBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    TSpdcPrfx tSpdcPrfx = new TSpdcPrfx();
    
    List tSpdcPrfxs = new ArrayList();

    public tSpdcPrfxBean() {
        tSpdcPrfxs = new TSpdcPrfxDao().buscarTodas();
        tSpdcPrfx = new TSpdcPrfx();
    }
    
    public void Record(ActionEvent actionEvent)
    {
        new TSpdcPrfxDao().persistir(tSpdcPrfx);
        tSpdcPrfxs = new TSpdcPrfxDao().buscarTodas();
        tSpdcPrfx = new TSpdcPrfx();
    }
    
    public void Exclude(ActionEvent actionEvent)
    {
        new TSpdcPrfxDao().excluir(tSpdcPrfx);
        tSpdcPrfxs = new TSpdcPrfxDao().buscarTodas();
        tSpdcPrfx = new TSpdcPrfx();
    }
    
    public TSpdcPrfx getTSpdcPrfx()
    {
        return tSpdcPrfx;
    }
    
    public void setTSpdcPrfx(TSpdcPrfx tSpdcPrfx)
    {
        this.tSpdcPrfx = tSpdcPrfx;
    }
    
    public List getTSpdcPrfxs()
    {
        return tSpdcPrfxs;
    }
    
    public void setTSpdcPrfxs(List tSpdcPrfxs) {
        this.tSpdcPrfxs = tSpdcPrfxs;
    }
    
}
