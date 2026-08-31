package net.fabricmc.fogman.client;

import net.fabricmc.fogman.entity.FogManEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class FogManModel extends GeoModel<FogManEntity> {
    @Override
    public Identifier getModelResource(FogManEntity animatable) {
        return new Identifier("fogman", "geo/fogman.geo.json");
    }

    @Override
    public Identifier getTextureResource(FogManEntity animatable) {
        return new Identifier("fogman", "textures/entity/fogman.png");
    }

    @Override
    public Identifier getAnimationResource(FogManEntity animatable) {
        return new Identifier("fogman", "animations/fogman.animation.json");
    }
}
