package com.masos.controller;
import com.masos.dao.*;
import com.masos.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private static PersonDAO personDAO = new PersonDAO();
    private static GoodDAO goodDAO = new GoodDAO();
    private static PurchaseDAO purchaseDAO = new PurchaseDAO();

    private static final String URL = "http://localhost:8080/1";


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(ModelMap modelMap) {
        return "index";
    }
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String readPersons(ModelMap modelMap) {
        modelMap.addAttribute("personList", personDAO.getAll());
        return "persons";
    }
    @RequestMapping(value ="/person/create", method = RequestMethod.POST)
    public ModelAndView createPerson(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "login") String login,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "email", required = false) String email,
                                     ModelMap modelMap) {
        personDAO.create(new Person(0, name, login, password, email));
        modelMap.addAttribute("personList", personDAO.getAll());
        return new ModelAndView("redirect:"+URL+"/person");
    }
    @RequestMapping(value ="/person/update", method = RequestMethod.POST)
    public ModelAndView updatePerson(@RequestParam(value = "id") int id,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "login", required = false) String login,
                                   @RequestParam(value = "password", required = false) String password,
                                   @RequestParam(value = "email", required = false) String email,
                                   ModelMap modelMap) {
        Person person = personDAO.getById(id);
        if(!name.isEmpty()) person.setName(name);
        if(!login.isEmpty()) person.setLogin(login);
        if(!password.isEmpty()) person.setPassword(password);
        if(!email.isEmpty()) person.setEmail(email);
        personDAO.update(person);
        modelMap.addAttribute("personList", personDAO.getAll());
        return new ModelAndView("redirect:"+URL+"/person");
    }
    @RequestMapping(value ="/person/delete", method = RequestMethod.POST)
    public ModelAndView deletePerson(@RequestParam(value = "id") int id, ModelMap modelMap) {
        personDAO.delete(id);
        modelMap.addAttribute("personList", personDAO.getAll());
        return new ModelAndView("redirect:"+URL+"/person");
    }
    @RequestMapping(value = "/good", method = RequestMethod.GET)
    public String readGoods(ModelMap modelMap) {
        modelMap.addAttribute("goodList", goodDAO.getAll());
        return "goods";
    }
    @RequestMapping(value ="/good/create", method = RequestMethod.POST)
    public ModelAndView createGood(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "price") double price,
                                   ModelMap modelMap) {
        goodDAO.create(new Good(0, name, price));
        modelMap.addAttribute("goodList", goodDAO.getAll());
        return new ModelAndView("redirect:"+URL+"/good");
    }
    @RequestMapping(value ="/good/update", method = RequestMethod.POST)
    public ModelAndView updateGood(@RequestParam(value = "id") int id,
                                   @RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "price", required = false) String price,
                                   ModelMap modelMap) {
        Good good = goodDAO.getById(id);
        if(!name.isEmpty()) good.setName(name);
        if(!price.isEmpty()) good.setPrice(Double.parseDouble(price));
        goodDAO.update(good);
        modelMap.addAttribute("goodList", goodDAO.getAll());
        return new ModelAndView("redirect:"+URL+"/good");
    }
    @RequestMapping(value ="/good/delete", method = RequestMethod.POST)
    public ModelAndView deleteGood(@RequestParam(value = "id") int id, ModelMap modelMap) {
        goodDAO.delete(id);
        modelMap.addAttribute("goodList", goodDAO.getAll());
        return new ModelAndView("redirect:"+URL+"/good");
    }
    @RequestMapping(value = "/purchase", method = RequestMethod.GET)
    public String readPurchases(ModelMap modelMap) {
        modelMap.addAttribute("purchaseList", purchaseDAO.getAll());
        return "purchases";
    }
    @RequestMapping(value ="/purchase/create", method = RequestMethod.POST)
    public ModelAndView createPurchase(@RequestParam(value = "personId") int personId,
                                       @RequestParam(value = "goodId") int goodId,
                                       ModelMap modelMap) {
        purchaseDAO.create(new Purchase(0, personId, goodId));
        modelMap.addAttribute("purchaseList", purchaseDAO.getAll());
        return new ModelAndView("redirect:"+URL+"/purchase");
    }
    @RequestMapping(value ="/purchase/update", method = RequestMethod.POST)
    public ModelAndView updatePurchase(@RequestParam(value = "number") int number,
                                       @RequestParam(value = "personId", required = false) String personId,
                                       @RequestParam(value = "goodId", required = false) String goodId,
                                       ModelMap modelMap) {
        Purchase purchase = purchaseDAO.getById(number);
        if(!personId.isEmpty()) purchase.setPersonId(Integer.parseInt(personId));
        if(!goodId.isEmpty()) purchase.setGoodId(Integer.parseInt(goodId));
        purchaseDAO.update(purchase);
        modelMap.addAttribute("purchaseList", purchaseDAO.getAll());
        return new ModelAndView("redirect:"+URL+"/purchase");
    }
    @RequestMapping(value ="/purchase/delete", method = RequestMethod.POST)
    public ModelAndView deletePurchase(@RequestParam(value = "number") int number, ModelMap modelMap) {
        purchaseDAO.delete(number);
        modelMap.addAttribute("purchaseList", purchaseDAO.getAll());
        return new ModelAndView("redirect:"+URL+"/purchase");
    }
}
