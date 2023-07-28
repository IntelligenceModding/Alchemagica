package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.common.blockentities.CentrifugeBlockEntity;
import de.artemis.alchemagica.common.blockentities.MortarAndPestleBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final RegistryObject<BlockEntityType<MortarAndPestleBlockEntity>> MORTAR_AND_PESTLE =
            Registration.BLOCK_ENTITIES.register("mortar_and_pestle",
                    () -> BlockEntityType.Builder.of(MortarAndPestleBlockEntity::new,
                            ModBlocks.MORTAR_AND_PESTLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<CentrifugeBlockEntity>> CENTRIFUGE =
            Registration.BLOCK_ENTITIES.register("centrifuge",
                    () -> BlockEntityType.Builder.of(CentrifugeBlockEntity::new,
                            ModBlocks.CENTRIFUGE.get()).build(null));

    public static void register() {
    }
}
