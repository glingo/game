package com.marvin.bundle.game.business;

import com.marvin.bundle.game.model.Game;
import com.marvin.bundle.game.repository.GameRepository;
import java.util.List;

public class GameManager {
    
    private final GameRepository repository;
    
    public GameManager(GameRepository repository) {
        this.repository = repository;
    }
    
    public Game save(Game game) {
        assert game != null;
        
        return this.repository.save(game);
    }
    
    public List<Game> getAll() {
        return this.repository.findAll();
    }
}
