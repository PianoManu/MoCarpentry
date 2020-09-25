package mod.pianomanu.mocarpentry.content;

import mod.pianomanu.mocarpentry.MoCarpentry;
import mod.pianomanu.mocarpentry.content.models.loader.*;
import mod.pianomanu.mocarpentry.utils.RenderSetup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Used for registering model loaders
 *
 * @author KiroTheBlueFox
 * @author PianoManu
 * @version 1.2 09/24/20
 */
@EventBusSubscriber(modid = MoCarpentry.MODID, value = Dist.CLIENT, bus = Bus.MOD)
public class ClientRegistration {
    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        RenderSetup.setup();
    }

    @SubscribeEvent
    public static void init(final ModelRegistryEvent event) {
        ModelLoaderRegistry.registerLoader(loc("pillar_frame_loader"), new PillarFrameModelLoader());
        ModelLoaderRegistry.registerLoader(loc("vertical_stairs_frame_loader"), new VerticalStairsFrameModelLoader());
        ModelLoaderRegistry.registerLoader(loc("post_frame_loader"), new PostFrameModelLoader());
        ModelLoaderRegistry.registerLoader(loc("ramp_frame_loader"), new RampFrameModelLoader());
        ModelLoaderRegistry.registerLoader(loc("arch_frame_loader"), new ArchFrameModelLoader());
    }

    private static ResourceLocation loc(String path) {
        return new ResourceLocation(MoCarpentry.MODID, path);
    }
}
//========SOLI DEO GLORIA========//