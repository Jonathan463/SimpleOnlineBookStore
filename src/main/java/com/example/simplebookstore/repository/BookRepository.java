package com.example.simplebookstore.repository;

import com.example.simplebookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "select * from book where del_flag = false", nativeQuery = true)
    public List<Book> findAllBook();

    @Query(value = "select * from book where id =?1 and del_flag = false",nativeQuery = true)
    Optional<Book> findById(Long id);
}
