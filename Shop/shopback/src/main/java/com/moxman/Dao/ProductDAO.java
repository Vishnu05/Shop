package com.moxman.Dao;
import java.util.*;
import org.springframework.stereotype.*;
import com.moxman.model.*;

@Repository("ProductDAO")
public interface ProductDAO {
	
	public List<Product> getAllProduct();
	public Product getProductbyID(int ID);
	public Product getProductbyName(String Name);
	public List<Product> getProductbyCatID(int catid);
	public void createProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);

}
