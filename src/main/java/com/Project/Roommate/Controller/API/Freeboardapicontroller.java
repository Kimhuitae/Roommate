package com.Project.Roommate.Controller.API;

import com.Project.Roommate.DTO.ReplyRequestDTO;
import com.Project.Roommate.DTO.RespDTO;
import com.Project.Roommate.Entity.Freeboard;
import com.Project.Roommate.Entity.Freeboardreply;
import com.Project.Roommate.Service.boardservice;
import com.Project.Roommate.Service.userservice;
import com.Project.Roommate.config.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class Freeboardapicontroller {

    @Autowired
    private boardservice boardservice;

    @PostMapping("/Roommate/Freeboard/Writeprob")
    public RespDTO<Integer> write(@RequestBody Freeboard freeboard, @AuthenticationPrincipal PrincipalDetail principal) {
        boardservice.write(freeboard, principal.getUser());
        return new RespDTO<Integer>(HttpStatus.OK, 1);
    }

    @DeleteMapping("/Roommate/Freeboard/Writeprob/fbn={fbn}")
    public RespDTO<Integer> deleteById(@PathVariable int fbn) {
        boardservice.delete(fbn);
        return new RespDTO<Integer>(HttpStatus.OK, 1);
    }

    @PutMapping("/Roommate/Freeboard/Writeprob/fbn={fbn}")
    public RespDTO<Integer> update(@PathVariable int fbn, @RequestBody Freeboard freeboard){
        boardservice.update(fbn,freeboard);
        return new RespDTO<Integer>(HttpStatus.OK, 1);
    }
    @PostMapping("/Roommate/Freeboard/{fbn}/reply")
    public RespDTO<Integer> replySave(@RequestBody ReplyRequestDTO replySaveRequestDto) {
        boardservice.replewrite(replySaveRequestDto);
        return new RespDTO<Integer>(HttpStatus.OK, 1);
    }

    @DeleteMapping("/Roommate/Freeboard/{fbn}/reply/{replyId}")
    public RespDTO<Integer> replyDelete(@PathVariable int replyId) {
        boardservice.replydelete(replyId);
        return new RespDTO<Integer>(HttpStatus.OK, 1);
    }
}
