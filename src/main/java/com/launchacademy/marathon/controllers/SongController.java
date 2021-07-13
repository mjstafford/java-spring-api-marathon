package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.services.SongService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongController {
  private SongService songService;

  @Autowired
  public SongController(SongService songService){
    this.songService = songService;
  }

  @GetMapping
  public String getSongs(Model model, Pageable pageable){
    model.addAttribute("songs", songService.findAll(pageable));
    return "songs/index";
  }

  @GetMapping("/new")
  public String getForm(@ModelAttribute("song") Song song){
    return "songs/new";
  }

  @PostMapping
  public String createSong(@ModelAttribute @Valid Song song, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
      return "songs/new";
    } else {
      try {
        songService.save(song);
        return "redirect:/songs";
      } catch (Exception exception) {
        exception.printStackTrace();
        return "songs/new";
      }
    }
  }
}
