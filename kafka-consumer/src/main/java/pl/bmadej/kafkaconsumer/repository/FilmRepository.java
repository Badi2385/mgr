package pl.bmadej.kafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bmadej.kafkaconsumer.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
