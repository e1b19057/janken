package oit.is.z0846.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0846.kaizi.janken.model.Janken;


/**
 * @RequestMapping("/sample26")をクラスの前につけると，このクラスのすべてのメソッドは/sample26で呼び出されることを表す
 */
@Controller
@RequestMapping("/lec02")
public class Lec02Controller {

  /**
   * @GetMappingに引数が与えられていないので，クラスで指定されたとおり/sample26へのGETリクエストがあったら，sample26()を呼び出して，sample26.htmlを返す
   *
   * @return
   */
  @GetMapping()
  public String lec02() {
    return "lec02.html";
  }

  @PostMapping
  public String lec02(@RequestParam String name, ModelMap model) {
    name = "Hi" + " " + name;
    model.addAttribute("name", name);
    return "lec02.html";
  }

   @GetMapping("/lec02janken")
   public String lec02janken(@RequestParam String me, ModelMap model) {
    Janken janken =new Janken(me);
    model.addAttribute("janken",janken);
    model.addAttribute("me",janken.me);
    model.addAttribute("you",janken.you);
    model.addAttribute("j",janken.j);
    return "lec02.html";
  }
}
