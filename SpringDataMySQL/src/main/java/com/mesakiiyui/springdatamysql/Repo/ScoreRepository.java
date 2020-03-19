package com.mesakiiyui.springdatamysql.Repo;

import com.mesakiiyui.springdatamysql.Entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
