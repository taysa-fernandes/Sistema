package Sistema.converter;

import java.util.function.Consumer;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import Sistema.entity.Tarefa;

@FacesConverter(forClass = Tarefa.class)
public class TarefaConverter implements Consumer {
	private UIComponent uiComponent;

	public Tarefa getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Tarefa) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		this.uiComponent = uiComponent;
		if (value instanceof Tarefa) {
			Tarefa entity = (Tarefa) value;
			if (entity != null && entity instanceof Tarefa && entity.getId() != null) {
				uiComponent.getAttributes().put(entity.getId().toString(), entity);
				return entity.getId().toString();
			}
		}
		return "";
	}

	@Override
	public void accept(Object t) {
		// TODO Auto-generated method stub

	}
}
