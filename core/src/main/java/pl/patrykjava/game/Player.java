package pl.patrykjava.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Player {

    public Vector2 position;
    public Vector2 position_bullet;

    public Sprite sprite;
    public Sprite sprite_bullet;
    public float speed = 300;
    public float speed_bullet = 700;

    public Player(Texture img, Texture bullet) {
        sprite = new Sprite(img);
        sprite.setScale(1);

        // Calculate the position for the middle bottom of the screen
        float x = (Gdx.graphics.getWidth() - sprite.getWidth()) / 2;
        float y = 0;

        // Set the position and origin
        sprite.setPosition(x, y);
        sprite.setOrigin(sprite.getWidth() / 2, 0);

        position = new Vector2(x, y);

        sprite_bullet = new Sprite(bullet);
        sprite_bullet.setScale(4);
        // Set the initial position of the bullet to the top-middle of the ship
        position_bullet = new Vector2(-1000, -1000);
    }

    public void Update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position_bullet.x = position.x + (sprite.getWidth() * sprite.getScaleX() / 2) - 5;
            position_bullet.y = position.y + sprite.getHeight() * sprite.getScaleY();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) position.x -= deltaTime * speed;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) position.x += deltaTime * speed;

        float minX = 0;
        float maxX = Gdx.graphics.getWidth() - sprite.getWidth() * sprite.getScaleX();
        position.x = MathUtils.clamp(position.x, minX, maxX);

        position_bullet.y += deltaTime * speed_bullet;
    }

    public void Draw(SpriteBatch batch) {
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);

        sprite_bullet.setPosition(position_bullet.x, position_bullet.y);
        sprite_bullet.draw(batch);
    }
}

