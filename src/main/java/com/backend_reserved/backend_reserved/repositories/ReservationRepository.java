package com.backend_reserved.backend_reserved.repositories;

import com.backend_reserved.backend_reserved.entitys.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findById(long id);

    Optional<Reservation> findByLocator(String locator);

    @Modifying
    @Transactional
    Optional<Reservation> deleteByLocator(String locator);

    Optional<Reservation> existsById(String locator);
}
