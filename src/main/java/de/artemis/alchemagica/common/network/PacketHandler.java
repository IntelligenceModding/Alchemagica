package de.artemis.alchemagica.common.network;

import de.artemis.alchemagica.Alchemagica;
import de.artemis.alchemagica.common.network.base.IPacket;
import de.artemis.alchemagica.common.network.toclient.CentrifugeClientPacket;
import de.artemis.alchemagica.common.network.toclient.MortarAndPestleClientPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;
import java.util.function.Function;

public class PacketHandler {
    private static final String PROTOCOL_VERSION = ModLoadingContext.get().getActiveContainer().getModInfo().getVersion().toString();
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(Alchemagica.MOD_ID, "main_channel"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static int index = 0;

    public static void init() {
        registerServerToClient(CentrifugeClientPacket.class, CentrifugeClientPacket::decode);
        registerServerToClient(MortarAndPestleClientPacket.class, MortarAndPestleClientPacket::decode);
    }

    public static <MSG extends IPacket> void registerServerToClient(Class<MSG> packet, Function<FriendlyByteBuf, MSG> decode) {
        CHANNEL.registerMessage(index++, packet, IPacket::encode, decode, IPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    }

    public static <MSG extends IPacket> void registerClientToServer(Class<MSG> packet, Function<FriendlyByteBuf, MSG> decode) {
        CHANNEL.registerMessage(index++, packet, IPacket::encode, decode, IPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }

    public static void sendToClient(Object packet, ServerPlayer player) {
        CHANNEL.sendTo(packet, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToServer(Object packet) {
        CHANNEL.sendToServer(packet);
    }

    public static void sendTo(Object packet, ServerPlayer player) {
        if (!(player instanceof FakePlayer)) {
            CHANNEL.sendTo(packet, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
        }
    }
}
