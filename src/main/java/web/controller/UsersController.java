package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
	private final UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping({"", "/", "list"})
	public String showAllUsers(Model model, @ModelAttribute("flashMessage") String flashAttribute) {
		model.addAttribute("users", userService.getAllUsers());
		return "list";
	}

	@GetMapping(value = "/new")
	public String addUserForm(@ModelAttribute("user") User user) {
		return "form";
	}

	@PostMapping()
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		userService.createOrUpdateUser(user);
		return "redirect:/users";
	}

	@GetMapping("/{id}/edit")
	public String editUserForm(@PathVariable(value = "id", required = true) long id, Model model) {
		User user = userService.readUser(id);
		if (null == user) {
			return "redirect:/users";
		}
		model.addAttribute("user", userService.readUser(id));
		return "form";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam(value = "id", required = true, defaultValue = "") long id) {
		User user = userService.deleteUser(id);
		return "redirect:/users";
	}
}