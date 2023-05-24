package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.common.blocks.ArcaneBlossomCropBlock;
import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModItems;
import de.artemis.alchemagica.common.registration.Registration;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class BlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        LootItemCondition.Builder arcaneBlossomCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ARCANE_BLOSSOM.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ArcaneBlossomCropBlock.AGE, 3));
        add(ModBlocks.ARCANE_BLOSSOM.get(), createBlossomCropDrops(ModBlocks.ARCANE_BLOSSOM.get(), ModItems.ARCANE_BLOSSOM_PETAL.get(), ModItems.ARCANE_BLOSSOM_SEED.get(), arcaneBlossomCondition));
        add(ModBlocks.ANCIENT_PETAL_CLUSTER.get(), createOreDrop(ModBlocks.ANCIENT_PETAL_CLUSTER.get(), ModItems.ANCIENT_PETAL_FRAGMENT.get()));
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
