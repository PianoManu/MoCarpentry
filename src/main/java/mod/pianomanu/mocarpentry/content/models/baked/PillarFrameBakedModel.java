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
            		int[][] listOfCuboids = {{13, 0, 6, 14, 8, 10},
            		        {2, 0, 6, 3, 8, 10},
            		        {12, 0, 4, 13, 8, 6},
            		        {3, 0, 4, 4, 8, 6},
            		        {12, 0, 10, 13, 8, 12},
            		        {3, 0, 10, 4, 8, 12},
            		        {10, 0, 12, 12, 8, 13},
            		        {4, 0, 12, 6, 8, 13},
            		        {10, 0, 3, 12, 8, 4},
            		        {4, 0, 3, 6, 8, 4},
            		        {6, 0, 2, 10, 8, 3},
            		        {6, 0, 13, 10, 8, 14},
            		        {1, 8, 1, 15, 16, 15},
            		        {1, 8, 0, 15, 16, 1},
            		        {1, 8, 15, 15, 16, 16},
            		        {0, 8, 1, 1, 16, 15},
            		        {15, 8, 1, 16, 16, 15}};
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, false, true, true, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, true, false, true, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, false, true, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, true, false, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, false, true, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, true, false, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, false, true, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, true, false, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, false, true, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, true, false, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, true, true, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, true, true, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, false, false, false, false, true, true));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, true, true, false, true, true, true));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, true, true, true, false, true, true));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, true, false, true, true, true, true));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, false, true, true, true, true, true));
                } else if (!state.get(PillarFrame.CONNECTED_DOWN) && state.get(PillarFrame.CONNECTED_UP)) {
                	int[][] listOfCuboids = {{13, 8, 6, 14, 16, 10},
                            {2, 8, 6, 3, 16, 10},
                            {12, 8, 4, 13, 16, 6},
                            {3, 8, 4, 4, 16, 6},
                            {12, 8, 10, 13, 16, 12},
                            {3, 8, 10, 4, 16, 12},
                            {10, 8, 12, 12, 16, 13},
                            {4, 8, 12, 6, 16, 13},
                            {10, 8, 3, 12, 16, 4},
                            {4, 8, 3, 6, 16, 4},
                            {6, 8, 2, 10, 16, 3},
                            {6, 8, 13, 10, 16, 14},
                            {1, 0, 1, 15, 8, 15},
                            {1, 0, 0, 15, 8, 1},
                            {1, 0, 15, 15, 8, 16},
                            {0, 0, 1, 1, 8, 15},
                            {15, 0, 1, 16, 8, 15}};
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, false, true, true, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, true, false, true, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, false, true, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, true, false, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, false, true, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, true, false, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, false, true, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, true, false, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, false, true, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, true, false, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, true, true, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, true, true, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, false, false, false, false, true, true));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, true, true, false, true, true, true));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, true, true, true, false, true, true));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, true, false, true, true, true, true));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, false, true, true, true, true, true));
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
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, false, true, true, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, true, false, true, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, false, true, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, true, false, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, false, true, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, true, false, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, false, true, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, true, false, true, false, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, false, true, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, true, false, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, true, true, false, true, false, false));
            		quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, true, true, true, false, false, false));
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
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, false, true, true, true, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, true, false, true, true, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, false, true, false, true, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, false, false, false, false, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, true, false, false, true, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, false, false, false, false, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, false, true, true, false, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, true, false, true, false, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, false, true, true, false, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, true, false, true, false, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, false, true, false, true, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, false, false, false, false, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, true, false, false, true, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, false, false, false, false, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, true, true, false, true, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, false, false, false, false, true, true));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, true, true, true, false, true, true));
                }
            } else {
            	if (state.get(PillarFrame.CONNECTED_DOWN) && !state.get(PillarFrame.CONNECTED_UP)) {
            		switch (state.get(PillarFrame.SIDE)) {
                    case WEST:
                    	int[][] listOfCuboids = {{0, 0, 4, 3, 8, 5},
                    	        {3, 0, 5, 6, 8, 6},
                    	        {6, 0, 6, 7, 8, 7},
                    	        {7, 0, 7, 8, 8, 8},
                    	        {8, 0, 8, 9, 8, 9},
                    	        {9, 0, 9, 10, 8, 10},
                    	        {10, 0, 10, 11, 8, 13},
                    	        {11, 0, 13, 12, 8, 16},
                    	        {0, 8, 0, 12, 16, 1},
                    	        {12, 8, 1, 14, 16, 2},
                    	        {14, 8, 2, 15, 16, 4},
                    	        {15, 8, 4, 16, 16, 16},
                    	        {0, 8, 1, 12, 16, 16},
                    	        {12, 8, 2, 14, 16, 16},
                    	        {14, 8, 4, 15, 16, 16}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
                    case SOUTH:
                    	int[][] listOfCuboids1 = {{13, 0, 4, 16, 8, 5},
                    	        {10, 0, 5, 13, 8, 6},
                    	        {9, 0, 6, 10, 8, 7},
                    	        {8, 0, 7, 9, 8, 8},
                    	        {7, 0, 8, 8, 8, 9},
                    	        {6, 0, 9, 7, 8, 10},
                    	        {5, 0, 10, 6, 8, 13},
                    	        {4, 0, 13, 5, 8, 16},
                    	        {4, 8, 0, 16, 16, 1},
                    	        {2, 8, 1, 4, 16, 2},
                    	        {1, 8, 2, 2, 16, 4},
                    	        {0, 8, 4, 1, 16, 16},
                    	        {4, 8, 1, 16, 16, 16},
                    	        {2, 8, 2, 4, 16, 16},
                    	        {1, 8, 4, 2, 16, 16}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[0][0], listOfCuboids1[0][3], listOfCuboids1[0][1], listOfCuboids1[0][4], listOfCuboids1[0][2], listOfCuboids1[0][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[1][0], listOfCuboids1[1][3], listOfCuboids1[1][1], listOfCuboids1[1][4], listOfCuboids1[1][2], listOfCuboids1[1][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[2][0], listOfCuboids1[2][3], listOfCuboids1[2][1], listOfCuboids1[2][4], listOfCuboids1[2][2], listOfCuboids1[2][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[3][0], listOfCuboids1[3][3], listOfCuboids1[3][1], listOfCuboids1[3][4], listOfCuboids1[3][2], listOfCuboids1[3][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[4][0], listOfCuboids1[4][3], listOfCuboids1[4][1], listOfCuboids1[4][4], listOfCuboids1[4][2], listOfCuboids1[4][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[5][0], listOfCuboids1[5][3], listOfCuboids1[5][1], listOfCuboids1[5][4], listOfCuboids1[5][2], listOfCuboids1[5][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[6][0], listOfCuboids1[6][3], listOfCuboids1[6][1], listOfCuboids1[6][4], listOfCuboids1[6][2], listOfCuboids1[6][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[7][0], listOfCuboids1[7][3], listOfCuboids1[7][1], listOfCuboids1[7][4], listOfCuboids1[7][2], listOfCuboids1[7][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[8][0], listOfCuboids1[8][3], listOfCuboids1[8][1], listOfCuboids1[8][4], listOfCuboids1[8][2], listOfCuboids1[8][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[9][0], listOfCuboids1[9][3], listOfCuboids1[9][1], listOfCuboids1[9][4], listOfCuboids1[9][2], listOfCuboids1[9][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[10][0], listOfCuboids1[10][3], listOfCuboids1[10][1], listOfCuboids1[10][4], listOfCuboids1[10][2], listOfCuboids1[10][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[11][0], listOfCuboids1[11][3], listOfCuboids1[11][1], listOfCuboids1[11][4], listOfCuboids1[11][2], listOfCuboids1[11][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[12][0], listOfCuboids1[12][3], listOfCuboids1[12][1], listOfCuboids1[12][4], listOfCuboids1[12][2], listOfCuboids1[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[13][0], listOfCuboids1[13][3], listOfCuboids1[13][1], listOfCuboids1[13][4], listOfCuboids1[13][2], listOfCuboids1[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[14][0], listOfCuboids1[14][3], listOfCuboids1[14][1], listOfCuboids1[14][4], listOfCuboids1[14][2], listOfCuboids1[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
                    case EAST:
                    	int[][] listOfCuboids11 = {{13, 0, 11, 16, 8, 12},
                    	        {10, 0, 10, 13, 8, 11},
                    	        {9, 0, 9, 10, 8, 10},
                    	        {8, 0, 8, 9, 8, 9},
                    	        {7, 0, 7, 8, 8, 8},
                    	        {6, 0, 6, 7, 8, 7},
                    	        {5, 0, 3, 6, 8, 6},
                    	        {4, 0, 0, 5, 8, 3},
                    	        {4, 8, 15, 16, 16, 16},
                    	        {2, 8, 14, 4, 16, 15},
                    	        {1, 8, 12, 2, 16, 14},
                    	        {0, 8, 0, 1, 16, 12},
                    	        {4, 8, 0, 16, 16, 15},
                    	        {2, 8, 0, 4, 16, 14},
                    	        {1, 8, 0, 2, 16, 12}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[0][0], listOfCuboids11[0][3], listOfCuboids11[0][1], listOfCuboids11[0][4], listOfCuboids11[0][2], listOfCuboids11[0][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[1][0], listOfCuboids11[1][3], listOfCuboids11[1][1], listOfCuboids11[1][4], listOfCuboids11[1][2], listOfCuboids11[1][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[2][0], listOfCuboids11[2][3], listOfCuboids11[2][1], listOfCuboids11[2][4], listOfCuboids11[2][2], listOfCuboids11[2][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[3][0], listOfCuboids11[3][3], listOfCuboids11[3][1], listOfCuboids11[3][4], listOfCuboids11[3][2], listOfCuboids11[3][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[4][0], listOfCuboids11[4][3], listOfCuboids11[4][1], listOfCuboids11[4][4], listOfCuboids11[4][2], listOfCuboids11[4][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[5][0], listOfCuboids11[5][3], listOfCuboids11[5][1], listOfCuboids11[5][4], listOfCuboids11[5][2], listOfCuboids11[5][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[6][0], listOfCuboids11[6][3], listOfCuboids11[6][1], listOfCuboids11[6][4], listOfCuboids11[6][2], listOfCuboids11[6][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[7][0], listOfCuboids11[7][3], listOfCuboids11[7][1], listOfCuboids11[7][4], listOfCuboids11[7][2], listOfCuboids11[7][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[8][0], listOfCuboids11[8][3], listOfCuboids11[8][1], listOfCuboids11[8][4], listOfCuboids11[8][2], listOfCuboids11[8][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[9][0], listOfCuboids11[9][3], listOfCuboids11[9][1], listOfCuboids11[9][4], listOfCuboids11[9][2], listOfCuboids11[9][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[10][0], listOfCuboids11[10][3], listOfCuboids11[10][1], listOfCuboids11[10][4], listOfCuboids11[10][2], listOfCuboids11[10][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[11][0], listOfCuboids11[11][3], listOfCuboids11[11][1], listOfCuboids11[11][4], listOfCuboids11[11][2], listOfCuboids11[11][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[12][0], listOfCuboids11[12][3], listOfCuboids11[12][1], listOfCuboids11[12][4], listOfCuboids11[12][2], listOfCuboids11[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[13][0], listOfCuboids11[13][3], listOfCuboids11[13][1], listOfCuboids11[13][4], listOfCuboids11[13][2], listOfCuboids11[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[14][0], listOfCuboids11[14][3], listOfCuboids11[14][1], listOfCuboids11[14][4], listOfCuboids11[14][2], listOfCuboids11[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
                    case NORTH:
                    	int[][] listOfCuboids111 = {{0, 0, 11, 3, 8, 12},
                    	        {3, 0, 10, 6, 8, 11},
                    	        {6, 0, 9, 7, 8, 10},
                    	        {7, 0, 8, 8, 8, 9},
                    	        {8, 0, 7, 9, 8, 8},
                    	        {9, 0, 6, 10, 8, 7},
                    	        {10, 0, 3, 11, 8, 6},
                    	        {11, 0, 0, 12, 8, 3},
                    	        {0, 8, 15, 12, 16, 16},
                    	        {12, 8, 14, 14, 16, 15},
                    	        {14, 8, 12, 15, 16, 14},
                    	        {15, 8, 0, 16, 16, 12},
                    	        {0, 8, 0, 12, 16, 15},
                    	        {12, 8, 0, 14, 16, 14},
                    	        {14, 8, 0, 15, 16, 12}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[0][0], listOfCuboids111[0][3], listOfCuboids111[0][1], listOfCuboids111[0][4], listOfCuboids111[0][2], listOfCuboids111[0][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[1][0], listOfCuboids111[1][3], listOfCuboids111[1][1], listOfCuboids111[1][4], listOfCuboids111[1][2], listOfCuboids111[1][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[2][0], listOfCuboids111[2][3], listOfCuboids111[2][1], listOfCuboids111[2][4], listOfCuboids111[2][2], listOfCuboids111[2][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[3][0], listOfCuboids111[3][3], listOfCuboids111[3][1], listOfCuboids111[3][4], listOfCuboids111[3][2], listOfCuboids111[3][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[4][0], listOfCuboids111[4][3], listOfCuboids111[4][1], listOfCuboids111[4][4], listOfCuboids111[4][2], listOfCuboids111[4][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[5][0], listOfCuboids111[5][3], listOfCuboids111[5][1], listOfCuboids111[5][4], listOfCuboids111[5][2], listOfCuboids111[5][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[6][0], listOfCuboids111[6][3], listOfCuboids111[6][1], listOfCuboids111[6][4], listOfCuboids111[6][2], listOfCuboids111[6][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[7][0], listOfCuboids111[7][3], listOfCuboids111[7][1], listOfCuboids111[7][4], listOfCuboids111[7][2], listOfCuboids111[7][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[8][0], listOfCuboids111[8][3], listOfCuboids111[8][1], listOfCuboids111[8][4], listOfCuboids111[8][2], listOfCuboids111[8][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[9][0], listOfCuboids111[9][3], listOfCuboids111[9][1], listOfCuboids111[9][4], listOfCuboids111[9][2], listOfCuboids111[9][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[10][0], listOfCuboids111[10][3], listOfCuboids111[10][1], listOfCuboids111[10][4], listOfCuboids111[10][2], listOfCuboids111[10][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[11][0], listOfCuboids111[11][3], listOfCuboids111[11][1], listOfCuboids111[11][4], listOfCuboids111[11][2], listOfCuboids111[11][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[12][0], listOfCuboids111[12][3], listOfCuboids111[12][1], listOfCuboids111[12][4], listOfCuboids111[12][2], listOfCuboids111[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[13][0], listOfCuboids111[13][3], listOfCuboids111[13][1], listOfCuboids111[13][4], listOfCuboids111[13][2], listOfCuboids111[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[14][0], listOfCuboids111[14][3], listOfCuboids111[14][1], listOfCuboids111[14][4], listOfCuboids111[14][2], listOfCuboids111[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
    				default:
    					break;
                    }
                } else if (!state.get(PillarFrame.CONNECTED_DOWN) && state.get(PillarFrame.CONNECTED_UP)) {
                    switch (state.get(PillarFrame.SIDE)) {
                    case WEST:
                    	int[][] listOfCuboids = {{0, 8, 4, 3, 16, 5},
                    	        {3, 8, 5, 6, 16, 6},
                    	        {6, 8, 6, 7, 16, 7},
                    	        {7, 8, 7, 8, 16, 8},
                    	        {8, 8, 8, 9, 16, 9},
                    	        {9, 8, 9, 10, 16, 10},
                    	        {10, 8, 10, 11, 16, 13},
                    	        {11, 8, 13, 12, 16, 16},
                    	        {0, 0, 0, 12, 8, 1},
                    	        {12, 0, 1, 14, 8, 2},
                    	        {14, 0, 2, 15, 8, 4},
                    	        {15, 0, 4, 16, 8, 16},
                    	        {0, 0, 1, 12, 8, 16},
                    	        {12, 0, 2, 14, 8, 16},
                    	        {14, 0, 4, 15, 8, 16}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
                    case SOUTH:
                    	int[][] listOfCuboids1 = {{13, 8, 4, 16, 16, 5},
                    	        {10, 8, 5, 13, 16, 6},
                    	        {9, 8, 6, 10, 16, 7},
                    	        {8, 8, 7, 9, 16, 8},
                    	        {7, 8, 8, 8, 16, 9},
                    	        {6, 8, 9, 7, 16, 10},
                    	        {5, 8, 10, 6, 16, 13},
                    	        {4, 8, 13, 5, 16, 16},
                    	        {4, 0, 0, 16, 8, 1},
                    	        {2, 0, 1, 4, 8, 2},
                    	        {1, 0, 2, 2, 8, 4},
                    	        {0, 0, 4, 1, 8, 16},
                    	        {4, 0, 1, 16, 8, 16},
                    	        {2, 0, 2, 4, 8, 16},
                    	        {1, 0, 4, 2, 8, 16}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[0][0], listOfCuboids1[0][3], listOfCuboids1[0][1], listOfCuboids1[0][4], listOfCuboids1[0][2], listOfCuboids1[0][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[1][0], listOfCuboids1[1][3], listOfCuboids1[1][1], listOfCuboids1[1][4], listOfCuboids1[1][2], listOfCuboids1[1][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[2][0], listOfCuboids1[2][3], listOfCuboids1[2][1], listOfCuboids1[2][4], listOfCuboids1[2][2], listOfCuboids1[2][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[3][0], listOfCuboids1[3][3], listOfCuboids1[3][1], listOfCuboids1[3][4], listOfCuboids1[3][2], listOfCuboids1[3][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[4][0], listOfCuboids1[4][3], listOfCuboids1[4][1], listOfCuboids1[4][4], listOfCuboids1[4][2], listOfCuboids1[4][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[5][0], listOfCuboids1[5][3], listOfCuboids1[5][1], listOfCuboids1[5][4], listOfCuboids1[5][2], listOfCuboids1[5][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[6][0], listOfCuboids1[6][3], listOfCuboids1[6][1], listOfCuboids1[6][4], listOfCuboids1[6][2], listOfCuboids1[6][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[7][0], listOfCuboids1[7][3], listOfCuboids1[7][1], listOfCuboids1[7][4], listOfCuboids1[7][2], listOfCuboids1[7][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[8][0], listOfCuboids1[8][3], listOfCuboids1[8][1], listOfCuboids1[8][4], listOfCuboids1[8][2], listOfCuboids1[8][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[9][0], listOfCuboids1[9][3], listOfCuboids1[9][1], listOfCuboids1[9][4], listOfCuboids1[9][2], listOfCuboids1[9][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[10][0], listOfCuboids1[10][3], listOfCuboids1[10][1], listOfCuboids1[10][4], listOfCuboids1[10][2], listOfCuboids1[10][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[11][0], listOfCuboids1[11][3], listOfCuboids1[11][1], listOfCuboids1[11][4], listOfCuboids1[11][2], listOfCuboids1[11][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[12][0], listOfCuboids1[12][3], listOfCuboids1[12][1], listOfCuboids1[12][4], listOfCuboids1[12][2], listOfCuboids1[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[13][0], listOfCuboids1[13][3], listOfCuboids1[13][1], listOfCuboids1[13][4], listOfCuboids1[13][2], listOfCuboids1[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[14][0], listOfCuboids1[14][3], listOfCuboids1[14][1], listOfCuboids1[14][4], listOfCuboids1[14][2], listOfCuboids1[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
                    case EAST:
                    	int[][] listOfCuboids11 = {{13, 8, 11, 16, 16, 12},
                    	        {10, 8, 10, 13, 16, 11},
                    	        {9, 8, 9, 10, 16, 10},
                    	        {8, 8, 8, 9, 16, 9},
                    	        {7, 8, 7, 8, 16, 8},
                    	        {6, 8, 6, 7, 16, 7},
                    	        {5, 8, 3, 6, 16, 6},
                    	        {4, 8, 0, 5, 16, 3},
                    	        {4, 0, 15, 16, 8, 16},
                    	        {2, 0, 14, 4, 8, 15},
                    	        {1, 0, 12, 2, 8, 14},
                    	        {0, 0, 0, 1, 8, 12},
                    	        {4, 0, 0, 16, 8, 15},
                    	        {2, 0, 0, 4, 8, 14},
                    	        {1, 0, 0, 2, 8, 12}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[0][0], listOfCuboids11[0][3], listOfCuboids11[0][1], listOfCuboids11[0][4], listOfCuboids11[0][2], listOfCuboids11[0][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[1][0], listOfCuboids11[1][3], listOfCuboids11[1][1], listOfCuboids11[1][4], listOfCuboids11[1][2], listOfCuboids11[1][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[2][0], listOfCuboids11[2][3], listOfCuboids11[2][1], listOfCuboids11[2][4], listOfCuboids11[2][2], listOfCuboids11[2][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[3][0], listOfCuboids11[3][3], listOfCuboids11[3][1], listOfCuboids11[3][4], listOfCuboids11[3][2], listOfCuboids11[3][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[4][0], listOfCuboids11[4][3], listOfCuboids11[4][1], listOfCuboids11[4][4], listOfCuboids11[4][2], listOfCuboids11[4][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[5][0], listOfCuboids11[5][3], listOfCuboids11[5][1], listOfCuboids11[5][4], listOfCuboids11[5][2], listOfCuboids11[5][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[6][0], listOfCuboids11[6][3], listOfCuboids11[6][1], listOfCuboids11[6][4], listOfCuboids11[6][2], listOfCuboids11[6][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[7][0], listOfCuboids11[7][3], listOfCuboids11[7][1], listOfCuboids11[7][4], listOfCuboids11[7][2], listOfCuboids11[7][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[8][0], listOfCuboids11[8][3], listOfCuboids11[8][1], listOfCuboids11[8][4], listOfCuboids11[8][2], listOfCuboids11[8][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[9][0], listOfCuboids11[9][3], listOfCuboids11[9][1], listOfCuboids11[9][4], listOfCuboids11[9][2], listOfCuboids11[9][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[10][0], listOfCuboids11[10][3], listOfCuboids11[10][1], listOfCuboids11[10][4], listOfCuboids11[10][2], listOfCuboids11[10][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[11][0], listOfCuboids11[11][3], listOfCuboids11[11][1], listOfCuboids11[11][4], listOfCuboids11[11][2], listOfCuboids11[11][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[12][0], listOfCuboids11[12][3], listOfCuboids11[12][1], listOfCuboids11[12][4], listOfCuboids11[12][2], listOfCuboids11[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[13][0], listOfCuboids11[13][3], listOfCuboids11[13][1], listOfCuboids11[13][4], listOfCuboids11[13][2], listOfCuboids11[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[14][0], listOfCuboids11[14][3], listOfCuboids11[14][1], listOfCuboids11[14][4], listOfCuboids11[14][2], listOfCuboids11[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
                    case NORTH:
                    	int[][] listOfCuboids111 = {{0, 8, 11, 3, 16, 12},
                    	        {3, 8, 10, 6, 16, 11},
                    	        {6, 8, 9, 7, 16, 10},
                    	        {7, 8, 8, 8, 16, 9},
                    	        {8, 8, 7, 9, 16, 8},
                    	        {9, 8, 6, 10, 16, 7},
                    	        {10, 8, 3, 11, 16, 6},
                    	        {11, 8, 0, 12, 16, 3},
                    	        {0, 0, 15, 12, 8, 16},
                    	        {12, 0, 14, 14, 8, 15},
                    	        {14, 0, 12, 15, 8, 14},
                    	        {15, 0, 0, 16, 8, 12},
                    	        {0, 0, 0, 12, 8, 15},
                    	        {12, 0, 0, 14, 8, 14},
                    	        {14, 0, 0, 15, 8, 12}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[0][0], listOfCuboids111[0][3], listOfCuboids111[0][1], listOfCuboids111[0][4], listOfCuboids111[0][2], listOfCuboids111[0][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[1][0], listOfCuboids111[1][3], listOfCuboids111[1][1], listOfCuboids111[1][4], listOfCuboids111[1][2], listOfCuboids111[1][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[2][0], listOfCuboids111[2][3], listOfCuboids111[2][1], listOfCuboids111[2][4], listOfCuboids111[2][2], listOfCuboids111[2][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[3][0], listOfCuboids111[3][3], listOfCuboids111[3][1], listOfCuboids111[3][4], listOfCuboids111[3][2], listOfCuboids111[3][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[4][0], listOfCuboids111[4][3], listOfCuboids111[4][1], listOfCuboids111[4][4], listOfCuboids111[4][2], listOfCuboids111[4][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[5][0], listOfCuboids111[5][3], listOfCuboids111[5][1], listOfCuboids111[5][4], listOfCuboids111[5][2], listOfCuboids111[5][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[6][0], listOfCuboids111[6][3], listOfCuboids111[6][1], listOfCuboids111[6][4], listOfCuboids111[6][2], listOfCuboids111[6][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[7][0], listOfCuboids111[7][3], listOfCuboids111[7][1], listOfCuboids111[7][4], listOfCuboids111[7][2], listOfCuboids111[7][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[8][0], listOfCuboids111[8][3], listOfCuboids111[8][1], listOfCuboids111[8][4], listOfCuboids111[8][2], listOfCuboids111[8][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[9][0], listOfCuboids111[9][3], listOfCuboids111[9][1], listOfCuboids111[9][4], listOfCuboids111[9][2], listOfCuboids111[9][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[10][0], listOfCuboids111[10][3], listOfCuboids111[10][1], listOfCuboids111[10][4], listOfCuboids111[10][2], listOfCuboids111[10][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[11][0], listOfCuboids111[11][3], listOfCuboids111[11][1], listOfCuboids111[11][4], listOfCuboids111[11][2], listOfCuboids111[11][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[12][0], listOfCuboids111[12][3], listOfCuboids111[12][1], listOfCuboids111[12][4], listOfCuboids111[12][2], listOfCuboids111[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[13][0], listOfCuboids111[13][3], listOfCuboids111[13][1], listOfCuboids111[13][4], listOfCuboids111[13][2], listOfCuboids111[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[14][0], listOfCuboids111[14][3], listOfCuboids111[14][1], listOfCuboids111[14][4], listOfCuboids111[14][2], listOfCuboids111[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
    				default:
    					break;
                    }
            	} else if (state.get(PillarFrame.CONNECTED_DOWN) && state.get(PillarFrame.CONNECTED_UP)) {
                    switch (state.get(PillarFrame.SIDE)) {
                    case WEST:
                    	int[][] listOfCuboids = {{0, 0, 4, 3, 16, 5},
                    	        {3, 0, 5, 6, 16, 6},
                    	        {6, 0, 6, 7, 16, 7},
                    	        {7, 0, 7, 8, 16, 8},
                    	        {8, 0, 8, 9, 16, 9},
                    	        {9, 0, 9, 10, 16, 10},
                    	        {10, 0, 10, 11, 16, 13},
                    	        {11, 0, 13, 12, 16, 16}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, false, true, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, false, true, false, true, false, false));
                        break;
                    case SOUTH:
                    	int[][] listOfCuboids1 = {{13, 0, 4, 16, 16, 5},
                    	        {10, 0, 5, 13, 16, 6},
                    	        {9, 0, 6, 10, 16, 7},
                    	        {8, 0, 7, 9, 16, 8},
                    	        {7, 0, 8, 8, 16, 9},
                    	        {6, 0, 9, 7, 16, 10},
                    	        {5, 0, 10, 6, 16, 13},
                    	        {4, 0, 13, 5, 16, 16}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[0][0], listOfCuboids1[0][3], listOfCuboids1[0][1], listOfCuboids1[0][4], listOfCuboids1[0][2], listOfCuboids1[0][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[1][0], listOfCuboids1[1][3], listOfCuboids1[1][1], listOfCuboids1[1][4], listOfCuboids1[1][2], listOfCuboids1[1][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[2][0], listOfCuboids1[2][3], listOfCuboids1[2][1], listOfCuboids1[2][4], listOfCuboids1[2][2], listOfCuboids1[2][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[3][0], listOfCuboids1[3][3], listOfCuboids1[3][1], listOfCuboids1[3][4], listOfCuboids1[3][2], listOfCuboids1[3][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[4][0], listOfCuboids1[4][3], listOfCuboids1[4][1], listOfCuboids1[4][4], listOfCuboids1[4][2], listOfCuboids1[4][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[5][0], listOfCuboids1[5][3], listOfCuboids1[5][1], listOfCuboids1[5][4], listOfCuboids1[5][2], listOfCuboids1[5][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[6][0], listOfCuboids1[6][3], listOfCuboids1[6][1], listOfCuboids1[6][4], listOfCuboids1[6][2], listOfCuboids1[6][5], texture, tintIndex, true, false, false, true, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[7][0], listOfCuboids1[7][3], listOfCuboids1[7][1], listOfCuboids1[7][4], listOfCuboids1[7][2], listOfCuboids1[7][5], texture, tintIndex, true, false, false, true, false, false));
                        break;
                    case EAST:
                    	int[][] listOfCuboids11 = {{13, 0, 11, 16, 16, 12},
                    	        {10, 0, 10, 13, 16, 11},
                    	        {9, 0, 9, 10, 16, 10},
                    	        {8, 0, 8, 9, 16, 9},
                    	        {7, 0, 7, 8, 16, 8},
                    	        {6, 0, 6, 7, 16, 7},
                    	        {5, 0, 3, 6, 16, 6},
                    	        {4, 0, 0, 5, 16, 3}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[0][0], listOfCuboids11[0][3], listOfCuboids11[0][1], listOfCuboids11[0][4], listOfCuboids11[0][2], listOfCuboids11[0][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[1][0], listOfCuboids11[1][3], listOfCuboids11[1][1], listOfCuboids11[1][4], listOfCuboids11[1][2], listOfCuboids11[1][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[2][0], listOfCuboids11[2][3], listOfCuboids11[2][1], listOfCuboids11[2][4], listOfCuboids11[2][2], listOfCuboids11[2][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[3][0], listOfCuboids11[3][3], listOfCuboids11[3][1], listOfCuboids11[3][4], listOfCuboids11[3][2], listOfCuboids11[3][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[4][0], listOfCuboids11[4][3], listOfCuboids11[4][1], listOfCuboids11[4][4], listOfCuboids11[4][2], listOfCuboids11[4][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[5][0], listOfCuboids11[5][3], listOfCuboids11[5][1], listOfCuboids11[5][4], listOfCuboids11[5][2], listOfCuboids11[5][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[6][0], listOfCuboids11[6][3], listOfCuboids11[6][1], listOfCuboids11[6][4], listOfCuboids11[6][2], listOfCuboids11[6][5], texture, tintIndex, true, false, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[7][0], listOfCuboids11[7][3], listOfCuboids11[7][1], listOfCuboids11[7][4], listOfCuboids11[7][2], listOfCuboids11[7][5], texture, tintIndex, true, false, true, false, false, false));
                        break;
                    case NORTH:
                    	int[][] listOfCuboids111 = {{0, 0, 11, 3, 16, 12},
                    	        {3, 0, 10, 6, 16, 11},
                    	        {6, 0, 9, 7, 16, 10},
                    	        {7, 0, 8, 8, 16, 9},
                    	        {8, 0, 7, 9, 16, 8},
                    	        {9, 0, 6, 10, 16, 7},
                    	        {10, 0, 3, 11, 16, 6},
                    	        {11, 0, 0, 12, 16, 3}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[0][0], listOfCuboids111[0][3], listOfCuboids111[0][1], listOfCuboids111[0][4], listOfCuboids111[0][2], listOfCuboids111[0][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[1][0], listOfCuboids111[1][3], listOfCuboids111[1][1], listOfCuboids111[1][4], listOfCuboids111[1][2], listOfCuboids111[1][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[2][0], listOfCuboids111[2][3], listOfCuboids111[2][1], listOfCuboids111[2][4], listOfCuboids111[2][2], listOfCuboids111[2][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[3][0], listOfCuboids111[3][3], listOfCuboids111[3][1], listOfCuboids111[3][4], listOfCuboids111[3][2], listOfCuboids111[3][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[4][0], listOfCuboids111[4][3], listOfCuboids111[4][1], listOfCuboids111[4][4], listOfCuboids111[4][2], listOfCuboids111[4][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[5][0], listOfCuboids111[5][3], listOfCuboids111[5][1], listOfCuboids111[5][4], listOfCuboids111[5][2], listOfCuboids111[5][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[6][0], listOfCuboids111[6][3], listOfCuboids111[6][1], listOfCuboids111[6][4], listOfCuboids111[6][2], listOfCuboids111[6][5], texture, tintIndex, false, true, true, false, false, false));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[7][0], listOfCuboids111[7][3], listOfCuboids111[7][1], listOfCuboids111[7][4], listOfCuboids111[7][2], listOfCuboids111[7][5], texture, tintIndex, false, true, true, false, false, false));
                        break;
    				default:
    					break;
                    }
                } else if (!state.get(PillarFrame.CONNECTED_DOWN) && !state.get(PillarFrame.CONNECTED_UP)) {
                    switch (state.get(PillarFrame.SIDE)) {
                    case WEST:
                    	int[][] listOfCuboids = {{0, 0, 4, 3, 16, 5},
                    	        {3, 0, 5, 6, 16, 6},
                    	        {6, 0, 6, 7, 16, 7},
                    	        {7, 0, 7, 8, 16, 8},
                    	        {8, 0, 8, 9, 16, 9},
                    	        {9, 0, 9, 10, 16, 10},
                    	        {10, 0, 10, 11, 16, 13},
                    	        {11, 0, 13, 12, 16, 16},
                    	        {0, 0, 5, 3, 16, 16},
                    	        {3, 0, 6, 6, 16, 16},
                    	        {6, 0, 7, 7, 16, 16},
                    	        {7, 0, 8, 8, 16, 16},
                    	        {8, 0, 9, 9, 16, 16},
                    	        {9, 0, 10, 10, 16, 16},
                    	        {10, 0, 13, 11, 16, 16}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, false, true, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
                    case SOUTH:
                    	int[][] listOfCuboids1 = {{13, 0, 4, 16, 16, 5},
                    	        {10, 0, 5, 13, 16, 6},
                    	        {9, 0, 6, 10, 16, 7},
                    	        {8, 0, 7, 9, 16, 8},
                    	        {7, 0, 8, 8, 16, 9},
                    	        {6, 0, 9, 7, 16, 10},
                    	        {5, 0, 10, 6, 16, 13},
                    	        {4, 0, 13, 5, 16, 16},
                    	        {13, 0, 5, 16, 16, 16},
                    	        {10, 0, 6, 13, 16, 16},
                    	        {9, 0, 7, 10, 16, 16},
                    	        {8, 0, 8, 9, 16, 16},
                    	        {7, 0, 9, 8, 16, 16},
                    	        {6, 0, 10, 7, 16, 16},
                    	        {5, 0, 13, 6, 16, 16}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[0][0], listOfCuboids1[0][3], listOfCuboids1[0][1], listOfCuboids1[0][4], listOfCuboids1[0][2], listOfCuboids1[0][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[1][0], listOfCuboids1[1][3], listOfCuboids1[1][1], listOfCuboids1[1][4], listOfCuboids1[1][2], listOfCuboids1[1][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[2][0], listOfCuboids1[2][3], listOfCuboids1[2][1], listOfCuboids1[2][4], listOfCuboids1[2][2], listOfCuboids1[2][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[3][0], listOfCuboids1[3][3], listOfCuboids1[3][1], listOfCuboids1[3][4], listOfCuboids1[3][2], listOfCuboids1[3][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[4][0], listOfCuboids1[4][3], listOfCuboids1[4][1], listOfCuboids1[4][4], listOfCuboids1[4][2], listOfCuboids1[4][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[5][0], listOfCuboids1[5][3], listOfCuboids1[5][1], listOfCuboids1[5][4], listOfCuboids1[5][2], listOfCuboids1[5][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[6][0], listOfCuboids1[6][3], listOfCuboids1[6][1], listOfCuboids1[6][4], listOfCuboids1[6][2], listOfCuboids1[6][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[7][0], listOfCuboids1[7][3], listOfCuboids1[7][1], listOfCuboids1[7][4], listOfCuboids1[7][2], listOfCuboids1[7][5], texture, tintIndex, true, false, false, true, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[8][0], listOfCuboids1[8][3], listOfCuboids1[8][1], listOfCuboids1[8][4], listOfCuboids1[8][2], listOfCuboids1[8][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[9][0], listOfCuboids1[9][3], listOfCuboids1[9][1], listOfCuboids1[9][4], listOfCuboids1[9][2], listOfCuboids1[9][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[10][0], listOfCuboids1[10][3], listOfCuboids1[10][1], listOfCuboids1[10][4], listOfCuboids1[10][2], listOfCuboids1[10][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[11][0], listOfCuboids1[11][3], listOfCuboids1[11][1], listOfCuboids1[11][4], listOfCuboids1[11][2], listOfCuboids1[11][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[12][0], listOfCuboids1[12][3], listOfCuboids1[12][1], listOfCuboids1[12][4], listOfCuboids1[12][2], listOfCuboids1[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[13][0], listOfCuboids1[13][3], listOfCuboids1[13][1], listOfCuboids1[13][4], listOfCuboids1[13][2], listOfCuboids1[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[14][0], listOfCuboids1[14][3], listOfCuboids1[14][1], listOfCuboids1[14][4], listOfCuboids1[14][2], listOfCuboids1[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
                    case EAST:
                    	int[][] listOfCuboids11 = {{13, 0, 11, 16, 16, 12},
                    	        {10, 0, 10, 13, 16, 11},
                    	        {9, 0, 9, 10, 16, 10},
                    	        {8, 0, 8, 9, 16, 9},
                    	        {7, 0, 7, 8, 16, 8},
                    	        {6, 0, 6, 7, 16, 7},
                    	        {5, 0, 3, 6, 16, 6},
                    	        {4, 0, 0, 5, 16, 3},
                    	        {13, 0, 0, 16, 16, 11},
                    	        {10, 0, 0, 13, 16, 10},
                    	        {9, 0, 0, 10, 16, 9},
                    	        {8, 0, 0, 9, 16, 8},
                    	        {7, 0, 0, 8, 16, 7},
                    	        {6, 0, 0, 7, 16, 6},
                    	        {5, 0, 0, 6, 16, 3}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[0][0], listOfCuboids11[0][3], listOfCuboids11[0][1], listOfCuboids11[0][4], listOfCuboids11[0][2], listOfCuboids11[0][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[1][0], listOfCuboids11[1][3], listOfCuboids11[1][1], listOfCuboids11[1][4], listOfCuboids11[1][2], listOfCuboids11[1][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[2][0], listOfCuboids11[2][3], listOfCuboids11[2][1], listOfCuboids11[2][4], listOfCuboids11[2][2], listOfCuboids11[2][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[3][0], listOfCuboids11[3][3], listOfCuboids11[3][1], listOfCuboids11[3][4], listOfCuboids11[3][2], listOfCuboids11[3][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[4][0], listOfCuboids11[4][3], listOfCuboids11[4][1], listOfCuboids11[4][4], listOfCuboids11[4][2], listOfCuboids11[4][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[5][0], listOfCuboids11[5][3], listOfCuboids11[5][1], listOfCuboids11[5][4], listOfCuboids11[5][2], listOfCuboids11[5][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[6][0], listOfCuboids11[6][3], listOfCuboids11[6][1], listOfCuboids11[6][4], listOfCuboids11[6][2], listOfCuboids11[6][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[7][0], listOfCuboids11[7][3], listOfCuboids11[7][1], listOfCuboids11[7][4], listOfCuboids11[7][2], listOfCuboids11[7][5], texture, tintIndex, true, false, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[8][0], listOfCuboids11[8][3], listOfCuboids11[8][1], listOfCuboids11[8][4], listOfCuboids11[8][2], listOfCuboids11[8][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[9][0], listOfCuboids11[9][3], listOfCuboids11[9][1], listOfCuboids11[9][4], listOfCuboids11[9][2], listOfCuboids11[9][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[10][0], listOfCuboids11[10][3], listOfCuboids11[10][1], listOfCuboids11[10][4], listOfCuboids11[10][2], listOfCuboids11[10][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[11][0], listOfCuboids11[11][3], listOfCuboids11[11][1], listOfCuboids11[11][4], listOfCuboids11[11][2], listOfCuboids11[11][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[12][0], listOfCuboids11[12][3], listOfCuboids11[12][1], listOfCuboids11[12][4], listOfCuboids11[12][2], listOfCuboids11[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[13][0], listOfCuboids11[13][3], listOfCuboids11[13][1], listOfCuboids11[13][4], listOfCuboids11[13][2], listOfCuboids11[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[14][0], listOfCuboids11[14][3], listOfCuboids11[14][1], listOfCuboids11[14][4], listOfCuboids11[14][2], listOfCuboids11[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
                    case NORTH:
                    	int[][] listOfCuboids111 = {{0, 0, 11, 3, 16, 12},
                    	        {3, 0, 10, 6, 16, 11},
                    	        {6, 0, 9, 7, 16, 10},
                    	        {7, 0, 8, 8, 16, 9},
                    	        {8, 0, 7, 9, 16, 8},
                    	        {9, 0, 6, 10, 16, 7},
                    	        {10, 0, 3, 11, 16, 6},
                    	        {11, 0, 0, 12, 16, 3},
                    	        {0, 0, 0, 3, 16, 11},
                    	        {3, 0, 0, 6, 16, 10},
                    	        {6, 0, 0, 7, 16, 9},
                    	        {7, 0, 0, 8, 16, 8},
                    	        {8, 0, 0, 9, 16, 7},
                    	        {9, 0, 0, 10, 16, 6},
                    	        {10, 0, 0, 11, 16, 3}};
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[0][0], listOfCuboids111[0][3], listOfCuboids111[0][1], listOfCuboids111[0][4], listOfCuboids111[0][2], listOfCuboids111[0][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[1][0], listOfCuboids111[1][3], listOfCuboids111[1][1], listOfCuboids111[1][4], listOfCuboids111[1][2], listOfCuboids111[1][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[2][0], listOfCuboids111[2][3], listOfCuboids111[2][1], listOfCuboids111[2][4], listOfCuboids111[2][2], listOfCuboids111[2][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[3][0], listOfCuboids111[3][3], listOfCuboids111[3][1], listOfCuboids111[3][4], listOfCuboids111[3][2], listOfCuboids111[3][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[4][0], listOfCuboids111[4][3], listOfCuboids111[4][1], listOfCuboids111[4][4], listOfCuboids111[4][2], listOfCuboids111[4][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[5][0], listOfCuboids111[5][3], listOfCuboids111[5][1], listOfCuboids111[5][4], listOfCuboids111[5][2], listOfCuboids111[5][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[6][0], listOfCuboids111[6][3], listOfCuboids111[6][1], listOfCuboids111[6][4], listOfCuboids111[6][2], listOfCuboids111[6][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[7][0], listOfCuboids111[7][3], listOfCuboids111[7][1], listOfCuboids111[7][4], listOfCuboids111[7][2], listOfCuboids111[7][5], texture, tintIndex, false, true, true, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[8][0], listOfCuboids111[8][3], listOfCuboids111[8][1], listOfCuboids111[8][4], listOfCuboids111[8][2], listOfCuboids111[8][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[9][0], listOfCuboids111[9][3], listOfCuboids111[9][1], listOfCuboids111[9][4], listOfCuboids111[9][2], listOfCuboids111[9][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[10][0], listOfCuboids111[10][3], listOfCuboids111[10][1], listOfCuboids111[10][4], listOfCuboids111[10][2], listOfCuboids111[10][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[11][0], listOfCuboids111[11][3], listOfCuboids111[11][1], listOfCuboids111[11][4], listOfCuboids111[11][2], listOfCuboids111[11][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[12][0], listOfCuboids111[12][3], listOfCuboids111[12][1], listOfCuboids111[12][4], listOfCuboids111[12][2], listOfCuboids111[12][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[13][0], listOfCuboids111[13][3], listOfCuboids111[13][1], listOfCuboids111[13][4], listOfCuboids111[13][2], listOfCuboids111[13][5], texture, tintIndex, false, false, false, false, true, true));
                    	quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[14][0], listOfCuboids111[14][3], listOfCuboids111[14][1], listOfCuboids111[14][4], listOfCuboids111[14][2], listOfCuboids111[14][5], texture, tintIndex, false, false, false, false, true, true));
                        break;
    				default:
    					break;
                    }
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