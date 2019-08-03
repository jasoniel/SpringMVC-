package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.validation.ProductValidator;

@Repository
@Transactional
public class ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void save(@Valid Product product ) {
		entityManager.persist(product);
	}


	public List<Product> list() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select p from Product p",Product.class)
				.getResultList();
	}
	
	
	public Product find(Integer id) {
		TypedQuery<Product> query = entityManager
				.createQuery(
						"select p from Product p join fetch p.prices where p.id=:id",
						Product.class).setParameter("id", id);
		return query.getSingleResult();
	}
}
