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
    public Optional<Article> findById(Long id) { // 게시판 특정 글 조회
        return blogRepository.findById(id);
        }
    public void update(Long id, AddArticleRequest request) {
        Optional<Article> optionalArticle = blogRepository.findById(id); // 단일 글 조회
        optionalArticle.ifPresent(article -> { // 값이 있으면
            article.update(request.getTitle(), request.getContent()); // 값을 수정
            blogRepository.save(article); // Article 객체에 저장
        });
    }
    public void delete(Long id) {
        blogRepository.deleteById(id);
        }
}
