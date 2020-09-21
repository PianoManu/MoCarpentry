package mod.pianomanu.mocarpentry.content.models.baked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.customproperties.PillarSize;
import mod.pianomanu.blockcarpentry.tileentity.FrameBlockTile;
import mod.pianomanu.blockcarpentry.util.TextureHelper;
import mod.pianomanu.mocarpentry.content.blocks.PillarFrame;
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
 * @version 1.1 09/21/20
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
            List<TextureAtlasSprite> textureList = TextureHelper.getTextureFromModel(model, extraData, rand);
            TextureAtlasSprite texture;
            int tex = extraData.getData(FrameBlockTile.TEXTURE);
            if (textureList.size() == 0) {
                return Collections.emptyList();
            }
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
            if (state.get(PillarFrame.SIZE)== PillarSize.SMALL) {
            	if (state.get(PillarFrame.CONNECTED_DOWN) && !state.get(PillarFrame.CONNECTED_UP)) {
                	int[][] listOfCuboids = {{15, 8, 1, 16, 16, 15},
                            {1, 8, 1, 15, 16, 15},
                            {0, 8, 1, 1, 16, 15},
                            {1, 8, 0, 15, 16, 1},
                            {1, 8, 15, 15, 16, 16},
                            {13, 0, 6, 14, 8, 10},
                            {2, 0, 6, 3, 8, 10},
                            {12, 0, 10, 13, 8, 12},
                            {3, 0, 10, 4, 8, 12},
                            {12, 0, 4, 13, 8, 6},
                            {3, 0, 4, 4, 8, 6},
                            {10, 0, 3, 12, 8, 4},
                            {4, 0, 3, 6, 8, 4},
                            {10, 0, 12, 12, 8, 13},
                            {4, 0, 12, 6, 8, 13},
                            {6, 0, 13, 10, 8, 14},
                            {6, 0, 2, 10, 8, 3}};
    				for (int[] cuboid : listOfCuboids) {
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    				}
                } else if (!state.get(PillarFrame.CONNECTED_DOWN) && state.get(PillarFrame.CONNECTED_UP)) {
                	int[][] listOfCuboids = {{15, 0, 1, 16, 8, 15},
                            {1, 0, 1, 15, 8, 15},
                            {0, 0, 1, 1, 8, 15},
                            {1, 0, 0, 15, 8, 1},
                            {1, 0, 15, 15, 8, 16},
                            {13, 8, 6, 14, 16, 10},
                            {2, 8, 6, 3, 16, 10},
                            {12, 8, 10, 13, 16, 12},
                            {3, 8, 10, 4, 16, 12},
                            {12, 8, 4, 13, 16, 6},
                            {3, 8, 4, 4, 16, 6},
                            {10, 8, 3, 12, 16, 4},
                            {4, 8, 3, 6, 16, 4},
                            {10, 8, 12, 12, 16, 13},
                            {4, 8, 12, 6, 16, 13},
                            {6, 8, 13, 10, 16, 14},
                            {6, 8, 2, 10, 16, 3}};
    				for (int[] cuboid : listOfCuboids) {
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
    					quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
					}
            	} else if (state.get(PillarFrame.CONNECTED_DOWN) && state.get(PillarFrame.CONNECTED_UP)) {
            		int[][] listOfCuboids = {{13, 0, 6, 14, 16, 10},
                            {2, 0, 6, 3, 16, 10},
                            {12, 0, 4, 13, 16, 6},
                            {3, 0, 4, 4, 16, 6},
                            {12, 0, 10, 13, 16, 12},
                            {3, 0, 10, 4, 16, 12},
                            {10, 0, 12, 12, 16, 13},
                            {4, 0, 12, 6, 16, 13},
                            {10, 0, 3, 12, 16, 4},
                            {4, 0, 3, 6, 16, 4},
                            {6, 0, 2, 10, 16, 3},
                            {6, 0, 13, 10, 16, 14}};
            		for (int[] cuboid : listOfCuboids) {
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            			quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, false, false));
            		}
                } else if (!state.get(PillarFrame.CONNECTED_DOWN) && !state.get(PillarFrame.CONNECTED_UP)) {
                	int[][] listOfCuboids = {{13, 0, 6, 14, 16, 10},
                			{2, 0, 6, 3, 16, 10},
                            {12, 0, 4, 13, 16, 6},
                            {12, 0, 6, 13, 16, 10},
                            {3, 0, 4, 4, 16, 6},
                            {3, 0, 6, 4, 16, 10},
                            {12, 0, 10, 13, 16, 12},
                            {3, 0, 10, 4, 16, 12},
                            {10, 0, 12, 12, 16, 13},
                            {4, 0, 12, 6, 16, 13},
                            {10, 0, 3, 12, 16, 4},
                            {10, 0, 4, 12, 16, 12},
                            {4, 0, 3, 6, 16, 4},
                            {4, 0, 4, 6, 16, 12},
                            {6, 0, 2, 10, 16, 3},
                            {6, 0, 3, 10, 16, 13},
                            {6, 0, 13, 10, 16, 14}};
                	for (int[] cuboid : listOfCuboids) {
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                		quads.addAll(ModelHelper.createCuboid16(cuboid[0], cuboid[3], cuboid[1], cuboid[4], cuboid[2], cuboid[5], texture, tintIndex, true, true, true, true, true, true));
                	}
                }
            } else {
                switch (state.get(PillarFrame.SIDE)) {
                case WEST:
                    quads.addAll(ModelHelper.createCuboid(0f,3/16f,0f,1f,4/16f,1f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(3/16f,6/16f,0f,1f,5/16f,1f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(6/16f,7/16f,0f,1f,6/16f,1f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(7/16f,8/16f,0f,1f,7/16f,1f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(8/16f,9/16f,0f,1f,8/16f,1f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(9/16f,10/16f,0f,1f,9/16f,1f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(10/16f,11/16f,0f,1f,10/16f,1f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(11/16f,12/16f,0f,1f,13/16f,1f,texture, tintIndex));
                    break;
                case SOUTH:
                    quads.addAll(ModelHelper.createCuboid(4/16f,1f,0f,1f,13/16f,1f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(5/16f,1f,0f,1f,10/16f,13/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(6/16f,1f,0f,1f,9/16f,10/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(7/16f,1f,0f,1f,8/16f,9/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(8/16f,1f,0f,1f,7/16f,8/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(9/16f,1f,0f,1f,6/16f,7/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(10/16f,1f,0f,1f,5/16f,6/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(13/16f,1f,0f,1f,4/16f,5/16f,texture,tintIndex));
                    break;
                case EAST:
                    quads.addAll(ModelHelper.createCuboid(4/16f,1f,0f,1f,0f,3/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(5/16f,1f,0f,1f,3/16f,6/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(6/16f,1f,0f,1f,6/16f,7/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(7/16f,1f,0f,1f,7/16f,8/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(8/16f,1f,0f,1f,8/16f,9/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(9/16f,1f,0f,1f,9/16f,10/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(10/16f,1f,0f,1f,10/16f,11/16f,texture,tintIndex));
                    quads.addAll(ModelHelper.createCuboid(13/16f,1f,0f,1f,11/16f,12/16f,texture,tintIndex));
                    break;
                case NORTH:
                    quads.addAll(ModelHelper.createCuboid(0f,12/16f,0f,1f,0f,3/16f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(0f,11/16f,0f,1f,3/16f,6/16f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(0f,10/16f,0f,1f,6/16f,7/16f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(0f,9/16f,0f,1f,7/16f,8/16f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(0f,8/16f,0f,1f,8/16f,9/16f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(0f,7/16f,0f,1f,9/16f,10/16f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(0f,6/16f,0f,1f,10/16f,11/16f,texture, tintIndex));
                    quads.addAll(ModelHelper.createCuboid(0f,3/16f,0f,1f,11/16f,12/16f,texture, tintIndex));
                    break;
				default:
					break;
                }
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