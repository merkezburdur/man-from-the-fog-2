package net.fabricmc.fogman;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fogman.client.FogManRenderer;
import net.fabricmc.fogman.entity.ModEntities;

public class FogManClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.FOG_MAN, FogManRenderer::new);
    }
}
