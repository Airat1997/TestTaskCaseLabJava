package edu.wilmerbl.repository;

import edu.wilmerbl.models.File64;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends CrudRepository<File64, UUID> {
    Page<File64> findAll(Pageable pageable);
}
