package gl.bookstore.store.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy	=	GenerationType.IDENTITY)
    private	Integer	id;
    private	String	name;
	
	public Author(Integer id) {
		this.id = id;
	}
   
	public Author() {
		// TODO Auto-generated constructor stub
	}
	

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


	
}
