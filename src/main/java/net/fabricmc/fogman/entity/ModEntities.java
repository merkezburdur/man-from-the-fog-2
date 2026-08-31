package net.fabricmc.fogman.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<FogManEntity> FOG_MAN = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("fogman", "fog_man"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FogManEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.95F))
                    .build()
    );

    // Spawn Yumurtası Eşyası
    public static final Item FOG_MAN_SPAWN_EGG = Registry.register(
            Registries.ITEM,
            new Identifier("fogman", "fog_man_spawn_egg"),
            new SpawnEggItem(FOG_MAN, 0x1a1a1a, 0x990000, new Item.Settings())
    );

    public static void registerModEntities() {
        // Kayıt tetikleme
    }
}
