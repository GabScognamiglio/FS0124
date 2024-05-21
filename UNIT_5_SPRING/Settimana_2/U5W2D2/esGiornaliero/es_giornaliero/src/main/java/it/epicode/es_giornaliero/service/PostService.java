package it.epicode.es_giornaliero.service;

import it.epicode.es_giornaliero.exception.PostNonTrovatoException;
import it.epicode.es_giornaliero.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    private List<Post> posts = new ArrayList<>();

    public List<Post> getAllPosts() {
        return posts;
    }

    public Optional<Post> getPostById(int id) {
        return posts.stream().filter(s -> s.getId() == id).findFirst();
    }

    public String savePost(Post post) {
        posts.add(post);
        return "Post creato con questa id: " + post.getId();
    }

    public Post updatePost(int matricola, Post postUpdate) throws PostNonTrovatoException {
        Optional<Post> postOpt = getPostById(matricola);

        if (postOpt.isPresent()) {
            Post post = postOpt.get();
            post.setCategoria(postUpdate.getCategoria());
            post.setTitolo(postUpdate.getTitolo());
            post.setTempoDiLettura(postUpdate.getTempoDiLettura());
            return post;
        }
        else {
            throw new PostNonTrovatoException("Post non trovato") ;
        }
    }

    public String deletePost (int id) throws PostNonTrovatoException {
        Optional<Post> postOpt = getPostById(id);

        if (postOpt.isPresent()) {
            posts.remove(postOpt.get());
            return "Post eliminato";
        }
        else {
            throw new PostNonTrovatoException("Post non trovato") ;
        }
    }
}
