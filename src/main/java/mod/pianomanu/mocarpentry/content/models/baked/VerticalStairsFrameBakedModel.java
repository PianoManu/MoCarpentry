package mod.pianomanu.mocarpentry.content.models.baked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mod.pianomanu.blockcarpentry.tileentity.FrameBlockTile;
import mod.pianomanu.blockcarpentry.util.TextureHelper;
import mod.pianomanu.mocarpentry.content.blocks.VerticalStairsFrame;
import mod.pianomanu.mocarpentry.utils.ModelHelper;
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
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;

/**
 * This class determines the model of the pillar when it does contain a block
 *
 * @author PianoManu
 * @version 1.0 09/15/20
 */
public class VerticalStairsFrameBakedModel implements IDynamicBakedModel {
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
            switch (state.get(VerticalStairsFrame.HORIZONTAL_FACING)) {
            case NORTH:
                quads.addAll(ModelHelper.createCuboid16(0, 16, 0, 16, 8, 16, texture, tintIndex, true, true, true, true, true, true));
                quads.addAll(ModelHelper.createCuboid16(0, 8, 0, 16, 0, 8, texture, tintIndex, false, true, true, true, true, true));
                return quads;
            case SOUTH:
                quads.addAll(ModelHelper.createCuboid16(8, 16, 0, 16, 0, 16, texture, tintIndex, true, true, true, true, true, true));
                quads.addAll(ModelHelper.createCuboid16(0, 8, 0, 16, 0, 8, texture, tintIndex, true, true, true, true, true, true));
                return quads;
            case EAST:
                quads.addAll(ModelHelper.createCuboid16(0, 8, 0, 16, 0, 16, texture, tintIndex, true, true, true, true, true, true));
                quads.addAll(ModelHelper.createCuboid16(8, 16, 0, 16, 0, 8, texture, tintIndex, true, true, true, true, true, true));
                return quads;
            case WEST:
                quads.addAll(ModelHelper.createCuboid16(8, 16, 0, 16, 0, 16, texture, tintIndex, true, true, true, true, true, true));
                quads.addAll(ModelHelper.createCuboid16(0, 8, 0, 16, 8, 16, texture, tintIndex, true, false, true, true, true, true));
                return quads;
			default:
				return Collections.emptyList();
            }
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

    @SuppressWarnings("deprecation")
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