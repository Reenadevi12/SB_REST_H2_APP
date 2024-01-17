package in.ashokit.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.moudel.Product;
import in.ashokit.repo.ProductRepository;

@RestController
public class ProductRestController {
	@Autowired
	private ProductRepository repo;
	
	@PostMapping(value="/addProduct",
			consumes = {"application/json","application/xml"})
	public ResponseEntity<String>addProduct(@RequestBody Product product){
		repo.save(product);
		return new ResponseEntity<>("Product Saved",HttpStatus.CREATED);
	}
	
	@GetMapping(value="/findProducts",
			produces = "application/json")
	public ResponseEntity<List<Product>>findProducts(){
		List<Product>products=repo.findAll();
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	

}
