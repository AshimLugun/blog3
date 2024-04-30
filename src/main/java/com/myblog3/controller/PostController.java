package com.myblog3.controller;

import com.myblog3.payload.PostDto;
import com.myblog3.service.PostService;
import com.myblog3.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //http:localhost:8080/api/post?id=1
    @GetMapping
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //http://localhost:8080/api/post/all?pageNo=0&pageSize=3
@GetMapping("/all")
    public List<PostDto> getAllPosts(

            @RequestParam(name="pageNo",required = false,defaultValue = "0")int pageNo,
            @RequestParam(name="pageSize",required = false,defaultValue = "3")int pageSize
){
        List<PostDto> postDtos = postService.getAllPosts(pageNo,pageSize);
        return postDtos;
    }
}
