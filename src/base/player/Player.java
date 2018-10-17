package base.player;

import base.GameObject;
import base.KeyEventPress;
import base.Settings;
import base.Vector2D;
import base.counter.FrameCounter;
import base.enemy.Enemy;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    BoxCollider collider;
    Vector2D velocity;
    int damage;
    public Player(){
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/snake.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.start_player_position_X
                , Settings.start_player_position_Y);
        this.collider = new BoxCollider(40, 30);
        this.velocity = new Vector2D(0,0);
        this.damage=1;
    }
    @Override
    public void run() {
        if(KeyEventPress.isUpPress) {
            this.move(0, -1);
        }
        if(KeyEventPress.isDownPress) {
            this.move(0, 1);
        }
        if(KeyEventPress.isRightPress) {
            this.move(1, 0);
        }
        if(KeyEventPress.isLeftPress) {
            this.move(-1, 0);
        }
        this.position.addThis(this.velocity);
        Enemy enemy = GameObject.intersect(Enemy.class, this);
        if(enemy!= null){
            enemy.takeDamage(this.damage);

            return;
        }
        if(this.position.y<0){
            this.destroy();
            return;
        }
    }

    public void move(int velocityX, int velocityY) {
        this.velocity.addThis(velocityX, velocityY);
        this.velocity.set(clamp((int) velocity.x, -5, 5), clamp((int) velocity.y, -5,5));

    }

    public float clamp(int number, float min, float max){
        return number< min? min:number>max?max:number;

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
