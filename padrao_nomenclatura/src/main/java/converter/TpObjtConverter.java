/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.TTipoObjtDao;
import model.TTipoObjt;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author terra
 */
@FacesConverter(value = "tpObjtConverter")
public class TpObjtConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
        if (id != null && !id.isEmpty()) {
            return (TTipoObjt) new TTipoObjtDao().buscar(Integer.valueOf(id));
        }
        return id;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
        if (objeto != null) {
            TTipoObjt tTipoObjt = (TTipoObjt) objeto;
            return tTipoObjt.getIdTipoObjt()!= null && tTipoObjt.getIdTipoObjt()> 0 ? tTipoObjt.getIdTipoObjt().toString() : null;
        }
        return null;
    }
}