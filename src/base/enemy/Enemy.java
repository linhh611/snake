package base.enemy;

import base.GameObject;
import base.Vector2D;
import base.action.*;
import base.physics.BoxCollider;
import base.physics.Physics;


public class Enemy extends GameObject implements Physics {
    BoxCollider collider;
    Action action;

        public Enemy(){
            super();
            this.position = new Vector2D(200,100);

    }

    public void takeDamage(int damage){

    }



    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
