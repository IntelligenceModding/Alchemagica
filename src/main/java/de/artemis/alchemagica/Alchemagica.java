package de.artemis.alchemagica;

import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.registration.Registration;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

@Mod(Alchemagica.MOD_ID)
public class Alchemagica {

    public static final String MOD_ID = "alchemagica";
    public static final CreativeModeTab INVENTORY_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.ARCANE_BLOSSOM_PETAL.get());
        }

        @Override
        public void fillItemList(@NotNull NonNullList<ItemStack> items) {
            ArrayList<Item> blockList = new ArrayList<>();
            Collections.addAll(blockList, ModItems.ARCANE_PICKAXE.get(), ModItems.ARCANE_SHEARS.get(), ModItems.ARCANE_HOE.get(), ModItems.ARCANE_AXE.get(), ModBlocks.MORTAR_AND_PESTLE.get().asItem(), ModBlocks.CENTRIFUGE.get().asItem(), ModBlocks.ARCANE_SOIL.get().asItem(), ModItems.ARCANE_BLOSSOM_SEED.get(), ModItems.ARCANE_BLOSSOM_PETAL.get(), ModItems.CRUSHED_ARCANE_BLOSSOM_PETAL.get(), ModItems.ARCANE_BLOSSOM_EXTRACT.get(), ModItems.ARCANE_STICK.get(), ModBlocks.ARCANE_CRYSTAL_BLOCK.get().asItem(), ModBlocks.BUDDING_ARCANE_CRYSTAL.get().asItem(), ModBlocks.ARCANE_CRYSTAL_CLUSTER.get().asItem(), ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get().asItem(), ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get().asItem(), ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get().asItem(), ModItems.ARCANE_CRYSTAL_SHARD.get(), ModItems.ARCANE_CRYSTAL_POWDER.get(), ModBlocks.ANCIENT_PETAL_CLUSTER.get().asItem(), ModItems.ANCIENT_PETAL_FRAGMENT.get(), ModItems.MARVELOUS_ANCIENT_PETAL_FRAGMENT.get(), ModBlocks.ARCANE_LOG.get().asItem(), ModBlocks.STRIPPED_ARCANE_LOG.get().asItem(), ModBlocks.ARCANE_WOOD.get().asItem(), ModBlocks.STRIPPED_ARCANE_WOOD.get().asItem(), ModBlocks.ARCANE_PLANKS.get().asItem(), ModBlocks.ARCANE_STAIRS.get().asItem(), ModBlocks.ARCANE_SLAB.get().asItem(), ModBlocks.ARCANE_DOOR.get().asItem(), ModBlocks.ARCANE_TRAPDOOR.get().asItem(), ModBlocks.ARCANE_FENCE.get().asItem(), ModBlocks.ARCANE_FENCE_GATE.get().asItem(), ModItems.ARCANE_SIGN.get(), ModBlocks.ARCANE_PRESSURE_PLATE.get().asItem(), ModBlocks.ARCANE_BUTTON.get().asItem(), ModBlocks.ARCANE_LEAVES.get().asItem(), ModBlocks.ARCANE_SAPLING.get().asItem(), ModItems.OAK_BARK.get(), ModItems.BIRCH_BARK.get(), ModItems.SPRUCE_BARK.get(), ModItems.DARK_OAK_BARK.get(), ModItems.JUNGLE_BARK.get(), ModItems.ACACIA_BARK.get(), ModItems.MANGROVE_BARK.get(), ModItems.CRIMSON_BARK.get(), ModItems.WARPED_BARK.get(), ModItems.ARCANE_BARK.get());

            int run = 0;
            for (Item x : blockList) {
                items.add(run, new ItemStack(x));
                run++;
            }
        }
    };

    public Alchemagica() {
        Registration.register();
    }

}