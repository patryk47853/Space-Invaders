package pl.patrykjava.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Alien {

    public Vector2 position;
    public boolean alive = true;
    public Sprite sprite;

    public Alien(Vector2 position, Texture img) {
        this.position = position;
        sprite = new Sprite(img);
        sprite.setScale(4);
    }

    public void Draw(SpriteBatch batch) {
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
}
