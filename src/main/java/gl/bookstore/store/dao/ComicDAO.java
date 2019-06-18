package gl.bookstore.store.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gl.bookstore.store.model.Comic;

public class ComicDAO {

	
	@PersistenceContext
	private	EntityManager	manager;
	
	
	public	void	save(Comic product) {
		manager.persist(product);
									}		
	
	
}
