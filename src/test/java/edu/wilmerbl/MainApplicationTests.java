package edu.wilmerbl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import edu.wilmerbl.models.File64;
import edu.wilmerbl.repository.FileRepository;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class MainApplicationTests {

    @Autowired
    private FileRepository fileRepository;
    String uuidString = "0bc1978c-a229-4ccc-adfc-3157910002df";
    UUID uuid = UUID.fromString(uuidString);

    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Test
    void getProductById() throws Exception {
        fileRepository.save(new File64(uuid, "text", new Date(), "text"));
        assertNotNull(fileRepository.findById(uuid));
    }

//    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//    @Test
//    void getProductById() throws Exception {
//        fileRepository.save(new File64(uuid, "text", new Date(), "text"));
//        assertNotNull(fileRepository.findById(uuid));
//    }


}
