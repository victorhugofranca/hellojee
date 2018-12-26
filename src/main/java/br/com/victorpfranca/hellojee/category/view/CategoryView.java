package br.com.victorpfranca.hellojee.category.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.victorpfranca.hellojee.manager.CategoryManager;
import br.com.victorpfranca.hellojee.model.Category;

@ManagedBean(value = "categorieView")
@Named
@Stateless
public class CategoryView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CategoryManager categoryManager;
    @Inject
    private Category category;
    private List<Category> listCategories;
    private Severity severity;
    private Category selectCategory;

   
    public List<Category> getListCategory() {
        listCategories = categoryManager.getListCategory();
        return listCategories;
    }

    public void record() {

        try {
            categoryManager.record(category);
            severity = FacesMessage.SEVERITY_INFO;
            addMessage("Data Record Sucess", "Data Saved", severity);
            clean();

        } catch (Exception e) {
            severity = FacesMessage.SEVERITY_ERROR;
            addMessage(e.getMessage(), "Data Not Saved", severity);
           
        }

    }

    public void delete(Category category) {
        try {
            categoryManager.delete(category);
            severity = FacesMessage.SEVERITY_INFO;
            addMessage("Data Deleted Sucess", "Data Deleted", severity);
        } catch (Exception e) {
            severity = FacesMessage.SEVERITY_ERROR;
            addMessage(e.getMessage(), "Data Not Deleted", severity);
        }

    }

    public void edit(Category category) {
        try {
            categoryManager.edit(category);
            severity = FacesMessage.SEVERITY_INFO;
            addMessage("Data Edited Sucess", "Data Edited", severity);
        } catch (Exception e) {
            severity = FacesMessage.SEVERITY_ERROR;
            addMessage(e.getMessage(), "Data not Edited", severity);
        }

    }

    public void clean() {
        category = new Category();
    }

    public void addMessage(String summary, String detail, Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getSelectCategory() {
        return selectCategory;
    }

    public void setSelectCategory(Category selectCategory) {
        this.selectCategory = selectCategory;
    }

}
