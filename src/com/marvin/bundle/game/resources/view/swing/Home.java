package com.marvin.bundle.game.resources.view.swing;

import com.marvin.bundle.framework.handler.Handler;
import com.marvin.bundle.swing.resources.view.SwingView;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends SwingView {
    
    private JButton play;

    public Home(Handler handler) {
        super(handler);
    }

    @Override
    protected void prepare(HashMap<String, Object> model, JFrame frame) {
        this.play = new JButton(createAction("Play", "/game/games/play", frame));
    }

    @Override
    protected void display(HashMap<String, Object> model, JFrame frame) {
        frame.getContentPane().removeAll();
        add(new JLabel("Welcome in game bundle."));
        add(this.play);
        super.display(model, frame);
    }
}
