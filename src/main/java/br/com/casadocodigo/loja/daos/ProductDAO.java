package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Product;

@Repository
public class ProductDAO {

	
	@PersistenceContext
	private EntityManager manager;
	
	
	public void save(Product product) {
		// TODO Auto-generated method stub
		
		manager.persist(product);
		
	}


	public List<Product> list() {
		// TODO Auto-generated method stub
		return manager.createQuery("select distinct(p) from Product p join fetch p.prices",Product.class).getResultList();
	}

}
