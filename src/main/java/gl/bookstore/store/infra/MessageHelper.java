package gl.bookstore.store.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ApplicationScoped
public class MessageHelper {

	
	@Inject
	private	FacesContext	facesContext;
	
	
	public	void	addFlash(FacesMessage	facesMessage) {
	facesContext.getExternalContext().getFlash().setKeepMessages(true);
	facesContext.addMessage(null,facesMessage);
									}


	
}
