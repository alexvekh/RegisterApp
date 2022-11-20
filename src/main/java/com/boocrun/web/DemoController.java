package com.boocrun.web;


//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boocrun.domain.User;
import com.boocrun.repository.UserRepository;



@Controller
public class DemoController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/")
	public String root (ModelMap model) {
		Iterable<User> allUsers = userRepo.findAll();
		
		User user = new User();
		
		model.put("allUsers", allUsers);
		model.put("user", user);
		
		return "register";
				
	}
	
	@PostMapping("/")
	public String rootPost (User user) {
		userRepo.save(user);
		
		return "redirect:/";
	}
//Delete user
//	 @PostMapping("/")
//	    public String rootDelete(User user){
//	        userRepo.delete(user);
//	        return "redirect:/";
//	    }
	 
//	@RequestMapping(value="/del/{luser}", method=RequestMethod.GET)
//	public String deleteUser (@PathVariable User luser, ModelMap model)
//	{
//		//model.remove("allUsers", allUsers);
//		model.remove("user", luser);
////		((HashMap<String, Object>) userRepo).remove(user);
//		root(model);
//		return "welcome";
//	}
}
