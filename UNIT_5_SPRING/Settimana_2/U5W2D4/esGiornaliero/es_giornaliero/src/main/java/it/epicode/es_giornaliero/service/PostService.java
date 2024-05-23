package it.epicode.es_giornaliero.service;

import it.epicode.es_giornaliero.dto.PostDto;
import it.epicode.es_giornaliero.exception.AutoreNonTrovatoException;
import it.epicode.es_giornaliero.exception.PostNonTrovatoException;
import it.epicode.es_giornaliero.model.Autore;
import it.epicode.es_giornaliero.model.Post;
import it.epicode.es_giornaliero.repository.AutoreRepository;
import it.epicode.es_giornaliero.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    public String savePost(PostDto postDto) {
        Post post = new Post();
        post.setCategoria(postDto.getCategoria());
        post.setTitolo(postDto.getTitolo());
        post.setContenuto(postDto.getContenuto());
        post.setCover(postDto.getCover());
        post.setTempoDiLettura(postDto.getTempoDiLettura());

        Optional<Autore> autoreOptional = autoreRepository.findById(postDto.getAutoreId());

        if (autoreOptional.isPresent()) {
            Autore autore = autoreOptional.get();
            post.setAutore(autore);
            postRepository.save(post);
            return "Post con ID " + post.getId() + " creato con successo.";
        }
        else {
            throw new PostNonTrovatoException("Autore con ID " + postDto.getAutoreId() + " non trovato.");
        }
    }

    public Page<Post> getPosts(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return postRepository.findAll(pageable);
    }

    public Optional<Post> getPostById(int id) {
        return postRepository.findById(id);
    }


    public Post updatePost(int id, PostDto postDto) {
        Optional<Post> postOptional = getPostById(id);

        if (postOptional.isPresent()) {
            Post post = postOptional.get();

            post.setTitolo(postDto.getTitolo());
            post.setContenuto(postDto.getContenuto());
            post.setCover(postDto.getCover());
            post.setCategoria(postDto.getCategoria());
            post.setTempoDiLettura(postDto.getTempoDiLettura());

            Optional<Autore> autoreOptional = autoreRepository.findById(postDto.getAutoreId());

            if (autoreOptional.isPresent()) {
                Autore autore = autoreOptional.get();
                post.setAutore(autore);
                postRepository.save(post);
                return post;
            } else {
                throw new AutoreNonTrovatoException("Autore con id: " + postDto.getAutoreId() + " non trovato");
            }
        }
        else {
            throw new PostNonTrovatoException("Post con id " + id + " non trovato");
        }
    }

    public String deletePost (int id) {
        Optional<Post> studenteOptional = getPostById(id);

        if (studenteOptional.isPresent()) {
            postRepository.delete(studenteOptional.get());
            return "Post con id" + id + " eliminato con successo.";
        }
        else {
            throw new PostNonTrovatoException("Post con id " + id + " non trovato");
        }
    }
}
