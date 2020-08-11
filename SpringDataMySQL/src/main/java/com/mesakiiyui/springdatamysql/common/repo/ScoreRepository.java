package com.mesakiiyui.springdatamysql.common.repo;

import com.mesakiiyui.springdatamysql.common.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
