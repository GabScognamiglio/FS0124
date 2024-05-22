package it.epicode.es_giornaliero.controller;


import it.epicode.es_giornaliero.exception.PostNonTrovatoException;
import it.epicode.es_giornaliero.model.Post;
import it.epicode.es_giornaliero.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("api/blogPosts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("api/blogPosts/{id}")
    public Post getPostById(@PathVariable int id) throws PostNonTrovatoException {
        Optional<Post> postOptional = postService.getPostById(id);
        if (postOptional.isPresent()){
            return postOptional.get();
        }
        else {
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

    @PostMapping("api/blogPosts")
    public String savePost(@RequestBody Post post){
        return postService.savePost(post);
    }

    @PutMapping("api/blogPosts/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody Post post) throws PostNonTrovatoException{
        return postService.updatePost(id, post);
    }

    @DeleteMapping("api/blogPosts/{id}")
    public String deletePost(@PathVariable int id) throws PostNonTrovatoException{
        return postService.deletePost(id);
    }

}
