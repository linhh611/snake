package base.renderer;

import base.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleImageRenderer extends Renderer {
    BufferedImage image;
    public SingleImageRenderer(String url){
        this.image = SpriteUtils.loadImage(url);
    }
    public SingleImageRenderer(BufferedImage image){
        this.image = image;
    }
    @Override
    public void render(Graphics g, GameObject master ) {
        double x = master.position.x - image.getWidth() * master.anohor.x;
        double y =  master.position.y - image.getHeight() * master.anohor.y;
        g.drawImage(this.image,(int) x,(int) y, null);
    }
}
