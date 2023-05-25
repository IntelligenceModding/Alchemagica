package de.artemis.alchemagica.common.registration;

import com.mojang.blaze3d.platform.InputConstants;
import de.artemis.alchemagica.Alchemagica;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

public class ModKeyBindings {

    public static final KeyMapping TOGGLE_DESCRIPTION_KEYBIND = new KeyMapping("keybind." + Alchemagica.MOD_ID + ".description_toggle_description_keybind", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_LEFT_CONTROL), "keybind." + Alchemagica.MOD_ID + ".category");
}
