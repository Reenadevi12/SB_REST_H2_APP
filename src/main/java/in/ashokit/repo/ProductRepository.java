package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.moudel.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
