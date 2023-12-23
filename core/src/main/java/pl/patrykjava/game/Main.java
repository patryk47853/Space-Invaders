package pl.patrykjava.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture bullet;
    Texture alien;
    Player player;
    Alien[] aliens;
    int widthOfAliens = 11;
    int heightOfAliens = 5;
    int spacingAliens = 40;

    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("ship.png");
        bullet = new Texture("fire.png");
        alien = new Texture("alien.png");
        player = new Player(img, bullet);
        aliens = new Alien[widthOfAliens * heightOfAliens];

        int i = 0;

        for (int y = 0; y < heightOfAliens; y++) {
            for (int x = 0; x < widthOfAliens; x++) {
                Vector2 position = new Vector2(x * spacingAliens, y * spacingAliens);
                position.x += Gdx.graphics.getWidth() / 2 - (widthOfAliens / 2);  // Adjusted to be more to the left
                position.y += Gdx.graphics.getHeight() - heightOfAliens;
                position.x -= (widthOfAliens / 2) + 200;
                position.y -= (heightOfAliens) * spacingAliens;
                aliens[i] = new Alien(position, alien);
                i++;
            }
        }
    }

    @Override
    public void render () {
        float deltaTime = Gdx.graphics.getDeltaTime();

        ScreenUtils.clear(0, 0, 0, 1);

        batch.begin();
        player.Update(deltaTime);
        player.Draw(batch);

        for (int i = 0; i < aliens.length; i++) {
            aliens[i].Draw(batch);
        }
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}
