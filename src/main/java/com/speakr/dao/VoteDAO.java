package com.speakr.dao;

import com.speakr.entity.Post;
import com.speakr.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface VoteDAO extends JpaRepository<Vote, Integer>
{
    default List<Vote> getDownVotesByPost(Post post) {
        return this.findAll().stream().filter(vote -> vote.getPost().equals(post)).filter(vote -> vote.getIncrement() == -1).collect(Collectors.toList());
    }
    default List<Vote> getUpVotesByPost(Post post) {
        return this.findAll().stream().filter(vote -> vote.getPost().equals(post)).filter(vote -> vote.getIncrement() == 1).collect(Collectors.toList());
    }

}
