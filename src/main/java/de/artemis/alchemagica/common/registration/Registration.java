package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.world.feature.ModConfiguredFeatures;
import de.artemis.alchemagica.common.world.feature.ModPlacedFeatures;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Alchemagica.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Alchemagica.MOD_ID);
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Alchemagica.MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Alchemagica.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Alchemagica.MOD_ID);
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Alchemagica.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Alchemagica.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Alchemagica.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Alchemagica.MOD_ID);

    public static void register() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        CONFIGURED_FEATURES.register(eventBus);
        PLACED_FEATURES.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
        MENUS.register(eventBus);
        RECIPE_SERIALIZERS.register(eventBus);
        RECIPE_TYPES.register(eventBus);
        PARTICLE_TYPES.register(eventBus);

        ModBlocks.register();
        ModItems.register();
        ModConfiguredFeatures.register();
        ModPlacedFeatures.register();
        ModBlockEntities.register();
        ModMenuTypes.register();
        ModRecipes.register();
        ModParticles.register();
    }
}
