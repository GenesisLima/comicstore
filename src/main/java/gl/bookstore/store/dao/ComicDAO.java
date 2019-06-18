package gl.bookstore.store.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import gl.bookstore.store.model.Comic;

public class ComicDAO {

	
	@PersistenceContext
	private	EntityManager	manager;
	
	@Transactional
	public	void	save(Comic product) {
		manager.persist(product);
									}		
	
	
}
