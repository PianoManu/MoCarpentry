package mod.pianomanu.mocarpentry.content.models.loader;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;

import mod.pianomanu.mocarpentry.content.models.geometry.VerticalStairsFrameModelGeometry;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.client.model.IModelLoader;

public class VerticalStairsFrameModelLoader implements IModelLoader<VerticalStairsFrameModelGeometry> {
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {

    }

    @Override
    public VerticalStairsFrameModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new VerticalStairsFrameModelGeometry();
    }
}
