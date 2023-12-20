package pl.strangelove.loginUtility;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.strangelove.objects.users.User;
import pl.strangelove.objects.users.UserRepository;


@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "user/loginUser";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") @Validated LoginForm loginForm,
                               BindingResult bindingResult,
                               HttpSession session) {
        // Validate the login form
        // (You can use annotations like @Email, @NotBlank, etc., on the LoginForm class)

        if (bindingResult.hasErrors()) {
            return "user/loginUser";
        }

        // Perform user authentication (you might want to use Spring Security for this)
        // For simplicity, let's assume a basic authentication mechanism
        User user = userRepository.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());

        if (user != null) {
            // Successful login
            session.setAttribute("user", user);
            return "redirect:/"; // Redirect to a dashboard or home page
        } else {
            // Failed login
            bindingResult.rejectValue("email", "error.loginForm", "Invalid email or password");
            return "/user/userNotFound";
        }
    }
}