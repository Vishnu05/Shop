package com.moxman.controllers;

import org.h2.util.New;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

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

	@Autowired
	UserDaoImpl userdao;

	@RequestMapping("/viewcategory")
	public String showCategoryPage(Model m, HttpSession session) {
		String email = (String) session.getAttribute("email");

		User user = userdao.getemail(email);
		if (user.getRole().equals("Role_Admin")) {

			System.out.println("---Category Page Displaying-----");
			List<Category> list = categoryDAOImpl.getAllCategory();
			m.addAttribute("catdetail", list);

			boolean flag = false;
			m.addAttribute("flag", flag);

			return "viewcategory";

		}

		else {
			Errorclz error = new Errorclz(1, "Access Denied");

		}

		return "admin";
	}

	@RequestMapping(value = "category")
	public String showcatpage(HttpSession session) {

		String email = (String) session.getAttribute("email");
		User user = userdao.getemail(email);
		if (user.getRole().equals("Role_Admin")) {

			return "category";
		}

		return "admin";
	}

	@RequestMapping(value = "/AddCategory", method = RequestMethod.POST)
	public String addCategory(@RequestParam("catname") String catname, @RequestParam("catdescription") String catdesc,
			Model m, HttpSession session) {

		String email = (String) session.getAttribute("email");
		User user = userdao.getemail(email);
		if (user.getRole().equals("Role_Admin")) {
			System.out.println("---Add Category Starting-----");

			System.out.println(catname + ":::" + catdesc);

			Category category = new Category();
			category.setCatname(catname);
			category.setCatdescription(catdesc);
			// category.setCatid(categoryDAOImpl.getMaxID()+1);

			categoryDAOImpl.createCategory(category);
			List<Category> list = categoryDAOImpl.getAllCategory();
			m.addAttribute("catdetail", list);

			boolean flag = false;
			m.addAttribute("flag", flag);

			System.out.println("---Category Added----");
			return "category";
		}

		return "admin";
	}

	@RequestMapping(value = "/deleteCategory/{catid}")
	public String deleteCategory(@PathVariable("catid") int catid, Model m, HttpSession session) {
		String email = (String) session.getAttribute("email");
		User user = userdao.getemail(email);
		if (user.getRole().equals(email)) {
			System.out.println("---Category Deleted----");
			Category category = categoryDAOImpl.getCategorybyID(catid);
			categoryDAOImpl.deleteCategory(category);

			List<Category> list = categoryDAOImpl.getAllCategory();
			m.addAttribute("catdetail", list);

			boolean flag = false;
			m.addAttribute("flag", flag);

			return "redirect:/category";
		}
		return "index";
	}

	@RequestMapping(value = "/updateCategory/{catid}")
	public String getUpdateCategory(@PathVariable("catid")  int catid, Model m, HttpSession session) {

		String email = (String) session.getAttribute("email");
		User user = userdao.getemail(email);
		if (user.getRole().equals("Role_Admin")) {
			System.out.println("--- Getting Category Object to be Updated ---");

			Category category = categoryDAOImpl.getCategorybyID(catid);
			m.addAttribute("category", category);

			List<Category> list = categoryDAOImpl.getAllCategory();
			m.addAttribute("catdetail", list);

			boolean flag = true;
			m.addAttribute("flag", flag);

			return "category";
		}

		return "index";
	}

	@RequestMapping(value = "updateCategory/UpdateCategory", method = RequestMethod.POST)
	public String updateCategory(@RequestParam("catid") int catid, @RequestParam("catname") String catname,
			@RequestParam("catdescription") String catdesc, Model m, HttpSession session) {
		String email = (String) session.getAttribute("email");
		User user = userdao.getemail(email);
		if (user.getRole().equals("Role_Admin")) {
			System.out.println("--Updating the Category----");
			Category category = new Category();
			category.setCatid(catid);
			category.setCatdescription(catdesc);
			category.setCatname(catname);
			categoryDAOImpl.updateCategory(category);
			List<Category> list = categoryDAOImpl.getAllCategory();
			m.addAttribute("catdetail", list);   
			boolean flag = false;
			m.addAttribute("flag", flag);
			return "redirect:/category";
		}
		 return "index";
	}
}
