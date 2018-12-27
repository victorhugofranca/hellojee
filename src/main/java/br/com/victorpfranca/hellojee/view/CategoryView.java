package br.com.victorpfranca.hellojee.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.victorpfranca.hellojee.manager.CategoryManager;
import br.com.victorpfranca.hellojee.model.Category;

@Named
@Stateless
public class CategoryView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CategoryManager categoryManager;
    
    @Inject
    private Category category;
        
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public List<Category> getListCategory() {
        return categoryManager.getListCategory();
    }
    
    public void save() {
        if (category.getId() == null) {
            categoryManager.persist(category);
            saveMessage("Successful", "Successful registration.");            
        } else {
            categoryManager.merge(category);
            saveMessage("Successful", "Registration updated successfully.");
        }
        clear();
    }
   
    public void remove(Category obj) {
        categoryManager.remove(obj);
        saveMessage("Successful", "Category removed successfully.");            
    }
    
    public void edit(Category obj) {
        category = categoryManager.find(obj);
        saveMessage("Warn", "To edit, update category information in the form.");                    
    }
    
    public void clear() {
        category = new Category();
    }
    
    public void saveMessage(String summary, String detail) { 
        FacesContext context = FacesContext.getCurrentInstance();
        
        if ("Successful".equals(summary)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
        } else if ("Warn".equals(summary)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error"));           
        }
    }
}
