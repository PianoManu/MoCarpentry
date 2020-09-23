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
						if (connectedLeft) {
						}
						if (connectedRight) {
						}
						break;
					case NORTH:
						if (connectedLeft) {
						}
						if (connectedRight) {
						}
						break;
					case SOUTH:
						int[][] listOfCuboids = {{0, 0, 0, 16, 1, 1},
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
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, true, true, true, true, true, true));
						quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, true, false, true, true, false, true));
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
						}
						if (connectedRight) {
						}
						break;
					case WEST:
						if (connectedLeft) {
						}
						if (connectedRight) {
						}
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