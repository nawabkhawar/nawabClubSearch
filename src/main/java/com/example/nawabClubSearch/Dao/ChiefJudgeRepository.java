package com.example.nawabClubSearch.Dao;

import com.example.nawabClubSearch.dto.ChiefJudge;
import com.example.nawabClubSearch.dto.Judge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ChiefJudgeRepository extends CrudRepository<ChiefJudge,Long> {

    /*@Query("SELECT TOP 1 id FROM Club c where c.club = :clubId")
    public long getByClubId(String clubId);*/

    public List<ChiefJudge> findBychiefjudgeid(long chiefjudgeid);

    public List<ChiefJudge> findBycjsecret(String cjsecret);
    //public Club getByClubId(int id);



    public List<ChiefJudge> findAll();
   /* public Employees getEmployee(){

    }*/
}
