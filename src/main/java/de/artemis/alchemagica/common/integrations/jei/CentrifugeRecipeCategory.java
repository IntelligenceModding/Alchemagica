package de.artemis.alchemagica.common.integrations.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.recipe.CentrifugeRecipe;
import de.artemis.alchemagica.common.registration.ModBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CentrifugeRecipeCategory implements IRecipeCategory<CentrifugeRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Alchemagica.MOD_ID, "centrifuging");
    public final static ResourceLocation TEXTURE = new ResourceLocation(Alchemagica.MOD_ID, "textures/gui/jei/centrifuge_jei.png");
    private final IGuiHelper guiHelper;

    private IDrawable progress;
    private final IDrawable background;
    private final IDrawable icon;

    public CentrifugeRecipeCategory(IGuiHelper guiHelper) {
        this.guiHelper = guiHelper;
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 64, 59);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CENTRIFUGE.get()));

    }

    @Override
    public void draw(@NotNull CentrifugeRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull PoseStack stack, double mouseX, double mouseY) {
        if (progress == null) {
            this.progress = guiHelper.createAnimatedDrawable(guiHelper.createDrawable(TEXTURE, 249, 0, 7, 27), 100, IDrawableAnimated.StartDirection.TOP, false);
        }

        progress.draw(stack, 43, 1);

        IRecipeCategory.super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
    }

    @NotNull
    @Override
    public RecipeType<CentrifugeRecipe> getRecipeType() {
        return JEIAlchemagicaPlugin.CENTRIFUGE_RECIPE_TYPE;
    }

    @NotNull
    @Override
    public Component getTitle() {
        return Component.translatable("displayname.alchemagica.centrifuge_block_entity");
    }

    @NotNull
    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @NotNull
    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CentrifugeRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 24, 1).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 1, 35).addItemStack(recipe.getResultItem());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 24, 42).addItemStack(recipe.getResultItem());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 47, 35).addItemStack(recipe.getResultItem());
    }
}