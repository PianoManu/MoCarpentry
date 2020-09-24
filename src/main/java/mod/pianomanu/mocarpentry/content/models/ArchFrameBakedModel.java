package mod.pianomanu.mocarpentry.content.models;

import mod.pianomanu.blockcarpentry.tileentity.FrameBlockTile;
import mod.pianomanu.blockcarpentry.util.TextureHelper;
import mod.pianomanu.mocarpentry.utils.ModelHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.StairsBlock;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class determines the model of the arch when it does contain a block
 *
 * @author PianoManu
 * @version 1.0 09/24/20
 */
public class ArchFrameBakedModel implements IDynamicBakedModel {
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
            switch (state.get(StairsBlock.SHAPE)) {
                case STRAIGHT:
                    switch (state.get(StairsBlock.HALF)) {
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                                case SOUTH:
                                    int[][] listOfCuboids = {{0, 0, 15, 16, 16, 16},
                                            {0, 4, 14, 16, 16, 15},
                                            {0, 7, 13, 16, 16, 14},
                                            {0, 9, 12, 16, 16, 13},
                                            {0, 10, 11, 16, 16, 12},
                                            {0, 11, 10, 16, 16, 11},
                                            {0, 12, 9, 16, 16, 10},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 4, 16, 16, 7},
                                            {0, 15, 0, 16, 16, 4}};
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
                                    break;
                                case WEST:
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 4, 0, 2, 16, 16},
                                            {2, 7, 0, 3, 16, 16},
                                            {3, 9, 0, 4, 16, 16},
                                            {4, 10, 0, 5, 16, 16},
                                            {5, 11, 0, 6, 16, 16},
                                            {6, 12, 0, 7, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {9, 14, 0, 12, 16, 16},
                                            {12, 15, 0, 16, 16, 16}};
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
                                    break;
                                case NORTH:
                                    listOfCuboids = new int[][]{{0, 0, 0, 16, 16, 1},
                                            {0, 4, 1, 16, 16, 2},
                                            {0, 7, 2, 16, 16, 3},
                                            {0, 9, 3, 16, 16, 4},
                                            {0, 10, 4, 16, 16, 5},
                                            {0, 11, 5, 16, 16, 6},
                                            {0, 12, 6, 16, 16, 7},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 9, 16, 16, 12},
                                            {0, 15, 12, 16, 16, 16}};
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
                                    break;
                                case EAST:
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 4, 0, 15, 16, 16},
                                            {13, 7, 0, 14, 16, 16},
                                            {12, 9, 0, 13, 16, 16},
                                            {11, 10, 0, 12, 16, 16},
                                            {10, 11, 0, 11, 16, 16},
                                            {9, 12, 0, 10, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {4, 14, 0, 7, 16, 16},
                                            {0, 15, 0, 4, 16, 16}};
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
                                    break;
                            }
                            break;
                        case BOTTOM:
                            switch (state.get(StairsBlock.FACING)) {
                                case NORTH:
                                    int[][] listOfCuboids = {{0, 0, 0, 16, 16, 1},
                                            {0, 0, 1, 16, 12, 2},
                                            {0, 0, 2, 16, 9, 3},
                                            {0, 0, 3, 16, 7, 4},
                                            {0, 0, 4, 16, 6, 5},
                                            {0, 0, 5, 16, 5, 6},
                                            {0, 0, 6, 16, 4, 7},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 9, 16, 2, 12},
                                            {0, 0, 12, 16, 1, 16}};
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
                                    break;
                                case EAST:
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 0, 0, 15, 12, 16},
                                            {13, 0, 0, 14, 9, 16},
                                            {12, 0, 0, 13, 7, 16},
                                            {11, 0, 0, 12, 6, 16},
                                            {10, 0, 0, 11, 5, 16},
                                            {9, 0, 0, 10, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {4, 0, 0, 7, 2, 16},
                                            {0, 0, 0, 4, 1, 16}};
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
                                    break;
                                case SOUTH:
                                    listOfCuboids = new int[][]{{0, 0, 15, 16, 16, 16},
                                            {0, 0, 14, 16, 12, 15},
                                            {0, 0, 13, 16, 9, 14},
                                            {0, 0, 12, 16, 7, 13},
                                            {0, 0, 11, 16, 6, 12},
                                            {0, 0, 10, 16, 5, 11},
                                            {0, 0, 9, 16, 4, 10},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 4, 16, 2, 7},
                                            {0, 0, 0, 16, 1, 4}};
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
                                    break;
                                case WEST:
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 0, 0, 2, 12, 16},
                                            {2, 0, 0, 3, 9, 16},
                                            {3, 0, 0, 4, 7, 16},
                                            {4, 0, 0, 5, 6, 16},
                                            {5, 0, 0, 6, 5, 16},
                                            {6, 0, 0, 7, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {9, 0, 0, 12, 2, 16},
                                            {12, 0, 0, 16, 1, 16}};
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
                                    break;
                            }
                            break;
                    }
                    break;
                case INNER_RIGHT:
                    switch (state.get(StairsBlock.HALF)) {
                        case BOTTOM:
                            switch (state.get(StairsBlock.FACING)) {
                                case NORTH:
                                    //NORTH
                                    int[][] listOfCuboids = {{0, 0, 0, 16, 16, 1},
                                            {0, 0, 1, 16, 12, 2},
                                            {0, 0, 2, 16, 9, 3},
                                            {0, 0, 3, 16, 7, 4},
                                            {0, 0, 4, 16, 6, 5},
                                            {0, 0, 5, 16, 5, 6},
                                            {0, 0, 6, 16, 4, 7},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 9, 16, 2, 12},
                                            {0, 0, 12, 16, 1, 16}};
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
                                    //EAST
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 0, 0, 15, 12, 16},
                                            {13, 0, 0, 14, 9, 16},
                                            {12, 0, 0, 13, 7, 16},
                                            {11, 0, 0, 12, 6, 16},
                                            {10, 0, 0, 11, 5, 16},
                                            {9, 0, 0, 10, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {4, 0, 0, 7, 2, 16},
                                            {0, 0, 0, 4, 1, 16}};
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
                                    break;
                                case EAST:
                                    //EAST
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 0, 0, 15, 12, 16},
                                            {13, 0, 0, 14, 9, 16},
                                            {12, 0, 0, 13, 7, 16},
                                            {11, 0, 0, 12, 6, 16},
                                            {10, 0, 0, 11, 5, 16},
                                            {9, 0, 0, 10, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {4, 0, 0, 7, 2, 16},
                                            {0, 0, 0, 4, 1, 16}};
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
                                    //SOUTH
                                    listOfCuboids = new int[][]{{0, 0, 15, 16, 16, 16},
                                            {0, 0, 14, 16, 12, 15},
                                            {0, 0, 13, 16, 9, 14},
                                            {0, 0, 12, 16, 7, 13},
                                            {0, 0, 11, 16, 6, 12},
                                            {0, 0, 10, 16, 5, 11},
                                            {0, 0, 9, 16, 4, 10},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 4, 16, 2, 7},
                                            {0, 0, 0, 16, 1, 4}};
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
                                    break;
                                case SOUTH:
                                    //SOUTH
                                    listOfCuboids = new int[][]{{0, 0, 15, 16, 16, 16},
                                            {0, 0, 14, 16, 12, 15},
                                            {0, 0, 13, 16, 9, 14},
                                            {0, 0, 12, 16, 7, 13},
                                            {0, 0, 11, 16, 6, 12},
                                            {0, 0, 10, 16, 5, 11},
                                            {0, 0, 9, 16, 4, 10},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 4, 16, 2, 7},
                                            {0, 0, 0, 16, 1, 4}};
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
                                    //WEST
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 0, 0, 2, 12, 16},
                                            {2, 0, 0, 3, 9, 16},
                                            {3, 0, 0, 4, 7, 16},
                                            {4, 0, 0, 5, 6, 16},
                                            {5, 0, 0, 6, 5, 16},
                                            {6, 0, 0, 7, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {9, 0, 0, 12, 2, 16},
                                            {12, 0, 0, 16, 1, 16}};
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
                                    break;
                                case WEST:
                                    //WEST
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 0, 0, 2, 12, 16},
                                            {2, 0, 0, 3, 9, 16},
                                            {3, 0, 0, 4, 7, 16},
                                            {4, 0, 0, 5, 6, 16},
                                            {5, 0, 0, 6, 5, 16},
                                            {6, 0, 0, 7, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {9, 0, 0, 12, 2, 16},
                                            {12, 0, 0, 16, 1, 16}};
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
                                    //NORTH
                                    listOfCuboids = new int[][]{{0, 0, 0, 16, 16, 1},
                                            {0, 0, 1, 16, 12, 2},
                                            {0, 0, 2, 16, 9, 3},
                                            {0, 0, 3, 16, 7, 4},
                                            {0, 0, 4, 16, 6, 5},
                                            {0, 0, 5, 16, 5, 6},
                                            {0, 0, 6, 16, 4, 7},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 9, 16, 2, 12},
                                            {0, 0, 12, 16, 1, 16}};
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
                                    break;
                            }
                            break;
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                                case NORTH:
                                    //NORTH
                                    int[][] listOfCuboids = {{0, 0, 0, 16, 16, 1},
                                            {0, 4, 1, 16, 16, 2},
                                            {0, 7, 2, 16, 16, 3},
                                            {0, 9, 3, 16, 16, 4},
                                            {0, 10, 4, 16, 16, 5},
                                            {0, 11, 5, 16, 16, 6},
                                            {0, 12, 6, 16, 16, 7},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 9, 16, 16, 12},
                                            {0, 15, 12, 16, 16, 16}};
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
                                    //EAST
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 4, 0, 15, 16, 16},
                                            {13, 7, 0, 14, 16, 16},
                                            {12, 9, 0, 13, 16, 16},
                                            {11, 10, 0, 12, 16, 16},
                                            {10, 11, 0, 11, 16, 16},
                                            {9, 12, 0, 10, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {4, 14, 0, 7, 16, 16},
                                            {0, 15, 0, 4, 16, 16}};
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
                                    break;
                                case EAST:
                                    //EAST
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 4, 0, 15, 16, 16},
                                            {13, 7, 0, 14, 16, 16},
                                            {12, 9, 0, 13, 16, 16},
                                            {11, 10, 0, 12, 16, 16},
                                            {10, 11, 0, 11, 16, 16},
                                            {9, 12, 0, 10, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {4, 14, 0, 7, 16, 16},
                                            {0, 15, 0, 4, 16, 16}};
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
                                    //SOUTH
                                    listOfCuboids = new int[][]{{0, 0, 15, 16, 16, 16},
                                            {0, 4, 14, 16, 16, 15},
                                            {0, 7, 13, 16, 16, 14},
                                            {0, 9, 12, 16, 16, 13},
                                            {0, 10, 11, 16, 16, 12},
                                            {0, 11, 10, 16, 16, 11},
                                            {0, 12, 9, 16, 16, 10},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 4, 16, 16, 7},
                                            {0, 15, 0, 16, 16, 4}};
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
                                    break;
                                case SOUTH:
                                    //SOUTH
                                    listOfCuboids = new int[][]{{0, 0, 15, 16, 16, 16},
                                            {0, 4, 14, 16, 16, 15},
                                            {0, 7, 13, 16, 16, 14},
                                            {0, 9, 12, 16, 16, 13},
                                            {0, 10, 11, 16, 16, 12},
                                            {0, 11, 10, 16, 16, 11},
                                            {0, 12, 9, 16, 16, 10},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 4, 16, 16, 7},
                                            {0, 15, 0, 16, 16, 4}};
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
                                    //WEST
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 4, 0, 2, 16, 16},
                                            {2, 7, 0, 3, 16, 16},
                                            {3, 9, 0, 4, 16, 16},
                                            {4, 10, 0, 5, 16, 16},
                                            {5, 11, 0, 6, 16, 16},
                                            {6, 12, 0, 7, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {9, 14, 0, 12, 16, 16},
                                            {12, 15, 0, 16, 16, 16}};
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
                                    break;
                                case WEST:
                                    //WEST
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 4, 0, 2, 16, 16},
                                            {2, 7, 0, 3, 16, 16},
                                            {3, 9, 0, 4, 16, 16},
                                            {4, 10, 0, 5, 16, 16},
                                            {5, 11, 0, 6, 16, 16},
                                            {6, 12, 0, 7, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {9, 14, 0, 12, 16, 16},
                                            {12, 15, 0, 16, 16, 16}};
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
                                    //NORTH
                                    listOfCuboids = new int[][]{{0, 0, 0, 16, 16, 1},
                                            {0, 4, 1, 16, 16, 2},
                                            {0, 7, 2, 16, 16, 3},
                                            {0, 9, 3, 16, 16, 4},
                                            {0, 10, 4, 16, 16, 5},
                                            {0, 11, 5, 16, 16, 6},
                                            {0, 12, 6, 16, 16, 7},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 9, 16, 16, 12},
                                            {0, 15, 12, 16, 16, 16}};
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
                                    break;
                            }
                            break;
                    }
                    break;
                case INNER_LEFT:
                    switch (state.get(StairsBlock.HALF)) {
                        case BOTTOM:
                            switch (state.get(StairsBlock.FACING)) {
                                case EAST:
                                    //NORTH
                                    int[][] listOfCuboids = {{0, 0, 0, 16, 16, 1},
                                            {0, 0, 1, 16, 12, 2},
                                            {0, 0, 2, 16, 9, 3},
                                            {0, 0, 3, 16, 7, 4},
                                            {0, 0, 4, 16, 6, 5},
                                            {0, 0, 5, 16, 5, 6},
                                            {0, 0, 6, 16, 4, 7},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 9, 16, 2, 12},
                                            {0, 0, 12, 16, 1, 16}};
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
                                    //EAST
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 0, 0, 15, 12, 16},
                                            {13, 0, 0, 14, 9, 16},
                                            {12, 0, 0, 13, 7, 16},
                                            {11, 0, 0, 12, 6, 16},
                                            {10, 0, 0, 11, 5, 16},
                                            {9, 0, 0, 10, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {4, 0, 0, 7, 2, 16},
                                            {0, 0, 0, 4, 1, 16}};
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
                                    break;
                                case SOUTH:
                                    //EAST
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 0, 0, 15, 12, 16},
                                            {13, 0, 0, 14, 9, 16},
                                            {12, 0, 0, 13, 7, 16},
                                            {11, 0, 0, 12, 6, 16},
                                            {10, 0, 0, 11, 5, 16},
                                            {9, 0, 0, 10, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {4, 0, 0, 7, 2, 16},
                                            {0, 0, 0, 4, 1, 16}};
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
                                    //SOUTH
                                    listOfCuboids = new int[][]{{0, 0, 15, 16, 16, 16},
                                            {0, 0, 14, 16, 12, 15},
                                            {0, 0, 13, 16, 9, 14},
                                            {0, 0, 12, 16, 7, 13},
                                            {0, 0, 11, 16, 6, 12},
                                            {0, 0, 10, 16, 5, 11},
                                            {0, 0, 9, 16, 4, 10},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 4, 16, 2, 7},
                                            {0, 0, 0, 16, 1, 4}};
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
                                    break;
                                case WEST:
                                    //SOUTH
                                    listOfCuboids = new int[][]{{0, 0, 15, 16, 16, 16},
                                            {0, 0, 14, 16, 12, 15},
                                            {0, 0, 13, 16, 9, 14},
                                            {0, 0, 12, 16, 7, 13},
                                            {0, 0, 11, 16, 6, 12},
                                            {0, 0, 10, 16, 5, 11},
                                            {0, 0, 9, 16, 4, 10},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 4, 16, 2, 7},
                                            {0, 0, 0, 16, 1, 4}};
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
                                    //WEST
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 0, 0, 2, 12, 16},
                                            {2, 0, 0, 3, 9, 16},
                                            {3, 0, 0, 4, 7, 16},
                                            {4, 0, 0, 5, 6, 16},
                                            {5, 0, 0, 6, 5, 16},
                                            {6, 0, 0, 7, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {9, 0, 0, 12, 2, 16},
                                            {12, 0, 0, 16, 1, 16}};
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
                                    break;
                                case NORTH:
                                    //WEST
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 0, 0, 2, 12, 16},
                                            {2, 0, 0, 3, 9, 16},
                                            {3, 0, 0, 4, 7, 16},
                                            {4, 0, 0, 5, 6, 16},
                                            {5, 0, 0, 6, 5, 16},
                                            {6, 0, 0, 7, 4, 16},
                                            {7, 0, 0, 9, 3, 16},
                                            {9, 0, 0, 12, 2, 16},
                                            {12, 0, 0, 16, 1, 16}};
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
                                    //NORTH
                                    listOfCuboids = new int[][]{{0, 0, 0, 16, 16, 1},
                                            {0, 0, 1, 16, 12, 2},
                                            {0, 0, 2, 16, 9, 3},
                                            {0, 0, 3, 16, 7, 4},
                                            {0, 0, 4, 16, 6, 5},
                                            {0, 0, 5, 16, 5, 6},
                                            {0, 0, 6, 16, 4, 7},
                                            {0, 0, 7, 16, 3, 9},
                                            {0, 0, 9, 16, 2, 12},
                                            {0, 0, 12, 16, 1, 16}};
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
                                    break;
                            }
                            break;
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                                case EAST:
                                    //NORTH
                                    int[][] listOfCuboids = {{0, 0, 0, 16, 16, 1},
                                            {0, 4, 1, 16, 16, 2},
                                            {0, 7, 2, 16, 16, 3},
                                            {0, 9, 3, 16, 16, 4},
                                            {0, 10, 4, 16, 16, 5},
                                            {0, 11, 5, 16, 16, 6},
                                            {0, 12, 6, 16, 16, 7},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 9, 16, 16, 12},
                                            {0, 15, 12, 16, 16, 16}};
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
                                    //EAST
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 4, 0, 15, 16, 16},
                                            {13, 7, 0, 14, 16, 16},
                                            {12, 9, 0, 13, 16, 16},
                                            {11, 10, 0, 12, 16, 16},
                                            {10, 11, 0, 11, 16, 16},
                                            {9, 12, 0, 10, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {4, 14, 0, 7, 16, 16},
                                            {0, 15, 0, 4, 16, 16}};
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
                                    break;
                                case SOUTH:
                                    //EAST
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 16, 16},
                                            {14, 4, 0, 15, 16, 16},
                                            {13, 7, 0, 14, 16, 16},
                                            {12, 9, 0, 13, 16, 16},
                                            {11, 10, 0, 12, 16, 16},
                                            {10, 11, 0, 11, 16, 16},
                                            {9, 12, 0, 10, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {4, 14, 0, 7, 16, 16},
                                            {0, 15, 0, 4, 16, 16}};
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
                                    //SOUTH
                                    listOfCuboids = new int[][]{{0, 0, 15, 16, 16, 16},
                                            {0, 4, 14, 16, 16, 15},
                                            {0, 7, 13, 16, 16, 14},
                                            {0, 9, 12, 16, 16, 13},
                                            {0, 10, 11, 16, 16, 12},
                                            {0, 11, 10, 16, 16, 11},
                                            {0, 12, 9, 16, 16, 10},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 4, 16, 16, 7},
                                            {0, 15, 0, 16, 16, 4}};
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
                                    break;
                                case WEST:
                                    //SOUTH
                                    listOfCuboids = new int[][]{{0, 0, 15, 16, 16, 16},
                                            {0, 4, 14, 16, 16, 15},
                                            {0, 7, 13, 16, 16, 14},
                                            {0, 9, 12, 16, 16, 13},
                                            {0, 10, 11, 16, 16, 12},
                                            {0, 11, 10, 16, 16, 11},
                                            {0, 12, 9, 16, 16, 10},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 4, 16, 16, 7},
                                            {0, 15, 0, 16, 16, 4}};
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
                                    //WEST
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 4, 0, 2, 16, 16},
                                            {2, 7, 0, 3, 16, 16},
                                            {3, 9, 0, 4, 16, 16},
                                            {4, 10, 0, 5, 16, 16},
                                            {5, 11, 0, 6, 16, 16},
                                            {6, 12, 0, 7, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {9, 14, 0, 12, 16, 16},
                                            {12, 15, 0, 16, 16, 16}};
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
                                    break;
                                case NORTH:
                                    //WEST
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 16, 16},
                                            {1, 4, 0, 2, 16, 16},
                                            {2, 7, 0, 3, 16, 16},
                                            {3, 9, 0, 4, 16, 16},
                                            {4, 10, 0, 5, 16, 16},
                                            {5, 11, 0, 6, 16, 16},
                                            {6, 12, 0, 7, 16, 16},
                                            {7, 13, 0, 9, 16, 16},
                                            {9, 14, 0, 12, 16, 16},
                                            {12, 15, 0, 16, 16, 16}};
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
                                    //NORTH
                                    listOfCuboids = new int[][]{{0, 0, 0, 16, 16, 1},
                                            {0, 4, 1, 16, 16, 2},
                                            {0, 7, 2, 16, 16, 3},
                                            {0, 9, 3, 16, 16, 4},
                                            {0, 10, 4, 16, 16, 5},
                                            {0, 11, 5, 16, 16, 6},
                                            {0, 12, 6, 16, 16, 7},
                                            {0, 13, 7, 16, 16, 9},
                                            {0, 14, 9, 16, 16, 12},
                                            {0, 15, 12, 16, 16, 16}};
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
                                    break;
                            }
                            break;
                    }
                    break;
                case OUTER_RIGHT:
                    switch (state.get(StairsBlock.HALF)) {
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                                case EAST:
                                    int[][] listOfCuboids = {{15, 0, 15, 16, 4, 16},
                                            {14, 4, 14, 16, 7, 16},
                                            {13, 7, 13, 16, 9, 16},
                                            {12, 9, 12, 16, 10, 16},
                                            {11, 10, 11, 16, 11, 16},
                                            {10, 11, 10, 16, 12, 16},
                                            {9, 12, 9, 16, 13, 16},
                                            {7, 13, 7, 16, 14, 16},
                                            {4, 14, 4, 16, 15, 16},
                                            {0, 15, 0, 16, 16, 16}};
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
                                    break;
                                case SOUTH:
                                    listOfCuboids = new int[][]{{0, 0, 15, 1, 4, 16},
                                            {0, 4, 14, 2, 7, 16},
                                            {0, 7, 13, 3, 9, 16},
                                            {0, 9, 12, 4, 10, 16},
                                            {0, 10, 11, 5, 11, 16},
                                            {0, 11, 10, 6, 12, 16},
                                            {0, 12, 9, 7, 13, 16},
                                            {0, 13, 7, 9, 14, 16},
                                            {0, 14, 4, 12, 15, 16},
                                            {0, 15, 0, 16, 16, 16}};
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
                                    break;
                                case NORTH:
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 4, 1},
                                            {14, 4, 0, 16, 7, 2},
                                            {13, 7, 0, 16, 9, 3},
                                            {12, 9, 0, 16, 10, 4},
                                            {11, 10, 0, 16, 11, 5},
                                            {10, 11, 0, 16, 12, 6},
                                            {9, 12, 0, 16, 13, 7},
                                            {7, 13, 0, 16, 14, 9},
                                            {4, 14, 0, 16, 15, 12},
                                            {0, 15, 0, 16, 16, 16}};
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
                                    break;
                                case WEST:
                                    listOfCuboids = new int[][]{{0, 0, 0, 1, 4, 1},
                                            {0, 4, 0, 2, 7, 2},
                                            {0, 7, 0, 3, 9, 3},
                                            {0, 9, 0, 4, 10, 4},
                                            {0, 10, 0, 5, 11, 5},
                                            {0, 11, 0, 6, 12, 6},
                                            {0, 12, 0, 7, 13, 7},
                                            {0, 13, 0, 9, 14, 9},
                                            {0, 14, 0, 12, 15, 12},
                                            {0, 15, 0, 16, 16, 16}};
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
                                    break;
                            }
                            break;
                        case BOTTOM:
                            switch (state.get(StairsBlock.FACING)) {
                                case WEST:
                                    int[][] listOfCuboids = {{0, 12, 0, 1, 16, 1},
                                            {0, 9, 0, 2, 12, 2},
                                            {0, 7, 0, 3, 9, 3},
                                            {0, 6, 0, 4, 7, 4},
                                            {0, 5, 0, 5, 6, 5},
                                            {0, 4, 0, 6, 5, 6},
                                            {0, 3, 0, 7, 4, 7},
                                            {0, 2, 0, 9, 3, 9},
                                            {0, 1, 0, 12, 2, 12},
                                            {0, 0, 0, 16, 1, 16}};
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
                                    break;
                                case EAST:
                                    listOfCuboids = new int[][]{{15, 12, 15, 16, 16, 16},
                                            {14, 9, 14, 16, 12, 16},
                                            {13, 7, 13, 16, 9, 16},
                                            {12, 6, 12, 16, 7, 16},
                                            {11, 5, 11, 16, 6, 16},
                                            {10, 4, 10, 16, 5, 16},
                                            {9, 3, 9, 16, 4, 16},
                                            {7, 2, 7, 16, 3, 16},
                                            {4, 1, 4, 16, 2, 16},
                                            {0, 0, 0, 16, 1, 16}};
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
                                    break;
                                case SOUTH:
                                    listOfCuboids = new int[][]{{0, 12, 15, 1, 16, 16},
                                            {0, 9, 14, 2, 12, 16},
                                            {0, 7, 13, 3, 9, 16},
                                            {0, 6, 12, 4, 7, 16},
                                            {0, 5, 11, 5, 6, 16},
                                            {0, 4, 10, 6, 5, 16},
                                            {0, 3, 9, 7, 4, 16},
                                            {0, 2, 7, 9, 3, 16},
                                            {0, 1, 4, 12, 2, 16},
                                            {0, 0, 0, 16, 1, 16}};
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
                                    break;
                                case NORTH:
                                    listOfCuboids = new int[][]{{15, 12, 0, 16, 16, 1},
                                            {14, 9, 0, 16, 12, 2},
                                            {13, 7, 0, 16, 9, 3},
                                            {12, 6, 0, 16, 7, 4},
                                            {11, 5, 0, 16, 6, 5},
                                            {10, 4, 0, 16, 5, 6},
                                            {9, 3, 0, 16, 4, 7},
                                            {7, 2, 0, 16, 3, 9},
                                            {4, 1, 0, 16, 2, 12},
                                            {0, 0, 0, 16, 1, 16}};
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
                                    break;
                            }
                            break;
                    }
                    break;
                case OUTER_LEFT:
                    switch (state.get(StairsBlock.HALF)) {
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                                case NORTH:
                                    int[][] listOfCuboids = {{0, 0, 0, 1, 4, 1},
                                            {0, 4, 0, 2, 7, 2},
                                            {0, 7, 0, 3, 9, 3},
                                            {0, 9, 0, 4, 10, 4},
                                            {0, 10, 0, 5, 11, 5},
                                            {0, 11, 0, 6, 12, 6},
                                            {0, 12, 0, 7, 13, 7},
                                            {0, 13, 0, 9, 14, 9},
                                            {0, 14, 0, 12, 15, 12},
                                            {0, 15, 0, 16, 16, 16}};
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
                                    break;
                                case WEST:
                                    listOfCuboids = new int[][]{{0, 0, 15, 1, 4, 16},
                                            {0, 4, 14, 2, 7, 16},
                                            {0, 7, 13, 3, 9, 16},
                                            {0, 9, 12, 4, 10, 16},
                                            {0, 10, 11, 5, 11, 16},
                                            {0, 11, 10, 6, 12, 16},
                                            {0, 12, 9, 7, 13, 16},
                                            {0, 13, 7, 9, 14, 16},
                                            {0, 14, 4, 12, 15, 16},
                                            {0, 15, 0, 16, 16, 16}};
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
                                    break;
                                case EAST:
                                    listOfCuboids = new int[][]{{15, 0, 0, 16, 4, 1},
                                            {14, 4, 0, 16, 7, 2},
                                            {13, 7, 0, 16, 9, 3},
                                            {12, 9, 0, 16, 10, 4},
                                            {11, 10, 0, 16, 11, 5},
                                            {10, 11, 0, 16, 12, 6},
                                            {9, 12, 0, 16, 13, 7},
                                            {7, 13, 0, 16, 14, 9},
                                            {4, 14, 0, 16, 15, 12},
                                            {0, 15, 0, 16, 16, 16}};
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
                                    break;
                                case SOUTH:
                                    listOfCuboids = new int[][]{{15, 0, 15, 16, 4, 16},
                                            {14, 4, 14, 16, 7, 16},
                                            {13, 7, 13, 16, 9, 16},
                                            {12, 9, 12, 16, 10, 16},
                                            {11, 10, 11, 16, 11, 16},
                                            {10, 11, 10, 16, 12, 16},
                                            {9, 12, 9, 16, 13, 16},
                                            {7, 13, 7, 16, 14, 16},
                                            {4, 14, 4, 16, 15, 16},
                                            {0, 15, 0, 16, 16, 16}};
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
                                    break;
                            }
                            break;
                        case BOTTOM:
                            switch (state.get(StairsBlock.FACING)) {
                                case EAST:
                                    int[][] listOfCuboids = {{15, 12, 0, 16, 16, 1},
                                            {14, 9, 0, 16, 12, 2},
                                            {13, 7, 0, 16, 9, 3},
                                            {12, 6, 0, 16, 7, 4},
                                            {11, 5, 0, 16, 6, 5},
                                            {10, 4, 0, 16, 5, 6},
                                            {9, 3, 0, 16, 4, 7},
                                            {7, 2, 0, 16, 3, 9},
                                            {4, 1, 0, 16, 2, 12},
                                            {0, 0, 0, 16, 1, 16}};
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
                                    break;
                                case NORTH:
                                    listOfCuboids = new int[][]{{0, 12, 0, 1, 16, 1},
                                            {0, 9, 0, 2, 12, 2},
                                            {0, 7, 0, 3, 9, 3},
                                            {0, 6, 0, 4, 7, 4},
                                            {0, 5, 0, 5, 6, 5},
                                            {0, 4, 0, 6, 5, 6},
                                            {0, 3, 0, 7, 4, 7},
                                            {0, 2, 0, 9, 3, 9},
                                            {0, 1, 0, 12, 2, 12},
                                            {0, 0, 0, 16, 1, 16}};
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
                                    break;
                                case SOUTH:
                                    listOfCuboids = new int[][]{{15, 12, 15, 16, 16, 16},
                                            {14, 9, 14, 16, 12, 16},
                                            {13, 7, 13, 16, 9, 16},
                                            {12, 6, 12, 16, 7, 16},
                                            {11, 5, 11, 16, 6, 16},
                                            {10, 4, 10, 16, 5, 16},
                                            {9, 3, 9, 16, 4, 16},
                                            {7, 2, 7, 16, 3, 16},
                                            {4, 1, 4, 16, 2, 16},
                                            {0, 0, 0, 16, 1, 16}};
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
                                    break;
                                case WEST:
                                    listOfCuboids = new int[][]{{0, 12, 15, 1, 16, 16},
                                            {0, 9, 14, 2, 12, 16},
                                            {0, 7, 13, 3, 9, 16},
                                            {0, 6, 12, 4, 7, 16},
                                            {0, 5, 11, 5, 6, 16},
                                            {0, 4, 10, 6, 5, 16},
                                            {0, 3, 9, 7, 4, 16},
                                            {0, 2, 7, 9, 3, 16},
                                            {0, 1, 4, 12, 2, 16},
                                            {0, 0, 0, 16, 1, 16}};
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