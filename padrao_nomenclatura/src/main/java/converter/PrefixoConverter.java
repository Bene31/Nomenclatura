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
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
        if (id != null && !id.isEmpty()) {
            return (TSpdcPrfx) new TSpdcPrfxDao().buscar(Integer.valueOf(id));
        }
        return id;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
        if (objeto != null) {
            TSpdcPrfx tSpdcPrfx = (TSpdcPrfx) objeto;
            return tSpdcPrfx.getIdPrfx()!= null && tSpdcPrfx.getIdPrfx() > 0 ? tSpdcPrfx.getIdPrfx().toString() : null;
        }
        return null;
    }
}