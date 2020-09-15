package mod.pianomanu.mocarpentry.content.models.loader;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import mod.pianomanu.mocarpentry.content.models.geometry.PillarFrameModelGeometry;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.client.model.IModelLoader;

public class PillarFrameModelLoader implements IModelLoader<PillarFrameModelGeometry> {
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {

    }

    @Override
    public PillarFrameModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new PillarFrameModelGeometry();
    }
}
