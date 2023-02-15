package com.example.nawabClubSearch.Dao;

import com.example.nawabClubSearch.dto.Book;
import com.example.nawabClubSearch.dto.Highlight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book,Long> {


    public List<Book> findById(String id);

    public List<Book> findByUserid(long id);

    public List<Book> findAll();

}
