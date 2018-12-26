package br.com.victorpfranca.hellojee.manager;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import javax.inject.Inject;

import br.com.victorpfranca.hellojee.dao.CategoryDao;
import br.com.victorpfranca.hellojee.model.Category;

@Stateless
public class CategoryManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private CategoryDao categoryDao;

    public List<Category> getListCategory() {
        return categoryDao.getListCategory();
    }

    public void record(Category category) {
        categoryDao.record(category);
    }
    
    public void delete(Category category) 
    {   
        categoryDao.delete(category);
    }
    
    public void edit(Category category) {
    	categoryDao.edit(category);
    }

}
