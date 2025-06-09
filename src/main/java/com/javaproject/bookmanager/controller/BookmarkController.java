package com.javaproject.bookmanager.controller;

import com.javaproject.bookmanager.entity.Bookmark;
import com.javaproject.bookmanager.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookmarks")
public class BookmarkController {

    BookmarkService bookmarkService;

    @Autowired
    BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping("/list")
    public String getBookmarkList(Model model) {
        List<Bookmark> theBookmark = bookmarkService.findAll();

        model.addAttribute("bookmarks", theBookmark);

        return "bookmarks";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Bookmark bookmark = new Bookmark();
        model.addAttribute("bookmark", bookmark);
        return "bookmark-add";
    }

    @PostMapping("/save")
    public String saveBookmark(@ModelAttribute("bookmark") Bookmark bookmark) {
        bookmarkService.save(bookmark);
        return "redirect:/bookmarks/list";
    }

    @GetMapping("/delete")
    public String deleteBookmark(@RequestParam("bookmarkId") int id) {
        bookmarkService.deleteById(id);
        System.out.println("the employee is deleted");
        return "redirect:/bookmarks/list";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("bookmarkId") int id, Model model) {

        Bookmark bookmark = bookmarkService.findById(id);
        model.addAttribute("bookmark", bookmark);
        return "bookmark-add";
    }
}

//TODO->logout handling, Registration page
// ->fetch bookmarks with user
// ->add the bookmark with user id