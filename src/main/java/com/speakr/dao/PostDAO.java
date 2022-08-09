package com.speakr.dao;

import com.speakr.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO extends JpaRepository<Post, Integer> {
}
