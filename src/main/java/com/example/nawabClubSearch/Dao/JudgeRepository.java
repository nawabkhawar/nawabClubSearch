package com.example.nawabClubSearch.Dao;

import com.example.nawabClubSearch.dto.Event;
import com.example.nawabClubSearch.dto.Judge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface JudgeRepository extends CrudRepository<Judge,Long> {

    /*@Query("SELECT TOP 1 id FROM Club c where c.club = :clubId")
    public long getByClubId(String clubId);*/

    public List<Judge> findByjudgeid(long judgeid);

    public List<Judge> findBychiefjudgeid(long chiefjudgeid);

    public List<Judge> findByjsecret(String jsecret);
    //public Club getByClubId(int id);



    public List<Judge> findAll();
   /* public Employees getEmployee(){

    }*/
}
