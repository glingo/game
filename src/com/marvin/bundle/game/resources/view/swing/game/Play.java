package com.marvin.bundle.game.resources.view.swing.game;

import com.marvin.bundle.framework.handler.Handler;
import com.marvin.bundle.swing.resources.view.SwingView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Play extends SwingView {

    private Canvas canvas;

    public Play(Handler handler) {
        super(handler);
    }

    @Override
    protected void prepare(HashMap<String, Object> model, JFrame frame) {
        this.canvas = new Canvas();
    }

    @Override
    protected void display(HashMap<String, Object> model, JFrame frame) {
        frame.getContentPane().removeAll();
        add(this.canvas);
        super.display(model, frame);
    }

    private static class Canvas extends JPanel {

        private int squareX = 50;
        private int squareY = 50;
        private int squareW = 20;
        private int squareH = 20;

        public Canvas() {
            setBorder(BorderFactory.createLineBorder(Color.black));

            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    moveSquare(e.getX(), e.getY());
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent e) {
                    moveSquare(e.getX(), e.getY());
                }
            });

        }

        private void moveSquare(int x, int y) {
            int OFFSET = 1;
            if ((squareX != x) || (squareY != y)) {
                repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
                squareX = x;
                squareY = y;
                repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(250, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("This is my custom Panel!", 10, 20);
            g.setColor(Color.RED);
            g.fillRect(squareX, squareY, squareW, squareH);
            g.setColor(Color.BLACK);
            g.drawRect(squareX, squareY, squareW, squareH);
        }
    }
}
