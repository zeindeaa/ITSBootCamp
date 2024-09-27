package com.project.TestBootcamp.service.Impl;

import com.project.TestBootcamp.dto.MovieRequest;
import com.project.TestBootcamp.entity.Movie;
import com.project.TestBootcamp.repository.MovieRepository;
import com.project.TestBootcamp.service.MovieService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    @Override
    public String save(MovieRequest request){
        saveToDB(request);

        return "success";
    }
    @Override
    public String get(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);

        if(movie.isPresent()){
            return "success";
        } else {
            return "Data not found";
        }
    }

    private void saveToDB(MovieRequest request){
        Movie movie = new Movie();

        movie.setRating(request.getRating());
        movie.setDuration(request.getDuration());
        movie.setGenre(request.getGenre());
        movie.setTitle(request.getTitle());
        movie.setDirector(request.getDirector());

        movieRepository.save(movie);
    }
}

