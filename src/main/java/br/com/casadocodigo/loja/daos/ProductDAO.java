package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Product;

@Repository
@Transactional
public class ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
	

	public void save(Product product ) {
		entityManager.persist(product);
	}


	public List<Product> list() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select p from Product p join fetch p.prices",Product.class)
				.getResultList();
	}
}
