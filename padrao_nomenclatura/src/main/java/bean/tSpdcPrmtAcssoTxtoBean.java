/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TSpdcPrmtAcssoTxtoDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import model.TSpdcPrmtAcssoTxto;

/**
 *
 * @author terra
 */
@ManagedBean
@ViewScoped
public class tSpdcPrmtAcssoTxtoBean {
    TSpdcPrmtAcssoTxto tSpdcPrmtAcssoTxto = new TSpdcPrmtAcssoTxto();
    
    List tSpdcPrmtAcssoTxtos = new ArrayList();

    public tSpdcPrmtAcssoTxtoBean() {
        tSpdcPrmtAcssoTxtos = new TSpdcPrmtAcssoTxtoDao().buscarTodas();
        tSpdcPrmtAcssoTxto = new TSpdcPrmtAcssoTxto();
    }
    
    public void Record(ActionEvent actionEvent)
    {
        new TSpdcPrmtAcssoTxtoDao().persistir(tSpdcPrmtAcssoTxto);
        tSpdcPrmtAcssoTxtos = new TSpdcPrmtAcssoTxtoDao().buscarTodas();
        tSpdcPrmtAcssoTxto = new TSpdcPrmtAcssoTxto();
    }
    
    public void Exclude(ActionEvent actionEvent)
    {
        new TSpdcPrmtAcssoTxtoDao().excluir(tSpdcPrmtAcssoTxto);
        tSpdcPrmtAcssoTxtos = new TSpdcPrmtAcssoTxtoDao().buscarTodas();
        tSpdcPrmtAcssoTxto = new TSpdcPrmtAcssoTxto();
    }
    
    public TSpdcPrmtAcssoTxto getTSpdcPrmtAcssoTxto()
    {
        return tSpdcPrmtAcssoTxto;
    }
    
    public void setTSpdcPrmtAcssoTxto(TSpdcPrmtAcssoTxto tSpdcPrmtAcssoTxto)
    {
        this.tSpdcPrmtAcssoTxto = tSpdcPrmtAcssoTxto;
    }
    
    public List getTSpdcPrmtAcssoTxtos()
    {
        return tSpdcPrmtAcssoTxtos;
    }
    
    public void setTSpdcPrmtAcssoTxtos(List tSpdcPrmtAcssoTxtos) {
        this.tSpdcPrmtAcssoTxtos = tSpdcPrmtAcssoTxtos;
    }
}
