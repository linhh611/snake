package game;

import base.KeyEventPress;
import base.Settings;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas;
    public GameWindow(){
        this.setSize(Settings.screen_width, Settings.screen_height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setupEventListener();
        canvas = new GameCanvas();
        this.add(canvas);
        this.setVisible(true);
    }

    private void setupEventListener() {
        this.addKeyListener(new KeyAdapter() {


            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W ){
                    KeyEventPress.isUpPress = true;
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    KeyEventPress.isDownPress = true;
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = true;
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    KeyEventPress.isRightPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W){
                    KeyEventPress.isUpPress = false;
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    KeyEventPress.isDownPress = false;
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = false;
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    KeyEventPress.isRightPress = false;
                }
            }

        });
    }
    public void gameLoop(){
        long delay = 1000/60;
        long lastTime = 0;
        while(true){
            long currentTime = System.currentTimeMillis();
            if(currentTime- lastTime > delay){
                canvas.run(); //runAll()
                canvas.render(); //reder all to backBuffer
                this.repaint(); //reder backBuffer to game
                lastTime = currentTime;
            }

        }
    }
}
