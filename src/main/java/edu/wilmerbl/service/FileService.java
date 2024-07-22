package edu.wilmerbl.service;

import edu.wilmerbl.repository.FileRepository;

public class FileService {
private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
}
