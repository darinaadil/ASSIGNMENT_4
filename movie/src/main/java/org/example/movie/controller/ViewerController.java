package org.example.movie.controller;

import org.example.movie.model.Viewer;
import org.example.movie.repository.ViewerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viewers")
public class ViewerController {
    private final ViewerRepository viewerRepository;

    public ViewerController(ViewerRepository viewerRepository) {
        this.viewerRepository = viewerRepository;
    }

    @GetMapping
    public List<Viewer> getAllViewers() {
        return viewerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Viewer getViewerById(@PathVariable Long id) {
        return viewerRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Viewer createViewer(@RequestBody Viewer viewer) {
        return viewerRepository.save(viewer);
    }
}
