package com.marvin.bundle.game.resources.view.swing.game;

import com.marvin.bundle.swing.resources.view.FormView;
import java.util.HashMap;
import javax.swing.JFrame;

public class Create extends FormView {
    
    public Create(String name) {
        super(name);
    }

    @Override
    protected void prepare(HashMap<String, Object> model, JFrame frame) throws Exception {
        super.prepare(model, frame);
        frame.setSize(500, 500);
    }
}
