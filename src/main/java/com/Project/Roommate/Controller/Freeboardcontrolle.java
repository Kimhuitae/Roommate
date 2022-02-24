package com.Project.Roommate.Controller;

import com.Project.Roommate.Entity.Freeboard;
import com.Project.Roommate.Entity.User;
import com.Project.Roommate.Service.boardservice;
import com.Project.Roommate.config.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class Freeboardcontrolle {

    Freeboard freeboard;
    @Autowired
    private boardservice boardservice;


    @GetMapping("/Roommate/Freeboard")
    public String Freeboardlist(Model model, @PageableDefault(size = 30, sort = "fbn", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("freeboard", boardservice.getlist(pageable));
        return "10_freeboard";
    }

    @GetMapping("/Roommate/Freeboard/fbn={fbn}")
    public String Freeboarddetail(@PathVariable int fbn,Model model,@AuthenticationPrincipal PrincipalDetail prin){
        model.addAttribute("freeboard",boardservice.getview(fbn));

        return "10_boardview";
    }
    @GetMapping("/Roommate/Freeboard/update/fbn={fbn}")
    public String Freeboardupdate(@PathVariable int fbn, Model model){
        model.addAttribute("freeboard",boardservice.getview(fbn));
        return "11_boardupdate";
    }



}