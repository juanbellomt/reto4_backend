package usa.ciclo3.reto4.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usa.ciclo3.reto4.model.Farm;
import usa.ciclo3.reto4.service.FarmService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class FarmController {

    @Autowired
    private FarmService farmService;
    @GetMapping("/all")
    public List<Farm> getFarms() {
        return farmService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Farm> getFarm(@PathVariable("id") int idFarm) {
        return farmService.getFarm(idFarm);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm f) {
        return farmService.save(f);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm update(@RequestBody Farm f) {
        return farmService.update(f);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int farmId) {
        return farmService.delete(farmId);
    }

}
