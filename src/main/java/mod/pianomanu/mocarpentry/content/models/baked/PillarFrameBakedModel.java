package mod.pianomanu.mocarpentry.content.models.baked;

import mod.pianomanu.blockcarpentry.tileentity.FrameBlockTile;
import mod.pianomanu.blockcarpentry.util.ModelHelper;
import mod.pianomanu.blockcarpentry.util.TextureHelper;
import mod.pianomanu.mocarpentry.content.blocks.PillarFrame;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class determines the model of the pillar when it does contain a block
 * @author PianoManu
 * @version 1.0 09/15/20
 */
public class PillarFrameBakedModel implements IDynamicBakedModel {
    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        BlockState mimic = extraData.getData(FrameBlockTile.MIMIC);
        if (mimic != null) {
            ModelResourceLocation location = BlockModelShapes.getModelLocation(mimic);
            if (location != null) {
                IBakedModel model = Minecraft.getInstance().getModelManager().getModel(location);
                model.getBakedModel().getQuads(mimic, side, rand, extraData);
                if (model != null) {
                    //only if model (from block saved in tile entity) exists:
                    return getMimicQuads(state, side, rand, extraData, model);
                }
            }
        }
        return Collections.emptyList();
    }

    private List<BakedQuad> getMimicQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData, IBakedModel model) {
        if (side != null) {
            return Collections.emptyList();
        }
        BlockState mimic = extraData.getData(FrameBlockTile.MIMIC);
        if (mimic != null && state != null) {
            List<TextureAtlasSprite> textureList = TextureHelper.getTextureListFromBlock(mimic.getBlock());
            TextureAtlasSprite texture;
            int tex = extraData.getData(FrameBlockTile.TEXTURE);
            if (textureList.size() > tex) {
                texture = textureList.get(tex);
            } else {
                texture = textureList.get(0);
            }
            int tintIndex = -1;
            if (mimic.getBlock() instanceof GrassBlock) {
                tintIndex = 1;
            }
            List<BakedQuad> quads = new ArrayList<>();
            quads.addAll(ModelHelper.createCuboid(2/16f,14/16f,0f,1f,6/16f,10/16f,texture, tintIndex));
            quads.addAll(ModelHelper.createCuboid(3/16f,13/16f,0f,1f,4/16f,6/16f,texture, tintIndex));
            quads.addAll(ModelHelper.createCuboid(3/16f,13/16f,0f,1f,10/16f,12/16f,texture, tintIndex));
            quads.addAll(ModelHelper.createCuboid(4/16f,12/16f,0f,1f,3/16f,4/16f,texture, tintIndex));
            quads.addAll(ModelHelper.createCuboid(4/16f,12/16f,0f,1f,12/16f,13/16f,texture, tintIndex));
            quads.addAll(ModelHelper.createCuboid(6/16f,10/16f,0f,1f,2/16f,3/16f,texture, tintIndex));
            quads.addAll(ModelHelper.createCuboid(6/16f,10/16f,0f,1f,13/16f,14/16f,texture, tintIndex));
            if (state.get(PillarFrame.CONNECTED_DOWN) && !state.get(PillarFrame.CONNECTED_UP)) {
                quads.addAll(ModelHelper.createCuboid(1/16f,15/16f,0.5f,1f,0f,1f,texture,tintIndex));
                quads.addAll(ModelHelper.createCuboid(0f,1f,0.5f,1f,1/16f,15/16f,texture,tintIndex));
            }
            if (!state.get(PillarFrame.CONNECTED_DOWN) && state.get(PillarFrame.CONNECTED_UP)) {
                quads.addAll(ModelHelper.createCuboid(1/16f,15/16f,0f,0.5f,0f,1f,texture,tintIndex));
                quads.addAll(ModelHelper.createCuboid(0f,1f,0f,0.5f,1/16f,15/16f,texture,tintIndex));
            }
            return quads;

        }
        return Collections.emptyList();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean func_230044_c_() {
        return false;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE).apply(new ResourceLocation("minecraft", "block/oak_planks"));
    }

    @Override
    public ItemOverrideList getOverrides() {
        return ItemOverrideList.EMPTY;
    }
}
//========SOLI DEO GLORIA========//