package com.javaproject.bookmanager.service;

import com.javaproject.bookmanager.entity.Bookmark;

import java.util.List;

public interface BookmarkService {

    List<Bookmark> findAll();
    Bookmark findById(int id);
    Bookmark save(Bookmark theBookmark);
    void deleteById(int id);
}
