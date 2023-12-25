package de.artemis.alchemagica.common.network.toclient;

import de.artemis.alchemagica.common.blockentities.MortarAndPestleBlockEntity;
import de.artemis.alchemagica.common.network.base.IPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

public class MortarAndPestleClientPacket implements IPacket {
    private final BlockPos blockPos;
    private final int fuel;

    public MortarAndPestleClientPacket(BlockPos blockPos, int fuel) {
        this.blockPos = blockPos;
        this.fuel = fuel;
    }

    public static MortarAndPestleClientPacket decode(FriendlyByteBuf buffer) {
        return new MortarAndPestleClientPacket(buffer.readBlockPos(), buffer.readInt());
    }

    @Override
    public void handle(NetworkEvent.Context context) {
        LocalPlayer player = Minecraft.getInstance().player;
        BlockEntity blockEntity = player.getLevel().getBlockEntity(blockPos);

        if (blockEntity instanceof MortarAndPestleBlockEntity mortarAndPestleBlockEntity) {
            mortarAndPestleBlockEntity.setFuel(fuel);
        }
    }

    @Override
    public void encode(FriendlyByteBuf buffer) {
        buffer.writeBlockPos(blockPos);
        buffer.writeInt(fuel);
    }
}