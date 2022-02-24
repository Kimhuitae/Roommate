package com.Project.Roommate.Service;

import com.Project.Roommate.DTO.ReplyRequestDTO;
import com.Project.Roommate.Entity.Freeboard;
import com.Project.Roommate.Entity.User;
import com.Project.Roommate.Repository.FreeboardRepository;
import com.Project.Roommate.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class boardservice {

    @Autowired
    private FreeboardRepository freeboardRepository;
    @Autowired
    private ReplyRepository replyRepository;


    //
    @Transactional
    public void write(Freeboard freeboard, User user){
        freeboard.setUser(user);
        freeboardRepository.save(freeboard);
    }
    @Transactional(readOnly = true)
    public Page<Freeboard> getlist(Pageable pageable){
        return freeboardRepository.findAll(pageable);
    }

        @Transactional(readOnly = true)
    public Freeboard getview(int id){
        return freeboardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("실패햇습니다");
                });
}

    @Transactional
    public void delete(int id){
        freeboardRepository.deleteById(id);
    }

    @Transactional

    public void update(int id,Freeboard requestboard){
        Freeboard freeboard=freeboardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("실패햇습니다");
                });
        freeboard.setFbo(requestboard.getFbo());
        freeboard.setFbrcontent(requestboard.getFbrcontent());
    }

    @Transactional
    public void replewrite(ReplyRequestDTO replyRequestDTO){
        replyRepository.replysave(replyRequestDTO.getFbn(), replyRequestDTO.getReplycontent(), replyRequestDTO.getUserid());

    }
    @Transactional
    public void replydelete(int replyId){replyRepository.deleteById(replyId);}
}
