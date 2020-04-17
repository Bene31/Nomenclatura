/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.TSpdcPrfxDao;
import model.TSpdcPrfx;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author terra
 */
@FacesConverter(value = "prefixoConverter")
public class PrefixoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (TSpdcPrfx) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof TSpdcPrfx) {
            TSpdcPrfx prfx = (TSpdcPrfx) value;
            if (prfx != null && prfx instanceof TSpdcPrfx && prfx.getIdPrfx()!= null) {
                uic.getAttributes().put(prfx.getIdPrfx().toString(), prfx);
                return prfx.getIdPrfx().toString();
            }
        }
        return "";
    }
}