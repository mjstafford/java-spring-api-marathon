package com.launchacademy.marathon.controllers.api;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.services.SongService;
import java.util.HashMap;
import java.util.Map;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/songs")
public class SongApiV1Controller {
  private SongService songService;

  @Autowired
  public SongApiV1Controller(SongService songService){
    this.songService = songService;
  }

  @GetMapping
  public Map<String, Iterable<Song>> getSongsApi(Pageable pageable){
    Map<String, Iterable<Song>> songs = new HashMap<>();
    songs.put("songs", songService.findAll(pageable));
    return songs;
  }

  @GetMapping("/{id}")
  public Map<String, Song> getSongApi(@PathVariable Integer id){
    Map<String, Song> song = new HashMap<>();
    Song mySong = songService.findById(id).orElseThrow(() -> new SongNotFoundException());
    song.put("song", mySong);
    return song;
  }

  @PostMapping
  public Song create(@RequestBody Song song) {
    return songService.save(song);
  }
// curl -X POST localhost:8080/api/v1/songs -H 'Content-type:application/json' -d '{"title": "Hello", "genre": "Pop", "releaseYear": "2015", "explicitContent": "false", "mediaType": "text"}'


  //Error handling for Optional return
  @NoArgsConstructor
  private class SongNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class SongNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SongNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String songNotFoundHandler(SongNotFoundException ex) {
      return ex.getMessage();
    }
  }
}
