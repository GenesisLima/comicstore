package gl.bookstore.store.managedbeans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import gl.bookstore.store.dao.ComicDAO;
import gl.bookstore.store.model.Comic;

@Model
public class AdminComicsBean {

	private Comic product = new Comic();
	
	@Inject
	private ComicDAO comicDAO;
	
	public void save() {
		System.out.println("Saving "+product.getTitle()+" book!");
		comicDAO.save(product);
		System.out.println(product.getTitle()+" saved!");

		
	}

	public Comic getProduct() {
		return product;
	}
	
	
	
}
