package com.team.structure.controllers;

import java.util.List;

import com.team.structure.domain.TeamMember;
import com.team.structure.service.LsdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private LsdService lsdService;

    @RequestMapping("/")
    public String homePage(Model model){
        List<TeamMember> member = lsdService.allMembers();
        model.addAttribute("memberS", member);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewMember(Model model){
        TeamMember member = new TeamMember();
        model.addAttribute("membeR", member);

        return "newMember";
    }

    @PostMapping()
    public String saveMember(@ModelAttribute("member") TeamMember member){
        lsdService.saveMember(member);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditNewMember(@PathVariable(name="id") Long id){
        ModelAndView modelAndView = new ModelAndView("editMember");

        TeamMember memBer = lsdService.getMember(id);
        modelAndView.addObject("memBer", memBer);

        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteMember(@PathVariable(name = "id") Long id){
        lsdService.delete(id);
        return "redirect:/";
    }
}
