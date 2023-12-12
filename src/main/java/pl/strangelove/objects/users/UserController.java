package pl.strangelove.objects.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/addUser")
    public String showAddUserForm(Model model){
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    @PostMapping("/addUser")
    public String addUserForm(@ModelAttribute("user") User user){
        userRepository.save(user);
        return "redirect:/userAdded";
    }

    @RequestMapping("/userAdded/{id}")
    public String showCreatedUser(){

    }



}
