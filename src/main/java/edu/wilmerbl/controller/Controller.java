package edu.wilmerbl.controller;

import edu.wilmerbl.models.File64;
import edu.wilmerbl.repository.FileRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/file")
public class Controller {

    @Autowired
    private final FileRepository fileRepository;

    public Controller(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<File64> getProductById(@PathVariable("id") File64 file64) {
        return new ResponseEntity<>(file64, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Iterable<File64>> getFiles() {
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity<UUID> postFile64(@RequestBody File64 file64) {
        fileRepository.save(file64);
        return new ResponseEntity<>(file64.getId(), HttpStatus.CREATED);
    }

}
