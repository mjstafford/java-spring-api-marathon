package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.repositories.SongRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService {
  private SongRepository songRepository;

  @Autowired
  public SongService(SongRepository songRepository){
    this.songRepository = songRepository;
  }

  //methods go here
  public Iterable<Song> findAll(Pageable pageable) {
    return songRepository.findAll(pageable);
  }

  public Song save(Song song) {
    return songRepository.save(song);
  }

  public Optional<Song> findById(Integer id) {
    return songRepository.findById(id);
  }

}
