package com.backend_reserved.backend_reserved.repositories;

import com.backend_reserved.backend_reserved.entitys.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {
        Optional<Turn> findById(long id);
}
