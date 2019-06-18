package gl.bookstore.store.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import gl.bookstore.store.dao.ComicDAO;
import gl.bookstore.store.model.Comic;

@Model
public class AdminListComicsBean {

	@Inject
	private ComicDAO comicDAO;
	
	private List<Comic> comics = new ArrayList<>();
	
	@PostConstruct
	public void loadObjects() {
		this.comics = comicDAO.list();
		
	}

	public List<Comic> getComics() {
		System.out.println("COMICS "+comics);
		return comics;
	}
	
	
}
