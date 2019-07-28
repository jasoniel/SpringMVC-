package br.com.casadocodigo.loja.daos;

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
}
