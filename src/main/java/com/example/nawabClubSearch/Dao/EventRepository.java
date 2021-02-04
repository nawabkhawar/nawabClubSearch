package com.example.nawabClubSearch.Dao;

import com.example.nawabClubSearch.dto.Club;
import com.example.nawabClubSearch.dto.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EventRepository extends CrudRepository<Event,Long> {

    /*@Query("SELECT TOP 1 id FROM Club c where c.club = :clubId")
    public long getByClubId(String clubId);*/

    public List<Event> findByeventid(long eventId);
    //public Club getByClubId(int id);



    public List<Event> findAll();
   /* public Employees getEmployee(){

    }*/
}
