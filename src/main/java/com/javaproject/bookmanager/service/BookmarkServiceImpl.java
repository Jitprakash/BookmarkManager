package com.javaproject.bookmanager.service;

import com.javaproject.bookmanager.dao.BookmarkRepository;
import com.javaproject.bookmanager.entity.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookmarkServiceImpl implements BookmarkService {


    BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public List<Bookmark> findAll() {
        return bookmarkRepository.findAll();
    }

    @Override
    public Bookmark findById(int id) {
        Optional<Bookmark> result = bookmarkRepository.findById(id);

        Bookmark bookmark = null;

        if (result.isPresent()) {
            bookmark = result.get();
        }

        return bookmark;
    }

    @Override
    public Bookmark save(Bookmark theBookmark) {
        return bookmarkRepository.save(theBookmark);
    }

    @Override
    public void deleteById(int id) {
        bookmarkRepository.deleteById(id);
    }
}
