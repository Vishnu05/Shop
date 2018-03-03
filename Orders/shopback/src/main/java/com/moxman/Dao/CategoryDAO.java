package com.moxman.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.moxman.model.*;

@Repository("CategoryDAO")
public interface CategoryDAO {
	
	public List<Category> getAllCategory();
	public Category getCategorybyID(int ID);
	public Category getCategorybyName(String Name);
	public void createCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(Category category);

}
