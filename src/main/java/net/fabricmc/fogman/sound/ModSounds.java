package net.fabricmc.fogman.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final Identifier ARRIVE_ID = new Identifier("fogman", "entity.fogman.arrive");
    public static final SoundEvent ARRIVE = SoundEvent.of(ARRIVE_ID);

    public static final Identifier DISABLE_ID = new Identifier("fogman", "entity.fogman.disable");
    public static final SoundEvent DISABLE = SoundEvent.of(DISABLE_ID);

    public static void registerSounds() {
        Registry.register(Registries.SOUND_EVENT, ARRIVE_ID, ARRIVE);
        Registry.register(Registries.SOUND_EVENT, DISABLE_ID, DISABLE);
    }
}
