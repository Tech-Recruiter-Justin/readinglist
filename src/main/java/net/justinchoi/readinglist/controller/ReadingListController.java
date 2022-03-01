package net.justinchoi.readinglist.controller;

import net.justinchoi.readinglist.entity.Book;
import net.justinchoi.readinglist.repository.ReadingListRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/")
public class ReadingListController {

    private static final Logger log = LoggerFactory.getLogger(ReadingListController.class);
    private ReadingListRepo readingListRepo;

    @Autowired
    public ReadingListController(ReadingListRepo readingListRepo) {
        this.readingListRepo = readingListRepo;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String allBooks(Model model) {
        log.info("get all books");
        List<Book> searchResult = readingListRepo.findAll();
        if (!searchResult.isEmpty()) model.addAttribute("books", searchResult);
        return "readingList";
    }

    @RequestMapping(value="/getBooksBy/{author}", method = RequestMethod.GET)
    public String booksByAuthor(@PathVariable("author") String author, Model model) {
        log.info("get books by {}", author);
        List<Book> searchResult = readingListRepo.findByAuthor(author);
        if (!searchResult.isEmpty()) model.addAttribute("books", searchResult);
        return "readingList";
    }

    @RequestMapping(value="/createBook", method = RequestMethod.POST)
    public String createBook(Book book) {
        readingListRepo.save(book);
        log.info("book created - id: {}, {} by {}, isbn: {}", book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn());
        return "redirect:/";
    }

}
