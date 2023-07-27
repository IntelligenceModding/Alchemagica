package de.artemis.alchemagica.common.integrations.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.recipe.MortarAndPestleRecipe;
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


public class MortarAndPestleRecipeCategory implements IRecipeCategory<MortarAndPestleRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Alchemagica.MOD_ID, "pestling");
    public final static ResourceLocation TEXTURE = new ResourceLocation(Alchemagica.MOD_ID, "textures/gui/jei/mortar_and_pestle_jei.png");
    private final IGuiHelper guiHelper;

    private IDrawable progress;
    private final IDrawable background;
    private final IDrawable icon;

    public MortarAndPestleRecipeCategory(IGuiHelper guiHelper) {
        this.guiHelper = guiHelper;
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 82, 26);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MORTAR_AND_PESTLE.get()));

    }

    @Override
    public void draw(@NotNull MortarAndPestleRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull PoseStack stack, double mouseX, double mouseY) {
        if (progress == null) {
            this.progress = guiHelper.createAnimatedDrawable(guiHelper.createDrawable(TEXTURE, 234, 0, 22, 16), 40, IDrawableAnimated.StartDirection.LEFT, false);
        }

        progress.draw(stack, 25, 5);

        IRecipeCategory.super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
    }

    @NotNull
    @Override
    public RecipeType<MortarAndPestleRecipe> getRecipeType() {
        return JEIAlchemagicaPlugin.MORTAR_AND_PESTLE_RECIPE_TYPE;
    }

    @NotNull
    @Override
    public Component getTitle() {
        return Component.translatable("displayname.alchemagica.mortar_and_pestle_block_entity");
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
    public void setRecipe(IRecipeLayoutBuilder builder, MortarAndPestleRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 4).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 5).addItemStack(recipe.getResultItem());
    }
}
