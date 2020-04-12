/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.TSpdcObjtDao;
import model.TSpdcObjt;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author terra
 */
@FacesConverter(value = "objetoConverter")
public class ObjetoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
        if (id != null && !id.isEmpty()) {
            return (TSpdcObjt) new TSpdcObjtDao().buscar(Integer.valueOf(id));
        }
        return id;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
        if (objeto != null) {
            TSpdcObjt tSpdcObjt = (TSpdcObjt) objeto;
            return tSpdcObjt.getIdObjt()!= null && tSpdcObjt.getIdObjt() > 0 ? tSpdcObjt.getIdObjt().toString() : null;
        }
        return null;
    }
}