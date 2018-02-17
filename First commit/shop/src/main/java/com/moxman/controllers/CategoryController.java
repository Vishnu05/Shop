package com.moxman.controllers;
import org.h2.util.New;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.moxman.Dao.*;
import com.moxman.DaoImpl.*;
import com.moxman.model.*;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAOImpl categoryDAOImpl;
	
	@RequestMapping("/viewcategory")
	public String showCategoryPage(Model m)
	{
		System.out.println("---Category Page Displaying-----");
		List<Category> list=categoryDAOImpl.getAllCategory();
		m.addAttribute("catdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "viewcategory";
	}
	
	@RequestMapping(value="category")
	public String showcatpage() {
		return "category";
	}
	
	@RequestMapping(value="/AddCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("catname") String catname,@RequestParam("catdescription") String catdesc,Model m)
	{
		System.out.println("---Add Category Starting-----");
		
		System.out.println(catname+":::"+catdesc);
		
		Category category=new Category();
		category.setCatname(catname);
		category.setCatdescription(catdesc);
		//category.setCatid(categoryDAOImpl.getMaxID()+1);
			
		categoryDAOImpl.createCategory(category);
		
		List<Category> list=categoryDAOImpl.getAllCategory();
		m.addAttribute("catdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		System.out.println("---Category Added----");
		return "category";
	}
	
	@RequestMapping(value="/deleteCategory/{catid}")
	public String deleteCategory(@PathVariable("catid") int catid,Model m)
	{
		System.out.println("---Category Deleted----");
		Category category=categoryDAOImpl.getCategorybyID(catid);
		categoryDAOImpl.deleteCategory(category);
		
		List<Category> list=categoryDAOImpl.getAllCategory();
		m.addAttribute("catdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "redirect:/category";
	}
	
	@RequestMapping(value="/updateCategory/{catid}")
	public String getUpdateCategory(@PathVariable("catid")int catid,Model m)
	{
		System.out.println("--- Getting Category Object to be Updated ---");
		
		Category category=categoryDAOImpl.getCategorybyID(catid);
		m.addAttribute("category",category);
		
		List<Category> list=categoryDAOImpl.getAllCategory();
		m.addAttribute("catdetail",list);
		
		boolean flag=true;
		m.addAttribute("flag",flag);
		
		return "category";
	}
	
	
	@RequestMapping(value="updateCategory/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catid") int catid,@RequestParam("catname") String catname,@RequestParam("catdescription") String catdesc,Model m)
	{
		System.out.println("--Updating the Category----");

		Category category=new Category();
		category.setCatid(catid);
		category.setCatdescription(catdesc);
		category.setCatname(catname);
		categoryDAOImpl.updateCategory(category);
		List<Category> list=categoryDAOImpl.getAllCategory();
		m.addAttribute("catdetail",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		return "redirect:/category";
	}
}
