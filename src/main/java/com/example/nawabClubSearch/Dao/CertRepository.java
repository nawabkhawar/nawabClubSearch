package com.example.nawabClubSearch.Dao;

import com.example.nawabClubSearch.dto.Club;
import com.example.nawabClubSearch.dto.Cert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CertRepository extends CrudRepository<Cert,Long> {


    public List<Cert> findById(String id);

    public List<Cert> findAll();

}
