package de.artemis.alchemagica.common.data;

import de.artemis.alchemagica.common.registration.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipesProvider extends RecipeProvider implements IConditionBuilder {

    public RecipesProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModItems.ARCANE_AXE.get(), 1).define('A', ModItems.ARCANE_STICK.get()).define('B', ModItems.ARCANE_CRYSTAL_SHARD.get()).define('C', Items.GOLD_INGOT).pattern("BC ").pattern("BA ").pattern(" A ").unlockedBy("has_arcane_stick", has(ModItems.ARCANE_STICK.get())).unlockedBy("has_arcane_crystal_shard", has(ModItems.ARCANE_CRYSTAL_SHARD.get())).unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.ARCANE_PICKAXE.get(), 1).define('A', ModItems.ARCANE_STICK.get()).define('B', ModItems.ARCANE_CRYSTAL_SHARD.get()).define('C', Items.GOLD_INGOT).pattern("BCB").pattern(" A ").pattern(" A ").unlockedBy("has_arcane_stick", has(ModItems.ARCANE_STICK.get())).unlockedBy("has_arcane_crystal_shard", has(ModItems.ARCANE_CRYSTAL_SHARD.get())).unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.ARCANE_HOE.get(), 1).define('A', ModItems.ARCANE_STICK.get()).define('B', ModItems.ARCANE_CRYSTAL_SHARD.get()).define('C', Items.GOLD_INGOT).pattern("BC ").pattern(" A ").pattern(" A ").unlockedBy("has_arcane_stick", has(ModItems.ARCANE_STICK.get())).unlockedBy("has_arcane_crystal_shard", has(ModItems.ARCANE_CRYSTAL_SHARD.get())).unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.ARCANE_SHEARS.get(), 1).define('A', ModItems.ARCANE_CRYSTAL_SHARD.get()).pattern("A ").pattern(" A").unlockedBy("has_arcane_crystal_shard", has(ModItems.ARCANE_CRYSTAL_SHARD.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(Items.IRON_NUGGET, 1).requires(ModItems.IRON_BLOSSOM_EXTRACT.get(), 9).unlockedBy("has_iron_blossom_extract", has(ModItems.IRON_BLOSSOM_EXTRACT.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(Items.GOLD_NUGGET, 1).requires(ModItems.GOLD_BLOSSOM_EXTRACT.get(), 9).unlockedBy("has_gold_blossom_extract", has(ModItems.GOLD_BLOSSOM_EXTRACT.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(ModItems.COPPER_NUGGET.get(), 1).requires(ModItems.COPPER_BLOSSOM_EXTRACT.get(), 9).unlockedBy("has_copper_blossom_extract", has(ModItems.COPPER_BLOSSOM_EXTRACT.get())).save(consumer);

    }
}
