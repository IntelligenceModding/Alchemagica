package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.items.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> ARCANE_BLOSSOM_SEED = Registration.ITEMS.register("arcane_blossom_seed",
            () -> new ItemNameBlockItem(ModBlocks.ARCANE_BLOSSOM.get(), (new Item.Properties())));

    public static final RegistryObject<Item> ARCANE_BLOSSOM_PETAL = Registration.ITEMS.register("arcane_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> CRUSHED_ARCANE_BLOSSOM_PETAL = Registration.ITEMS.register("crushed_arcane_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ARCANE_BLOSSOM_EXTRACT = Registration.ITEMS.register("arcane_blossom_extract",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> IRON_BLOSSOM_SEED = Registration.ITEMS.register("iron_blossom_seed",
            () -> new ItemNameBlockItem(ModBlocks.IRON_BLOSSOM.get(), (new Item.Properties())));

    public static final RegistryObject<Item> IRON_BLOSSOM_PETAL = Registration.ITEMS.register("iron_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> CRUSHED_IRON_BLOSSOM_PETAL = Registration.ITEMS.register("crushed_iron_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> IRON_BLOSSOM_EXTRACT = Registration.ITEMS.register("iron_blossom_extract",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> GOLD_BLOSSOM_SEED = Registration.ITEMS.register("gold_blossom_seed",
            () -> new ItemNameBlockItem(ModBlocks.GOLD_BLOSSOM.get(), (new Item.Properties())));

    public static final RegistryObject<Item> GOLD_BLOSSOM_PETAL = Registration.ITEMS.register("gold_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> CRUSHED_GOLD_BLOSSOM_PETAL = Registration.ITEMS.register("crushed_gold_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> GOLD_BLOSSOM_EXTRACT = Registration.ITEMS.register("gold_blossom_extract",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> COPPER_BLOSSOM_SEED = Registration.ITEMS.register("copper_blossom_seed",
            () -> new ItemNameBlockItem(ModBlocks.COPPER_BLOSSOM.get(), (new Item.Properties())));

    public static final RegistryObject<Item> COPPER_BLOSSOM_PETAL = Registration.ITEMS.register("copper_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> CRUSHED_COPPER_BLOSSOM_PETAL = Registration.ITEMS.register("crushed_copper_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> COPPER_BLOSSOM_EXTRACT = Registration.ITEMS.register("copper_blossom_extract",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ARCANE_CRYSTAL_SHARD = Registration.ITEMS.register("arcane_crystal_shard",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ARCANE_CRYSTAL_POWDER = Registration.ITEMS.register("arcane_crystal_powder",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ANCIENT_PETAL_FRAGMENT = Registration.ITEMS.register("ancient_petal_fragment",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> MARVELOUS_ANCIENT_PETAL_FRAGMENT = Registration.ITEMS.register("marvelous_ancient_petal_fragment",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<ArcaneShearsItem> ARCANE_SHEARS = Registration.ITEMS.register("arcane_shears",
            () -> new ArcaneShearsItem(new Item.Properties().rarity(ModRarities.ARCANE).tab(Alchemagica.INVENTORY_TAB).durability(238)));

    public static final RegistryObject<ArcanePickaxeItem> ARCANE_PICKAXE = Registration.ITEMS.register("arcane_pickaxe",
            () -> new ArcanePickaxeItem(new Item.Properties().rarity(ModRarities.ARCANE).tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<ArcaneHoeItem> ARCANE_HOE = Registration.ITEMS.register("arcane_hoe",
            () -> new ArcaneHoeItem(new Item.Properties().rarity(ModRarities.ARCANE).tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<ArcaneAxeItem> ARCANE_AXE = Registration.ITEMS.register("arcane_axe",
            () -> new ArcaneAxeItem(new Item.Properties().rarity(ModRarities.ARCANE).tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<SignItem> ARCANE_SIGN = Registration.ITEMS.register("arcane_sign",
            () -> new SignItem((new Item.Properties()).stacksTo(16).tab(Alchemagica.INVENTORY_TAB), ModBlocks.ARCANE_SIGN.get(), ModBlocks.ARCANE_WALL_SIGN.get()));

    public static final RegistryObject<BarkItem> OAK_BARK = Registration.ITEMS.register("oak_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<BarkItem> BIRCH_BARK = Registration.ITEMS.register("birch_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<BarkItem> SPRUCE_BARK = Registration.ITEMS.register("spruce_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<BarkItem> DARK_OAK_BARK = Registration.ITEMS.register("dark_oak_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<BarkItem> JUNGLE_BARK = Registration.ITEMS.register("jungle_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<BarkItem> ACACIA_BARK = Registration.ITEMS.register("acacia_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<BarkItem> MANGROVE_BARK = Registration.ITEMS.register("mangrove_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<BarkItem> CRIMSON_BARK = Registration.ITEMS.register("crimson_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<BarkItem> WARPED_BARK = Registration.ITEMS.register("warped_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<BarkItem> ARCANE_BARK = Registration.ITEMS.register("arcane_bark",
            () -> new BarkItem(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ARCANE_STICK = Registration.ITEMS.register("arcane_stick",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> COPPER_NUGGET = Registration.ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static void register() {
    }

}
