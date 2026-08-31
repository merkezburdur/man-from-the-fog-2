package net.fabricmc.fogman.world;

import net.fabricmc.fogman.entity.FogManEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class FogManSpawner {
    private static final int MIN_SPAWN_DELAY = 6000; // 5 Dakika
    private static final int MAX_SPAWN_DELAY = 18000; // 15 Dakika
    private static int nextSpawnTimer = MIN_SPAWN_DELAY;

    public static void tick(ServerWorld world, ServerPlayerEntity player) {
        if (world.isNight()) {
            nextSpawnTimer--;

            if (nextSpawnTimer <= 0) {
                spawnBehindPlayer(world, player);
                nextSpawnTimer = MIN_SPAWN_DELAY + world.random.nextInt(MAX_SPAWN_DELAY - MIN_SPAWN_DELAY);
            }
        }
    }

    private static void spawnBehindPlayer(ServerWorld world, ServerPlayerEntity player) {
        Vec3d lookDir = player.getRotationVector();
        Vec3d spawnPosVec = player.getPos().subtract(lookDir.multiply(15.0));
        BlockPos spawnPos = new BlockPos((int) spawnPosVec.x, (int) player.getY(), (int) spawnPosVec.z);

        FogManEntity fogMan = new FogManEntity(null, world);
        fogMan.refreshPositionAndAngles(spawnPos, player.getYaw(), player.getPitch());
        
        if (world.spawnEntity(fogMan)) {
            fogMan.triggerSpawnEffect();
        }
    }
}
