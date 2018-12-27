package br.com.victorpfranca.hellojee.manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.victorpfranca.hellojee.dao.CategoryDAO;
import br.com.victorpfranca.hellojee.model.Category;

@Stateless
public class CategoryManager implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private CategoryDAO categoryDAO;

    public List<Category> getListCategory() {
        return categoryDAO.getListCategory();
    }
    
    public Category find (Category category) {
        return categoryDAO.find(category);
    }
    
    public void persist(Category category) {
        categoryDAO.persist(category);
    }
    
    public void merge(Category category) {
        categoryDAO.merge(category);
    }  
    
    public void remove(Category category) {
        categoryDAO.remove(category);
    }    
}
