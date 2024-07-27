package com.example.User_Management_Netflx.repo;

import com.example.User_Management_Netflx.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Reviews, Integer> {
    @Query(value = "SELECT * FROM reviews WHERE movie_id=?1",nativeQuery = true)
    List<Reviews> findAllByMovieId(int movieId);
}
