package laser.tag.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rest/v1/laser-tag")
public class LaserTagController {

    @PostMapping
    public void printNumber(@RequestBody int number) {
        System.out.println("Received number: " + number);
    }

}
