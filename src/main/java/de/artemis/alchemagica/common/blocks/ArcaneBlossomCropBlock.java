package de.artemis.alchemagica.common.blocks;

import net.minecraft.util.Mth;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ArcaneBlossomCropBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private final Supplier<ItemLike> seed;

    public ArcaneBlossomCropBlock(Properties properties, Supplier<ItemLike> seed) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
        this.seed = seed;
    }

    @NotNull
    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected int getBonemealAgeIncrease(Level p_52262_) {
        return Mth.nextInt(p_52262_.random, 0, 1);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @NotNull
    @Override
    public ItemLike getBaseSeedId() {
        return seed.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
