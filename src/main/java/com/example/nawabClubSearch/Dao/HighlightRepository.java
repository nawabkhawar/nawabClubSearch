package com.example.nawabClubSearch.Dao;

import com.example.nawabClubSearch.dto.Cert;
import com.example.nawabClubSearch.dto.Highlight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface HighlightRepository extends CrudRepository<Highlight,Long> {


    public List<Highlight> findById(String id);

    public List<Highlight> findByBookid(long id);

    public List<Highlight> findAll();



}
