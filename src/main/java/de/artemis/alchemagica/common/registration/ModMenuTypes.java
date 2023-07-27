package de.artemis.alchemagica.common.registration;

import de.artemis.alchemagica.common.containers.menus.MortarAndPestleMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final RegistryObject<MenuType<MortarAndPestleMenu>> MORTAR_AND_PESTLE_MENU =
            registerMenuType(MortarAndPestleMenu::new, "mortar_and_pestle_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return Registration.MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(){
    }
}
