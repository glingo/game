package com.marvin.bundle.game.controller;

import com.marvin.component.mvc.ModelAndView;
import com.marvin.bundle.framework.mvc.controller.Controller;
import com.marvin.component.mvc.model.Model;
import com.marvin.bundle.game.business.GameManager;
import com.marvin.bundle.game.model.Game;
import com.marvin.component.form.FormTypeInterface;
import com.marvin.component.form.support.ButtonType;
import com.marvin.component.form.support.TextType;

public class GameController extends Controller {
    
    private final GameManager manager;
    
    public GameController(GameManager manager) {
        this.manager = manager;
    }
    
    public ModelAndView all(Model model) {
        model.put("games", manager.getAll());
        ModelAndView mav = new ModelAndView("games", model);
        return mav;
    }
    
    public ModelAndView save(Model model) {
        FormTypeInterface form = (FormTypeInterface) model.get("gameForm");
        
        if(null != form) {
            model.remove("gameForm");
            this.manager.save((Game) form.getData());
            return all(model);
        }
        
        form = createFormBuilder("person", new Game())
            .add("firstName", new TextType("firstName", "First name : "))
            .add("lastName", new TextType("lastName", "Last name : "))
            .add("email", new TextType("email", "Email : "))
            .add("connect", new ButtonType("validate", "Valider", "/addressbook/persons/save"))
            .add("cancel", new ButtonType("cancel", "Annuler", "/addressbook/persons"))
            .getForm();

        model.put("gameForm", form);

        return ModelAndView.builder().view("game").model(model).build();
    }
    
     public ModelAndView play(Model model) {
        model.put("game", new Game());
        return ModelAndView.builder().view("play").model(model).build();
    }
}
