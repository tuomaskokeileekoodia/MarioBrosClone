package com.tuomaslahti.mariobros.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.tuomaslahti.mariobros.MarioBros;
import com.tuomaslahti.mariobros.Scenes.Hud;


public class Coin extends InteractiveTileObject{
    private static TiledMapTileSet tileset;
    private final int BLANK_COIN = 28;
    public Coin(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        tileset = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin", "Collision");
        getCell().setTile(tileset.getTile(BLANK_COIN));
        Hud.addScore(100);
    }
}
