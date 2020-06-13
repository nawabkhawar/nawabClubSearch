package com.example.nawabClubSearch.Dao;

import com.example.nawabClubSearch.dto.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ClubRepository extends CrudRepository<Club,Long> {

    /*@Query("SELECT TOP 1 id FROM Club c where c.club = :clubId")
    public long getByClubId(String clubId);*/

    public List<Club> findByClub(String clubId);
    //public Club getByClubId(int id);


   /* public Employees getEmployee(){

    }*/
}
