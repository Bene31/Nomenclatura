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
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (TSpdcObjt) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof TSpdcObjt) {
            TSpdcObjt objt = (TSpdcObjt) value;
            if (objt != null && objt instanceof TSpdcObjt && objt.getIdObjt()!= null) {
                uic.getAttributes().put(objt.getIdObjt().toString(), objt);
                return objt.getIdObjt().toString();
            }
        }
        return "";
    }
}