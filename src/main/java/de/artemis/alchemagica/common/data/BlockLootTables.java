package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.common.blocks.ArcaneBlossomCropBlock;
import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.registration.Registration;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class BlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        LootItemCondition.Builder arcaneBlossomCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ARCANE_BLOSSOM.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ArcaneBlossomCropBlock.AGE, 3));

        add(ModBlocks.ARCANE_BLOSSOM.get(), createBlossomCropDrops(ModBlocks.ARCANE_BLOSSOM.get(), ModItems.ARCANE_BLOSSOM_PETAL.get(), ModItems.ARCANE_BLOSSOM_SEED.get(), arcaneBlossomCondition));
        add(ModBlocks.ANCIENT_PETAL_CLUSTER.get(), createOreDrop(ModBlocks.ANCIENT_PETAL_CLUSTER.get(), ModItems.ANCIENT_PETAL_FRAGMENT.get()));
        dropSelf(ModBlocks.ARCANE_CRYSTAL_BLOCK.get());
        add(ModBlocks.BUDDING_ARCANE_CRYSTAL.get(), noDrop());
        add(ModBlocks.ARCANE_CRYSTAL_CLUSTER.get(), createSilkTouchDispatchTable(ModBlocks.ARCANE_CRYSTAL_BLOCK.get(), LootItem.lootTableItem(ModItems.ARCANE_CRYSTAL_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES))).otherwise(applyExplosionDecay(ModItems.ARCANE_CRYSTAL_SHARD.get(), LootItem.lootTableItem(ModItems.ARCANE_CRYSTAL_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        dropWhenSilkTouch(ModBlocks.LARGE_ARCANE_CRYSTAL_BUD.get());
        dropWhenSilkTouch(ModBlocks.MEDIUM_ARCANE_CRYSTAL_BUD.get());
        dropWhenSilkTouch(ModBlocks.SMALL_ARCANE_CRYSTAL_BUD.get());
    }

    protected static LootTable.Builder createBlossomCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootItemCondition.Builder pDropGrownCropCondition) {
        return applyExplosionDecay(pCropBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition).otherwise(LootItem.lootTableItem(pSeedsItem)))).withPool(LootPool.lootPool().when(pDropGrownCropCondition).add(LootItem.lootTableItem(pSeedsItem))));
    }

    @Override
    @NotNull
    protected Iterable<Block> getKnownBlocks() {
        return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
