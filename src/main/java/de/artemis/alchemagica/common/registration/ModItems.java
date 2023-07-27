package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.items.ArcaneHoeItem;
import de.artemis.alchemagica.common.items.ArcanePickaxeItem;
import de.artemis.alchemagica.common.items.ArcaneShearsItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> ARCANE_BLOSSOM_SEED = Registration.ITEMS.register("arcane_blossom_seed",
            () -> new ItemNameBlockItem(ModBlocks.ARCANE_BLOSSOM.get(), (new Item.Properties()).tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> ARCANE_BLOSSOM_PETAL = Registration.ITEMS.register("arcane_blossom_petal",
            () -> new Item(new Item.Properties().tab(Alchemagica.INVENTORY_TAB)));

    public static final RegistryObject<Item> CRUSHED_ARCANE_BLOSSOM_PETAL = Registration.ITEMS.register("crushed_arcane_blossom_petal",
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

    public static void register() {
    }

}
