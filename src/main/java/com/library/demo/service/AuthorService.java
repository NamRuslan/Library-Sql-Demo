package com.library.demo.service;

import com.library.demo.entity.AuthorEntity;
import com.library.demo.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepo authorRepo;

    @Autowired
    public void setAuthorRepo(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void add(AuthorEntity authorEntity) {
        authorRepo.save(authorEntity);
    }

    public void delete(int id) {
        authorRepo.deleteById(id);
    }

    public List<AuthorEntity> getAll() {
        return authorRepo.findAll();
    }

    public void addAll(List<AuthorEntity> list) {
        authorRepo.saveAll(list);
    }

    public List<String> getAllAuthorsAndTheirBooks(){
        return authorRepo.findAllBooksByAuthor();
    }

    public String findAuthorMostBookCount() {
        return authorRepo.findAuthorWithMostBookCount();
    }
}
