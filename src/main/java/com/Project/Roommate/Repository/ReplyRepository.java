package com.Project.Roommate.Repository;

import com.Project.Roommate.Entity.Freeboardreply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Freeboardreply,Integer> {

    @Modifying
    @Query(value="INSERT INTO freeboardreply(fbn, replycontent, userid) VALUES(?, ?, ?)",
            nativeQuery = true)
    int replysave(int fbn,String replycontent,String userid);

}
