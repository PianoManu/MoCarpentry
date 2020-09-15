# Baked models and how to use them
### What should you already know?
- basic java stuff like how implementing Interfaces work, how to handle lists (List<?>) and how to create static methods
- basics of vector calculation
- some Minecraft stuff like how TileEntities work and how to retrieve Textures
### What are baked models?
- baked models determine the look of the block they are representing
- big difference to json models: json models are static
- baked models are useful, if the model can change during runtime or if you have complex structures (but for that I recommend using TESR instead of baked models)
- baked models are useful, if your block has a tile entity and changes its appearance when the tile entity changes (and vice versa)
- baked models consist of a list of **baked quads** (the faces of the model, e.g. 6 baked quads for a cuboid), which itself consist of four **vertices** storing all important model information like texture, vertex position etc.
### How to create a baked model
- you need three different classes per baked model (ModelLoader, ModelGeometry and the BakedModel class itself) and one class to register your ModelLoader (for this mod it's the ClientRegistration class)
- it does not really matter with which point you start, but the baked model class itself is the most complex one, so I'll start with this one here
### Setting up the baked model
- **if you do not understand the following instructions, feel free, to copy mod.pianomanu.blockcarpentry.util.ModelHelper, but please give credit to me**
- **I recommend first trying what I'm explaining, because you might need something different**
- you need to create a class "...BakedModel", where "..." should be something like the name of the block you want to create a baked model for
- this class needs to implement some sort of BakedModel-interface, I prefer using IDynamicBakedModel
- you should change the return value of the "getItemOverrides()"-method from "null" into "ItemOverrideList.*EMPTY*" 
- you should change the return value of the "getParticleTexture()"-method from "null" into your preferred texture, e.g. "Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE).apply(new ResourceLocation("minecraft", "block/oak_planks"))" 
- the most important one is the getQuads-method, where we actually determine the quads of the model, so this deserves its own headline
##### The getQuads(...)-method
- this method is pretty complex, it takes four parameters (BlockState - state of the block we're making the model for; Direction - side of the block, might be useful later; Random - tbh. I don't know what this is used for, never needed it; IModelData - it contains some information about the model and (more important) about the corresponding tile entity) and it returns a list of BakedQuads (i.e. the faces of the model)
- you can see some examples by reading our baked models; in the beginning, it might be hard to understand, but once you've gotten into it, you are able to make entirely new block models, nearly without any more help (*Source for that statement: it was the same for me*)
- I recommend creating some sort of helper methods, which calculates the baked models for you and you only have to put in the coordinates and the texture you want, instead of creating 6 or more quads for every state - you might end up with more than 500 or 600 mainly identical lines of code in one single file (*Source for that statement: it was the same for me*), so you should set up something like a "createCuboid"-method or whatever
##### Making a Cuboid-Helper-Method
- you need at least seven parameters (you can add more if you need them), six of them being the coordinates of the block (lower and greater x coordinate, lower and greater y coordinate, lower and greater z coordinate), alternatively you can use two Vec3d from the minecraft math package 
- as stated above you need to return a list of BakedQuads determining the model
- this method now has to compute the cuboid creating six faces (again, I recommend making some sort of helper method for that), so you either have to make eight vectors (these represent the 8 vertices of a cuboid) from the six coordinates, or you have to split the two vectors into their components and again creating 8 new vectors for the vertices
##### Making a Quad-Helper-Method
- you need at least nine parameters (again, you can add more if you want to), four of them being the vertex vectors (two would be sufficient, but four are just more comfortable), one parameter for the texture, four int values for the lower and greater u and v value of the texture (to learn more about uv-coordinates, see https://en.wikipedia.org/wiki/UV_mapping)
- this method should return a BakedQuad (to be precisely the quad is being built by the BakedQuadBuilder, see below)
- first, you have to calculate the normal vector (https://en.wikipedia.org/wiki/Normal_(geometry)), which is needed for the directions of the face
- also you have to create a new instance of the BakedQuadBuilder, like that: "BakedQuadBuilder builder = new BakedQuadBuilder(sprite);", where sprite is the TextureAtlasSprite of the block
- you then have to set the direction of the builder to the normal vector
- now you have to create the four vertices; again, I recommend to set up a last helper method for creating the vertices, since it is a lot of code
##### Making a Vertex-Helper-Method
- you need exactly 11 parameters (if you want some alpha channel changes, you can add a 12th parameter), where the first one is the BakedQuadBuilder we made in the Quad-Helper-Method, second one is the Normal Vector, third to fifth should be the coordinates of the vertex (you can also replace these three with the corresponding vector, but I think that might be a bit more to do), sixth and seventh are the u and v value from the texture, eighth is the TextureAtlasSprite the vertex should have, and ninth to eleventh are the r, g, and b colors (you might want to take a look at the putVertex(...)-method in my ModelHelper-class, you could also copy-paste the whole class and only change the parameters in the *switch*-branches)
- this method does not have to return anything (void)
### Setting up the Model Geometry
- you need to connect the baked model with the loader: this is the only purpose of the ModelGeometry class
- all ModelGeometry classes should somewhat look similar:
   

    public class "YourBlock"ModelGeometry implements IModelGeometry<"YourBlock"ModelGeometry> {
        @Override
        public IBakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<RenderMaterial, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ItemOverrideList overrides, ResourceLocation modelLocation) {
            return new "YourBlock"BakedModel(); //used for creating the right model, that's why you should use uniform naming
        }
        @Override
        public Collection<RenderMaterial> getTextures(IModelConfiguration owner, Function<ResourceLocation, IUnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
            return Collections.singletonList(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, "YourTexturePath"));
        }
    }
### Setting up the Model Loader
- you need the model loader to register your model in the model registry
- again, all ModelLoader classes should somewhat look similar:


    public class "YourBlock"ModelLoader implements IModelLoader<"YourBlock"ModelGeometry> {
        @Override
        public void onResourceManagerReload(IResourceManager resourceManager) {
    
        }
    
        @Override
        public "YourBlock"ModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
            return new "YourBlock"ModelGeometry();
        }
    }
### Registering the loader to the ModelRegistry
- you should make some sort of _ClientRegistry_-class containing the following lines of code


    @SubscribeEvent
    public static void init(final ModelRegistryEvent event) {
        ModelLoaderRegistry.registerLoader(loc("path_of_your_block_loader"), new "YourBlock"ModelLoader());
    }
    private static ResourceLocation loc(String path) {
        return new ResourceLocation("YourModID", path);
    }
- we need to wait for the ModelRegistryEvent and then register our model to the ModelLoaderRegistry
- to keep the arguments clean and tidy, I also made some method that would return the needed ResourceLocation
### Creating the final json file
- the last step is to create the model file, where we tell minecraft to use our model loader with the baked model
- the file should look like


    {
      "loader": "YourModID:path_of_your_block_loader"
    }
- as always, this _"YourBlock".json_-file should be located in the _models/block_ directory and you should have an entry in the corresponding _blockstates/"YourBlock".json_ file pointing to the file in the models directory

That's it! Have fun with your new baked model.


*Author: PianoManu*