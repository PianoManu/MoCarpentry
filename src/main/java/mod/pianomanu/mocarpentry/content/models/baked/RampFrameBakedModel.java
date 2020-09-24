package mod.pianomanu.mocarpentry.content.models.baked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mod.pianomanu.blockcarpentry.tileentity.FrameBlockTile;
import mod.pianomanu.blockcarpentry.util.TextureHelper;
import mod.pianomanu.mocarpentry.content.blocks.RampFrame;
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
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;

/**
 * This class determines the model of the ramp when it does contain a block
 *
 * @author PianoManu
 * @version 1.1 09/21/20
 */
public class RampFrameBakedModel implements IDynamicBakedModel {
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
            Direction facing = state.get(RampFrame.FACING);
            Half half = state.get(RampFrame.HALF);
            StairsShape shape = state.get(RampFrame.SHAPE);
            Boolean connectedLeft = state.get(RampFrame.CONNECTED_LEFT),
        			connectedRight = state.get(RampFrame.CONNECTED_RIGHT);
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
            switch (shape) {
			case INNER_LEFT:
				switch (half) {
				case BOTTOM:
					switch (facing) {
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					case WEST:
						break;
					default:
						break;
					}
					break;
				case TOP:
					switch (facing) {
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					case WEST:
						break;
					default:
						break;
					}
					break;
				}
				break;
			case INNER_RIGHT:
				switch (half) {
				case BOTTOM:
					switch (facing) {
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					case WEST:
						break;
					default:
						break;
					}
					break;
				case TOP:
					switch (facing) {
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					case WEST:
						break;
					default:
						break;
					}
					break;
				}
				break;
			case OUTER_LEFT:
				switch (half) {
				case BOTTOM:
					switch (facing) {
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					case WEST:
						break;
					default:
						break;
					}
					break;
				case TOP:
					switch (facing) {
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					case WEST:
						break;
					default:
						break;
					}
					break;
				}
				break;
			case OUTER_RIGHT:
				switch (half) {
				case BOTTOM:
					switch (facing) {
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					case WEST:
						break;
					default:
						break;
					}
					break;
				case TOP:
					switch (facing) {
					case EAST:
						break;
					case NORTH:
						break;
					case SOUTH:
						break;
					case WEST:
						break;
					default:
						break;
					}
					break;
				}
				break;
			case STRAIGHT:
				switch (half) {
				case BOTTOM:
					switch (facing) {
					case EAST:
						int[][] listOfCuboids = {{0, 0, 0, 1, 1, 16},
						        {1, 1, 0, 2, 2, 16},
						        {6, 6, 0, 7, 7, 16},
						        {7, 7, 0, 8, 8, 16},
						        {4, 4, 0, 5, 5, 16},
						        {5, 5, 0, 6, 6, 16},
						        {2, 2, 0, 3, 3, 16},
						        {3, 3, 0, 4, 4, 16},
						        {14, 14, 0, 15, 15, 16},
						        {15, 15, 0, 16, 16, 16},
						        {12, 12, 0, 13, 13, 16},
						        {13, 13, 0, 14, 14, 16},
						        {10, 10, 0, 11, 11, 16},
						        {9, 9, 0, 10, 10, 16},
						        {8, 8, 0, 9, 9, 16},
						        {11, 11, 0, 12, 12, 16},
						        {15, 0, 0, 16, 15, 16},
						        {1, 0, 0, 2, 1, 16},
						        {6, 0, 0, 7, 6, 16},
						        {7, 0, 0, 8, 7, 16},
						        {4, 0, 0, 5, 4, 16},
						        {5, 0, 0, 6, 5, 16},
						        {2, 0, 0, 3, 2, 16},
						        {3, 0, 0, 4, 3, 16},
						        {14, 0, 0, 15, 14, 16},
						        {12, 0, 0, 13, 12, 16},
						        {13, 0, 0, 14, 13, 16},
						        {10, 0, 0, 11, 10, 16},
						        {9, 0, 0, 10, 9, 16},
						        {8, 0, 0, 9, 8, 16},
						        {11, 0, 0, 12, 11, 16}};
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, true, false, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, true, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[17][0], listOfCuboids[17][3], listOfCuboids[17][1], listOfCuboids[17][4], listOfCuboids[17][2], listOfCuboids[17][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[18][0], listOfCuboids[18][3], listOfCuboids[18][1], listOfCuboids[18][4], listOfCuboids[18][2], listOfCuboids[18][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[19][0], listOfCuboids[19][3], listOfCuboids[19][1], listOfCuboids[19][4], listOfCuboids[19][2], listOfCuboids[19][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[20][0], listOfCuboids[20][3], listOfCuboids[20][1], listOfCuboids[20][4], listOfCuboids[20][2], listOfCuboids[20][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[21][0], listOfCuboids[21][3], listOfCuboids[21][1], listOfCuboids[21][4], listOfCuboids[21][2], listOfCuboids[21][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[22][0], listOfCuboids[22][3], listOfCuboids[22][1], listOfCuboids[22][4], listOfCuboids[22][2], listOfCuboids[22][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[23][0], listOfCuboids[23][3], listOfCuboids[23][1], listOfCuboids[23][4], listOfCuboids[23][2], listOfCuboids[23][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[24][0], listOfCuboids[24][3], listOfCuboids[24][1], listOfCuboids[24][4], listOfCuboids[24][2], listOfCuboids[24][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[25][0], listOfCuboids[25][3], listOfCuboids[25][1], listOfCuboids[25][4], listOfCuboids[25][2], listOfCuboids[25][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[26][0], listOfCuboids[26][3], listOfCuboids[26][1], listOfCuboids[26][4], listOfCuboids[26][2], listOfCuboids[26][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[27][0], listOfCuboids[27][3], listOfCuboids[27][1], listOfCuboids[27][4], listOfCuboids[27][2], listOfCuboids[27][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[28][0], listOfCuboids[28][3], listOfCuboids[28][1], listOfCuboids[28][4], listOfCuboids[28][2], listOfCuboids[28][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[29][0], listOfCuboids[29][3], listOfCuboids[29][1], listOfCuboids[29][4], listOfCuboids[29][2], listOfCuboids[29][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[30][0], listOfCuboids[30][3], listOfCuboids[30][1], listOfCuboids[30][4], listOfCuboids[30][2], listOfCuboids[30][5], texture, tintIndex, false, false, true, true, false, true));
						if (connectedLeft) {
							int[][] listOfCuboidsLeft = {{1, 1, -1, 2, 2, 0},
							        {5, 5, -5, 6, 6, 0},
							        {12, 12, -12, 13, 13, 0},
							        {3, 3, -3, 4, 4, 0},
							        {10, 10, -10, 11, 11, 0},
							        {7, 7, -7, 8, 8, 0},
							        {14, 14, -14, 15, 15, 0},
							        {2, 2, -2, 3, 3, 0},
							        {9, 9, -9, 10, 10, 0},
							        {6, 6, -6, 7, 7, 0},
							        {13, 13, -13, 14, 14, 0},
							        {4, 4, -4, 5, 5, 0},
							        {11, 11, -11, 12, 12, 0},
							        {8, 8, -8, 9, 9, 0},
							        {15, 15, -15, 16, 16, 0},
							        {2, 1, -1, 16, 2, 0},
							        {6, 5, -5, 16, 6, 0},
							        {13, 12, -12, 16, 13, 0},
							        {4, 3, -3, 16, 4, 0},
							        {11, 10, -10, 16, 11, 0},
							        {8, 7, -7, 16, 8, 0},
							        {15, 14, -14, 16, 15, 0},
							        {3, 2, -2, 16, 3, 0},
							        {10, 9, -9, 16, 10, 0},
							        {7, 6, -6, 16, 7, 0},
							        {14, 13, -13, 16, 14, 0},
							        {5, 4, -4, 16, 5, 0},
							        {12, 11, -11, 16, 12, 0},
							        {9, 8, -8, 16, 9, 0}};
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[0][0], listOfCuboidsLeft[0][3], listOfCuboidsLeft[0][1], listOfCuboidsLeft[0][4], listOfCuboidsLeft[0][2], listOfCuboidsLeft[0][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[1][0], listOfCuboidsLeft[1][3], listOfCuboidsLeft[1][1], listOfCuboidsLeft[1][4], listOfCuboidsLeft[1][2], listOfCuboidsLeft[1][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[2][0], listOfCuboidsLeft[2][3], listOfCuboidsLeft[2][1], listOfCuboidsLeft[2][4], listOfCuboidsLeft[2][2], listOfCuboidsLeft[2][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[3][0], listOfCuboidsLeft[3][3], listOfCuboidsLeft[3][1], listOfCuboidsLeft[3][4], listOfCuboidsLeft[3][2], listOfCuboidsLeft[3][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[4][0], listOfCuboidsLeft[4][3], listOfCuboidsLeft[4][1], listOfCuboidsLeft[4][4], listOfCuboidsLeft[4][2], listOfCuboidsLeft[4][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[5][0], listOfCuboidsLeft[5][3], listOfCuboidsLeft[5][1], listOfCuboidsLeft[5][4], listOfCuboidsLeft[5][2], listOfCuboidsLeft[5][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[6][0], listOfCuboidsLeft[6][3], listOfCuboidsLeft[6][1], listOfCuboidsLeft[6][4], listOfCuboidsLeft[6][2], listOfCuboidsLeft[6][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[7][0], listOfCuboidsLeft[7][3], listOfCuboidsLeft[7][1], listOfCuboidsLeft[7][4], listOfCuboidsLeft[7][2], listOfCuboidsLeft[7][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[8][0], listOfCuboidsLeft[8][3], listOfCuboidsLeft[8][1], listOfCuboidsLeft[8][4], listOfCuboidsLeft[8][2], listOfCuboidsLeft[8][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[9][0], listOfCuboidsLeft[9][3], listOfCuboidsLeft[9][1], listOfCuboidsLeft[9][4], listOfCuboidsLeft[9][2], listOfCuboidsLeft[9][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[10][0], listOfCuboidsLeft[10][3], listOfCuboidsLeft[10][1], listOfCuboidsLeft[10][4], listOfCuboidsLeft[10][2], listOfCuboidsLeft[10][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[11][0], listOfCuboidsLeft[11][3], listOfCuboidsLeft[11][1], listOfCuboidsLeft[11][4], listOfCuboidsLeft[11][2], listOfCuboidsLeft[11][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[12][0], listOfCuboidsLeft[12][3], listOfCuboidsLeft[12][1], listOfCuboidsLeft[12][4], listOfCuboidsLeft[12][2], listOfCuboidsLeft[12][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[13][0], listOfCuboidsLeft[13][3], listOfCuboidsLeft[13][1], listOfCuboidsLeft[13][4], listOfCuboidsLeft[13][2], listOfCuboidsLeft[13][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[14][0], listOfCuboidsLeft[14][3], listOfCuboidsLeft[14][1], listOfCuboidsLeft[14][4], listOfCuboidsLeft[14][2], listOfCuboidsLeft[14][5], texture, tintIndex, true, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[15][0], listOfCuboidsLeft[15][3], listOfCuboidsLeft[15][1], listOfCuboidsLeft[15][4], listOfCuboidsLeft[15][2], listOfCuboidsLeft[15][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[16][0], listOfCuboidsLeft[16][3], listOfCuboidsLeft[16][1], listOfCuboidsLeft[16][4], listOfCuboidsLeft[16][2], listOfCuboidsLeft[16][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[17][0], listOfCuboidsLeft[17][3], listOfCuboidsLeft[17][1], listOfCuboidsLeft[17][4], listOfCuboidsLeft[17][2], listOfCuboidsLeft[17][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[18][0], listOfCuboidsLeft[18][3], listOfCuboidsLeft[18][1], listOfCuboidsLeft[18][4], listOfCuboidsLeft[18][2], listOfCuboidsLeft[18][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[19][0], listOfCuboidsLeft[19][3], listOfCuboidsLeft[19][1], listOfCuboidsLeft[19][4], listOfCuboidsLeft[19][2], listOfCuboidsLeft[19][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[20][0], listOfCuboidsLeft[20][3], listOfCuboidsLeft[20][1], listOfCuboidsLeft[20][4], listOfCuboidsLeft[20][2], listOfCuboidsLeft[20][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[21][0], listOfCuboidsLeft[21][3], listOfCuboidsLeft[21][1], listOfCuboidsLeft[21][4], listOfCuboidsLeft[21][2], listOfCuboidsLeft[21][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[22][0], listOfCuboidsLeft[22][3], listOfCuboidsLeft[22][1], listOfCuboidsLeft[22][4], listOfCuboidsLeft[22][2], listOfCuboidsLeft[22][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[23][0], listOfCuboidsLeft[23][3], listOfCuboidsLeft[23][1], listOfCuboidsLeft[23][4], listOfCuboidsLeft[23][2], listOfCuboidsLeft[23][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[24][0], listOfCuboidsLeft[24][3], listOfCuboidsLeft[24][1], listOfCuboidsLeft[24][4], listOfCuboidsLeft[24][2], listOfCuboidsLeft[24][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[25][0], listOfCuboidsLeft[25][3], listOfCuboidsLeft[25][1], listOfCuboidsLeft[25][4], listOfCuboidsLeft[25][2], listOfCuboidsLeft[25][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[26][0], listOfCuboidsLeft[26][3], listOfCuboidsLeft[26][1], listOfCuboidsLeft[26][4], listOfCuboidsLeft[26][2], listOfCuboidsLeft[26][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[27][0], listOfCuboidsLeft[27][3], listOfCuboidsLeft[27][1], listOfCuboidsLeft[27][4], listOfCuboidsLeft[27][2], listOfCuboidsLeft[27][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[28][0], listOfCuboidsLeft[28][3], listOfCuboidsLeft[28][1], listOfCuboidsLeft[28][4], listOfCuboidsLeft[28][2], listOfCuboidsLeft[28][5], texture, tintIndex, false, true, false, false, false, false));
						}
						if (connectedRight) {
							int[][] listOfCuboidsRight = {{1, 1, 16, 2, 2, 17},
							        {5, 5, 16, 6, 6, 21},
							        {12, 12, 16, 13, 13, 28},
							        {3, 3, 16, 4, 4, 19},
							        {10, 10, 16, 11, 11, 26},
							        {7, 7, 16, 8, 8, 23},
							        {14, 14, 16, 15, 15, 30},
							        {2, 2, 16, 3, 3, 18},
							        {9, 9, 16, 10, 10, 25},
							        {6, 6, 16, 7, 7, 22},
							        {13, 13, 16, 14, 14, 29},
							        {4, 4, 16, 5, 5, 20},
							        {11, 11, 16, 12, 12, 27},
							        {8, 8, 16, 9, 9, 24},
							        {15, 15, 16, 16, 16, 31},
							        {2, 1, 16, 16, 2, 17},
							        {6, 5, 16, 16, 6, 21},
							        {13, 12, 16, 16, 13, 28},
							        {4, 3, 16, 16, 4, 19},
							        {11, 10, 16, 16, 11, 26},
							        {8, 7, 16, 16, 8, 23},
							        {15, 14, 16, 16, 15, 30},
							        {3, 2, 16, 16, 3, 18},
							        {10, 9, 16, 16, 10, 25},
							        {7, 6, 16, 16, 7, 22},
							        {14, 13, 16, 16, 14, 29},
							        {5, 4, 16, 16, 5, 20},
							        {12, 11, 16, 16, 12, 27},
							        {9, 8, 16, 16, 9, 24}};
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[0][0], listOfCuboidsRight[0][3], listOfCuboidsRight[0][1], listOfCuboidsRight[0][4], listOfCuboidsRight[0][2], listOfCuboidsRight[0][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[1][0], listOfCuboidsRight[1][3], listOfCuboidsRight[1][1], listOfCuboidsRight[1][4], listOfCuboidsRight[1][2], listOfCuboidsRight[1][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[2][0], listOfCuboidsRight[2][3], listOfCuboidsRight[2][1], listOfCuboidsRight[2][4], listOfCuboidsRight[2][2], listOfCuboidsRight[2][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[3][0], listOfCuboidsRight[3][3], listOfCuboidsRight[3][1], listOfCuboidsRight[3][4], listOfCuboidsRight[3][2], listOfCuboidsRight[3][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[4][0], listOfCuboidsRight[4][3], listOfCuboidsRight[4][1], listOfCuboidsRight[4][4], listOfCuboidsRight[4][2], listOfCuboidsRight[4][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[5][0], listOfCuboidsRight[5][3], listOfCuboidsRight[5][1], listOfCuboidsRight[5][4], listOfCuboidsRight[5][2], listOfCuboidsRight[5][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[6][0], listOfCuboidsRight[6][3], listOfCuboidsRight[6][1], listOfCuboidsRight[6][4], listOfCuboidsRight[6][2], listOfCuboidsRight[6][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[7][0], listOfCuboidsRight[7][3], listOfCuboidsRight[7][1], listOfCuboidsRight[7][4], listOfCuboidsRight[7][2], listOfCuboidsRight[7][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[8][0], listOfCuboidsRight[8][3], listOfCuboidsRight[8][1], listOfCuboidsRight[8][4], listOfCuboidsRight[8][2], listOfCuboidsRight[8][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[9][0], listOfCuboidsRight[9][3], listOfCuboidsRight[9][1], listOfCuboidsRight[9][4], listOfCuboidsRight[9][2], listOfCuboidsRight[9][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[10][0], listOfCuboidsRight[10][3], listOfCuboidsRight[10][1], listOfCuboidsRight[10][4], listOfCuboidsRight[10][2], listOfCuboidsRight[10][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[11][0], listOfCuboidsRight[11][3], listOfCuboidsRight[11][1], listOfCuboidsRight[11][4], listOfCuboidsRight[11][2], listOfCuboidsRight[11][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[12][0], listOfCuboidsRight[12][3], listOfCuboidsRight[12][1], listOfCuboidsRight[12][4], listOfCuboidsRight[12][2], listOfCuboidsRight[12][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[13][0], listOfCuboidsRight[13][3], listOfCuboidsRight[13][1], listOfCuboidsRight[13][4], listOfCuboidsRight[13][2], listOfCuboidsRight[13][5], texture, tintIndex, true, false, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[14][0], listOfCuboidsRight[14][3], listOfCuboidsRight[14][1], listOfCuboidsRight[14][4], listOfCuboidsRight[14][2], listOfCuboidsRight[14][5], texture, tintIndex, true, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[15][0], listOfCuboidsRight[15][3], listOfCuboidsRight[15][1], listOfCuboidsRight[15][4], listOfCuboidsRight[15][2], listOfCuboidsRight[15][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[16][0], listOfCuboidsRight[16][3], listOfCuboidsRight[16][1], listOfCuboidsRight[16][4], listOfCuboidsRight[16][2], listOfCuboidsRight[16][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[17][0], listOfCuboidsRight[17][3], listOfCuboidsRight[17][1], listOfCuboidsRight[17][4], listOfCuboidsRight[17][2], listOfCuboidsRight[17][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[18][0], listOfCuboidsRight[18][3], listOfCuboidsRight[18][1], listOfCuboidsRight[18][4], listOfCuboidsRight[18][2], listOfCuboidsRight[18][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[19][0], listOfCuboidsRight[19][3], listOfCuboidsRight[19][1], listOfCuboidsRight[19][4], listOfCuboidsRight[19][2], listOfCuboidsRight[19][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[20][0], listOfCuboidsRight[20][3], listOfCuboidsRight[20][1], listOfCuboidsRight[20][4], listOfCuboidsRight[20][2], listOfCuboidsRight[20][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[21][0], listOfCuboidsRight[21][3], listOfCuboidsRight[21][1], listOfCuboidsRight[21][4], listOfCuboidsRight[21][2], listOfCuboidsRight[21][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[22][0], listOfCuboidsRight[22][3], listOfCuboidsRight[22][1], listOfCuboidsRight[22][4], listOfCuboidsRight[22][2], listOfCuboidsRight[22][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[23][0], listOfCuboidsRight[23][3], listOfCuboidsRight[23][1], listOfCuboidsRight[23][4], listOfCuboidsRight[23][2], listOfCuboidsRight[23][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[24][0], listOfCuboidsRight[24][3], listOfCuboidsRight[24][1], listOfCuboidsRight[24][4], listOfCuboidsRight[24][2], listOfCuboidsRight[24][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[25][0], listOfCuboidsRight[25][3], listOfCuboidsRight[25][1], listOfCuboidsRight[25][4], listOfCuboidsRight[25][2], listOfCuboidsRight[25][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[26][0], listOfCuboidsRight[26][3], listOfCuboidsRight[26][1], listOfCuboidsRight[26][4], listOfCuboidsRight[26][2], listOfCuboidsRight[26][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[27][0], listOfCuboidsRight[27][3], listOfCuboidsRight[27][1], listOfCuboidsRight[27][4], listOfCuboidsRight[27][2], listOfCuboidsRight[27][5], texture, tintIndex, false, true, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[28][0], listOfCuboidsRight[28][3], listOfCuboidsRight[28][1], listOfCuboidsRight[28][4], listOfCuboidsRight[28][2], listOfCuboidsRight[28][5], texture, tintIndex, false, true, false, false, false, false));
						}
						break;
					case NORTH:
						int[][] listOfCuboids1 = {{0, 0, 15, 16, 1, 16},
						        {0, 1, 14, 16, 2, 15},
						        {0, 6, 9, 16, 7, 10},
						        {0, 7, 8, 16, 8, 9},
						        {0, 4, 11, 16, 5, 12},
						        {0, 5, 10, 16, 6, 11},
						        {0, 2, 13, 16, 3, 14},
						        {0, 3, 12, 16, 4, 13},
						        {0, 14, 1, 16, 15, 2},
						        {0, 15, 0, 16, 16, 1},
						        {0, 12, 3, 16, 13, 4},
						        {0, 13, 2, 16, 14, 3},
						        {0, 10, 5, 16, 11, 6},
						        {0, 9, 6, 16, 10, 7},
						        {0, 8, 7, 16, 9, 8},
						        {0, 11, 4, 16, 12, 5},
						        {0, 0, 0, 16, 15, 1},
						        {0, 0, 14, 16, 1, 15},
						        {0, 0, 9, 16, 6, 10},
						        {0, 0, 8, 16, 7, 9},
						        {0, 0, 11, 16, 4, 12},
						        {0, 0, 10, 16, 5, 11},
						        {0, 0, 13, 16, 2, 14},
						        {0, 0, 12, 16, 3, 13},
						        {0, 0, 1, 16, 14, 2},
						        {0, 0, 3, 16, 12, 4},
						        {0, 0, 2, 16, 13, 3},
						        {0, 0, 5, 16, 10, 6},
						        {0, 0, 6, 16, 9, 7},
						        {0, 0, 7, 16, 8, 8},
						        {0, 0, 4, 16, 11, 5}};
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[0][0], listOfCuboids1[0][3], listOfCuboids1[0][1], listOfCuboids1[0][4], listOfCuboids1[0][2], listOfCuboids1[0][5], texture, tintIndex, true, true, true, false, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[1][0], listOfCuboids1[1][3], listOfCuboids1[1][1], listOfCuboids1[1][4], listOfCuboids1[1][2], listOfCuboids1[1][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[2][0], listOfCuboids1[2][3], listOfCuboids1[2][1], listOfCuboids1[2][4], listOfCuboids1[2][2], listOfCuboids1[2][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[3][0], listOfCuboids1[3][3], listOfCuboids1[3][1], listOfCuboids1[3][4], listOfCuboids1[3][2], listOfCuboids1[3][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[4][0], listOfCuboids1[4][3], listOfCuboids1[4][1], listOfCuboids1[4][4], listOfCuboids1[4][2], listOfCuboids1[4][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[5][0], listOfCuboids1[5][3], listOfCuboids1[5][1], listOfCuboids1[5][4], listOfCuboids1[5][2], listOfCuboids1[5][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[6][0], listOfCuboids1[6][3], listOfCuboids1[6][1], listOfCuboids1[6][4], listOfCuboids1[6][2], listOfCuboids1[6][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[7][0], listOfCuboids1[7][3], listOfCuboids1[7][1], listOfCuboids1[7][4], listOfCuboids1[7][2], listOfCuboids1[7][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[8][0], listOfCuboids1[8][3], listOfCuboids1[8][1], listOfCuboids1[8][4], listOfCuboids1[8][2], listOfCuboids1[8][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[9][0], listOfCuboids1[9][3], listOfCuboids1[9][1], listOfCuboids1[9][4], listOfCuboids1[9][2], listOfCuboids1[9][5], texture, tintIndex, true, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[10][0], listOfCuboids1[10][3], listOfCuboids1[10][1], listOfCuboids1[10][4], listOfCuboids1[10][2], listOfCuboids1[10][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[11][0], listOfCuboids1[11][3], listOfCuboids1[11][1], listOfCuboids1[11][4], listOfCuboids1[11][2], listOfCuboids1[11][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[12][0], listOfCuboids1[12][3], listOfCuboids1[12][1], listOfCuboids1[12][4], listOfCuboids1[12][2], listOfCuboids1[12][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[13][0], listOfCuboids1[13][3], listOfCuboids1[13][1], listOfCuboids1[13][4], listOfCuboids1[13][2], listOfCuboids1[13][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[14][0], listOfCuboids1[14][3], listOfCuboids1[14][1], listOfCuboids1[14][4], listOfCuboids1[14][2], listOfCuboids1[14][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[15][0], listOfCuboids1[15][3], listOfCuboids1[15][1], listOfCuboids1[15][4], listOfCuboids1[15][2], listOfCuboids1[15][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[16][0], listOfCuboids1[16][3], listOfCuboids1[16][1], listOfCuboids1[16][4], listOfCuboids1[16][2], listOfCuboids1[16][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[17][0], listOfCuboids1[17][3], listOfCuboids1[17][1], listOfCuboids1[17][4], listOfCuboids1[17][2], listOfCuboids1[17][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[18][0], listOfCuboids1[18][3], listOfCuboids1[18][1], listOfCuboids1[18][4], listOfCuboids1[18][2], listOfCuboids1[18][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[19][0], listOfCuboids1[19][3], listOfCuboids1[19][1], listOfCuboids1[19][4], listOfCuboids1[19][2], listOfCuboids1[19][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[20][0], listOfCuboids1[20][3], listOfCuboids1[20][1], listOfCuboids1[20][4], listOfCuboids1[20][2], listOfCuboids1[20][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[21][0], listOfCuboids1[21][3], listOfCuboids1[21][1], listOfCuboids1[21][4], listOfCuboids1[21][2], listOfCuboids1[21][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[22][0], listOfCuboids1[22][3], listOfCuboids1[22][1], listOfCuboids1[22][4], listOfCuboids1[22][2], listOfCuboids1[22][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[23][0], listOfCuboids1[23][3], listOfCuboids1[23][1], listOfCuboids1[23][4], listOfCuboids1[23][2], listOfCuboids1[23][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[24][0], listOfCuboids1[24][3], listOfCuboids1[24][1], listOfCuboids1[24][4], listOfCuboids1[24][2], listOfCuboids1[24][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[25][0], listOfCuboids1[25][3], listOfCuboids1[25][1], listOfCuboids1[25][4], listOfCuboids1[25][2], listOfCuboids1[25][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[26][0], listOfCuboids1[26][3], listOfCuboids1[26][1], listOfCuboids1[26][4], listOfCuboids1[26][2], listOfCuboids1[26][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[27][0], listOfCuboids1[27][3], listOfCuboids1[27][1], listOfCuboids1[27][4], listOfCuboids1[27][2], listOfCuboids1[27][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[28][0], listOfCuboids1[28][3], listOfCuboids1[28][1], listOfCuboids1[28][4], listOfCuboids1[28][2], listOfCuboids1[28][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[29][0], listOfCuboids1[29][3], listOfCuboids1[29][1], listOfCuboids1[29][4], listOfCuboids1[29][2], listOfCuboids1[29][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[30][0], listOfCuboids1[30][3], listOfCuboids1[30][1], listOfCuboids1[30][4], listOfCuboids1[30][2], listOfCuboids1[30][5], texture, tintIndex, true, true, false, false, false, true));
						if (connectedLeft) {
						}
						if (connectedRight) {int[][] listOfCuboidsRight = {{16, 1, 14, 17, 2, 15},
						        {16, 5, 10, 21, 6, 11},
						        {16, 12, 3, 28, 13, 4},
						        {16, 3, 12, 19, 4, 13},
						        {16, 10, 5, 26, 11, 6},
						        {16, 7, 8, 23, 8, 9},
						        {16, 14, 1, 30, 15, 2},
						        {16, 2, 13, 18, 3, 14},
						        {16, 9, 6, 25, 10, 7},
						        {16, 6, 9, 22, 7, 10},
						        {16, 13, 2, 29, 14, 3},
						        {16, 4, 11, 20, 5, 12},
						        {16, 11, 4, 27, 12, 5},
						        {16, 8, 7, 24, 9, 8},
						        {16, 15, 0, 31, 16, 1},
						        {16, 1, 0, 17, 2, 14},
						        {16, 5, 0, 21, 6, 10},
						        {16, 12, 0, 28, 13, 3},
						        {16, 3, 0, 19, 4, 12},
						        {16, 10, 0, 26, 11, 5},
						        {16, 7, 0, 23, 8, 8},
						        {16, 14, 0, 30, 15, 1},
						        {16, 2, 0, 18, 3, 13},
						        {16, 9, 0, 25, 10, 6},
						        {16, 6, 0, 22, 7, 9},
						        {16, 13, 0, 29, 14, 2},
						        {16, 4, 0, 20, 5, 11},
						        {16, 11, 0, 27, 12, 4},
						        {16, 8, 0, 24, 9, 7}};
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[0][0], listOfCuboidsRight[0][3], listOfCuboidsRight[0][1], listOfCuboidsRight[0][4], listOfCuboidsRight[0][2], listOfCuboidsRight[0][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[1][0], listOfCuboidsRight[1][3], listOfCuboidsRight[1][1], listOfCuboidsRight[1][4], listOfCuboidsRight[1][2], listOfCuboidsRight[1][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[2][0], listOfCuboidsRight[2][3], listOfCuboidsRight[2][1], listOfCuboidsRight[2][4], listOfCuboidsRight[2][2], listOfCuboidsRight[2][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[3][0], listOfCuboidsRight[3][3], listOfCuboidsRight[3][1], listOfCuboidsRight[3][4], listOfCuboidsRight[3][2], listOfCuboidsRight[3][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[4][0], listOfCuboidsRight[4][3], listOfCuboidsRight[4][1], listOfCuboidsRight[4][4], listOfCuboidsRight[4][2], listOfCuboidsRight[4][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[5][0], listOfCuboidsRight[5][3], listOfCuboidsRight[5][1], listOfCuboidsRight[5][4], listOfCuboidsRight[5][2], listOfCuboidsRight[5][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[6][0], listOfCuboidsRight[6][3], listOfCuboidsRight[6][1], listOfCuboidsRight[6][4], listOfCuboidsRight[6][2], listOfCuboidsRight[6][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[7][0], listOfCuboidsRight[7][3], listOfCuboidsRight[7][1], listOfCuboidsRight[7][4], listOfCuboidsRight[7][2], listOfCuboidsRight[7][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[8][0], listOfCuboidsRight[8][3], listOfCuboidsRight[8][1], listOfCuboidsRight[8][4], listOfCuboidsRight[8][2], listOfCuboidsRight[8][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[9][0], listOfCuboidsRight[9][3], listOfCuboidsRight[9][1], listOfCuboidsRight[9][4], listOfCuboidsRight[9][2], listOfCuboidsRight[9][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[10][0], listOfCuboidsRight[10][3], listOfCuboidsRight[10][1], listOfCuboidsRight[10][4], listOfCuboidsRight[10][2], listOfCuboidsRight[10][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[11][0], listOfCuboidsRight[11][3], listOfCuboidsRight[11][1], listOfCuboidsRight[11][4], listOfCuboidsRight[11][2], listOfCuboidsRight[11][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[12][0], listOfCuboidsRight[12][3], listOfCuboidsRight[12][1], listOfCuboidsRight[12][4], listOfCuboidsRight[12][2], listOfCuboidsRight[12][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[13][0], listOfCuboidsRight[13][3], listOfCuboidsRight[13][1], listOfCuboidsRight[13][4], listOfCuboidsRight[13][2], listOfCuboidsRight[13][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[14][0], listOfCuboidsRight[14][3], listOfCuboidsRight[14][1], listOfCuboidsRight[14][4], listOfCuboidsRight[14][2], listOfCuboidsRight[14][5], texture, tintIndex, false, false, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[15][0], listOfCuboidsRight[15][3], listOfCuboidsRight[15][1], listOfCuboidsRight[15][4], listOfCuboidsRight[15][2], listOfCuboidsRight[15][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[16][0], listOfCuboidsRight[16][3], listOfCuboidsRight[16][1], listOfCuboidsRight[16][4], listOfCuboidsRight[16][2], listOfCuboidsRight[16][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[17][0], listOfCuboidsRight[17][3], listOfCuboidsRight[17][1], listOfCuboidsRight[17][4], listOfCuboidsRight[17][2], listOfCuboidsRight[17][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[18][0], listOfCuboidsRight[18][3], listOfCuboidsRight[18][1], listOfCuboidsRight[18][4], listOfCuboidsRight[18][2], listOfCuboidsRight[18][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[19][0], listOfCuboidsRight[19][3], listOfCuboidsRight[19][1], listOfCuboidsRight[19][4], listOfCuboidsRight[19][2], listOfCuboidsRight[19][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[20][0], listOfCuboidsRight[20][3], listOfCuboidsRight[20][1], listOfCuboidsRight[20][4], listOfCuboidsRight[20][2], listOfCuboidsRight[20][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[21][0], listOfCuboidsRight[21][3], listOfCuboidsRight[21][1], listOfCuboidsRight[21][4], listOfCuboidsRight[21][2], listOfCuboidsRight[21][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[22][0], listOfCuboidsRight[22][3], listOfCuboidsRight[22][1], listOfCuboidsRight[22][4], listOfCuboidsRight[22][2], listOfCuboidsRight[22][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[23][0], listOfCuboidsRight[23][3], listOfCuboidsRight[23][1], listOfCuboidsRight[23][4], listOfCuboidsRight[23][2], listOfCuboidsRight[23][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[24][0], listOfCuboidsRight[24][3], listOfCuboidsRight[24][1], listOfCuboidsRight[24][4], listOfCuboidsRight[24][2], listOfCuboidsRight[24][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[25][0], listOfCuboidsRight[25][3], listOfCuboidsRight[25][1], listOfCuboidsRight[25][4], listOfCuboidsRight[25][2], listOfCuboidsRight[25][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[26][0], listOfCuboidsRight[26][3], listOfCuboidsRight[26][1], listOfCuboidsRight[26][4], listOfCuboidsRight[26][2], listOfCuboidsRight[26][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[27][0], listOfCuboidsRight[27][3], listOfCuboidsRight[27][1], listOfCuboidsRight[27][4], listOfCuboidsRight[27][2], listOfCuboidsRight[27][5], texture, tintIndex, false, false, true, false, false, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[28][0], listOfCuboidsRight[28][3], listOfCuboidsRight[28][1], listOfCuboidsRight[28][4], listOfCuboidsRight[28][2], listOfCuboidsRight[28][5], texture, tintIndex, false, false, true, false, false, false));
						}
						break;
					case SOUTH:
						int[][] listOfCuboids11 = {{0, 0, 0, 16, 1, 1},
						        {0, 1, 1, 16, 2, 2},
						        {0, 6, 6, 16, 7, 7},
						        {0, 7, 7, 16, 8, 8},
						        {0, 4, 4, 16, 5, 5},
						        {0, 5, 5, 16, 6, 6},
						        {0, 2, 2, 16, 3, 3},
						        {0, 3, 3, 16, 4, 4},
						        {0, 14, 14, 16, 15, 15},
						        {0, 15, 15, 16, 16, 16},
						        {0, 12, 12, 16, 13, 13},
						        {0, 13, 13, 16, 14, 14},
						        {0, 10, 10, 16, 11, 11},
						        {0, 9, 9, 16, 10, 10},
						        {0, 8, 8, 16, 9, 9},
						        {0, 11, 11, 16, 12, 12},
						        {0, 0, 15, 16, 15, 16},
						        {0, 0, 1, 16, 1, 2},
						        {0, 0, 6, 16, 6, 7},
						        {0, 0, 7, 16, 7, 8},
						        {0, 0, 4, 16, 4, 5},
						        {0, 0, 5, 16, 5, 6},
						        {0, 0, 2, 16, 2, 3},
						        {0, 0, 3, 16, 3, 4},
						        {0, 0, 14, 16, 14, 15},
						        {0, 0, 12, 16, 12, 13},
						        {0, 0, 13, 16, 13, 14},
						        {0, 0, 10, 16, 10, 11},
						        {0, 0, 9, 16, 9, 10},
						        {0, 0, 8, 16, 8, 9},
						        {0, 0, 11, 16, 11, 12}};
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[0][0], listOfCuboids11[0][3], listOfCuboids11[0][1], listOfCuboids11[0][4], listOfCuboids11[0][2], listOfCuboids11[0][5], texture, tintIndex, true, true, false, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[1][0], listOfCuboids11[1][3], listOfCuboids11[1][1], listOfCuboids11[1][4], listOfCuboids11[1][2], listOfCuboids11[1][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[2][0], listOfCuboids11[2][3], listOfCuboids11[2][1], listOfCuboids11[2][4], listOfCuboids11[2][2], listOfCuboids11[2][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[3][0], listOfCuboids11[3][3], listOfCuboids11[3][1], listOfCuboids11[3][4], listOfCuboids11[3][2], listOfCuboids11[3][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[4][0], listOfCuboids11[4][3], listOfCuboids11[4][1], listOfCuboids11[4][4], listOfCuboids11[4][2], listOfCuboids11[4][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[5][0], listOfCuboids11[5][3], listOfCuboids11[5][1], listOfCuboids11[5][4], listOfCuboids11[5][2], listOfCuboids11[5][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[6][0], listOfCuboids11[6][3], listOfCuboids11[6][1], listOfCuboids11[6][4], listOfCuboids11[6][2], listOfCuboids11[6][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[7][0], listOfCuboids11[7][3], listOfCuboids11[7][1], listOfCuboids11[7][4], listOfCuboids11[7][2], listOfCuboids11[7][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[8][0], listOfCuboids11[8][3], listOfCuboids11[8][1], listOfCuboids11[8][4], listOfCuboids11[8][2], listOfCuboids11[8][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[9][0], listOfCuboids11[9][3], listOfCuboids11[9][1], listOfCuboids11[9][4], listOfCuboids11[9][2], listOfCuboids11[9][5], texture, tintIndex, true, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[10][0], listOfCuboids11[10][3], listOfCuboids11[10][1], listOfCuboids11[10][4], listOfCuboids11[10][2], listOfCuboids11[10][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[11][0], listOfCuboids11[11][3], listOfCuboids11[11][1], listOfCuboids11[11][4], listOfCuboids11[11][2], listOfCuboids11[11][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[12][0], listOfCuboids11[12][3], listOfCuboids11[12][1], listOfCuboids11[12][4], listOfCuboids11[12][2], listOfCuboids11[12][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[13][0], listOfCuboids11[13][3], listOfCuboids11[13][1], listOfCuboids11[13][4], listOfCuboids11[13][2], listOfCuboids11[13][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[14][0], listOfCuboids11[14][3], listOfCuboids11[14][1], listOfCuboids11[14][4], listOfCuboids11[14][2], listOfCuboids11[14][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[15][0], listOfCuboids11[15][3], listOfCuboids11[15][1], listOfCuboids11[15][4], listOfCuboids11[15][2], listOfCuboids11[15][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[16][0], listOfCuboids11[16][3], listOfCuboids11[16][1], listOfCuboids11[16][4], listOfCuboids11[16][2], listOfCuboids11[16][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[17][0], listOfCuboids11[17][3], listOfCuboids11[17][1], listOfCuboids11[17][4], listOfCuboids11[17][2], listOfCuboids11[17][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[18][0], listOfCuboids11[18][3], listOfCuboids11[18][1], listOfCuboids11[18][4], listOfCuboids11[18][2], listOfCuboids11[18][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[19][0], listOfCuboids11[19][3], listOfCuboids11[19][1], listOfCuboids11[19][4], listOfCuboids11[19][2], listOfCuboids11[19][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[20][0], listOfCuboids11[20][3], listOfCuboids11[20][1], listOfCuboids11[20][4], listOfCuboids11[20][2], listOfCuboids11[20][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[21][0], listOfCuboids11[21][3], listOfCuboids11[21][1], listOfCuboids11[21][4], listOfCuboids11[21][2], listOfCuboids11[21][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[22][0], listOfCuboids11[22][3], listOfCuboids11[22][1], listOfCuboids11[22][4], listOfCuboids11[22][2], listOfCuboids11[22][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[23][0], listOfCuboids11[23][3], listOfCuboids11[23][1], listOfCuboids11[23][4], listOfCuboids11[23][2], listOfCuboids11[23][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[24][0], listOfCuboids11[24][3], listOfCuboids11[24][1], listOfCuboids11[24][4], listOfCuboids11[24][2], listOfCuboids11[24][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[25][0], listOfCuboids11[25][3], listOfCuboids11[25][1], listOfCuboids11[25][4], listOfCuboids11[25][2], listOfCuboids11[25][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[26][0], listOfCuboids11[26][3], listOfCuboids11[26][1], listOfCuboids11[26][4], listOfCuboids11[26][2], listOfCuboids11[26][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[27][0], listOfCuboids11[27][3], listOfCuboids11[27][1], listOfCuboids11[27][4], listOfCuboids11[27][2], listOfCuboids11[27][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[28][0], listOfCuboids11[28][3], listOfCuboids11[28][1], listOfCuboids11[28][4], listOfCuboids11[28][2], listOfCuboids11[28][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[29][0], listOfCuboids11[29][3], listOfCuboids11[29][1], listOfCuboids11[29][4], listOfCuboids11[29][2], listOfCuboids11[29][5], texture, tintIndex, true, true, false, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[30][0], listOfCuboids11[30][3], listOfCuboids11[30][1], listOfCuboids11[30][4], listOfCuboids11[30][2], listOfCuboids11[30][5], texture, tintIndex, true, true, false, false, false, true));
						if (connectedLeft) {
						}
						if (connectedRight) {
						}
						break;
					case WEST:
						int[][] listOfCuboids111 = {{15, 0, 0, 16, 1, 16},
						        {14, 1, 0, 15, 2, 16},
						        {9, 6, 0, 10, 7, 16},
						        {8, 7, 0, 9, 8, 16},
						        {11, 4, 0, 12, 5, 16},
						        {10, 5, 0, 11, 6, 16},
						        {13, 2, 0, 14, 3, 16},
						        {12, 3, 0, 13, 4, 16},
						        {1, 14, 0, 2, 15, 16},
						        {0, 15, 0, 1, 16, 16},
						        {3, 12, 0, 4, 13, 16},
						        {2, 13, 0, 3, 14, 16},
						        {5, 10, 0, 6, 11, 16},
						        {6, 9, 0, 7, 10, 16},
						        {7, 8, 0, 8, 9, 16},
						        {4, 11, 0, 5, 12, 16},
						        {0, 0, 0, 1, 15, 16},
						        {14, 0, 0, 15, 1, 16},
						        {9, 0, 0, 10, 6, 16},
						        {8, 0, 0, 9, 7, 16},
						        {11, 0, 0, 12, 4, 16},
						        {10, 0, 0, 11, 5, 16},
						        {13, 0, 0, 14, 2, 16},
						        {12, 0, 0, 13, 3, 16},
						        {1, 0, 0, 2, 14, 16},
						        {3, 0, 0, 4, 12, 16},
						        {2, 0, 0, 3, 13, 16},
						        {5, 0, 0, 6, 10, 16},
						        {6, 0, 0, 7, 9, 16},
						        {7, 0, 0, 8, 8, 16},
						        {4, 0, 0, 5, 11, 16}};
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[0][0], listOfCuboids111[0][3], listOfCuboids111[0][1], listOfCuboids111[0][4], listOfCuboids111[0][2], listOfCuboids111[0][5], texture, tintIndex, false, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[1][0], listOfCuboids111[1][3], listOfCuboids111[1][1], listOfCuboids111[1][4], listOfCuboids111[1][2], listOfCuboids111[1][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[2][0], listOfCuboids111[2][3], listOfCuboids111[2][1], listOfCuboids111[2][4], listOfCuboids111[2][2], listOfCuboids111[2][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[3][0], listOfCuboids111[3][3], listOfCuboids111[3][1], listOfCuboids111[3][4], listOfCuboids111[3][2], listOfCuboids111[3][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[4][0], listOfCuboids111[4][3], listOfCuboids111[4][1], listOfCuboids111[4][4], listOfCuboids111[4][2], listOfCuboids111[4][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[5][0], listOfCuboids111[5][3], listOfCuboids111[5][1], listOfCuboids111[5][4], listOfCuboids111[5][2], listOfCuboids111[5][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[6][0], listOfCuboids111[6][3], listOfCuboids111[6][1], listOfCuboids111[6][4], listOfCuboids111[6][2], listOfCuboids111[6][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[7][0], listOfCuboids111[7][3], listOfCuboids111[7][1], listOfCuboids111[7][4], listOfCuboids111[7][2], listOfCuboids111[7][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[8][0], listOfCuboids111[8][3], listOfCuboids111[8][1], listOfCuboids111[8][4], listOfCuboids111[8][2], listOfCuboids111[8][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[9][0], listOfCuboids111[9][3], listOfCuboids111[9][1], listOfCuboids111[9][4], listOfCuboids111[9][2], listOfCuboids111[9][5], texture, tintIndex, true, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[10][0], listOfCuboids111[10][3], listOfCuboids111[10][1], listOfCuboids111[10][4], listOfCuboids111[10][2], listOfCuboids111[10][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[11][0], listOfCuboids111[11][3], listOfCuboids111[11][1], listOfCuboids111[11][4], listOfCuboids111[11][2], listOfCuboids111[11][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[12][0], listOfCuboids111[12][3], listOfCuboids111[12][1], listOfCuboids111[12][4], listOfCuboids111[12][2], listOfCuboids111[12][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[13][0], listOfCuboids111[13][3], listOfCuboids111[13][1], listOfCuboids111[13][4], listOfCuboids111[13][2], listOfCuboids111[13][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[14][0], listOfCuboids111[14][3], listOfCuboids111[14][1], listOfCuboids111[14][4], listOfCuboids111[14][2], listOfCuboids111[14][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[15][0], listOfCuboids111[15][3], listOfCuboids111[15][1], listOfCuboids111[15][4], listOfCuboids111[15][2], listOfCuboids111[15][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[16][0], listOfCuboids111[16][3], listOfCuboids111[16][1], listOfCuboids111[16][4], listOfCuboids111[16][2], listOfCuboids111[16][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[17][0], listOfCuboids111[17][3], listOfCuboids111[17][1], listOfCuboids111[17][4], listOfCuboids111[17][2], listOfCuboids111[17][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[18][0], listOfCuboids111[18][3], listOfCuboids111[18][1], listOfCuboids111[18][4], listOfCuboids111[18][2], listOfCuboids111[18][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[19][0], listOfCuboids111[19][3], listOfCuboids111[19][1], listOfCuboids111[19][4], listOfCuboids111[19][2], listOfCuboids111[19][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[20][0], listOfCuboids111[20][3], listOfCuboids111[20][1], listOfCuboids111[20][4], listOfCuboids111[20][2], listOfCuboids111[20][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[21][0], listOfCuboids111[21][3], listOfCuboids111[21][1], listOfCuboids111[21][4], listOfCuboids111[21][2], listOfCuboids111[21][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[22][0], listOfCuboids111[22][3], listOfCuboids111[22][1], listOfCuboids111[22][4], listOfCuboids111[22][2], listOfCuboids111[22][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[23][0], listOfCuboids111[23][3], listOfCuboids111[23][1], listOfCuboids111[23][4], listOfCuboids111[23][2], listOfCuboids111[23][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[24][0], listOfCuboids111[24][3], listOfCuboids111[24][1], listOfCuboids111[24][4], listOfCuboids111[24][2], listOfCuboids111[24][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[25][0], listOfCuboids111[25][3], listOfCuboids111[25][1], listOfCuboids111[25][4], listOfCuboids111[25][2], listOfCuboids111[25][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[26][0], listOfCuboids111[26][3], listOfCuboids111[26][1], listOfCuboids111[26][4], listOfCuboids111[26][2], listOfCuboids111[26][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[27][0], listOfCuboids111[27][3], listOfCuboids111[27][1], listOfCuboids111[27][4], listOfCuboids111[27][2], listOfCuboids111[27][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[28][0], listOfCuboids111[28][3], listOfCuboids111[28][1], listOfCuboids111[28][4], listOfCuboids111[28][2], listOfCuboids111[28][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[29][0], listOfCuboids111[29][3], listOfCuboids111[29][1], listOfCuboids111[29][4], listOfCuboids111[29][2], listOfCuboids111[29][5], texture, tintIndex, false, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[30][0], listOfCuboids111[30][3], listOfCuboids111[30][1], listOfCuboids111[30][4], listOfCuboids111[30][2], listOfCuboids111[30][5], texture, tintIndex, false, false, true, true, false, true));
						if (connectedLeft) {
							int[][] listOfCuboidsLeft = {{14, 1, 16, 15, 2, 17},
							        {10, 5, 16, 11, 6, 21},
							        {3, 12, 16, 4, 13, 28},
							        {12, 3, 16, 13, 4, 19},
							        {5, 10, 16, 6, 11, 26},
							        {8, 7, 16, 9, 8, 23},
							        {1, 14, 16, 2, 15, 30},
							        {13, 2, 16, 14, 3, 18},
							        {6, 9, 16, 7, 10, 25},
							        {9, 6, 16, 10, 7, 22},
							        {2, 13, 16, 3, 14, 29},
							        {11, 4, 16, 12, 5, 20},
							        {4, 11, 16, 5, 12, 27},
							        {7, 8, 16, 8, 9, 24},
							        {0, 15, 16, 1, 16, 31},
							        {0, 1, 16, 14, 2, 17},
							        {0, 5, 16, 10, 6, 21},
							        {0, 12, 16, 3, 13, 28},
							        {0, 3, 16, 12, 4, 19},
							        {0, 10, 16, 5, 11, 26},
							        {0, 7, 16, 8, 8, 23},
							        {0, 14, 16, 1, 15, 30},
							        {0, 2, 16, 13, 3, 18},
							        {0, 9, 16, 6, 10, 25},
							        {0, 6, 16, 9, 7, 22},
							        {0, 13, 16, 2, 14, 29},
							        {0, 4, 16, 11, 5, 20},
							        {0, 11, 16, 4, 12, 27},
							        {0, 8, 16, 7, 9, 24}};
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[0][0], listOfCuboidsLeft[0][3], listOfCuboidsLeft[0][1], listOfCuboidsLeft[0][4], listOfCuboidsLeft[0][2], listOfCuboidsLeft[0][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[1][0], listOfCuboidsLeft[1][3], listOfCuboidsLeft[1][1], listOfCuboidsLeft[1][4], listOfCuboidsLeft[1][2], listOfCuboidsLeft[1][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[2][0], listOfCuboidsLeft[2][3], listOfCuboidsLeft[2][1], listOfCuboidsLeft[2][4], listOfCuboidsLeft[2][2], listOfCuboidsLeft[2][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[3][0], listOfCuboidsLeft[3][3], listOfCuboidsLeft[3][1], listOfCuboidsLeft[3][4], listOfCuboidsLeft[3][2], listOfCuboidsLeft[3][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[4][0], listOfCuboidsLeft[4][3], listOfCuboidsLeft[4][1], listOfCuboidsLeft[4][4], listOfCuboidsLeft[4][2], listOfCuboidsLeft[4][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[5][0], listOfCuboidsLeft[5][3], listOfCuboidsLeft[5][1], listOfCuboidsLeft[5][4], listOfCuboidsLeft[5][2], listOfCuboidsLeft[5][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[6][0], listOfCuboidsLeft[6][3], listOfCuboidsLeft[6][1], listOfCuboidsLeft[6][4], listOfCuboidsLeft[6][2], listOfCuboidsLeft[6][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[7][0], listOfCuboidsLeft[7][3], listOfCuboidsLeft[7][1], listOfCuboidsLeft[7][4], listOfCuboidsLeft[7][2], listOfCuboidsLeft[7][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[8][0], listOfCuboidsLeft[8][3], listOfCuboidsLeft[8][1], listOfCuboidsLeft[8][4], listOfCuboidsLeft[8][2], listOfCuboidsLeft[8][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[9][0], listOfCuboidsLeft[9][3], listOfCuboidsLeft[9][1], listOfCuboidsLeft[9][4], listOfCuboidsLeft[9][2], listOfCuboidsLeft[9][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[10][0], listOfCuboidsLeft[10][3], listOfCuboidsLeft[10][1], listOfCuboidsLeft[10][4], listOfCuboidsLeft[10][2], listOfCuboidsLeft[10][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[11][0], listOfCuboidsLeft[11][3], listOfCuboidsLeft[11][1], listOfCuboidsLeft[11][4], listOfCuboidsLeft[11][2], listOfCuboidsLeft[11][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[12][0], listOfCuboidsLeft[12][3], listOfCuboidsLeft[12][1], listOfCuboidsLeft[12][4], listOfCuboidsLeft[12][2], listOfCuboidsLeft[12][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[13][0], listOfCuboidsLeft[13][3], listOfCuboidsLeft[13][1], listOfCuboidsLeft[13][4], listOfCuboidsLeft[13][2], listOfCuboidsLeft[13][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[14][0], listOfCuboidsLeft[14][3], listOfCuboidsLeft[14][1], listOfCuboidsLeft[14][4], listOfCuboidsLeft[14][2], listOfCuboidsLeft[14][5], texture, tintIndex, true, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[15][0], listOfCuboidsLeft[15][3], listOfCuboidsLeft[15][1], listOfCuboidsLeft[15][4], listOfCuboidsLeft[15][2], listOfCuboidsLeft[15][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[16][0], listOfCuboidsLeft[16][3], listOfCuboidsLeft[16][1], listOfCuboidsLeft[16][4], listOfCuboidsLeft[16][2], listOfCuboidsLeft[16][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[17][0], listOfCuboidsLeft[17][3], listOfCuboidsLeft[17][1], listOfCuboidsLeft[17][4], listOfCuboidsLeft[17][2], listOfCuboidsLeft[17][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[18][0], listOfCuboidsLeft[18][3], listOfCuboidsLeft[18][1], listOfCuboidsLeft[18][4], listOfCuboidsLeft[18][2], listOfCuboidsLeft[18][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[19][0], listOfCuboidsLeft[19][3], listOfCuboidsLeft[19][1], listOfCuboidsLeft[19][4], listOfCuboidsLeft[19][2], listOfCuboidsLeft[19][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[20][0], listOfCuboidsLeft[20][3], listOfCuboidsLeft[20][1], listOfCuboidsLeft[20][4], listOfCuboidsLeft[20][2], listOfCuboidsLeft[20][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[21][0], listOfCuboidsLeft[21][3], listOfCuboidsLeft[21][1], listOfCuboidsLeft[21][4], listOfCuboidsLeft[21][2], listOfCuboidsLeft[21][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[22][0], listOfCuboidsLeft[22][3], listOfCuboidsLeft[22][1], listOfCuboidsLeft[22][4], listOfCuboidsLeft[22][2], listOfCuboidsLeft[22][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[23][0], listOfCuboidsLeft[23][3], listOfCuboidsLeft[23][1], listOfCuboidsLeft[23][4], listOfCuboidsLeft[23][2], listOfCuboidsLeft[23][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[24][0], listOfCuboidsLeft[24][3], listOfCuboidsLeft[24][1], listOfCuboidsLeft[24][4], listOfCuboidsLeft[24][2], listOfCuboidsLeft[24][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[25][0], listOfCuboidsLeft[25][3], listOfCuboidsLeft[25][1], listOfCuboidsLeft[25][4], listOfCuboidsLeft[25][2], listOfCuboidsLeft[25][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[26][0], listOfCuboidsLeft[26][3], listOfCuboidsLeft[26][1], listOfCuboidsLeft[26][4], listOfCuboidsLeft[26][2], listOfCuboidsLeft[26][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[27][0], listOfCuboidsLeft[27][3], listOfCuboidsLeft[27][1], listOfCuboidsLeft[27][4], listOfCuboidsLeft[27][2], listOfCuboidsLeft[27][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsLeft[28][0], listOfCuboidsLeft[28][3], listOfCuboidsLeft[28][1], listOfCuboidsLeft[28][4], listOfCuboidsLeft[28][2], listOfCuboidsLeft[28][5], texture, tintIndex, true, false, false, false, false, false));
						}
						if (connectedRight) {
							int[][] listOfCuboidsRight = {{14, 1, -1, 15, 2, 0},
							        {10, 5, -5, 11, 6, 0},
							        {3, 12, -12, 4, 13, 0},
							        {12, 3, -3, 13, 4, 0},
							        {5, 10, -10, 6, 11, 0},
							        {8, 7, -7, 9, 8, 0},
							        {1, 14, -14, 2, 15, 0},
							        {13, 2, -2, 14, 3, 0},
							        {6, 9, -9, 7, 10, 0},
							        {9, 6, -6, 10, 7, 0},
							        {2, 13, -13, 3, 14, 0},
							        {11, 4, -4, 12, 5, 0},
							        {4, 11, -11, 5, 12, 0},
							        {7, 8, -8, 8, 9, 0},
							        {0, 15, -15, 1, 16, 0},
							        {0, 1, -1, 14, 2, 0},
							        {0, 5, -5, 10, 6, 0},
							        {0, 12, -12, 3, 13, 0},
							        {0, 3, -3, 12, 4, 0},
							        {0, 10, -10, 5, 11, 0},
							        {0, 7, -7, 8, 8, 0},
							        {0, 14, -14, 1, 15, 0},
							        {0, 2, -2, 13, 3, 0},
							        {0, 9, -9, 6, 10, 0},
							        {0, 6, -6, 9, 7, 0},
							        {0, 13, -13, 2, 14, 0},
							        {0, 4, -4, 11, 5, 0},
							        {0, 11, -11, 4, 12, 0},
							        {0, 8, -8, 7, 9, 0}};
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[0][0], listOfCuboidsRight[0][3], listOfCuboidsRight[0][1], listOfCuboidsRight[0][4], listOfCuboidsRight[0][2], listOfCuboidsRight[0][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[1][0], listOfCuboidsRight[1][3], listOfCuboidsRight[1][1], listOfCuboidsRight[1][4], listOfCuboidsRight[1][2], listOfCuboidsRight[1][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[2][0], listOfCuboidsRight[2][3], listOfCuboidsRight[2][1], listOfCuboidsRight[2][4], listOfCuboidsRight[2][2], listOfCuboidsRight[2][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[3][0], listOfCuboidsRight[3][3], listOfCuboidsRight[3][1], listOfCuboidsRight[3][4], listOfCuboidsRight[3][2], listOfCuboidsRight[3][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[4][0], listOfCuboidsRight[4][3], listOfCuboidsRight[4][1], listOfCuboidsRight[4][4], listOfCuboidsRight[4][2], listOfCuboidsRight[4][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[5][0], listOfCuboidsRight[5][3], listOfCuboidsRight[5][1], listOfCuboidsRight[5][4], listOfCuboidsRight[5][2], listOfCuboidsRight[5][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[6][0], listOfCuboidsRight[6][3], listOfCuboidsRight[6][1], listOfCuboidsRight[6][4], listOfCuboidsRight[6][2], listOfCuboidsRight[6][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[7][0], listOfCuboidsRight[7][3], listOfCuboidsRight[7][1], listOfCuboidsRight[7][4], listOfCuboidsRight[7][2], listOfCuboidsRight[7][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[8][0], listOfCuboidsRight[8][3], listOfCuboidsRight[8][1], listOfCuboidsRight[8][4], listOfCuboidsRight[8][2], listOfCuboidsRight[8][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[9][0], listOfCuboidsRight[9][3], listOfCuboidsRight[9][1], listOfCuboidsRight[9][4], listOfCuboidsRight[9][2], listOfCuboidsRight[9][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[10][0], listOfCuboidsRight[10][3], listOfCuboidsRight[10][1], listOfCuboidsRight[10][4], listOfCuboidsRight[10][2], listOfCuboidsRight[10][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[11][0], listOfCuboidsRight[11][3], listOfCuboidsRight[11][1], listOfCuboidsRight[11][4], listOfCuboidsRight[11][2], listOfCuboidsRight[11][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[12][0], listOfCuboidsRight[12][3], listOfCuboidsRight[12][1], listOfCuboidsRight[12][4], listOfCuboidsRight[12][2], listOfCuboidsRight[12][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[13][0], listOfCuboidsRight[13][3], listOfCuboidsRight[13][1], listOfCuboidsRight[13][4], listOfCuboidsRight[13][2], listOfCuboidsRight[13][5], texture, tintIndex, false, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[14][0], listOfCuboidsRight[14][3], listOfCuboidsRight[14][1], listOfCuboidsRight[14][4], listOfCuboidsRight[14][2], listOfCuboidsRight[14][5], texture, tintIndex, true, true, false, false, true, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[15][0], listOfCuboidsRight[15][3], listOfCuboidsRight[15][1], listOfCuboidsRight[15][4], listOfCuboidsRight[15][2], listOfCuboidsRight[15][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[16][0], listOfCuboidsRight[16][3], listOfCuboidsRight[16][1], listOfCuboidsRight[16][4], listOfCuboidsRight[16][2], listOfCuboidsRight[16][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[17][0], listOfCuboidsRight[17][3], listOfCuboidsRight[17][1], listOfCuboidsRight[17][4], listOfCuboidsRight[17][2], listOfCuboidsRight[17][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[18][0], listOfCuboidsRight[18][3], listOfCuboidsRight[18][1], listOfCuboidsRight[18][4], listOfCuboidsRight[18][2], listOfCuboidsRight[18][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[19][0], listOfCuboidsRight[19][3], listOfCuboidsRight[19][1], listOfCuboidsRight[19][4], listOfCuboidsRight[19][2], listOfCuboidsRight[19][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[20][0], listOfCuboidsRight[20][3], listOfCuboidsRight[20][1], listOfCuboidsRight[20][4], listOfCuboidsRight[20][2], listOfCuboidsRight[20][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[21][0], listOfCuboidsRight[21][3], listOfCuboidsRight[21][1], listOfCuboidsRight[21][4], listOfCuboidsRight[21][2], listOfCuboidsRight[21][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[22][0], listOfCuboidsRight[22][3], listOfCuboidsRight[22][1], listOfCuboidsRight[22][4], listOfCuboidsRight[22][2], listOfCuboidsRight[22][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[23][0], listOfCuboidsRight[23][3], listOfCuboidsRight[23][1], listOfCuboidsRight[23][4], listOfCuboidsRight[23][2], listOfCuboidsRight[23][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[24][0], listOfCuboidsRight[24][3], listOfCuboidsRight[24][1], listOfCuboidsRight[24][4], listOfCuboidsRight[24][2], listOfCuboidsRight[24][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[25][0], listOfCuboidsRight[25][3], listOfCuboidsRight[25][1], listOfCuboidsRight[25][4], listOfCuboidsRight[25][2], listOfCuboidsRight[25][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[26][0], listOfCuboidsRight[26][3], listOfCuboidsRight[26][1], listOfCuboidsRight[26][4], listOfCuboidsRight[26][2], listOfCuboidsRight[26][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[27][0], listOfCuboidsRight[27][3], listOfCuboidsRight[27][1], listOfCuboidsRight[27][4], listOfCuboidsRight[27][2], listOfCuboidsRight[27][5], texture, tintIndex, true, false, false, false, false, false));
							quads.addAll(ModelHelper.createCuboid16(listOfCuboidsRight[28][0], listOfCuboidsRight[28][3], listOfCuboidsRight[28][1], listOfCuboidsRight[28][4], listOfCuboidsRight[28][2], listOfCuboidsRight[28][5], texture, tintIndex, true, false, false, false, false, false));
						}
						break;
					default:
						break;
					}
					break;
				case TOP:
					switch (facing) {
					case EAST:
						int[][] listOfCuboids = {{0, 15, 0, 1, 16, 16},
						        {1, 14, 0, 2, 15, 16},
						        {6, 9, 0, 7, 10, 16},
						        {7, 8, 0, 8, 9, 16},
						        {4, 11, 0, 5, 12, 16},
						        {5, 10, 0, 6, 11, 16},
						        {2, 13, 0, 3, 14, 16},
						        {3, 12, 0, 4, 13, 16},
						        {14, 1, 0, 15, 2, 16},
						        {15, 0, 0, 16, 1, 16},
						        {12, 3, 0, 13, 4, 16},
						        {13, 2, 0, 14, 3, 16},
						        {10, 5, 0, 11, 6, 16},
						        {9, 6, 0, 10, 7, 16},
						        {8, 7, 0, 9, 8, 16},
						        {11, 4, 0, 12, 5, 16},
						        {15, 1, 0, 16, 16, 16},
						        {1, 15, 0, 2, 16, 16},
						        {6, 10, 0, 7, 16, 16},
						        {7, 9, 0, 8, 16, 16},
						        {4, 12, 0, 5, 16, 16},
						        {5, 11, 0, 6, 16, 16},
						        {2, 14, 0, 3, 16, 16},
						        {3, 13, 0, 4, 16, 16},
						        {14, 2, 0, 15, 16, 16},
						        {12, 4, 0, 13, 16, 16},
						        {13, 3, 0, 14, 16, 16},
						        {10, 6, 0, 11, 16, 16},
						        {9, 7, 0, 10, 16, 16},
						        {8, 8, 0, 9, 16, 16},
						        {11, 5, 0, 12, 16, 16}};
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, true, false, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, true, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, true, false, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, false, true, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[17][0], listOfCuboids[17][3], listOfCuboids[17][1], listOfCuboids[17][4], listOfCuboids[17][2], listOfCuboids[17][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[18][0], listOfCuboids[18][3], listOfCuboids[18][1], listOfCuboids[18][4], listOfCuboids[18][2], listOfCuboids[18][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[19][0], listOfCuboids[19][3], listOfCuboids[19][1], listOfCuboids[19][4], listOfCuboids[19][2], listOfCuboids[19][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[20][0], listOfCuboids[20][3], listOfCuboids[20][1], listOfCuboids[20][4], listOfCuboids[20][2], listOfCuboids[20][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[21][0], listOfCuboids[21][3], listOfCuboids[21][1], listOfCuboids[21][4], listOfCuboids[21][2], listOfCuboids[21][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[22][0], listOfCuboids[22][3], listOfCuboids[22][1], listOfCuboids[22][4], listOfCuboids[22][2], listOfCuboids[22][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[23][0], listOfCuboids[23][3], listOfCuboids[23][1], listOfCuboids[23][4], listOfCuboids[23][2], listOfCuboids[23][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[24][0], listOfCuboids[24][3], listOfCuboids[24][1], listOfCuboids[24][4], listOfCuboids[24][2], listOfCuboids[24][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[25][0], listOfCuboids[25][3], listOfCuboids[25][1], listOfCuboids[25][4], listOfCuboids[25][2], listOfCuboids[25][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[26][0], listOfCuboids[26][3], listOfCuboids[26][1], listOfCuboids[26][4], listOfCuboids[26][2], listOfCuboids[26][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[27][0], listOfCuboids[27][3], listOfCuboids[27][1], listOfCuboids[27][4], listOfCuboids[27][2], listOfCuboids[27][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[28][0], listOfCuboids[28][3], listOfCuboids[28][1], listOfCuboids[28][4], listOfCuboids[28][2], listOfCuboids[28][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[29][0], listOfCuboids[29][3], listOfCuboids[29][1], listOfCuboids[29][4], listOfCuboids[29][2], listOfCuboids[29][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[30][0], listOfCuboids[30][3], listOfCuboids[30][1], listOfCuboids[30][4], listOfCuboids[30][2], listOfCuboids[30][5], texture, tintIndex, false, false, true, true, true, false));
						if (connectedLeft) {
						}
						if (connectedRight) {
						}
						break;
					case NORTH:
						int[][] listOfCuboids1 = {{0, 15, 15, 16, 16, 16},
						        {0, 14, 14, 16, 15, 15},
						        {0, 9, 9, 16, 10, 10},
						        {0, 8, 8, 16, 9, 9},
						        {0, 11, 11, 16, 12, 12},
						        {0, 10, 10, 16, 11, 11},
						        {0, 13, 13, 16, 14, 14},
						        {0, 12, 12, 16, 13, 13},
						        {0, 1, 1, 16, 2, 2},
						        {0, 0, 0, 16, 1, 1},
						        {0, 3, 3, 16, 4, 4},
						        {0, 2, 2, 16, 3, 3},
						        {0, 5, 5, 16, 6, 6},
						        {0, 6, 6, 16, 7, 7},
						        {0, 7, 7, 16, 8, 8},
						        {0, 4, 4, 16, 5, 5},
						        {0, 1, 0, 16, 16, 1},
						        {0, 15, 14, 16, 16, 15},
						        {0, 10, 9, 16, 16, 10},
						        {0, 9, 8, 16, 16, 9},
						        {0, 12, 11, 16, 16, 12},
						        {0, 11, 10, 16, 16, 11},
						        {0, 14, 13, 16, 16, 14},
						        {0, 13, 12, 16, 16, 13},
						        {0, 2, 1, 16, 16, 2},
						        {0, 4, 3, 16, 16, 4},
						        {0, 3, 2, 16, 16, 3},
						        {0, 6, 5, 16, 16, 6},
						        {0, 7, 6, 16, 16, 7},
						        {0, 8, 7, 16, 16, 8},
						        {0, 5, 4, 16, 16, 5}};
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[0][0], listOfCuboids1[0][3], listOfCuboids1[0][1], listOfCuboids1[0][4], listOfCuboids1[0][2], listOfCuboids1[0][5], texture, tintIndex, true, true, true, false, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[1][0], listOfCuboids1[1][3], listOfCuboids1[1][1], listOfCuboids1[1][4], listOfCuboids1[1][2], listOfCuboids1[1][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[2][0], listOfCuboids1[2][3], listOfCuboids1[2][1], listOfCuboids1[2][4], listOfCuboids1[2][2], listOfCuboids1[2][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[3][0], listOfCuboids1[3][3], listOfCuboids1[3][1], listOfCuboids1[3][4], listOfCuboids1[3][2], listOfCuboids1[3][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[4][0], listOfCuboids1[4][3], listOfCuboids1[4][1], listOfCuboids1[4][4], listOfCuboids1[4][2], listOfCuboids1[4][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[5][0], listOfCuboids1[5][3], listOfCuboids1[5][1], listOfCuboids1[5][4], listOfCuboids1[5][2], listOfCuboids1[5][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[6][0], listOfCuboids1[6][3], listOfCuboids1[6][1], listOfCuboids1[6][4], listOfCuboids1[6][2], listOfCuboids1[6][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[7][0], listOfCuboids1[7][3], listOfCuboids1[7][1], listOfCuboids1[7][4], listOfCuboids1[7][2], listOfCuboids1[7][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[8][0], listOfCuboids1[8][3], listOfCuboids1[8][1], listOfCuboids1[8][4], listOfCuboids1[8][2], listOfCuboids1[8][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[9][0], listOfCuboids1[9][3], listOfCuboids1[9][1], listOfCuboids1[9][4], listOfCuboids1[9][2], listOfCuboids1[9][5], texture, tintIndex, true, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[10][0], listOfCuboids1[10][3], listOfCuboids1[10][1], listOfCuboids1[10][4], listOfCuboids1[10][2], listOfCuboids1[10][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[11][0], listOfCuboids1[11][3], listOfCuboids1[11][1], listOfCuboids1[11][4], listOfCuboids1[11][2], listOfCuboids1[11][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[12][0], listOfCuboids1[12][3], listOfCuboids1[12][1], listOfCuboids1[12][4], listOfCuboids1[12][2], listOfCuboids1[12][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[13][0], listOfCuboids1[13][3], listOfCuboids1[13][1], listOfCuboids1[13][4], listOfCuboids1[13][2], listOfCuboids1[13][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[14][0], listOfCuboids1[14][3], listOfCuboids1[14][1], listOfCuboids1[14][4], listOfCuboids1[14][2], listOfCuboids1[14][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[15][0], listOfCuboids1[15][3], listOfCuboids1[15][1], listOfCuboids1[15][4], listOfCuboids1[15][2], listOfCuboids1[15][5], texture, tintIndex, true, true, true, false, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[16][0], listOfCuboids1[16][3], listOfCuboids1[16][1], listOfCuboids1[16][4], listOfCuboids1[16][2], listOfCuboids1[16][5], texture, tintIndex, true, true, false, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[17][0], listOfCuboids1[17][3], listOfCuboids1[17][1], listOfCuboids1[17][4], listOfCuboids1[17][2], listOfCuboids1[17][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[18][0], listOfCuboids1[18][3], listOfCuboids1[18][1], listOfCuboids1[18][4], listOfCuboids1[18][2], listOfCuboids1[18][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[19][0], listOfCuboids1[19][3], listOfCuboids1[19][1], listOfCuboids1[19][4], listOfCuboids1[19][2], listOfCuboids1[19][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[20][0], listOfCuboids1[20][3], listOfCuboids1[20][1], listOfCuboids1[20][4], listOfCuboids1[20][2], listOfCuboids1[20][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[21][0], listOfCuboids1[21][3], listOfCuboids1[21][1], listOfCuboids1[21][4], listOfCuboids1[21][2], listOfCuboids1[21][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[22][0], listOfCuboids1[22][3], listOfCuboids1[22][1], listOfCuboids1[22][4], listOfCuboids1[22][2], listOfCuboids1[22][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[23][0], listOfCuboids1[23][3], listOfCuboids1[23][1], listOfCuboids1[23][4], listOfCuboids1[23][2], listOfCuboids1[23][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[24][0], listOfCuboids1[24][3], listOfCuboids1[24][1], listOfCuboids1[24][4], listOfCuboids1[24][2], listOfCuboids1[24][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[25][0], listOfCuboids1[25][3], listOfCuboids1[25][1], listOfCuboids1[25][4], listOfCuboids1[25][2], listOfCuboids1[25][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[26][0], listOfCuboids1[26][3], listOfCuboids1[26][1], listOfCuboids1[26][4], listOfCuboids1[26][2], listOfCuboids1[26][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[27][0], listOfCuboids1[27][3], listOfCuboids1[27][1], listOfCuboids1[27][4], listOfCuboids1[27][2], listOfCuboids1[27][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[28][0], listOfCuboids1[28][3], listOfCuboids1[28][1], listOfCuboids1[28][4], listOfCuboids1[28][2], listOfCuboids1[28][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[29][0], listOfCuboids1[29][3], listOfCuboids1[29][1], listOfCuboids1[29][4], listOfCuboids1[29][2], listOfCuboids1[29][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids1[30][0], listOfCuboids1[30][3], listOfCuboids1[30][1], listOfCuboids1[30][4], listOfCuboids1[30][2], listOfCuboids1[30][5], texture, tintIndex, true, true, false, false, true, false));
						if (connectedLeft) {
						}
						if (connectedRight) {
						}
						break;
					case SOUTH:
						int[][] listOfCuboids11 = {{0, 15, 0, 16, 16, 1},
						        {0, 14, 1, 16, 15, 2},
						        {0, 9, 6, 16, 10, 7},
						        {0, 8, 7, 16, 9, 8},
						        {0, 11, 4, 16, 12, 5},
						        {0, 10, 5, 16, 11, 6},
						        {0, 13, 2, 16, 14, 3},
						        {0, 12, 3, 16, 13, 4},
						        {0, 1, 14, 16, 2, 15},
						        {0, 0, 15, 16, 1, 16},
						        {0, 3, 12, 16, 4, 13},
						        {0, 2, 13, 16, 3, 14},
						        {0, 5, 10, 16, 6, 11},
						        {0, 6, 9, 16, 7, 10},
						        {0, 7, 8, 16, 8, 9},
						        {0, 4, 11, 16, 5, 12},
						        {0, 1, 15, 16, 16, 16},
						        {0, 15, 1, 16, 16, 2},
						        {0, 10, 6, 16, 16, 7},
						        {0, 9, 7, 16, 16, 8},
						        {0, 12, 4, 16, 16, 5},
						        {0, 11, 5, 16, 16, 6},
						        {0, 14, 2, 16, 16, 3},
						        {0, 13, 3, 16, 16, 4},
						        {0, 2, 14, 16, 16, 15},
						        {0, 4, 12, 16, 16, 13},
						        {0, 3, 13, 16, 16, 14},
						        {0, 6, 10, 16, 16, 11},
						        {0, 7, 9, 16, 16, 10},
						        {0, 8, 8, 16, 16, 9},
						        {0, 5, 11, 16, 16, 12}};
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[0][0], listOfCuboids11[0][3], listOfCuboids11[0][1], listOfCuboids11[0][4], listOfCuboids11[0][2], listOfCuboids11[0][5], texture, tintIndex, true, true, false, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[1][0], listOfCuboids11[1][3], listOfCuboids11[1][1], listOfCuboids11[1][4], listOfCuboids11[1][2], listOfCuboids11[1][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[2][0], listOfCuboids11[2][3], listOfCuboids11[2][1], listOfCuboids11[2][4], listOfCuboids11[2][2], listOfCuboids11[2][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[3][0], listOfCuboids11[3][3], listOfCuboids11[3][1], listOfCuboids11[3][4], listOfCuboids11[3][2], listOfCuboids11[3][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[4][0], listOfCuboids11[4][3], listOfCuboids11[4][1], listOfCuboids11[4][4], listOfCuboids11[4][2], listOfCuboids11[4][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[5][0], listOfCuboids11[5][3], listOfCuboids11[5][1], listOfCuboids11[5][4], listOfCuboids11[5][2], listOfCuboids11[5][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[6][0], listOfCuboids11[6][3], listOfCuboids11[6][1], listOfCuboids11[6][4], listOfCuboids11[6][2], listOfCuboids11[6][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[7][0], listOfCuboids11[7][3], listOfCuboids11[7][1], listOfCuboids11[7][4], listOfCuboids11[7][2], listOfCuboids11[7][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[8][0], listOfCuboids11[8][3], listOfCuboids11[8][1], listOfCuboids11[8][4], listOfCuboids11[8][2], listOfCuboids11[8][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[9][0], listOfCuboids11[9][3], listOfCuboids11[9][1], listOfCuboids11[9][4], listOfCuboids11[9][2], listOfCuboids11[9][5], texture, tintIndex, true, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[10][0], listOfCuboids11[10][3], listOfCuboids11[10][1], listOfCuboids11[10][4], listOfCuboids11[10][2], listOfCuboids11[10][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[11][0], listOfCuboids11[11][3], listOfCuboids11[11][1], listOfCuboids11[11][4], listOfCuboids11[11][2], listOfCuboids11[11][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[12][0], listOfCuboids11[12][3], listOfCuboids11[12][1], listOfCuboids11[12][4], listOfCuboids11[12][2], listOfCuboids11[12][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[13][0], listOfCuboids11[13][3], listOfCuboids11[13][1], listOfCuboids11[13][4], listOfCuboids11[13][2], listOfCuboids11[13][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[14][0], listOfCuboids11[14][3], listOfCuboids11[14][1], listOfCuboids11[14][4], listOfCuboids11[14][2], listOfCuboids11[14][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[15][0], listOfCuboids11[15][3], listOfCuboids11[15][1], listOfCuboids11[15][4], listOfCuboids11[15][2], listOfCuboids11[15][5], texture, tintIndex, true, true, false, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[16][0], listOfCuboids11[16][3], listOfCuboids11[16][1], listOfCuboids11[16][4], listOfCuboids11[16][2], listOfCuboids11[16][5], texture, tintIndex, true, true, true, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[17][0], listOfCuboids11[17][3], listOfCuboids11[17][1], listOfCuboids11[17][4], listOfCuboids11[17][2], listOfCuboids11[17][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[18][0], listOfCuboids11[18][3], listOfCuboids11[18][1], listOfCuboids11[18][4], listOfCuboids11[18][2], listOfCuboids11[18][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[19][0], listOfCuboids11[19][3], listOfCuboids11[19][1], listOfCuboids11[19][4], listOfCuboids11[19][2], listOfCuboids11[19][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[20][0], listOfCuboids11[20][3], listOfCuboids11[20][1], listOfCuboids11[20][4], listOfCuboids11[20][2], listOfCuboids11[20][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[21][0], listOfCuboids11[21][3], listOfCuboids11[21][1], listOfCuboids11[21][4], listOfCuboids11[21][2], listOfCuboids11[21][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[22][0], listOfCuboids11[22][3], listOfCuboids11[22][1], listOfCuboids11[22][4], listOfCuboids11[22][2], listOfCuboids11[22][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[23][0], listOfCuboids11[23][3], listOfCuboids11[23][1], listOfCuboids11[23][4], listOfCuboids11[23][2], listOfCuboids11[23][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[24][0], listOfCuboids11[24][3], listOfCuboids11[24][1], listOfCuboids11[24][4], listOfCuboids11[24][2], listOfCuboids11[24][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[25][0], listOfCuboids11[25][3], listOfCuboids11[25][1], listOfCuboids11[25][4], listOfCuboids11[25][2], listOfCuboids11[25][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[26][0], listOfCuboids11[26][3], listOfCuboids11[26][1], listOfCuboids11[26][4], listOfCuboids11[26][2], listOfCuboids11[26][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[27][0], listOfCuboids11[27][3], listOfCuboids11[27][1], listOfCuboids11[27][4], listOfCuboids11[27][2], listOfCuboids11[27][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[28][0], listOfCuboids11[28][3], listOfCuboids11[28][1], listOfCuboids11[28][4], listOfCuboids11[28][2], listOfCuboids11[28][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[29][0], listOfCuboids11[29][3], listOfCuboids11[29][1], listOfCuboids11[29][4], listOfCuboids11[29][2], listOfCuboids11[29][5], texture, tintIndex, true, true, false, false, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids11[30][0], listOfCuboids11[30][3], listOfCuboids11[30][1], listOfCuboids11[30][4], listOfCuboids11[30][2], listOfCuboids11[30][5], texture, tintIndex, true, true, false, false, true, false));
						if (connectedLeft) {
						}
						if (connectedRight) {
						}
						break;
					case WEST:
						int[][] listOfCuboids111 = {{15, 15, 0, 16, 16, 16},
						        {14, 14, 0, 15, 15, 16},
						        {9, 9, 0, 10, 10, 16},
						        {8, 8, 0, 9, 9, 16},
						        {11, 11, 0, 12, 12, 16},
						        {10, 10, 0, 11, 11, 16},
						        {13, 13, 0, 14, 14, 16},
						        {12, 12, 0, 13, 13, 16},
						        {1, 1, 0, 2, 2, 16},
						        {0, 0, 0, 1, 1, 16},
						        {3, 3, 0, 4, 4, 16},
						        {2, 2, 0, 3, 3, 16},
						        {5, 5, 0, 6, 6, 16},
						        {6, 6, 0, 7, 7, 16},
						        {7, 7, 0, 8, 8, 16},
						        {4, 4, 0, 5, 5, 16},
						        {0, 1, 0, 1, 16, 16},
						        {14, 15, 0, 15, 16, 16},
						        {9, 10, 0, 10, 16, 16},
						        {8, 9, 0, 9, 16, 16},
						        {11, 12, 0, 12, 16, 16},
						        {10, 11, 0, 11, 16, 16},
						        {13, 14, 0, 14, 16, 16},
						        {12, 13, 0, 13, 16, 16},
						        {1, 2, 0, 2, 16, 16},
						        {3, 4, 0, 4, 16, 16},
						        {2, 3, 0, 3, 16, 16},
						        {5, 6, 0, 6, 16, 16},
						        {6, 7, 0, 7, 16, 16},
						        {7, 8, 0, 8, 16, 16},
						        {4, 5, 0, 5, 16, 16}};
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[0][0], listOfCuboids111[0][3], listOfCuboids111[0][1], listOfCuboids111[0][4], listOfCuboids111[0][2], listOfCuboids111[0][5], texture, tintIndex, false, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[1][0], listOfCuboids111[1][3], listOfCuboids111[1][1], listOfCuboids111[1][4], listOfCuboids111[1][2], listOfCuboids111[1][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[2][0], listOfCuboids111[2][3], listOfCuboids111[2][1], listOfCuboids111[2][4], listOfCuboids111[2][2], listOfCuboids111[2][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[3][0], listOfCuboids111[3][3], listOfCuboids111[3][1], listOfCuboids111[3][4], listOfCuboids111[3][2], listOfCuboids111[3][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[4][0], listOfCuboids111[4][3], listOfCuboids111[4][1], listOfCuboids111[4][4], listOfCuboids111[4][2], listOfCuboids111[4][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[5][0], listOfCuboids111[5][3], listOfCuboids111[5][1], listOfCuboids111[5][4], listOfCuboids111[5][2], listOfCuboids111[5][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[6][0], listOfCuboids111[6][3], listOfCuboids111[6][1], listOfCuboids111[6][4], listOfCuboids111[6][2], listOfCuboids111[6][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[7][0], listOfCuboids111[7][3], listOfCuboids111[7][1], listOfCuboids111[7][4], listOfCuboids111[7][2], listOfCuboids111[7][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[8][0], listOfCuboids111[8][3], listOfCuboids111[8][1], listOfCuboids111[8][4], listOfCuboids111[8][2], listOfCuboids111[8][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[9][0], listOfCuboids111[9][3], listOfCuboids111[9][1], listOfCuboids111[9][4], listOfCuboids111[9][2], listOfCuboids111[9][5], texture, tintIndex, true, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[10][0], listOfCuboids111[10][3], listOfCuboids111[10][1], listOfCuboids111[10][4], listOfCuboids111[10][2], listOfCuboids111[10][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[11][0], listOfCuboids111[11][3], listOfCuboids111[11][1], listOfCuboids111[11][4], listOfCuboids111[11][2], listOfCuboids111[11][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[12][0], listOfCuboids111[12][3], listOfCuboids111[12][1], listOfCuboids111[12][4], listOfCuboids111[12][2], listOfCuboids111[12][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[13][0], listOfCuboids111[13][3], listOfCuboids111[13][1], listOfCuboids111[13][4], listOfCuboids111[13][2], listOfCuboids111[13][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[14][0], listOfCuboids111[14][3], listOfCuboids111[14][1], listOfCuboids111[14][4], listOfCuboids111[14][2], listOfCuboids111[14][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[15][0], listOfCuboids111[15][3], listOfCuboids111[15][1], listOfCuboids111[15][4], listOfCuboids111[15][2], listOfCuboids111[15][5], texture, tintIndex, false, true, true, true, false, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[16][0], listOfCuboids111[16][3], listOfCuboids111[16][1], listOfCuboids111[16][4], listOfCuboids111[16][2], listOfCuboids111[16][5], texture, tintIndex, true, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[17][0], listOfCuboids111[17][3], listOfCuboids111[17][1], listOfCuboids111[17][4], listOfCuboids111[17][2], listOfCuboids111[17][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[18][0], listOfCuboids111[18][3], listOfCuboids111[18][1], listOfCuboids111[18][4], listOfCuboids111[18][2], listOfCuboids111[18][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[19][0], listOfCuboids111[19][3], listOfCuboids111[19][1], listOfCuboids111[19][4], listOfCuboids111[19][2], listOfCuboids111[19][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[20][0], listOfCuboids111[20][3], listOfCuboids111[20][1], listOfCuboids111[20][4], listOfCuboids111[20][2], listOfCuboids111[20][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[21][0], listOfCuboids111[21][3], listOfCuboids111[21][1], listOfCuboids111[21][4], listOfCuboids111[21][2], listOfCuboids111[21][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[22][0], listOfCuboids111[22][3], listOfCuboids111[22][1], listOfCuboids111[22][4], listOfCuboids111[22][2], listOfCuboids111[22][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[23][0], listOfCuboids111[23][3], listOfCuboids111[23][1], listOfCuboids111[23][4], listOfCuboids111[23][2], listOfCuboids111[23][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[24][0], listOfCuboids111[24][3], listOfCuboids111[24][1], listOfCuboids111[24][4], listOfCuboids111[24][2], listOfCuboids111[24][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[25][0], listOfCuboids111[25][3], listOfCuboids111[25][1], listOfCuboids111[25][4], listOfCuboids111[25][2], listOfCuboids111[25][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[26][0], listOfCuboids111[26][3], listOfCuboids111[26][1], listOfCuboids111[26][4], listOfCuboids111[26][2], listOfCuboids111[26][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[27][0], listOfCuboids111[27][3], listOfCuboids111[27][1], listOfCuboids111[27][4], listOfCuboids111[27][2], listOfCuboids111[27][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[28][0], listOfCuboids111[28][3], listOfCuboids111[28][1], listOfCuboids111[28][4], listOfCuboids111[28][2], listOfCuboids111[28][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[29][0], listOfCuboids111[29][3], listOfCuboids111[29][1], listOfCuboids111[29][4], listOfCuboids111[29][2], listOfCuboids111[29][5], texture, tintIndex, false, false, true, true, true, false));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids111[30][0], listOfCuboids111[30][3], listOfCuboids111[30][1], listOfCuboids111[30][4], listOfCuboids111[30][2], listOfCuboids111[30][5], texture, tintIndex, false, false, true, true, true, false));
						if (connectedLeft) {
						}
						if (connectedRight) {
						}
						break;
					default:
						break;
					}
					break;
				}
				break;
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