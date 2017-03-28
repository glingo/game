package com.marvin.bundle.game.repository;

import com.marvin.bundle.game.model.Game;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    
    private final List<Game> games = new ArrayList<>();
    
    public GameRepository() {
    }
    
    public Game save(Game game) {
        this.games.add(game);
        return game;
    }
    
    public List<Game> findAll(){
        return this.games;
    }
}
