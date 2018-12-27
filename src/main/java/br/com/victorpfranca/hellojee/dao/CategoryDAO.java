package br.com.victorpfranca.hellojee.dao;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.victorpfranca.hellojee.model.Category;

@ViewScoped
public class CategoryDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "hellojee")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Category> getListCategory() {
        return em.createQuery("select c from Category c order by c.name").getResultList();
    }

    public Category find (Category category) {
        return em.find(Category.class, category.getId());
    }
    
    public void persist(Category category) {
        em.persist(category);
    }

    public void merge(Category category) {
        em.merge(category);
    }
    
    public void remove(Category category) {
        em.remove(em.getReference(Category.class, category.getId()));
    }
}
