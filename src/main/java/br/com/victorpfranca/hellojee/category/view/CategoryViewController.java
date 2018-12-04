package br.com.victorpfranca.hellojee.category.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.victorpfranca.hellojee.category.Category;

@Stateless
public class CategoryViewController implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "hellojee")
	private EntityManager em;

	public List<Category> list() {
		return em.createQuery("select c from categoria").getResultList();
	}

}
