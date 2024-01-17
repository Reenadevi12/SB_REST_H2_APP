package in.ashokit.moudel;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	private Integer pId;
	private String pName;
	private Double pPrice;

}
