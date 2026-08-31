package net.fabricmc.fogman;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fogman.entity.FogManEntity;
import net.fabricmc.fogman.entity.ModEntities;
import net.fabricmc.fogman.sound.ModSounds;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class FogMan implements ModInitializer {
    public static final String MOD_ID = "fogman";
    private int spawnTimer = 0;
    private final Random random = new Random();

    @Override
    public void onInitialize() {
        ModSounds.registerSounds();
        ModEntities.registerModEntities();

        // Yaratık Can ve Saldırı Değerleri
        FabricDefaultAttributeRegistry.register(ModEntities.FOG_MAN, HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0));

        // Gece Doğma Döngüsü (Her 30 saniyede bir kontrol eder)
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            if (!world.isClient() && world instanceof ServerWorld serverWorld) {
                spawnTimer++;
                if (spawnTimer >= 600) { // 600 tick = 30 saniye
                    spawnTimer = 0;
                    if (serverWorld.isNight()) {
                        serverWorld.getPlayers().forEach(player -> {
                            if (random.nextInt(100) < 50) { // %50 doğma şansı
                                BlockPos pos = player.getBlockPos().add(
                                        random.nextInt(20) - 10, 
                                        0, 
                                        random.nextInt(20) - 10
                                );
                                FogManEntity entity = ModEntities.FOG_MAN.create(serverWorld);
                                if (entity != null) {
                                    entity.refreshPositionAndAngles(pos, 0, 0);
                                    serverWorld.spawnEntity(entity);
                                    entity.triggerSpawnEffect();
                                }
                            }
                        });
                    }
                }
            }
        });
