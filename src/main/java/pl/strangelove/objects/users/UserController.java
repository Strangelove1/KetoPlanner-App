package pl.strangelove.objects.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registerUser")
    public String showAddUserForm(Model model){
        model.addAttribute("user", new User());
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String addUserForm(@ModelAttribute("user") User user){
        user.setEnable(0);
        userRepository.save(user);
        return "redirect:/userAdded/" + user.getId();
    }

    @RequestMapping("/userAdded/{id}")
    public String showCreatedUser(@PathVariable long id, Model model){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
            return "/userAdded";
        } else {
            return "userNotFound";
        }
    }

    @GetMapping("/updateUser/{id}")
    public String showUpdateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "user/updateUser";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        userRepository.save(user);
        return "redirect:/userUpdated/" + user.getId();
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/userDeleted";
    }

}
