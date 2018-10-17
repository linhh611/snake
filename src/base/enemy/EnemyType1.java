package base.enemy;

import base.physics.BoxCollider;
import base.renderer.AnimationRenderer;

public class EnemyType1 extends Enemy {
    public EnemyType1(){
        super();
        this.renderer = new AnimationRenderer(
                "assets/images/food.png"
        );
        this.collider = new BoxCollider(28,15);
    }


    public void takeDamage(int damage) {
        if(damage>0){
            this.destroy();
        }
    }
}
