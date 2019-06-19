package gl.bookstore.store.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ApplicationScoped
public class FacesContextProducer {

	@Inject
	private FacesContext facesContext;

	public void addFlash(FacesMessage facesMessage) {
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		facesContext.addMessage("messages",facesMessage);
	}

	public FacesContext get() {
		return facesContext;
	}

	
	
}
