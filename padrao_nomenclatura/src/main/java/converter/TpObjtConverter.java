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
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (TTipoObjt) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof TTipoObjt) {
            TTipoObjt tipo = (TTipoObjt) value;
            if (tipo != null && tipo instanceof TTipoObjt && tipo.getIdTipoObjt()!= null) {
                uic.getAttributes().put(tipo.getIdTipoObjt().toString(), tipo);
                return tipo.getIdTipoObjt().toString();
            }
        }
        return "";
    }
}