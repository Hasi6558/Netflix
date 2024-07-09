package com.example.User_Management_Netflx.repo;

import com.example.User_Management_Netflx.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContentRepo extends JpaRepository<Content,Integer> {
//SELECT * FROM dbnetflix.content WHERE title LIKE '%ghost%' OR SOUNDEX(title) = SOUNDEX('ghost');
    @Query(value = "SELECT * FROM Content WHERE title LIKE CONCAT('%', ?1, '%') OR SOUNDEX(title) = SOUNDEX(?1)",nativeQuery = true)
    List<Content> getContentsByTitle(String heading);
    @Query(value = "SELECT * FROM Content WHERE ID=?1",nativeQuery = true)
    Content getContentById(String contentId);
}
