package mod.pianomanu.mocarpentry.content.models.loader;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import mod.pianomanu.mocarpentry.content.models.geometry.ArchFrameModelGeometry;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.client.model.IModelLoader;

public class ArchFrameModelLoader implements IModelLoader<ArchFrameModelGeometry> {
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {

    }

    @Override
    public ArchFrameModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new ArchFrameModelGeometry();
    }
}
