package mod.pianomanu.mocarpentry.content.models.loader;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import mod.pianomanu.mocarpentry.content.models.geometry.PostFrameModelGeometry;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.client.model.IModelLoader;

public class PostFrameModelLoader implements IModelLoader<PostFrameModelGeometry> {
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {

    }

    @Override
    public PostFrameModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new PostFrameModelGeometry();
    }
}
