package br.com.cwi.crescer.aula5.converter;

import br.com.cwi.crescer.aula5.entity.UsuarioCadastrado;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Carlos H. Nonnemacher
 */
@FacesConverter("UsuarioCadastradoConverter")
public class UsuarioCadastradoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent uIComponent, String value) {
        if (value != null) {
            return this.getInComponent(uIComponent, value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        final UsuarioCadastrado Usuario = (UsuarioCadastrado) value;
        if (Usuario != null) {
            this.setInComponent(component, Usuario);
            return Usuario.getId().toString();
        }
        return null;
    }

    private void setInComponent(final UIComponent uIComponent, final UsuarioCadastrado usuario) {
        Map<Long, UsuarioCadastrado> Usuarios;
        Usuarios = (Map<Long, UsuarioCadastrado>) uIComponent.getAttributes().get("usuarios");
        if (Usuarios == null) {
            Usuarios = new HashMap<>();
        }
        Usuarios.put(usuario.getId(), usuario);
        uIComponent.getAttributes().put("usuarios", Usuarios);
    }

    private Object getInComponent(UIComponent uIComponent, String value) throws NumberFormatException {
        Map<Long, UsuarioCadastrado> usuarios;
        usuarios = (Map<Long, UsuarioCadastrado>) uIComponent.getAttributes().get("usuarios");
        if (usuarios != null) {
            return usuarios.get(Long.valueOf(value));
        }
        return null;
    }

}
