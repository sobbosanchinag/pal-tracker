package io.pivotal.pal.tracker.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EnvControllerTest {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testImplementation() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://localhost:"+randomServerPort+"/env";
        Map<String, String> env = new HashMap<>();
        env.put("PORT", "NOT SET");
        env.put("MEMORY_LIMIT", "NOT SET");
        env.put("CF_INSTANCE_INDEX", "NOT SET");
        env.put("CF_INSTANCE_ADDR", "NOT SET");
        env.put("WELCOME_MESSAGE","Hello from test");
        ResponseEntity<Map> response = restTemplate.getForEntity(new URL(baseUrl).toString(), Map.class);
        assertEquals(env,response.getBody());
    }
}