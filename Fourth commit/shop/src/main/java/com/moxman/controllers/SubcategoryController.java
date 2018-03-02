package com.moxman.controllers;

//import org.h2.util.New;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.moxman.Dao.*;
import com.moxman.DaoImpl.*;
import com.moxman.model.*;

@Controller
public class SubcategoryController {

	@Autowired
	SubcategoryDAOImpl subcategoryDAOImpl;
	
	@Autowired
	CategoryDAOImpl categoryDAOImpl;
	
	public LinkedHashMap<Integer, String> getCatList() {
		List<Category> list = categoryDAOImpl.getAllCategory();
        LinkedHashMap<Integer, String> catlist = new LinkedHashMap<Integer, String>();
        for (Category cat : list)
        {
			catlist.put(cat.getCatid(), cat.getCatname());
		}

		return catlist;
	}

	
	@RequestMapping("/subcategory")
	public String showCategoryPage(Model m)
	{
		System.out.println("---Category Page Displaying-----");
		List<Subcategory> list=subcategoryDAOImpl.getAllSubcategory();
		m.addAttribute("subcatdetail",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("subcategory",  new Subcategory());
		
		return "subcategory";
	}
	
	@RequestMapping(value="Addsubcategory",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("subcategory") Subcategory subcategory,Model m)
	{
		subcategoryDAOImpl.createSubcategory(subcategory);
		List<Subcategory> list=subcategoryDAOImpl.getAllSubcategory();
		m.addAttribute("subcatdetail",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("subcategory",  new Subcategory());
		return "subcategory";
	}
	
	@RequestMapping(value="/deletesubcategory/{subcatid}")
	public String deleteCategory(@PathVariable("subcatid") int subcatid,Model m)
	{
		
		Subcategory subcategory = subcategoryDAOImpl.getSubcategorybyID(subcatid);
		subcategoryDAOImpl.deleteSubcategory(subcategory);
		List<Subcategory> list=subcategoryDAOImpl.getAllSubcategory();
		m.addAttribute("subcatdetail",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("subcategory",  new Subcategory());
		
		return "redirect:/subcategory";
	}
	
	@RequestMapping(value="/updateSubcategory/{subcatid}")
	public String getUpdateCategory(@PathVariable("subcatid")int subcatid,Model m)
	{
		
		Subcategory subcategory = subcategoryDAOImpl.getSubcategorybyID(subcatid);
		m.addAttribute("subcategory",subcategory);
		List<Subcategory> list=subcategoryDAOImpl.getAllSubcategory();
		m.addAttribute("subcatdetail",list);
		boolean flag=true;
		m.addAttribute("flag",flag);
		m.addAttribute("catlist",this.getCatList());
		
		return "subcategory";
	}
	
	
	@RequestMapping(value="updateSubcategory/UpdateSubCategory",method=RequestMethod.POST)
	public String updateCategory(@ModelAttribute("subcategory") Subcategory subcategory,Model m)
	{
					
		subcategoryDAOImpl.updateSubcategory(subcategory);
		List<Subcategory> list=subcategoryDAOImpl.getAllSubcategory();
		m.addAttribute("subcatdetail",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "redirect:/subcategory";
	}
}
