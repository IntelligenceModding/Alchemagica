package de.artemis.alchemagica.common.blockentities;

import de.artemis.alchemagica.common.containers.menus.MortarAndPestleMenu;
import de.artemis.alchemagica.common.recipe.MortarAndPestleRecipe;
import de.artemis.alchemagica.common.registration.ModBlockEntities;
import de.artemis.alchemagica.common.util.ParticleUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MortarAndPestleBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    private final LazyOptional<? extends IItemHandler>[] itemHandler = SidedInvWrapper.create(this, Direction.values());
    public NonNullList<ItemStack> items;
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 40;

    public MortarAndPestleBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.MORTAR_AND_PESTLE.get(), blockPos, blockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> MortarAndPestleBlockEntity.this.progress;
                    case 1 -> MortarAndPestleBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> MortarAndPestleBlockEntity.this.progress = value;
                    case 1 -> MortarAndPestleBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };

        items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("displayname.alchemagica.mortar_and_pestle_block_entity");
    }

    @NotNull
    @Override
    protected AbstractContainerMenu createMenu(int containerId, @NotNull Inventory inventory) {
        return new MortarAndPestleMenu(containerId, inventory, this, data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER && !isRemoved() && side != null) {
            return itemHandler[side.get3DDataValue()].cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
        ContainerHelper.saveAllItems(nbt, this.items, true);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        ContainerHelper.loadAllItems(nbt, this.items);
    }

    public void tick() {

        if (hasRecipe()) {
            progress++;
            setChanged();
            if ((progress & 10) == 0) {
                ParticleUtil.addArcaneGrowthParticles(level, this.getBlockPos(), 1, 0.02F);
            }

            if (progress >= maxProgress) {
                craftItem();
            }
        } else {
            resetProgress();
            setChanged();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Level level = getLevel();
        SimpleContainer inventory = new SimpleContainer(getContainerSize());
        for (int i = 0; i < getContainerSize(); i++) {
            inventory.setItem(i, getItem(i));
        }

        Optional<MortarAndPestleRecipe> recipe = level.getRecipeManager().getRecipeFor(MortarAndPestleRecipe.Type.INSTANCE, inventory, level);

        if (hasRecipe()) {
            removeItem(0, 1);
            setItem(1, new ItemStack(recipe.get().getResultItem().getItem(), getItem(1).getCount() + 1));

            resetProgress();
        }
    }

    private boolean hasRecipe() {
        Level level = getLevel();
        SimpleContainer inventory = new SimpleContainer(getContainerSize());
        for (int i = 0; i < getContainerSize(); i++) {
            inventory.setItem(i, getItem(i));
        }

        Optional<MortarAndPestleRecipe> recipe = level.getRecipeManager().getRecipeFor(MortarAndPestleRecipe.Type.INSTANCE, inventory, level);
        return recipe.isPresent() && hasOutputCountSpace(inventory) && canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem());
    }

    private boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack itemStack) {
        return inventory.getItem(1).getItem() == itemStack.getItem() || inventory.getItem(1).isEmpty();
    }

    private boolean hasOutputCountSpace(SimpleContainer inventory) {
        return inventory.getItem(1).getMaxStackSize() > inventory.getItem(1).getCount();
    }

    @Override
    public int @NotNull [] getSlotsForFace(@NotNull Direction side) {
        if (side == Direction.DOWN) return new int[]{1};
        return new int[]{0};
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, @NotNull ItemStack itemStack, @Nullable Direction direction) {
        return direction != Direction.DOWN;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, @NotNull ItemStack itemStack, @NotNull Direction direction) {
        return direction == Direction.DOWN;
    }

    @Override
    public int getContainerSize() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : items) {
            if (itemStack.isEmpty()) return true;
        }
        return false;
    }

    @NotNull
    @Override
    public ItemStack getItem(int index) {
        if (index < 0 || index >= items.size()) {
            return ItemStack.EMPTY;
        }
        return items.get(index);
    }

    @NotNull
    @Override
    public ItemStack removeItem(int index, int count) {
        return ContainerHelper.removeItem(items, index, count);
    }

    @NotNull
    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(items, index);
    }

    @Override
    public void setItem(int index, @NotNull ItemStack stack) {
        items.set(index, stack);
        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return !(player.distanceToSqr((double) this.worldPosition.getX() + 0.5D, (double) this.worldPosition.getY() + 0.5D, (double) this.worldPosition.getZ() + 0.5D) > 64.0D);
        }
    }

    @Override
    public void clearContent() {
        items.clear();
    }
}
