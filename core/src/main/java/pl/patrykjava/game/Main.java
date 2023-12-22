package pl.patrykjava.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Texture bullet;
    Player player;

    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("ship.png");
        bullet = new Texture("fire.png");
        player = new Player(img, bullet);
    }

    @Override
    public void render () {
        float deltaTime = Gdx.graphics.getDeltaTime();

        ScreenUtils.clear(0, 0, 0, 1);

        batch.begin();
        player.Update(deltaTime);
        player.Draw(batch);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}
