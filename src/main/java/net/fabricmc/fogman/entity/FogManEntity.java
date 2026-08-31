package net.fabricmc.fogman.entity;

import net.fabricmc.fogman.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class FogManEntity extends HostileEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public FogManEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    public void triggerSpawnEffect() {
        this.getWorld().playSound(
            null, 
            this.getBlockPos(), 
            ModSounds.ARRIVE, 
            SoundCategory.HOSTILE, 
            2.0F, 1.0F
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, event -> {
            if (event.isMoving()) {
                return event.setAndContinue(RawAnimation.begin().thenLoop("animation.fogman.run"));
            }
            return event.setAndContinue(RawAnimation.begin().thenLoop("animation.fogman.idle"));
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
