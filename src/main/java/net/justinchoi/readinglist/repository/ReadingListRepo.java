package net.justinchoi.readinglist.repository;

import net.justinchoi.readinglist.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepo extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

}
