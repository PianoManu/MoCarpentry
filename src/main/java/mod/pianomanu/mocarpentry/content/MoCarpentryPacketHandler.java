package mod.pianomanu.mocarpentry.content;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import mod.pianomanu.mocarpentry.MoCarpentry;

/**
 * Used for handling packets
 * @author KiroTheBlueFox
 * @version 1.0 09/14/20
 */
public class MoCarpentryPacketHandler {
	static SimpleChannel INSTANCE;
    private static int ID = 0;

    @SuppressWarnings("unused")
	private static int nextID() {
        return ID++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(MoCarpentry.MODID, "main"),
                () -> "1.0",
                s -> true,
                s -> true);
    }

    public static void sendToClient(Object packet, ServerPlayerEntity player) {
        INSTANCE.sendTo(packet, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }
}
//========SOLI DEO GLORIA========//