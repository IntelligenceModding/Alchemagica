package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.common.recipe.MortarAndPestleRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

    public static final RegistryObject<RecipeSerializer<MortarAndPestleRecipe>> PESTLING_SERIALIZER =
            Registration.RECIPE_SERIALIZERS.register(MortarAndPestleRecipe.Serializer.ID.getPath(),
                    () -> MortarAndPestleRecipe.Serializer.INSTANCE);


    public static void register() {
    }
}
