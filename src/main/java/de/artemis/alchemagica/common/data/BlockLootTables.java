package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.common.blocks.ArcaneBlossomCropBlock;
import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.registration.Registration;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        add(ModBlocks.ARCANE_BLOSSOM.get(), createBlossomCropDrops(ModBlocks.ARCANE_BLOSSOM.get(), ModItems.ARCANE_BLOSSOM_PETAL.get(), ModItems.ARCANE_BLOSSOM_SEED.get()));
        add(ModBlocks.IRON_BLOSSOM.get(), createBlossomCropDrops(ModBlocks.IRON_BLOSSOM.get(), ModItems.IRON_BLOSSOM_PETAL.get(), ModItems.IRON_BLOSSOM_SEED.get()));
        add(ModBlocks.ANCIENT_PETAL_CLUSTER.get(), createOreDrop(ModBlocks.ANCIENT_PETAL_CLUSTER.get(), ModItems.ANCIENT_PETAL_FRAGMENT.get()));
        dropSelf(ModBlocks.ARCANE_CRYSTAL_BLOCK.get());
        add(ModBlocks.BUDDING_ARCANE_CRYSTAL.get(), noDrop());
        add(ModBlocks.ARCANE_CRYSTAL_CLUSTER.get(), createSilkTouchDispatchTable(ModBlocks.ARCANE_CRYSTAL_CLUSTER.get(), LootItem.lootTableItem(ModItems.ARCANE_CRYSTAL_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES))).otherwise(applyExplosionDecay(ModItems.ARCANE_CRYSTAL_SHARD.get(), LootItem.lootTableItem(ModItems.ARCANE_CRYSTAL_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        dropWhenSilkTouch(ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get());
        dropWhenSilkTouch(ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get());
        dropWhenSilkTouch(ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get());
        dropOther(ModBlocks.ARCANE_SOIL.get(), Blocks.DIRT);
        dropSelf(ModBlocks.MORTAR_AND_PESTLE.get());
        dropSelf(ModBlocks.CENTRIFUGE.get());
    }

    protected static LootTable.Builder createBlossomCropDrops(Block cropBlock, Item pGrownCropItem, Item pSeedsItem) {
        LootItemCondition.Builder arcaneBlossomCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ArcaneBlossomCropBlock.AGE, 3));
        return applyExplosionDecay(cropBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).when(arcaneBlossomCondition).otherwise(LootItem.lootTableItem(pSeedsItem)))).withPool(LootPool.lootPool().when(arcaneBlossomCondition).add(LootItem.lootTableItem(pSeedsItem))));
    }

    @Override
    @NotNull
    protected Iterable<Block> getKnownBlocks() {

        ArrayList<Block> registeredBlocks = new ArrayList<Block>();
        registeredBlocks.add(ModBlocks.ARCANE_BLOSSOM.get());
        registeredBlocks.add(ModBlocks.IRON_BLOSSOM.get());
        registeredBlocks.add(ModBlocks.ANCIENT_PETAL_CLUSTER.get());
        registeredBlocks.add(ModBlocks.ARCANE_CRYSTAL_BLOCK.get());
        registeredBlocks.add(ModBlocks.BUDDING_ARCANE_CRYSTAL.get());
        registeredBlocks.add(ModBlocks.ARCANE_CRYSTAL_CLUSTER.get());
        registeredBlocks.add(ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get());
        registeredBlocks.add(ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get());
        registeredBlocks.add(ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get());
        registeredBlocks.add(ModBlocks.ARCANE_SOIL.get());
        registeredBlocks.add(ModBlocks.MORTAR_AND_PESTLE.get());
        registeredBlocks.add(ModBlocks.CENTRIFUGE.get());

        return registeredBlocks;
    }
}
