package gl.bookstore.store.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import gl.bookstore.store.dao.AuthorDAO;
import gl.bookstore.store.dao.ComicDAO;
import gl.bookstore.store.infra.FacesContextProducer;
import gl.bookstore.store.infra.MessageHelper;
import gl.bookstore.store.model.Author;
import gl.bookstore.store.model.Comic;

@Model
public class AdminComicsBean {

	private Comic product = new Comic();
	private	List<Integer>	selectedAuthorsIds	= new	ArrayList<>();
	private	List<Author>	authors	=	new	ArrayList<Author>();
	
	@Inject
	private AuthorDAO authorDAO;
	
	@Inject
	private ComicDAO comicDAO;
	
	@Inject
	private FacesContextProducer facesContext;
	
	@Inject
	MessageHelper messagesHelper;
	
	
	public String save() {
		populateBookAuthor();
		if(product.getTitle()==null	||	
				product.getTitle().trim().isEmpty()){
				facesContext.get().addMessage(null, new FacesMessage("titulo	obrigatorio"));
}
if(product.getDescription()==null	||	
				product.getDescription().trim().isEmpty()){
	           facesContext.get().addMessage(null,new FacesMessage("descrição	obrigatoria"));
				
}

				if(facesContext.get().getMessages().hasNext()){
					//volta	para	a	mesma	tela
					return "/livros/form";
													}
				
				
		comicDAO.save(product);
		clearObjects();		
		facesContext.get().getExternalContext().getFlash().setKeepMessages(true);	
		messagesHelper.addFlash(new FacesMessage("Comic Successfully Saved!"));
		return "/lista?faces-redirect=true";		
	}

	
	@PostConstruct
	public	void	loadObjects(){								
	this.authors	=	authorDAO.list();
	}
	
	
	public Comic getProduct() {
		return product;
	}
	
	
	
	public List<Integer> getSelectedAuthorsIds() {
		return selectedAuthorsIds;
	}


	private	void populateBookAuthor() {
		selectedAuthorsIds.stream().map((id)->{return	new	Author(id);}).forEach(product::add);
}

	public List<Author> getAuthors() {
		return authors;
	}


	public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
		this.selectedAuthorsIds = selectedAuthorsIds;
	}
	
	private void clearObjects() {
		this.product = new Comic();
		this.selectedAuthorsIds.clear();
	}
	
	
	
	
}
