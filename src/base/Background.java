package base;

import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public Background( ){
        super();
        this.renderer = new SingleImageRenderer("assets/images/Background.png");
        BufferedImage image = SpriteUtils.loadImage("assets/images/Background.png");
        this.position= new Vector2D(0, -(image.getHeight()- Settings.screen_height));
        this.anohor.set(0,0);
    }





}
