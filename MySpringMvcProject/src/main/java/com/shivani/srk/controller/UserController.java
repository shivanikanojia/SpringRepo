package com.shivani.srk.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shivani.srk.pojos.Address;
import com.shivani.srk.pojos.ImageFile;
import com.shivani.srk.pojos.UserDetails;
import com.shivani.srk.services.FileService;
import com.shivani.srk.services.LoginService;
import com.shivani.srk.services.UserDetailService;


@Controller
@RequestMapping("/")
@ComponentScan("com.shivani.srk.pojos")
public class UserController {
	

	ModelAndView mv = new ModelAndView();
	
	static Logger log = Logger.getLogger(UserController.class.getName());
	
	
	int k=0;

	@Autowired
	private  UserDetailService service;

	//	@Autowired
	//	private  AddressService addService;

	@Autowired
	private UserDetails details;

	@Autowired 
	private Address address;


	@Autowired
	private FileService fileService;

//	@Autowired
//	private ImageFile file; 

	@Autowired
	private LoginService loginService;

	@Autowired
	private JpaTransactionManager manager;
	List<Address> multiAddress ;




	@RequestMapping( value = "/register")
	@GetMapping(value="details")
	@Transactional
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response, @RequestPart("file") MultipartFile[] fileUpload) throws IOException {

		details.setFirstName(request.getParameter("firstName"));
		details.setLastName(request.getParameter("lastName"));
		details.setUserName(request.getParameter("userName"));
		details.setEmail(request.getParameter("email"));
		
		String gender = request.getParameter("gender");
		if (gender.equals("Female")) {
			details.setGender("Female");
		} else {
			details.setGender("Male");
		}
		details.setGender(request.getParameter("gender"));

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = format.parse(request.getParameter("date"));
			details.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        details.setPassword(request.getParameter("password"));
		details.setContact(request.getParameter("contact"));	

		
		
		List<Address> addressOfUser = new ArrayList<Address>();

		int i = 0;

		while(request.getParameter("test[" + i + "]line1") != null) {

			Address address= new AnnotationConfigApplicationContext(Address.class).getBean(Address.class);
			address.setLine1(request.getParameter("test[" + i + "]line1"));
			address.setLine2(request.getParameter("test[" + i + "]line2"));
			address.setCity(request.getParameter("test[" + i + "]city"));
			address.setState(request.getParameter("test[" + i + "]state"));
			address.setZipcode(request.getParameter("test[" + i + "]zipcode"));
			address.setUser(details);
			addressOfUser.add(address);
			System.out.println(address);
			i++;

		}

		details.setAddress(addressOfUser);

		

		/**
		 * 
		 * File upload
		 *
		 */

		List<ImageFile> fileOfUser = new ArrayList<ImageFile>();
		
		if (fileUpload != null) {
			for (MultipartFile aFile : fileUpload){
				ImageFile file= new AnnotationConfigApplicationContext(ImageFile.class).getBean(ImageFile.class);
				System.out.println("Saving file: " + aFile.getOriginalFilename());
				file.setFileName(aFile.getOriginalFilename());
				file.setFile(BlobProxy.generateProxy(aFile.getBytes()));
				file.setUser(details);
				fileOfUser.add(file);
			}
		}
		
		
		details.setFile(fileOfUser);
		
		
		
		service.insert(details);


		System.out.println("Success!!");



		mv.setViewName("index");
		return mv;	
	}



	@RequestMapping( value = "/direct")
	
	@Transactional
	public String direct() {
		return "registeration";
	}



	@RequestScope
	@RequestMapping( value = "/login")
	@Transactional
	public ModelAndView processForm(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");


		UserDetails details;
		try {
			details = loginService.checkLogin(username, password);
			log.info(details);

			session.setAttribute("userId", details.getUserId());

			mv.setViewName("dashboard");
			mv.addObject("FirstName", details.getFirstName());
			mv.addObject("LastName", details.getLastName());
			mv.addObject("email", details.getEmail());
			mv.addObject("username", details.getUserName());
			mv.addObject("contact", details.getContact());
			
			return mv;
		} catch (Exception e) {
			mv.setViewName("index");
			return mv;
			
		}		

	}
	
	@RequestScope
	@RequestMapping( value = "/dashboard")
	@Transactional
	public ModelAndView dashboard(HttpSession session) {


		if(session.getAttribute("userId")==null) {

			mv.setViewName("index");
			return mv;
		}

		UserDetails details = (UserDetails) service.getData((Integer)session.getAttribute("userId"));

		mv.setViewName("dashboard");
		mv.addObject("FirstName", details.getFirstName());
		mv.addObject("LastName", details.getLastName());
		mv.addObject("email", details.getEmail());
		mv.addObject("username", details.getUserName());
		mv.addObject("contact", details.getContact());

		return mv;
	}
	
	

	// Address Detail mapping

	@RequestScope
	@RequestMapping( value = "/residentialDetails")
	@Transactional
	public String residentialDetails(ModelMap model, HttpSession session) {	

		if(session.getAttribute("userId")==null) {

			return "index";
		}

		List<Address> add = service.getAddress((Integer)session.getAttribute("userId"));

		System.out.println(add);
		model.addAttribute("addresses", add);
		return "residentialDetails";
	}


	//Image file mapping

	@RequestScope
	@RequestMapping( value = "/images")
	@Transactional
	public String image(ModelMap model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException {


		if(session.getAttribute("userId")==null) {
			return "index";
		}

		int i = 0;

		List<ImageFile> img = service.getFile((Integer)session.getAttribute("userId"));
		System.out.println("in image controller");
		
		List<String> file = new ArrayList<String>();

		for (Iterator<ImageFile> iterator = img.iterator(); iterator.hasNext();) {
			Blob filedata = iterator.next().getFile();
			file.add( Base64.getEncoder().encodeToString(filedata.getBytes(1, (int) filedata.length())));
		}
		
		model.addAttribute("img" , file);
		return "images";

	}
	
	

	// logout mapping

	@RequestScope
	@RequestMapping( value = "/logout")
	@Transactional
	public ModelAndView logout(HttpSession session) {


		if(session.getAttribute("userId")==null) {

			mv.setViewName("index");
			return mv;
		}

		session.invalidate();
		mv.setViewName("index");
		return mv;
	}
	
	

	// list of other users mapping

	@RequestScope
	@RequestMapping( value = "/otherUser")
	@Transactional
	public ModelAndView otherUser(HttpSession session) {


		if(session.getAttribute("userId")==null) {

			mv.setViewName("index");
			return mv;
		}

		List<UserDetails> details = service.findAll((Integer)session.getAttribute("userId"));

		mv.setViewName("otherUser");

		System.out.println(details);

		mv.addObject("UserDetails", details);
		return mv;
	}
	
	

	// deleting a user mapping
	@RequestScope
	@RequestMapping( value = "/delete")
	@Transactional
	public ModelAndView delete(HttpSession session, HttpServletRequest request, HttpServletResponse response) {


		if(session.getAttribute("userId")==null) {

			mv.setViewName("index");
			return mv;
		}
		System.out.println("Deleting following item");
		System.out.println(request.getParameter("userid"));
		int id = Integer.parseInt(request.getParameter("userid"));

		service.delete(id);
		mv.setViewName("otherUser");
		return mv;
	}

	
	@RequestScope
	@RequestMapping( value = "/update")
	@Transactional
	public ModelAndView update(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SQLException {


		if(session.getAttribute("userId")==null) {

			mv.setViewName("index");
			return mv;
		}
		
		UserDetails details = (UserDetails) service.getData((Integer)session.getAttribute("userId"));

		mv.setViewName("update");
		mv.addObject("FirstName", details.getFirstName());
		mv.addObject("LastName", details.getLastName());
		mv.addObject("email", details.getEmail());
		mv.addObject("username", details.getUserName());
		mv.addObject("contact", details.getContact());
		mv.addObject("password",details.getPassword());
		mv.addObject("dob",details.getDate());
		
		List<Address> add = service.getAddress((Integer)session.getAttribute("userId"));

		System.out.println(add);
		mv.addObject("addresses", add);
		
		
		List<ImageFile> img = service.getFile((Integer)session.getAttribute("userId"));
		System.out.println("in image controller");
		
		List<String> file = new ArrayList<String>();

		for (Iterator<ImageFile> iterator = img.iterator(); iterator.hasNext();) {
			Blob filedata = iterator.next().getFile();
			file.add( Base64.getEncoder().encodeToString(filedata.getBytes(1, (int) filedata.length())));
		}
		
		mv.addObject("img" , file);
		
		
		return mv;
	}
	
	//update
	
	@RequestScope
	@RequestMapping( value = "/updateInfo")
	@Transactional
	public ModelAndView updateInfo(HttpSession session, HttpServletRequest request, HttpServletResponse response) {


		if(session.getAttribute("userId")==null) {

			mv.setViewName("index");
			return mv;
		}
		
		UserDetails details = (UserDetails) service.getData((Integer)session.getAttribute("userId"));

		mv.setViewName("dashboard");
		mv.addObject("FirstName", details.getFirstName());
		mv.addObject("LastName", details.getLastName());
		mv.addObject("email", details.getEmail());
		mv.addObject("username", details.getUserName());
		mv.addObject("contact", details.getContact());
		mv.addObject("password",details.getPassword());
		mv.addObject("dob",details.getDate());
		
		List<Address> add = service.getAddress((Integer)session.getAttribute("userId"));

		System.out.println(add);
		mv.addObject("addresses", add);
		
		return mv;
	}
	
	


	// directing to reset password page
	@RequestScope
	@RequestMapping( value = "/reset")
	@Transactional
	public ModelAndView reset(HttpSession session, HttpServletRequest request, HttpServletResponse response) {


		mv.setViewName("reset");
		return mv;
	}

	// reset password mapping

	@RequestScope
	@RequestMapping( value = "/resetPass")
	@Transactional
	public ModelAndView resetPass(HttpSession session, HttpServletRequest request, HttpServletResponse response) {


		String username = request.getParameter("username");
		String password = request.getParameter("password");


		details = service.resetPass(username);
		details.setPassword(password);
		service.update(details);

		mv.setViewName("index");

		System.out.println(details);


		return mv;


	}
	
	
	
	
}
