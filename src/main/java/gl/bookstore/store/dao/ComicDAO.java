package gl.bookstore.store.dao;

import java.util.List;

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

	public List<Comic> list() {
		return	manager.createQuery("select	distinct(c)	from Comic c join fetch	c.authors",Comic.class).getResultList();
	}		
	
	
}
