/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.TSpdcPrpdObjt;

/**
 *
 * @author terra
 */
@FacesConverter(value = "prpdObjetoConverter")
public class PrpdObjetoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (TSpdcPrpdObjt) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof TSpdcPrpdObjt) {
            TSpdcPrpdObjt prpd = (TSpdcPrpdObjt) value;
            if (prpd != null && prpd instanceof TSpdcPrpdObjt && prpd.getIdPrpdObjt()!= null) {
                uic.getAttributes().put(prpd.getIdPrpdObjt().toString(), prpd);
                return prpd.getIdPrpdObjt().toString();
            }
        }
        return "";
    }
}
