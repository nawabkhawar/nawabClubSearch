package com.example.nawabClubSearch.Dao;

import com.example.nawabClubSearch.dto.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClubRepository extends JpaRepository<Club,Long> {



   /* public Employees getEmployee(){

    }*/
}
