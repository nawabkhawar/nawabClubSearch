package com.example.nawabClubSearch.Dao;

import com.example.nawabClubSearch.dto.Highlight;
import com.example.nawabClubSearch.dto.HighlightUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface HighlightUserRepository extends CrudRepository<HighlightUser,Long> {


    public List<HighlightUser> findById(String id);

    public List<HighlightUser> findAll();

}
