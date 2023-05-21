package de.artemis.alchemagica;

import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.registration.Registration;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
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
            Collections.addAll(blockList, ModItems.ARCANE_BLOSSOM_SEED.get(), ModItems.ARCANE_BLOSSOM_PETAL.get(), ModItems.ARCANE_SHARD.get(), ModItems.ARCANE_POWDER.get(), ModItems.ARCANE_SHEARS.get());

            int run = 0;
            for (Item x : blockList) {
                items.add(run, new ItemStack(x));
                run++;
            }
        }
    };

    public Alchemagica() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registration.register();
    }

}