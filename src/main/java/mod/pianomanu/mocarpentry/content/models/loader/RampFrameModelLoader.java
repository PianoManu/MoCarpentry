package mod.pianomanu.mocarpentry.content.models.loader;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;

import mod.pianomanu.mocarpentry.content.models.geometry.RampFrameModelGeometry;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.client.model.IModelLoader;

public class RampFrameModelLoader implements IModelLoader<RampFrameModelGeometry> {
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {

    }

    @Override
    public RampFrameModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new RampFrameModelGeometry();
    }
}
