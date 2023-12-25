package de.artemis.alchemagica.common.network.toclient;

import de.artemis.alchemagica.common.blockentities.CentrifugeBlockEntity;
import de.artemis.alchemagica.common.network.base.IPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

public class CentrifugeClientPacket implements IPacket {
    private final BlockPos blockPos;
    private final int fuel;

    public CentrifugeClientPacket(BlockPos blockPos, int fuel) {
        this.blockPos = blockPos;
        this.fuel = fuel;
    }

    public static CentrifugeClientPacket decode(FriendlyByteBuf buffer) {
        return new CentrifugeClientPacket(buffer.readBlockPos(), buffer.readInt());
    }

    @Override
    public void handle(NetworkEvent.Context context) {
        LocalPlayer player = Minecraft.getInstance().player;
        BlockEntity blockEntity = player.getLevel().getBlockEntity(blockPos);

        if (blockEntity instanceof CentrifugeBlockEntity centrifugeBlockEntity) {
            centrifugeBlockEntity.setFuel(fuel);
        }
    }

    @Override
    public void encode(FriendlyByteBuf buffer) {
        buffer.writeBlockPos(blockPos);
        buffer.writeInt(fuel);
    }
}
