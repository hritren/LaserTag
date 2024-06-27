package laser.tag.controller;

import laser.tag.game.Game;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest/v1/laser-tag")
public class LaserTagController {

    private Game game;

    LaserTagController() {
        game = new Game();
    }

    @PostMapping
    public void hit(@RequestBody String playerName) {
        game.handleHit(playerName);


    }

}
