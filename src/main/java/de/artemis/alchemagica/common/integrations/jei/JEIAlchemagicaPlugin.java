package de.artemis.alchemagica.common.integrations.jei;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.containers.menus.MortarAndPestleMenu;
import de.artemis.alchemagica.common.containers.screens.MortarAndPestleScreen;
import de.artemis.alchemagica.common.recipe.MortarAndPestleRecipe;
import de.artemis.alchemagica.common.registration.ModBlocks;
import de.artemis.alchemagica.common.registration.ModMenuTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIAlchemagicaPlugin implements IModPlugin {
    public static RecipeType<MortarAndPestleRecipe> MORTAR_AND_PESTLE_RECIPE_TYPE =
            new RecipeType<>(MortarAndPestleRecipeCategory.UID, MortarAndPestleRecipe.class);

    private static final int PLAYER_INVENTORY_COUNT = 36;
    private static final int SLOT_DEFAULT = 0;

    @NotNull
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Alchemagica.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                MortarAndPestleRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<MortarAndPestleRecipe> recipesPestling = recipeManager.getAllRecipesFor(MortarAndPestleRecipe.Type.INSTANCE);
        registration.addRecipes(MORTAR_AND_PESTLE_RECIPE_TYPE, recipesPestling);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ModBlocks.MORTAR_AND_PESTLE.get().asItem().getDefaultInstance(), MORTAR_AND_PESTLE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(MortarAndPestleMenu.class, ModMenuTypes.MORTAR_AND_PESTLE_MENU.get(), MORTAR_AND_PESTLE_RECIPE_TYPE, SLOT_DEFAULT + PLAYER_INVENTORY_COUNT, 1, SLOT_DEFAULT, PLAYER_INVENTORY_COUNT);
    }

    @Override
    public void registerGuiHandlers(@NotNull IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(MortarAndPestleScreen.class, 80, 35, 22, 16, MORTAR_AND_PESTLE_RECIPE_TYPE);
    }
}
