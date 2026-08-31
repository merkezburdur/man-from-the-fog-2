package net.fabricmc.fogman.client;

import net.fabricmc.fogman.entity.FogManEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FogManRenderer extends GeoEntityRenderer<FogManEntity> {
    public FogManRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new FogManModel());
    }
}
