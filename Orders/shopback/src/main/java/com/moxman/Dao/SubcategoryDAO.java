package com.moxman.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
import com.moxman.model.*;

@Repository("SubcategoryDAO")
public interface SubcategoryDAO {
	
	public List<Subcategory> getAllSubcategory();
	public Subcategory getSubcategorybyID(int ID);
	public Subcategory getSubcategorybyName(String Name);
	public void createSubcategory(Subcategory subcategory);
	public void updateSubcategory(Subcategory subcategory);
	public void deleteSubcategory(Subcategory subcategory);
	

}
