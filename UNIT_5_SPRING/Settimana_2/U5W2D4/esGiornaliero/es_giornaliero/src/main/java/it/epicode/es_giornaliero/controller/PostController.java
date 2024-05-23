package it.epicode.es_giornaliero.controller;



import it.epicode.es_giornaliero.dto.PostDto;
import it.epicode.es_giornaliero.exception.BadRequestException;
import it.epicode.es_giornaliero.exception.PostNonTrovatoException;
import it.epicode.es_giornaliero.model.Post;
import it.epicode.es_giornaliero.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;



    @PostMapping("api/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public String savePost(@RequestBody PostDto postDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }

        return postService.savePost(postDto);
    }

    @GetMapping("api/posts")
    public Page<Post> getPosts(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        return postService.getPosts(page, size, sortBy);
    }

    @GetMapping("api/posts/{id}")
    public Post getPostById(@PathVariable int id) {
        Optional<Post> postOptional = postService.getPostById(id);
        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new PostNonTrovatoException("Post non trovato");
        }
    }

    @PutMapping("/api/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post updatePost(@PathVariable int id, @RequestBody PostDto postDto,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s+s2)));
        }

        return postService.updatePost(id, postDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable int id) {
        return postService.deletePost(id);
    }

}
