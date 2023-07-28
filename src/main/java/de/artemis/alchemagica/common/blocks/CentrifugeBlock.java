package de.artemis.alchemagica.common.blocks;

import de.artemis.alchemagica.common.blockentities.CentrifugeBlockEntity;
import de.artemis.alchemagica.common.util.VoxelShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class CentrifugeBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Stream.of(Block.box(1, 0, 1, 3, 6, 3), Block.box(10, 9, 11.5, 12.5, 13.5, 14), Block.box(12.5, 9, 9, 15, 13.5, 11.5), Block.box(10, 9, 6.5, 12.5, 13.5, 9), Block.box(7.5, 9, 9, 10, 13.5, 11.5), Block.box(13, 0, 13, 15, 6, 15), Block.box(13, 0, 1, 15, 6, 3), Block.box(1, 0, 13, 3, 6, 15), Block.box(0, 6, 0, 16, 7, 16), Block.box(2.25, 7.25, 7.25, 6.75, 9.75, 9.75), Block.box(1.5, 7.25, 10, 4, 11.75, 12.5), Block.box(4.25, 7.25, 10.75, 6.75, 11.75, 13.25), Block.box(9.75, 7.25, 8.75, 12.75, 14.75, 11.75)).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public CentrifugeBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext context) {
        return switch (blockState.getValue(FACING)) {
            case DOWN, UP -> Shapes.block();
            case NORTH -> SHAPE;
            case EAST -> VoxelShapeUtil.rotateShape(Direction.EAST, Direction.WEST, SHAPE);
            case SOUTH -> VoxelShapeUtil.rotateShape(Direction.SOUTH, Direction.NORTH, SHAPE);
            case WEST -> VoxelShapeUtil.rotateShape(Direction.WEST, Direction.WEST, SHAPE);
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    //Blockentity Start

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new CentrifugeBlockEntity(blockPos, blockState);
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, BlockState newBlockState, boolean isMoving) {
        if (blockState.getBlock() != newBlockState.getBlock()) {
            BlockEntity tileEntity = level.getBlockEntity(blockPos);
            if (tileEntity instanceof Container container) Containers.dropContents(level, blockPos, container);
            super.onRemove(blockState, level, blockPos, newBlockState, isMoving);
        }
    }

    @SuppressWarnings("deprecation")
    @NotNull
    @Override
    public InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        MenuProvider namedContainerProvider = this.getMenuProvider(blockState, level, blockPos);
        if (namedContainerProvider != null) {
            if (player instanceof ServerPlayer serverPlayerEntity)
                NetworkHooks.openScreen(serverPlayerEntity, namedContainerProvider, blockPos);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : (a, b, c, blockEntity) -> ((CentrifugeBlockEntity) blockEntity).tick();
    }
}
