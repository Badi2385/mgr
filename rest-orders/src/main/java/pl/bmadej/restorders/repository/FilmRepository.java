package pl.bmadej.restorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bmadej.restorders.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
