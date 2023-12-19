package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UsersController {
	private final UserServiceImpl userServiceImpl;

	@Autowired
	public UsersController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;

		User user1 = new User("Ivan1", "Ivanov1", "ivanov1@mail.ru");
		User user2 = new User("Ivan2", "Ivanov2", "ivanov2@mail.ru");
		userServiceImpl.saveUser(user1);
		userServiceImpl.saveUser(user2);
	}
	@GetMapping(value = "/users")
	public String printUsers(ModelMap model) {
		List<User> userList = userServiceImpl.getAllUsers();
		model.addAttribute("users", userList);
		return "users";
	}
}