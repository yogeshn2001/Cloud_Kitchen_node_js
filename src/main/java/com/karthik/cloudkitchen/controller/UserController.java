// package com.karthik.cloudkitchen.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// // UserController.java
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import com.karthik.cloudkitchen.model.User;
// import com.karthik.cloudkitchen.service.UserService;

// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpSession;

// @Controller
// public class UserController {
//     @Autowired
//     private UserService userService;

//     @Value("${registration.success.message}")
//     private String registrationSuccessMessage;

//     @GetMapping("/login")
//     public String showLoginForm() {
//         return "login";
//     }

//     // @PostMapping("/login")
//     // public String login(@RequestParam String username, @RequestParam String
//     // password, HttpSessionListener session) {
//     // User user = userService.authenticateUser(username, password);
//     // if (user != null) {
//     // ((jakarta.servlet.http.HttpSession) session).setAttribute("user", user);
//     // return "redirect:/welcome";
//     // } else {
//     // return "redirect:/login?error";
//     // }
//     // }
//     // @PostMapping("/login")
//     // public String login(@RequestParam String username, @RequestParam String
//     // password, HttpServletRequest request) {
//     // User user = userService.authenticateUser(username, password);
//     // if (user != null) {
//     // HttpSession session = request.getSession();
//     // session.setAttribute("user", user);
//     // return "redirect:/welcome";
//     // } else {
//     // return "redirect:/login?error";
//     // }
//     // }
//     @PostMapping("/login")
//     public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
//         if ("admin".equals(username) && "admin123".equals(password)) {
//             return "redirect:/admin/welcome";
//         }

//         User user = userService.authenticateUser(username, password);
//         if (user != null) {
//             HttpSession session = request.getSession();
//             session.setAttribute("user", user);
//             return "redirect:/welcome";
//         } else {
//             return "redirect:/login?error";
//         }
//     }

//     @GetMapping("/signup")
//     public String showSignupForm(Model model) {
//         model.addAttribute("user", new User());
//         return "signup";
//     }

//     @PostMapping("/signup")
//     public String signup(@ModelAttribute User user, Model model) {
//         userService.saveUser(user);
//         model.addAttribute("successMessage", registrationSuccessMessage);
//         return "redirect:/login";
//     }

//     @GetMapping("/welcome")
//     public String welcome(jakarta.servlet.http.HttpSession session, Model model) {
//         User user = (User) session.getAttribute("user");
//         if (user != null) {
//             if ("CUSTOMER".equals(user.getRole())) {
//                 return "customer_welcome";
//             } else if ("CATERER".equals(user.getRole())) {
//                 return "caterer_welcome";
//             }
//         }
//         return "redirect:/login";
//     }
//     @GetMapping("/admin/welcome")
//     public String adminWelcome() {
//         return "admin_welcome";
//     }
//}
package com.karthik.cloudkitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.karthik.cloudkitchen.model.User;
import com.karthik.cloudkitchen.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${registration.success.message}")
    private String registrationSuccessMessage;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @GetMapping("/")
    public String showLoginForm2() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            // return "redirect:/admin/welcome";
            return "caterer_welcome()";
        }

        User user = userService.authenticateUser(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "customer_welcome";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
    @GetMapping("/makeorder")
    public String showMakeOrder(Model model) {
        model.addAttribute("user", new User());
        return "makeorder";
    }

    @GetMapping("/trackorder")
    public String showTrackOrder(Model model) {
        model.addAttribute("user", new User());
        return "trackorder";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        model.addAttribute("user", new User());
        return "profile";
    }

    @GetMapping("/payment")
    public String showPayment(Model model) {
        model.addAttribute("user", new User());
        return "payment";
    }

    @GetMapping("/about")
    public String showAbout(Model model) {
        model.addAttribute("user", new User());
        return "about";
    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("successMessage", registrationSuccessMessage);
        return "redirect:/login";
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
           return "customer_welcome";
        }
        return "redirect:/login";
    }

    // @GetMapping("/admin/welcome")
    // public String adminWelcome() {
    //     return "admin_welcome";
    // }

    @GetMapping("caterer_welcome")
    public String caterer_welcome() {
        return "caterer_welcome";
    }

    @GetMapping("customer_welcome")
    public String customer_welcome() {
        return "customer_welcome";
    }

   
}
