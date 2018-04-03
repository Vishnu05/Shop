package com.moxman.controllers;

import java.io.*;
import java.util.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.moxman.Dao.*;
import com.moxman.DaoImpl.*;
import com.moxman.model.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
public class ProductController {

	@Autowired
	ProductDAOImpl productDAOImpl;

	@Autowired
	CategoryDAOImpl categoryDAOImpl;

	@Autowired
	SubcategoryDAOImpl subcategoryDAOImpl;
 
	public LinkedHashMap<Integer, String> getCatList() {
		List<Category> list = categoryDAOImpl.getAllCategory();
		LinkedHashMap<Integer, String> catlist = new LinkedHashMap<Integer, String>();
		for (Category cat : list) {
			catlist.put(cat.getCatid(), cat.getCatname());
		}

		return catlist;
	}

	public LinkedHashMap<Integer, String> getSubCatList() {
		List<Subcategory> list = subcategoryDAOImpl.getAllSubcategory();
		LinkedHashMap<Integer, String> subcatlist = new LinkedHashMap<Integer, String>();
		for (Subcategory subcat : list) {
			subcatlist.put(subcat.getSubcatid(), subcat.getSubcatname());
		}

		return subcatlist;
	}

	@RequestMapping("/newproduct")
	public ModelAndView gotonewproduct(Model m) {

		m.addAttribute("catlist", this.getCatList());
		m.addAttribute("subcatlist", this.getSubCatList());
		ModelAndView mv = new ModelAndView("newproduct", "product", new Product());
		return mv;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String createBread(@ModelAttribute("product") Product product, Model m,
			@RequestParam("pimage") MultipartFile filedet, BindingResult result) {
		productDAOImpl.createProduct(product);
		System.out.println("Images storing started");
		String path = "C:\\Users\\ADMIN\\eclipse-workspace\\shop\\src\\main\\webapp\\images";

		System.out.println("images stored");
		String fileinfo = path + product.getPid() + ".jpg";
		File f = new File(fileinfo);
		// MultipartFile filedet=product.getPimage();
		if (!filedet.isEmpty()) {
			try {
				byte buff[] = filedet.getBytes();
				FileOutputStream fos = new FileOutputStream(f);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(buff);
			} catch (Exception e) {
				System.out.println("Exception Arised");
			}
		} else

		{
			System.out.println("File uploading problem");
		}
		System.out.println("images stored");

		return "redirect:/newproduct";
	}

	@RequestMapping(value = "viewproduct")
	public String viewproduct(Model m) {
		System.out.println("Product Displaying page");
		List<Product> list = productDAOImpl.getAllProduct();
		m.addAttribute("proddetails", list);

		return "viewproduct";

	}

	@RequestMapping(value = "/deleteproduct/{id}")
	public ModelAndView deltebread(@PathVariable int id) {
		Product p = productDAOImpl.getProductbyID(id);
		productDAOImpl.deleteProduct(p);
		return new ModelAndView("redirect:/viewproduct");
	}

	/* It updates model object. */
	@RequestMapping(value = "editsave", method = RequestMethod.POST)
	public ModelAndView editsavebread(@ModelAttribute("product") Product product, Model m) {
		System.out.println("---------------------->bread name after editing" + product.getPname());
		productDAOImpl.updateProduct(product);
		List<Product> ll = productDAOImpl.getAllProduct();
		ModelAndView mv = new ModelAndView("bread", "allbread", ll);
		return mv;

	}

	@RequestMapping(value = "/productdisplay")
	public String getproductdisplay(Model m) {

		List<Product> list = productDAOImpl.getAllProduct();
		m.addAttribute("proddetails", list);
		return "productdisplay";
	}

		
	@RequestMapping(value="updateprod/{pid}",method=RequestMethod.GET)
	public String updateProduct(@PathVariable("pid") int productId,Model m)
	{
		System.out.println("---");
		Product product=productDAOImpl.getProductbyID(productId);  //.getProduct(productId);
		m.addAttribute(product);
		
		List<Product> listProduct=productDAOImpl.getAllProduct();  //.retrieveProduct();
		m.addAttribute("productList",listProduct);
		m.addAttribute("catlist",this.getCatList() );
		m.addAttribute("subcatlist",this.getSubCatList());
		return "editproduct";
	}
	
	@RequestMapping(value="updateprod",method=RequestMethod.POST)
	public String updateMyProduct(@ModelAttribute("product")Product product,Model m)
	{
		productDAOImpl.updateProduct(product);
		
		Product product1=new Product();
		m.addAttribute(product1);
		
		List<Product> listProduct=productDAOImpl.getAllProduct();   //.retrieveProduct();
		m.addAttribute("productList",listProduct);
		
		return "redirect:/viewproduct";
	}
	


	@RequestMapping(value="productdescription")
	public String showProductDesc(@RequestParam("id")int productId,Model m)
	{
		//int id=Integer.parseInt(productId);
		Product product=productDAOImpl.getProductbyID(productId);  //getProduct(productId); 
		
		m.addAttribute("product",product);
		return "productdescription";
	}

	 	
}
