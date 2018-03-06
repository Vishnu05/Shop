package com.moxman.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.moxman.model.*;

@Repository("CartDAO")
public interface CartDAO {
	
	public void insertCart(Cart cart);
	public Cart getCart(int citemid);
	public List<Cart> retrive(String email);
	public void removeCart(Cart cart);
	public void updateCart(Cart cart);
	public Cart getnCartID(String email);
	public void setQuantity(String email,String name,String qty,int caid);
	public void deletecitems(String email);
	
	

}
