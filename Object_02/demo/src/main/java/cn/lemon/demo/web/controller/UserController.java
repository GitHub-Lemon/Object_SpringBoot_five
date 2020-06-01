package cn.lemon.demo.web.controller;

import cn.lemon.demo.domain.User;
import cn.lemon.demo.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
  @Resource
  private UserServiceImpl userService;

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Integer id) {
    userService.delete(id);
    return "redirect:/user/userList";
  }


  @RequestMapping("/insertPage")
  public String insertPage() {
    return "insertPage";
  }


  @RequestMapping("/insert")
  public String insert(User user) {
    userService.add(user);
    return "redirect:/user/userList";
  }


  @RequestMapping("/select/{id}")
  @ResponseBody
  public String select(@PathVariable int id) {
    return userService.findById(id).toString();
  }


  @GetMapping("/updatePage/{id}")
  public String updatePage(Model model, @PathVariable int id) {
    User user = userService.findById(id);
    model.addAttribute("user", user);
    return "updatePage";
  }


  @PostMapping("/update")
  public String update(User user) {
    userService.update(user);
    return "redirect:/user/userList";
  }


  @RequestMapping("/userList")
  public String userList(Model model) {
    List<User> users = userService.findAll();
    model.addAttribute("users", users);
    return "userList";
  }

  @RequestMapping("/find")
  public String userFind(Model model,String name) {
    List<User> users = userService.findByName(name);
    model.addAttribute("users", users);
    return "userList";
  }

}
