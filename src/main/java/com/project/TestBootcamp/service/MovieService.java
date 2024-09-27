package com.project.TestBootcamp.service;

import com.project.TestBootcamp.dto.MovieRequest;

public interface MovieService {

    String save(MovieRequest request);
    String get(Long id);
}
