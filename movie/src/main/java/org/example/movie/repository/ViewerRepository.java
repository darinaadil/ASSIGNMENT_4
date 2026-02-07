package org.example.movie.repository;

import org.example.movie.model.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Long> {
    Optional<Viewer> findByName(String name);
}
