package de.artemis.alchemagica.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.artemis.alchemagica.Alchemagica;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CentrifugeRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public CentrifugeRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(@NotNull SimpleContainer container, Level level) {
        if (level.isClientSide) {
            return false;
        }

        return recipeItems.get(0).test(container.getItem(0));
    }

    @NotNull
    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @NotNull
    @Override
    public ItemStack assemble(@NotNull SimpleContainer container) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @NotNull
    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @NotNull
    @Override
    public ResourceLocation getId() {
        return id;
    }

    @NotNull
    @Override
    public RecipeSerializer<?> getSerializer() {
        return CentrifugeRecipe.Serializer.INSTANCE;
    }

    @NotNull
    @Override
    public RecipeType<?> getType() {
        return CentrifugeRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<CentrifugeRecipe> {
        private Type() {
        }

        public static final CentrifugeRecipe.Type INSTANCE = new CentrifugeRecipe.Type();
        public static final String ID = "centrifuging";
    }

    public static class Serializer implements RecipeSerializer<CentrifugeRecipe> {
        public static final CentrifugeRecipe.Serializer INSTANCE = new CentrifugeRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Alchemagica.MOD_ID, "centrifuging");

        @NotNull
        @Override
        public CentrifugeRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CentrifugeRecipe(id, output, inputs);
        }

        @Override
        public CentrifugeRecipe fromNetwork(@NotNull ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new CentrifugeRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, CentrifugeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }
}