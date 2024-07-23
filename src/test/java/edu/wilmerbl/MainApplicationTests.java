package edu.wilmerbl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wilmerbl.models.File64;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
@Disabled
class MainApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    String uuidString = "0bc1978c-a219-4ccc-adfc-3157910002df";
    UUID uuid = UUID.fromString(uuidString);

    @Test
    public void testPost() throws Exception {
        File64 file64 = new File64(uuid, "test", new Date(), "test");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(file64);
        mockMvc.perform(post("/file").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
    }
@Test
public void testGetFiles() throws Exception{
    mockMvc.perform(get("/file"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(
                    MediaType.APPLICATION_JSON));
}
    @Test
    public void testGetById() throws Exception {
        mockMvc.perform(get("/file/{id}", "123e4567-e89b-12d3-a456-426614174000"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(
                        MediaType.APPLICATION_JSON));
    }

}
