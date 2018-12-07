package ar.edu.unnoba.poo2018.converter;

import ar.edu.unnoba.poo2018.dao.AbstractDAO;
import ar.edu.unnoba.poo2018.model.AbstractEntity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author poo
 * @param <T>
 */
public abstract class AbstractConverter<T> implements Converter {

    public abstract String getDAOName();

    private AbstractDAO<T> getEntityDAO() {
        InitialContext ic;
        try {
            ic = new InitialContext();
            return (AbstractDAO<T>) ic.lookup("java:module/" + getDAOName());
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return this.getEntityDAO().find(Long.valueOf(value));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Long id = ((AbstractEntity) value).getId();
        return id == null ? "0" : id.toString();
    }
}
