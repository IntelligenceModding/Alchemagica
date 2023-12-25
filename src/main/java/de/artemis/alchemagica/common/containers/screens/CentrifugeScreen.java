package de.artemis.alchemagica.common.containers.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.containers.menus.CentrifugeMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class CentrifugeScreen extends AbstractContainerScreen<CentrifugeMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Alchemagica.MOD_ID, "textures/gui/centrifuge.png");

    public CentrifugeScreen(CentrifugeMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(poseStack, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(poseStack, x, y);
        renderFuel(poseStack, x, y);
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if (menu.isCrafting()) {
            blit(pPoseStack, x + 99, y + 17, 177, 1, 7, menu.getScaledProgress());
        }
    }

    private void renderFuel(PoseStack poseStack, int x, int y) {
        if (menu.blockEntity.getFuel() > 0) {
            int height = (int) (29F / 10F * menu.blockEntity.getFuel());
            blit(poseStack, x + 12, y + 18 + 29 - height, 186, 29 - height, 8, height);
        }
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);
    }
}