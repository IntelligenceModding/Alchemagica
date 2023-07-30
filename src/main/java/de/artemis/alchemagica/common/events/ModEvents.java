package de.artemis.alchemagica.common.events;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.client.particle.ArcaneGlintParticle;
import de.artemis.alchemagica.common.containers.screens.CentrifugeScreen;
import de.artemis.alchemagica.common.containers.screens.MortarAndPestleScreen;
import de.artemis.alchemagica.common.registration.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Alchemagica.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.MORTAR_AND_PESTLE_MENU.get(), MortarAndPestleScreen::new);
        MenuScreens.register(ModMenuTypes.CENTRIFUGE_MENU.get(), CentrifugeScreen::new);

        WoodType.register(ModWoodTypes.ARCANE);

        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ARCANE_SAPLING.getId(), ModBlocks.POTTED_ARCANE_SAPLING);

        Sheets.addWoodType(ModWoodTypes.ARCANE);
    }

    @SubscribeEvent
    public static void registerParticleProvidersEvent(final RegisterParticleProvidersEvent event) {
        event.register(ModParticles.ARCANE_GLINT_PARTICLE.get(), ArcaneGlintParticle.Provider::new);
    }
}
