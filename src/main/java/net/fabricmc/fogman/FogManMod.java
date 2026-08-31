package net.fabricmc.fogman;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fogman.sound.ModSounds;
import net.fabricmc.fogman.world.FogManSpawner;

public class FogManMod implements ModInitializer {
    public static final String MOD_ID = "fogman";

    @Override
    public void onInitialize() {
        ModSounds.registerSounds();

        ServerTickEvents.END_WORLD_TICK.register(world -> {
            world.getPlayers().forEach(player -> FogManSpawner.tick(world, player));
        });
    }
}
