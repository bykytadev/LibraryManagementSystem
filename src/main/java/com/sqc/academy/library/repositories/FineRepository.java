package com.sqc.academy.library.repositories;

import com.sqc.academy.library.entities.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long> {

}
