package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.domain.Article;
import com.example.demo.model.service.BlogService;


import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService; // blogService 주입

    @GetMapping("/article_list") // 게시판 링크 지정
    public String articleList(Model model) {
        // 모든 게시글을 조회
        List<Article> list = blogService.findAll();
        
        // 조회된 게시글을 모델에 추가
        model.addAttribute("articles", list);
        
        // article_list.html 페이지로 이동
        return "article_list";
    }
    @GetMapping("/article_edit/{id}") // 게시판 링크 지정
    public String article_edit(Model model, @PathVariable Long id) {
        Optional<Article> list = blogService.findById(id); // 선택한 게시판 글
        if (list.isPresent()) {
            model.addAttribute("article", list.get()); // 존재하면 Article 객체를 모델에 추가
        } else {
            // 처리할 로직 추가 (예: 오류 페이지로 리다이렉트, 예외 처리 등)
            return "error"; // 오류 처리 페이지로 연결
        }
        return "article_edit"; // .HTML 연결
    }

}
