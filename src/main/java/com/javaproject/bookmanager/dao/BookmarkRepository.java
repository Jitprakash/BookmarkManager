package com.javaproject.bookmanager.dao;

import com.javaproject.bookmanager.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer > {

}
