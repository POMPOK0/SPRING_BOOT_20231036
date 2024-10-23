package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
