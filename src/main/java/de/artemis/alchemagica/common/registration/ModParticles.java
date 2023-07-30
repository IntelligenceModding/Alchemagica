package de.artemis.alchemagica.common.registration;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.RegistryObject;

import static de.artemis.alchemagica.common.registration.Registration.PARTICLE_TYPES;

public class ModParticles {

    public static final RegistryObject<SimpleParticleType> ARCANE_GLINT_PARTICLE =
            PARTICLE_TYPES.register("arcane_glint_particle", () -> new SimpleParticleType(true));

    public static void register() {
    }
}
