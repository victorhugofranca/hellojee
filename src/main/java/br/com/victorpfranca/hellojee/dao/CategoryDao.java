package br.com.victorpfranca.hellojee.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.victorpfranca.hellojee.model.Category;

@ViewScoped
public class CategoryDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "hellojee")
    private EntityManager manager;

    @SuppressWarnings("unchecked")
    public List<Category> getListCategory() {
        return manager.createQuery("select c from Category c").getResultList();

    }

    public void record(Category category) {
        manager.persist(category);
    }
    
    public void delete(Category category) {
        Category categoryaDelete=manager.find(Category.class, category.getId());
        manager.remove(categoryaDelete);
    }
    
    public void edit(Category category) {
    	//Category categoryEdit = manager.find(Category.class, category.getId());
    	manager.merge(category);
    	
    }

}
