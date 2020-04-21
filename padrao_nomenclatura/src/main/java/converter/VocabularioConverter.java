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
import model.TSpdcVocbCntld;

/**
 *
 * @author terra
 */
@FacesConverter(value = "vocabularioConverter")
public class VocabularioConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (TSpdcVocbCntld) uic.getAttributes().get(value);
        }
        return null;
    }
    
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof TSpdcVocbCntld) {
            TSpdcVocbCntld vocb = (TSpdcVocbCntld) value;
            if (vocb != null && vocb instanceof TSpdcVocbCntld && vocb.getIdVocbCntld()!= null) {
                uic.getAttributes().put(vocb.getIdVocbCntld().toString(), vocb);
                return vocb.getIdVocbCntld().toString();
            }
        }
        return "";
    }
}
