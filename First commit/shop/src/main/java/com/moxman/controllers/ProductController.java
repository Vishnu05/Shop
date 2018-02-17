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
	        for (Category cat : list)
	        {
				catlist.put(cat.getCatid(), cat.getCatname());
			}

			return catlist;
		}
	  
	  public LinkedHashMap<Integer, String> getSubCatList() {
			List<Subcategory> list = subcategoryDAOImpl.getAllSubcategory();
	        LinkedHashMap<Integer, String> subcatlist = new LinkedHashMap<Integer, String>();
	        for (Subcategory subcat : list)
	        {
				subcatlist.put(subcat.getSubcatid(), subcat.getSubcatname());
			}

			return subcatlist;
		}

	
	 @RequestMapping("/newproduct")
	   public ModelAndView gotonewproduct(Model m) {
		 
		    m.addAttribute("catlist", this.getCatList());
		    m.addAttribute("subcatlist", this.getSubCatList());
			ModelAndView mv=new ModelAndView("newproduct","product",new Product());
	        return mv;
	   }
	 
	 @RequestMapping(value="insert",method=RequestMethod.POST)
		public String createBread(@ModelAttribute("product")Product product,Model m,@RequestParam("pimage") MultipartFile filedet,BindingResult result) {
			productDAOImpl.createProduct(product);
			System.out.println("Images storing started");
			String path="C:\\Users\\ADMIN\\eclipse-workspace\\vrmini\\src\\main\\webapp\\WEB-INF\\resources\\images\\";
			System.out.println("images stored");
			String fileinfo=path+product.getPid()+".jpg";
			File f=new File(fileinfo);
			if(!filedet.isEmpty())
			{
				try
				{
					byte buff[]=filedet.getBytes();
					FileOutputStream fos=new FileOutputStream(f);
					BufferedOutputStream bs=new BufferedOutputStream(fos);
					bs.write(buff);
				}
				catch(Exception e)
				{
					System.out.println("Exception Arised");
				}
			}
				else 
					
					{
						System.out.println("File uploading problem");
					}
			System.out.println("images stored");
			
			
			return "redirect:/viewproduct";
		}
	 
		 
	 @RequestMapping(value="viewproduct")
	 public String viewproduct(Model m)
		{
			System.out.println("Product Displaying page");
			List<Product> list=productDAOImpl.getAllProduct();
			m.addAttribute("proddetails",list);
			
			return "viewproduct";
			
		}
	 
	    
	    @RequestMapping(value="/deleteproduct/{id}")
		public ModelAndView deltebread(@PathVariable int id) {
			 Product p=productDAOImpl.getProductbyID(id);
			productDAOImpl.deleteProduct(p);
			return new ModelAndView("redirect:/viewproduct");
		}	
	 
	 /* It updates model object. */  
	    @RequestMapping(value="editsave",method=RequestMethod.POST)  
	    public ModelAndView editsavebread(@ModelAttribute("product") Product product,Model m){  
	    	System.out.println("---------------------->bread name after editing"+product.getPname());
	    	  	productDAOImpl.updateProduct(product);
	    	 List<Product>ll=productDAOImpl.getAllProduct();
			 ModelAndView mv=new ModelAndView("bread","allbread",ll);
			 return mv;
	    	
	    } 
	    
	    
	  @RequestMapping(value="editprod",method=RequestMethod.POST)
	    public String updateproductdetails(@ModelAttribute("product")Product product, Model m)
	    {
	    	System.out.println("product details upadating"+product);
	    	productDAOImpl.updateProduct(product);
	    	List<Product> prod=productDAOImpl.getAllProduct();
	    	m.addAttribute(product);
	    			return "editproduct";
	    }
	
	    

	/**    @RequestMapping(value="/updateSubcategory/{subcatid}")
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
		
		*/
	    @RequestMapping(value="/updateproduct/{id}",method=RequestMethod.GET)
	    public String gettingproddetails(@PathVariable int id, Model m) {
	    	
	    	System.out.println("getting product details ");
	    	productDAOImpl.getProductbyID(id);
	    	List<Product> pod=productDAOImpl.getAllProduct();
	    	m.addAttribute(pod);
	    	return "editproduct";
	    }

		
	/**	@RequestMapping(value="updateSubcategory/UpdateSubCategory",method=RequestMethod.POST)
		public String updateCategory(@ModelAttribute("subcategory") Subcategory subcategory,Model m)
		{
						
			subcategoryDAOImpl.updateSubcategory(subcategory);
			List<Subcategory> list=subcategoryDAOImpl.getAllSubcategory();
			m.addAttribute("subcatdetail",list);
			boolean flag=false;
			m.addAttribute("flag",flag);
			
			return "redirect:/subcategory";
		}

	    */
	    
}
