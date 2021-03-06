package oit.is.z0846.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0846.kaizi.janken.model.Janken;
import oit.is.z0846.kaizi.janken.model.Entry;


/**
 * @RequestMapping("/sample26")をクラスの前につけると，このクラスのすべてのメソッドは/sample26で呼び出されることを表す
 */
@Controller
public class Lec02Controller {

  @Autowired
  private Entry room;

  /**
   * @GetMappingに引数が与えられていないので，クラスで指定されたとおり/sample26へのGETリクエストがあったら，sample26()を呼び出して，sample26.htmlを返す
   *
   * @return
   */
  @GetMapping("/lec02")
  public String lec02(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);

    String name = "Hi" + " " + loginUser;
    model.addAttribute("name", name);
    return "lec02.html";
  }

  @PostMapping("/lec02")
  public String lec02(@RequestParam String name, Principal prin, ModelMap model) {
    name = "Hi" + " " + name;
    model.addAttribute("name", name);
    return "lec02.html";
  }

   @GetMapping("/lec02janken")
   public String lec02janken(@RequestParam String me, Principal prin, ModelMap model) {
     String loginUser = prin.getName();
     String name = "Hi" + " " + loginUser;
     model.addAttribute("name", name);

     Janken janken = new Janken(me);
     model.addAttribute("janken", janken);
     model.addAttribute("me", janken.me);
     model.addAttribute("you", janken.you);
     model.addAttribute("j", janken.j);

     this.room.addUser(loginUser);
     model.addAttribute("room", this.room);
     return "lec02.html";
   }
}
