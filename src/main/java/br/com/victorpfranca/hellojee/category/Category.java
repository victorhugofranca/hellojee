package br.com.victorpfranca.hellojee.category;

import static br.com.victorpfranca.hellojee.category.Category.FIND_ALL_QUERY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
@NamedQueries({ @NamedQuery(name = FIND_ALL_QUERY, query = "SELECT c FROM Category c") })

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String GENERATOR = "GeneratorCategory";

	public static final String FIND_ALL_QUERY = "Category.findAll";

	@Id
	@SequenceGenerator(name = GENERATOR, sequenceName = "sq_category", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = GENERATOR, strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;

	@NotNull(message = "The category must have a name")
	@Column(name = "nome", nullable = false, unique = false)
	private String name;

	public Category() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Category))
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getName();
	}

}