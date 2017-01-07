package com.majkimajk.controller;

import java.util.List;

import org.jgroups.protocols.pbcast.CoordGmsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.majkimajk.dao.UserDAO;
import com.majkimajk.dao.UserDAOImpl;
import com.majkimajk.entity.User;
import com.majkimajk.geoloc.Address;
import com.majkimajk.geoloc.Coordinates;
import com.majkimajk.service.UserService;

@Controller
@RequestMapping("/user")
public class MyController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/list")
	public String showList(Model theModel) {
		
		List<User> theList = service.getUsers();
		
		theModel.addAttribute("users", theList);
		
		return "user-list";
	}
	
	@GetMapping("/showAddUser")
	public String showAddForm(Model theModel) {
		
		User theUser = new User();
		theModel.addAttribute("user", theUser );
		
		return "add-user";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		service.saveUser(theUser);
		
		return "redirect:/user/list";
	}
	
	@GetMapping("/updateUser")
	public String updateUser(@RequestParam("userId") int theId, Model theModel) {
		
		User theUser = service.getUser(theId);
		
		theModel.addAttribute("user", theUser);
	
		return "/add-user";
		
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int theId) {
		
		
		service.deleteUser(theId);
		return "redirect:/user/list";
	}
	
	@GetMapping("/geoloc")
	public String showChoice() {
		return "geoloc";
	}
	
	@GetMapping("/geoloc/getcoordinates")
	public String getCoord(Model theModel) {
		
		Coordinates coord = new Coordinates();
		theModel.addAttribute("getCoord", coord);
		return "getcoordinates";
	}
	
	@PostMapping("/geoloc/showcoords")
	public String showCoords(@ModelAttribute("getCoord") Coordinates theCoords, Model theModel){
		String url = theCoords.getAddressUrl();
		String coordsToShow = theCoords.getCoordinates(url);
		theModel.addAttribute("coordsToShow", coordsToShow);
		return "showcoords";
	}
	
	
	@GetMapping("/geoloc/getaddress")
	public String getAddr(Model theModel) {
		Address adr = new Address();
		theModel.addAttribute("getAdr", adr);
		return "getaddress";
		
		
	}
	
	@PostMapping("/geoloc/showaddress")
	public String showaddress(@ModelAttribute("getAdr") Address theAddress, Model theModel) {
		String url = theAddress.getAdressUrl();
		String addressToShow = theAddress.getFinalAddress(url);
		theModel.addAttribute("addressToShow", addressToShow);
		return "showaddress";
	}
}
