package com.Project.Roommate.Controller;

import com.Project.Roommate.Entity.User;
import com.Project.Roommate.Service.boardservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Mappingcontroller {


    @GetMapping("/Roommate/main")
    public ModelAndView Main(ModelAndView mav){
        mav.setViewName("01_index");
        return mav;
    }
    @GetMapping("/Roommate/login")
    public ModelAndView Loginpage(ModelAndView mav){
        mav.setViewName("08_login");
        return mav;
    }
    @GetMapping("/Roommate/signup")
    public ModelAndView Signuppage(ModelAndView mav){
        mav.setViewName("09_signup");
        return mav;
    }
    @GetMapping("/Roommate/signup2")
    public ModelAndView Signuppage2(ModelAndView mav){
        mav.setViewName("09_signup2");
        return mav;
    }
    @GetMapping("/Roommate/Welcome")
    public ModelAndView Welcome(ModelAndView mav){
        mav.setViewName("09_signup3");
        return mav;
    }
    @GetMapping("/Rommmate/Oneroom")
    public ModelAndView Oneroompage(ModelAndView mav){
        mav.setViewName("02_onroomPage");
        return mav;
    }
    @GetMapping("/Rommmate/Oneroom/detail(example)")
    public ModelAndView Oneroompagedetail(ModelAndView mav){
        mav.setViewName("03_onroomPage_Detail");
        return mav;
    }
    @GetMapping("/Roommate/Tworoom")
    public ModelAndView Tworoompage(ModelAndView mav){
        mav.setViewName("04_tworoomPage");
        return mav;
    }
    @GetMapping("/Roommate/Tworoom/detail(example)")
    public ModelAndView Tworoompagedetail(ModelAndView mav){
        mav.setViewName("05_tworoomPage_Detail");
        return mav;
    }
    @GetMapping("/Roommate/Apt")
    public ModelAndView Aptpage(ModelAndView mav){
        mav.setViewName("06_aptPage");
        return mav;
    }
    @GetMapping("/Roommate/Apt/detail(example)")
    public ModelAndView Aptpagedetail(ModelAndView mav){
        mav.setViewName("07_aptPage_Detail");
        return mav;
    }
    @GetMapping("/Roommate/Freeboard/Writeform")
    public String Freeboardpage(){
        return "11_boardwrite";
    }
    @GetMapping("/Roommate/QnA")
    public ModelAndView QnA(ModelAndView mav){
        mav.setViewName("13_qna");
        return mav;
    }
    @GetMapping("/Roommate/serach")
    public ModelAndView mapdetail(ModelAndView mav){
        mav.setViewName("14_detail_serch");
        return mav;
    }


}
