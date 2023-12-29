package dev.efrxngg.geoproject;

import dev.efrxngg.geoproject.model.Coordinate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.http.ResponseEntity.ok;

@SpringBootApplication
@RestController()
@RequestMapping("/coordinates")
@CrossOrigin(value = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class GeoprojectApplication {

    private final Set<Coordinate> cache = new HashSet<>();

    public static void main(String[] args) {
        SpringApplication.run(GeoprojectApplication.class, args);
    }

    @PostMapping
    public ResponseEntity<Coordinate> notifyPosition(@RequestBody Coordinate coordinate) {
        cache.add(coordinate);
        return ok().body(coordinate);
    }

    @GetMapping
    public ResponseEntity<List<String>> getPositions() {
        var result = cache.stream()
                .distinct()
                .map(c -> "%s,%s".formatted(c.getLatitude(), c.getLongitude()))
                .toList();
        return ok().body(result);
    }

}
