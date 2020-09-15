package mod.pianomanu.mocarpentry.content;

import mod.pianomanu.mocarpentry.content.models.loader.PillarFrameModelLoader;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import mod.pianomanu.mocarpentry.MoCarpentry;

/**
 * Used for registering model loaders
 * @author KiroTheBlueFox
 * @author PianoManu
 * @version 1.0 09/15/20
 */
@EventBusSubscriber(modid = MoCarpentry.MODID, value = Dist.CLIENT, bus=Bus.MOD)
public class ClientRegistration {
	@SubscribeEvent
	public static void init(FMLClientSetupEvent event) {
	}

	@SubscribeEvent
	public static void init(final ModelRegistryEvent event) {
		ModelLoaderRegistry.registerLoader(loc("pillar_frame_loader"), new PillarFrameModelLoader());
	}

	private static ResourceLocation loc(String path) {
		return new ResourceLocation(MoCarpentry.MODID, path);
	}
}
//========SOLI DEO GLORIA========//