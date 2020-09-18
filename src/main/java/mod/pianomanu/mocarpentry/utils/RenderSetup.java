package mod.pianomanu.mocarpentry.utils;

import mod.pianomanu.mocarpentry.content.RegistrationHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class RenderSetup {
    public static void setup() {
        RenderTypeLookup.setRenderLayer(RegistrationHandler.PILLAR_FRAME.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(RegistrationHandler.VERTICAL_STAIRS_FRAME.get(), RenderType.getTranslucent());
    }
}
