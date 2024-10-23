package com.example.demo.model.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.domain.Article;
import com.example.demo.model.repository.BlogRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동 생성
public class BlogService {
    
    private final BlogRepository blogRepository; // 리포지토리 선언

    // 게시판 전체 목록 조회
    public List<Article> findAll() { 
        return blogRepository.findAll();
    }

    // 게시글 저장
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }    
    
}
