package com.launchacademy.marathon.repositories;

import com.launchacademy.marathon.models.Song;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends PagingAndSortingRepository<Song, Integer> {
  //additional methods can go here
}
