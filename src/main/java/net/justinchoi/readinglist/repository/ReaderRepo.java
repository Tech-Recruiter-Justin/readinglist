package net.justinchoi.readinglist.repository;

import net.justinchoi.readinglist.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepo extends JpaRepository<Reader, String> {

    Reader findByUsername(String username);

}
