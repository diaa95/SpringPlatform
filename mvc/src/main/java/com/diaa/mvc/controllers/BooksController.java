package com.diaa.mvc.controllers;

import com.diaa.mvc.models.Book;
import com.diaa.mvc.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BooksController {

    private final BookService bookService;
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "books/index.jsp";
    }


    @RequestMapping("/books/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "books/show.jsp";
    }


    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "books/add.jsp";
    }


    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String creat(@Valid @ModelAttribute("book") Book book, BindingResult result){
        if (result.hasErrors()){
            return "/books/add.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }


    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }

    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookService.updateBook(id, book.getTitle(), book.getDescription(), book.getLanguage(), book.getNumberOfPages());
            return "redirect:/books";
        }
    }


    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
