package com.diaa.lookify.controllers;


import com.diaa.lookify.models.Song;
import com.diaa.lookify.services.SongService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService){
        this.songService = songService;
    }

    @RequestMapping("/")
    public String index(){
        return "songs/index.jsp";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model, @ModelAttribute("artist") String artist){
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "songs/dashboard.jsp";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model, @RequestParam("artist") String artist){
        List<Song> songs = songService.search(artist);
        model.addAttribute("songs", songs);
        model.addAttribute("artist",artist);
        return "songs/artist.jsp";
    }

    @RequestMapping("/songs/new")
    public String newBook(@ModelAttribute("song") Song song){
        return "songs/add.jsp";
    }

    @RequestMapping(value = "/songs", method = RequestMethod.POST)
    public String creat(@Valid @ModelAttribute("song") Song song, BindingResult result){
        if (result.hasErrors()){
            return "/songs/add.jsp";
        } else {
            songService.addSong(song);
            return "redirect:/dashboard";
        }
    }

    @RequestMapping("/songs/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "songs/show.jsp";
    }

    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }

    @RequestMapping("/search/topTen")
    public String topTen(Model model){
        List<Song> topTen = songService.topTen();
        model.addAttribute("songs", topTen);
        return "songs/topTen.jsp";
    }
}
