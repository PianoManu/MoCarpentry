package mod.pianomanu.mocarpentry.content.models.baked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mod.pianomanu.blockcarpentry.tileentity.FrameBlockTile;
import mod.pianomanu.blockcarpentry.util.TextureHelper;
import mod.pianomanu.mocarpentry.utils.ModelCuboidsHelper;
import mod.pianomanu.mocarpentry.utils.ModelHelper;
import mod.pianomanu.mocarpentry.utils.Tuple2;
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
        	Tuple2<int[][], boolean[][]> modelStraight = new Tuple2<int[][], boolean[][]>(new int[][] {{0, 0, 15, 16, 4, 16},
        		{0, 4, 14, 16, 7, 15},
    	        {0, 7, 13, 16, 9, 14},
    	        {0, 9, 12, 16, 10, 13},
    	        {0, 10, 11, 16, 11, 12},
    	        {0, 11, 10, 16, 12, 11},
    	        {0, 12, 9, 16, 13, 10},
    	        {0, 13, 7, 16, 14, 9},
    	        {0, 14, 4, 16, 15, 7},
    	        {0, 15, 0, 16, 16, 4},
    	        {0, 4, 15, 16, 7, 16},
    	        {0, 7, 14, 16, 9, 16},
    	        {0, 9, 13, 16, 10, 16},
    	        {0, 10, 12, 16, 11, 16},
    	        {0, 11, 11, 16, 12, 16},
    	        {0, 12, 10, 16, 13, 16},
    	        {0, 13, 9, 16, 14, 16},
    	        {0, 14, 7, 16, 15, 16},
    	        {0, 15, 4, 16, 16, 16}},
    			new boolean[][] {{true, true, true, true, false, true},
    	        	{true, true, false, true, false, true},
					{true, true, false, true, false, true},
					{true, true, false, true, false, true},
					{true, true, false, true, false, true},
					{true, true, false, true, false, true},
					{true, true, false, true, false, true},
					{true, true, false, true, false, true},
					{true, true, false, true, false, true},
					{true, true, false, true, true, true},
					{true, true, true, false, false, false},
					{true, true, true, false, false, false},
					{true, true, true, false, false, false},
					{true, true, true, false, false, false},
					{true, true, true, false, false, false},
					{true, true, true, false, false, false},
					{true, true, true, false, false, false},
					{true, true, true, false, false, false},
					{true, true, true, false, true, false}});
            Tuple2<int[][], boolean[][]> modelInner = new Tuple2<int[][], boolean[][]>(new int[][] {{0, 0, 15, 15, 4, 16},
                {0, 4, 14, 14, 7, 15},
                {0, 7, 13, 13, 9, 14},
                {0, 9, 12, 12, 10, 13},
                {0, 10, 11, 11, 11, 12},
                {0, 11, 10, 10, 12, 11},
                {0, 12, 9, 9, 13, 10},
                {0, 13, 7, 7, 14, 9},
                {0, 14, 4, 4, 15, 7},
                {0, 4, 15, 15, 16, 16},
                {0, 7, 14, 14, 16, 15},
                {0, 9, 13, 13, 16, 14},
                {0, 10, 12, 12, 16, 13},
                {0, 11, 11, 11, 16, 12},
                {0, 12, 10, 10, 16, 11},
                {0, 13, 9, 9, 16, 10},
                {0, 14, 7, 7, 16, 9},
                {0, 15, 4, 4, 16, 7},
                {15, 0, 0, 16, 4, 15},
                {14, 4, 0, 15, 7, 14},
                {13, 7, 0, 14, 9, 13},
                {12, 9, 0, 13, 10, 12},
                {11, 10, 0, 12, 11, 11},
                {10, 11, 0, 11, 12, 10},
                {9, 12, 0, 10, 13, 9},
                {7, 13, 0, 9, 14, 7},
                {4, 14, 0, 7, 15, 4},
                {15, 4, 0, 16, 16, 15},
                {14, 7, 0, 15, 16, 14},
                {13, 9, 0, 14, 16, 13},
                {12, 10, 0, 13, 16, 12},
                {11, 11, 0, 12, 16, 11},
                {10, 12, 0, 11, 16, 10},
                {9, 13, 0, 10, 16, 9},
                {7, 14, 0, 9, 16, 7},
                {4, 15, 0, 7, 16, 4},
                {0, 15, 0, 4, 16, 4},
                {4, 14, 4, 7, 16, 7},
                {7, 13, 7, 9, 16, 9},
                {9, 12, 9, 10, 16, 10},
                {10, 11, 10, 11, 16, 11},
                {11, 10, 11, 12, 16, 12},
                {12, 9, 12, 13, 16, 13},
                {13, 7, 13, 14, 16, 14},
                {14, 4, 14, 15, 16, 15},
                {15, 0, 15, 16, 16, 16}},
        		new boolean[][] {{true, false, true, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, true, false, true, false},
		            {true, false, false, false, true, false},
		            {true, false, false, false, true, false},
		            {true, false, false, false, true, false},
		            {true, false, false, false, true, false},
		            {true, false, false, false, true, false},
		            {true, false, false, false, true, false},
		            {true, false, false, false, true, false},
		            {true, false, false, false, true, false},
		            {true, true, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {true, false, false, true, false, true},
		            {false, true, false, true, true, false},
		            {false, false, false, true, true, false},
		            {false, false, false, true, true, false},
		            {false, false, false, true, true, false},
		            {false, false, false, true, true, false},
		            {false, false, false, true, true, false},
		            {false, false, false, true, true, false},
		            {false, false, false, true, true, false},
		            {false, false, false, true, true, false},
		            {true, false, false, true, true, true},
		            {false, false, false, false, true, true},
		            {false, false, false, false, true, true},
		            {false, false, false, false, true, true},
		            {false, false, false, false, true, true},
		            {false, false, false, false, true, true},
		            {false, false, false, false, true, true},
		            {false, false, false, false, true, true},
		            {false, false, false, false, true, true},
		            {false, true, true, false, true, true}});
            Tuple2<int[][], boolean[][]> modelOuter = new Tuple2<int[][], boolean[][]>(new int[][] {{0, 15, 4, 4, 16, 16},
                {4, 14, 7, 7, 15, 16},
                {7, 13, 9, 9, 14, 16},
                {9, 12, 10, 10, 13, 16},
                {10, 11, 11, 11, 12, 16},
                {11, 10, 12, 12, 11, 16},
                {12, 9, 13, 13, 10, 16},
                {13, 7, 14, 14, 9, 16},
                {14, 4, 15, 15, 7, 16},
                {4, 15, 0, 16, 16, 4},
                {7, 14, 4, 16, 15, 7},
                {9, 13, 7, 16, 14, 9},
                {10, 12, 9, 16, 13, 10},
                {11, 11, 10, 16, 12, 11},
                {12, 10, 11, 16, 11, 12},
                {13, 9, 12, 16, 10, 13},
                {14, 7, 13, 16, 9, 14},
                {15, 4, 14, 16, 7, 15},
                {0, 15, 0, 4, 16, 4},
                {4, 14, 4, 7, 15, 7},
                {7, 13, 7, 9, 14, 9},
                {9, 12, 9, 10, 13, 10},
                {10, 11, 10, 11, 12, 11},
                {11, 10, 11, 12, 11, 12},
                {12, 9, 12, 13, 10, 13},
                {13, 7, 13, 14, 9, 14},
                {14, 4, 14, 15, 7, 15},
                {15, 0, 15, 16, 4, 16},
                {4, 15, 4, 16, 16, 16},
                {7, 14, 7, 16, 15, 16},
                {9, 13, 9, 16, 14, 16},
                {10, 12, 10, 16, 13, 16},
                {11, 11, 11, 16, 12, 16},
                {12, 10, 12, 16, 11, 16},
                {13, 9, 13, 16, 10, 16},
                {14, 7, 14, 16, 9, 16},
                {15, 4, 15, 16, 7, 16}},
        		new boolean[][] {{true, false, true, false, true, true},
        			{true, false, true, false, false, true},
        			{true, false, true, false, false, true},
        			{true, false, true, false, false, true},
        			{true, false, true, false, false, true},
        			{true, false, true, false, false, true},
        			{true, false, true, false, false, true},
        			{true, false, true, false, false, true},
        			{true, false, true, false, false, true},
        			{false, true, false, true, true, true},
        			{false, true, false, true, false, true},
        			{false, true, false, true, false, true},
        			{false, true, false, true, false, true},
        			{false, true, false, true, false, true},
        			{false, true, false, true, false, true},
        			{false, true, false, true, false, true},
        			{false, true, false, true, false, true},
        			{false, true, false, true, false, true},
        			{true, false, false, true, true, true},
        			{true, false, false, true, false, true},
        			{true, false, false, true, false, true},
        			{true, false, false, true, false, true},
        			{true, false, false, true, false, true},
        			{true, false, false, true, false, true},
        			{true, false, false, true, false, true},
        			{true, false, false, true, false, true},
        			{true, false, false, true, false, true},
        			{true, true, true, true, false, true},
        			{false, true, true, false, true, false},
        			{false, true, true, false, false, false},
        			{false, true, true, false, false, false},
        			{false, true, true, false, false, false},
        			{false, true, true, false, false, false},
        			{false, true, true, false, false, false},
        			{false, true, true, false, false, false},
        			{false, true, true, false, false, false},
        			{false, true, true, false, false, false}});
            switch (state.get(StairsBlock.SHAPE)) {
                case STRAIGHT:
                    switch (state.get(StairsBlock.HALF)) {
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                            case WEST:
                                modelStraight = ModelCuboidsHelper.mirrorX(ModelCuboidsHelper.flipXZ(modelStraight));
                                break;
                            case NORTH:
                                modelStraight = ModelCuboidsHelper.mirrorZ(modelStraight);
                            	break;
                            case EAST:
                                modelStraight = ModelCuboidsHelper.flipXZ(modelStraight);
                                break;
							default:
								break;
                            }
                            break;
                        case BOTTOM:
                            modelStraight = ModelCuboidsHelper.mirrorY(modelStraight);
                            switch (state.get(StairsBlock.FACING)) {
                            case WEST:
                                modelStraight = ModelCuboidsHelper.mirrorX(ModelCuboidsHelper.flipXZ(modelStraight));
                                break;
                            case NORTH:
                                modelStraight = ModelCuboidsHelper.mirrorZ(modelStraight);
                            	break;
                            case EAST:
                                modelStraight = ModelCuboidsHelper.flipXZ(modelStraight);
                                break;
							default:
								break;
                            }
                            break;
                    }
                    int[][] listOfCuboids = modelStraight.getA();
                    boolean[][] listOfFaces = modelStraight.getB();
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex,       listOfFaces[0][0], listOfFaces[0][1], listOfFaces[0][2], listOfFaces[0][3], listOfFaces[0][4], listOfFaces[0][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex,       listOfFaces[1][0], listOfFaces[1][1], listOfFaces[1][2], listOfFaces[1][3], listOfFaces[1][4], listOfFaces[1][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex,       listOfFaces[2][0], listOfFaces[2][1], listOfFaces[2][2], listOfFaces[2][3], listOfFaces[2][4], listOfFaces[2][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex,       listOfFaces[3][0], listOfFaces[3][1], listOfFaces[3][2], listOfFaces[3][3], listOfFaces[3][4], listOfFaces[3][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex,       listOfFaces[4][0], listOfFaces[4][1], listOfFaces[4][2], listOfFaces[4][3], listOfFaces[4][4], listOfFaces[4][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex,       listOfFaces[5][0], listOfFaces[5][1], listOfFaces[5][2], listOfFaces[5][3], listOfFaces[5][4], listOfFaces[5][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex,       listOfFaces[6][0], listOfFaces[6][1], listOfFaces[6][2], listOfFaces[6][3], listOfFaces[6][4], listOfFaces[6][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex,       listOfFaces[7][0], listOfFaces[7][1], listOfFaces[7][2], listOfFaces[7][3], listOfFaces[7][4], listOfFaces[7][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex,       listOfFaces[8][0], listOfFaces[8][1], listOfFaces[8][2], listOfFaces[8][3], listOfFaces[8][4], listOfFaces[8][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex,       listOfFaces[9][0], listOfFaces[9][1], listOfFaces[9][2], listOfFaces[9][3], listOfFaces[9][4], listOfFaces[9][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, listOfFaces[10][0], listOfFaces[10][1], listOfFaces[10][2], listOfFaces[10][3], listOfFaces[10][4], listOfFaces[10][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, listOfFaces[11][0], listOfFaces[11][1], listOfFaces[11][2], listOfFaces[11][3], listOfFaces[11][4], listOfFaces[11][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, listOfFaces[12][0], listOfFaces[12][1], listOfFaces[12][2], listOfFaces[12][3], listOfFaces[12][4], listOfFaces[12][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, listOfFaces[13][0], listOfFaces[13][1], listOfFaces[13][2], listOfFaces[13][3], listOfFaces[13][4], listOfFaces[13][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, listOfFaces[14][0], listOfFaces[14][1], listOfFaces[14][2], listOfFaces[14][3], listOfFaces[14][4], listOfFaces[14][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, listOfFaces[15][0], listOfFaces[15][1], listOfFaces[15][2], listOfFaces[15][3], listOfFaces[15][4], listOfFaces[15][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, listOfFaces[16][0], listOfFaces[16][1], listOfFaces[16][2], listOfFaces[16][3], listOfFaces[16][4], listOfFaces[16][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[17][0], listOfCuboids[17][3], listOfCuboids[17][1], listOfCuboids[17][4], listOfCuboids[17][2], listOfCuboids[17][5], texture, tintIndex, listOfFaces[17][0], listOfFaces[17][1], listOfFaces[17][2], listOfFaces[17][3], listOfFaces[17][4], listOfFaces[17][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[18][0], listOfCuboids[18][3], listOfCuboids[18][1], listOfCuboids[18][4], listOfCuboids[18][2], listOfCuboids[18][5], texture, tintIndex, listOfFaces[18][0], listOfFaces[18][1], listOfFaces[18][2], listOfFaces[18][3], listOfFaces[18][4], listOfFaces[18][5]));
                    break;
                case INNER_RIGHT:
                    switch (state.get(StairsBlock.HALF)) {
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                            case NORTH:
                            	modelInner = ModelCuboidsHelper.mirrorZ(modelInner);
                                break;
                            case SOUTH:
                            	modelInner = ModelCuboidsHelper.mirrorX(modelInner);
                                break;
                            case WEST:
                            	modelInner = ModelCuboidsHelper.mirrorZ(ModelCuboidsHelper.mirrorX(modelInner));
                                break;
							default:
								break;
                            }
                            break;
                        case BOTTOM:
                        	modelInner = ModelCuboidsHelper.mirrorY(modelInner);
                            switch (state.get(StairsBlock.FACING)) {
                            case NORTH:
                            	modelInner = ModelCuboidsHelper.mirrorZ(modelInner);
                                break;
                            case SOUTH:
                            	modelInner = ModelCuboidsHelper.mirrorX(modelInner);
                                break;
                            case WEST:
                            	modelInner = ModelCuboidsHelper.mirrorZ(ModelCuboidsHelper.mirrorX(modelInner));
                                break;
							default:
								break;
                            }
                            break;
                    }
                    listOfCuboids = modelInner.getA();
                    listOfFaces = modelInner.getB();
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, listOfFaces[0][0], listOfFaces[0][1], listOfFaces[0][2], listOfFaces[0][3], listOfFaces[0][4], listOfFaces[0][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, listOfFaces[1][0], listOfFaces[1][1], listOfFaces[1][2], listOfFaces[1][3], listOfFaces[1][4], listOfFaces[1][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, listOfFaces[2][0], listOfFaces[2][1], listOfFaces[2][2], listOfFaces[2][3], listOfFaces[2][4], listOfFaces[2][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, listOfFaces[3][0], listOfFaces[3][1], listOfFaces[3][2], listOfFaces[3][3], listOfFaces[3][4], listOfFaces[3][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, listOfFaces[4][0], listOfFaces[4][1], listOfFaces[4][2], listOfFaces[4][3], listOfFaces[4][4], listOfFaces[4][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, listOfFaces[5][0], listOfFaces[5][1], listOfFaces[5][2], listOfFaces[5][3], listOfFaces[5][4], listOfFaces[5][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, listOfFaces[6][0], listOfFaces[6][1], listOfFaces[6][2], listOfFaces[6][3], listOfFaces[6][4], listOfFaces[6][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, listOfFaces[7][0], listOfFaces[7][1], listOfFaces[7][2], listOfFaces[7][3], listOfFaces[7][4], listOfFaces[7][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, listOfFaces[8][0], listOfFaces[8][1], listOfFaces[8][2], listOfFaces[8][3], listOfFaces[8][4], listOfFaces[8][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, listOfFaces[9][0], listOfFaces[9][1], listOfFaces[9][2], listOfFaces[9][3], listOfFaces[9][4], listOfFaces[9][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, listOfFaces[10][0], listOfFaces[10][1], listOfFaces[10][2], listOfFaces[10][3], listOfFaces[10][4], listOfFaces[10][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, listOfFaces[11][0], listOfFaces[11][1], listOfFaces[11][2], listOfFaces[11][3], listOfFaces[11][4], listOfFaces[11][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, listOfFaces[12][0], listOfFaces[12][1], listOfFaces[12][2], listOfFaces[12][3], listOfFaces[12][4], listOfFaces[12][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, listOfFaces[13][0], listOfFaces[13][1], listOfFaces[13][2], listOfFaces[13][3], listOfFaces[13][4], listOfFaces[13][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, listOfFaces[14][0], listOfFaces[14][1], listOfFaces[14][2], listOfFaces[14][3], listOfFaces[14][4], listOfFaces[14][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, listOfFaces[15][0], listOfFaces[15][1], listOfFaces[15][2], listOfFaces[15][3], listOfFaces[15][4], listOfFaces[15][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, listOfFaces[16][0], listOfFaces[16][1], listOfFaces[16][2], listOfFaces[16][3], listOfFaces[16][4], listOfFaces[16][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[17][0], listOfCuboids[17][3], listOfCuboids[17][1], listOfCuboids[17][4], listOfCuboids[17][2], listOfCuboids[17][5], texture, tintIndex, listOfFaces[17][0], listOfFaces[17][1], listOfFaces[17][2], listOfFaces[17][3], listOfFaces[17][4], listOfFaces[17][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[18][0], listOfCuboids[18][3], listOfCuboids[18][1], listOfCuboids[18][4], listOfCuboids[18][2], listOfCuboids[18][5], texture, tintIndex, listOfFaces[18][0], listOfFaces[18][1], listOfFaces[18][2], listOfFaces[18][3], listOfFaces[18][4], listOfFaces[18][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[19][0], listOfCuboids[19][3], listOfCuboids[19][1], listOfCuboids[19][4], listOfCuboids[19][2], listOfCuboids[19][5], texture, tintIndex, listOfFaces[19][0], listOfFaces[19][1], listOfFaces[19][2], listOfFaces[19][3], listOfFaces[19][4], listOfFaces[19][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[20][0], listOfCuboids[20][3], listOfCuboids[20][1], listOfCuboids[20][4], listOfCuboids[20][2], listOfCuboids[20][5], texture, tintIndex, listOfFaces[20][0], listOfFaces[20][1], listOfFaces[20][2], listOfFaces[20][3], listOfFaces[20][4], listOfFaces[20][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[21][0], listOfCuboids[21][3], listOfCuboids[21][1], listOfCuboids[21][4], listOfCuboids[21][2], listOfCuboids[21][5], texture, tintIndex, listOfFaces[21][0], listOfFaces[21][1], listOfFaces[21][2], listOfFaces[21][3], listOfFaces[21][4], listOfFaces[21][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[22][0], listOfCuboids[22][3], listOfCuboids[22][1], listOfCuboids[22][4], listOfCuboids[22][2], listOfCuboids[22][5], texture, tintIndex, listOfFaces[22][0], listOfFaces[22][1], listOfFaces[22][2], listOfFaces[22][3], listOfFaces[22][4], listOfFaces[22][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[23][0], listOfCuboids[23][3], listOfCuboids[23][1], listOfCuboids[23][4], listOfCuboids[23][2], listOfCuboids[23][5], texture, tintIndex, listOfFaces[23][0], listOfFaces[23][1], listOfFaces[23][2], listOfFaces[23][3], listOfFaces[23][4], listOfFaces[23][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[24][0], listOfCuboids[24][3], listOfCuboids[24][1], listOfCuboids[24][4], listOfCuboids[24][2], listOfCuboids[24][5], texture, tintIndex, listOfFaces[24][0], listOfFaces[24][1], listOfFaces[24][2], listOfFaces[24][3], listOfFaces[24][4], listOfFaces[24][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[25][0], listOfCuboids[25][3], listOfCuboids[25][1], listOfCuboids[25][4], listOfCuboids[25][2], listOfCuboids[25][5], texture, tintIndex, listOfFaces[25][0], listOfFaces[25][1], listOfFaces[25][2], listOfFaces[25][3], listOfFaces[25][4], listOfFaces[25][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[26][0], listOfCuboids[26][3], listOfCuboids[26][1], listOfCuboids[26][4], listOfCuboids[26][2], listOfCuboids[26][5], texture, tintIndex, listOfFaces[26][0], listOfFaces[26][1], listOfFaces[26][2], listOfFaces[26][3], listOfFaces[26][4], listOfFaces[26][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[27][0], listOfCuboids[27][3], listOfCuboids[27][1], listOfCuboids[27][4], listOfCuboids[27][2], listOfCuboids[27][5], texture, tintIndex, listOfFaces[27][0], listOfFaces[27][1], listOfFaces[27][2], listOfFaces[27][3], listOfFaces[27][4], listOfFaces[27][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[28][0], listOfCuboids[28][3], listOfCuboids[28][1], listOfCuboids[28][4], listOfCuboids[28][2], listOfCuboids[28][5], texture, tintIndex, listOfFaces[28][0], listOfFaces[28][1], listOfFaces[28][2], listOfFaces[28][3], listOfFaces[28][4], listOfFaces[28][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[29][0], listOfCuboids[29][3], listOfCuboids[29][1], listOfCuboids[29][4], listOfCuboids[29][2], listOfCuboids[29][5], texture, tintIndex, listOfFaces[29][0], listOfFaces[29][1], listOfFaces[29][2], listOfFaces[29][3], listOfFaces[29][4], listOfFaces[29][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[30][0], listOfCuboids[30][3], listOfCuboids[30][1], listOfCuboids[30][4], listOfCuboids[30][2], listOfCuboids[30][5], texture, tintIndex, listOfFaces[30][0], listOfFaces[30][1], listOfFaces[30][2], listOfFaces[30][3], listOfFaces[30][4], listOfFaces[30][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[31][0], listOfCuboids[31][3], listOfCuboids[31][1], listOfCuboids[31][4], listOfCuboids[31][2], listOfCuboids[31][5], texture, tintIndex, listOfFaces[31][0], listOfFaces[31][1], listOfFaces[31][2], listOfFaces[31][3], listOfFaces[31][4], listOfFaces[31][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[32][0], listOfCuboids[32][3], listOfCuboids[32][1], listOfCuboids[32][4], listOfCuboids[32][2], listOfCuboids[32][5], texture, tintIndex, listOfFaces[32][0], listOfFaces[32][1], listOfFaces[32][2], listOfFaces[32][3], listOfFaces[32][4], listOfFaces[32][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[33][0], listOfCuboids[33][3], listOfCuboids[33][1], listOfCuboids[33][4], listOfCuboids[33][2], listOfCuboids[33][5], texture, tintIndex, listOfFaces[33][0], listOfFaces[33][1], listOfFaces[33][2], listOfFaces[33][3], listOfFaces[33][4], listOfFaces[33][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[34][0], listOfCuboids[34][3], listOfCuboids[34][1], listOfCuboids[34][4], listOfCuboids[34][2], listOfCuboids[34][5], texture, tintIndex, listOfFaces[34][0], listOfFaces[34][1], listOfFaces[34][2], listOfFaces[34][3], listOfFaces[34][4], listOfFaces[34][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[35][0], listOfCuboids[35][3], listOfCuboids[35][1], listOfCuboids[35][4], listOfCuboids[35][2], listOfCuboids[35][5], texture, tintIndex, listOfFaces[35][0], listOfFaces[35][1], listOfFaces[35][2], listOfFaces[35][3], listOfFaces[35][4], listOfFaces[35][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[36][0], listOfCuboids[36][3], listOfCuboids[36][1], listOfCuboids[36][4], listOfCuboids[36][2], listOfCuboids[36][5], texture, tintIndex, listOfFaces[36][0], listOfFaces[36][1], listOfFaces[36][2], listOfFaces[36][3], listOfFaces[36][4], listOfFaces[36][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[37][0], listOfCuboids[37][3], listOfCuboids[37][1], listOfCuboids[37][4], listOfCuboids[37][2], listOfCuboids[37][5], texture, tintIndex, listOfFaces[37][0], listOfFaces[37][1], listOfFaces[37][2], listOfFaces[37][3], listOfFaces[37][4], listOfFaces[37][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[38][0], listOfCuboids[38][3], listOfCuboids[38][1], listOfCuboids[38][4], listOfCuboids[38][2], listOfCuboids[38][5], texture, tintIndex, listOfFaces[38][0], listOfFaces[38][1], listOfFaces[38][2], listOfFaces[38][3], listOfFaces[38][4], listOfFaces[38][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[39][0], listOfCuboids[39][3], listOfCuboids[39][1], listOfCuboids[39][4], listOfCuboids[39][2], listOfCuboids[39][5], texture, tintIndex, listOfFaces[39][0], listOfFaces[39][1], listOfFaces[39][2], listOfFaces[39][3], listOfFaces[39][4], listOfFaces[39][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[40][0], listOfCuboids[40][3], listOfCuboids[40][1], listOfCuboids[40][4], listOfCuboids[40][2], listOfCuboids[40][5], texture, tintIndex, listOfFaces[40][0], listOfFaces[40][1], listOfFaces[40][2], listOfFaces[40][3], listOfFaces[40][4], listOfFaces[40][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[41][0], listOfCuboids[41][3], listOfCuboids[41][1], listOfCuboids[41][4], listOfCuboids[41][2], listOfCuboids[41][5], texture, tintIndex, listOfFaces[41][0], listOfFaces[41][1], listOfFaces[41][2], listOfFaces[41][3], listOfFaces[41][4], listOfFaces[41][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[42][0], listOfCuboids[42][3], listOfCuboids[42][1], listOfCuboids[42][4], listOfCuboids[42][2], listOfCuboids[42][5], texture, tintIndex, listOfFaces[42][0], listOfFaces[42][1], listOfFaces[42][2], listOfFaces[42][3], listOfFaces[42][4], listOfFaces[42][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[43][0], listOfCuboids[43][3], listOfCuboids[43][1], listOfCuboids[43][4], listOfCuboids[43][2], listOfCuboids[43][5], texture, tintIndex, listOfFaces[43][0], listOfFaces[43][1], listOfFaces[43][2], listOfFaces[43][3], listOfFaces[43][4], listOfFaces[43][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[44][0], listOfCuboids[44][3], listOfCuboids[44][1], listOfCuboids[44][4], listOfCuboids[44][2], listOfCuboids[44][5], texture, tintIndex, listOfFaces[44][0], listOfFaces[44][1], listOfFaces[44][2], listOfFaces[44][3], listOfFaces[44][4], listOfFaces[44][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[45][0], listOfCuboids[45][3], listOfCuboids[45][1], listOfCuboids[45][4], listOfCuboids[45][2], listOfCuboids[45][5], texture, tintIndex, listOfFaces[45][0], listOfFaces[45][1], listOfFaces[45][2], listOfFaces[45][3], listOfFaces[45][4], listOfFaces[45][5]));      
                    break;
                case INNER_LEFT:
                	modelInner = ModelCuboidsHelper.mirrorX(modelInner);
                    switch (state.get(StairsBlock.HALF)) {
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                            case NORTH:
                            	modelInner = ModelCuboidsHelper.mirrorZ(modelInner);
                                break;
                            case SOUTH:
                            	modelInner = ModelCuboidsHelper.mirrorX(modelInner);
                                break;
                            case EAST:
                            	modelInner = ModelCuboidsHelper.mirrorZ(ModelCuboidsHelper.mirrorX(modelInner));
                                break;
							default:
								break;
                            }
                            break;
                        case BOTTOM:
                        	modelInner = ModelCuboidsHelper.mirrorY(modelInner);
                            switch (state.get(StairsBlock.FACING)) {
                            case NORTH:
                            	modelInner = ModelCuboidsHelper.mirrorZ(modelInner);
                                break;
                            case SOUTH:
                            	modelInner = ModelCuboidsHelper.mirrorX(modelInner);
                                break;
                            case EAST:
                            	modelInner = ModelCuboidsHelper.mirrorZ(ModelCuboidsHelper.mirrorX(modelInner));
                                break;
							default:
								break;
                            }
                            break;
                    }
                    listOfCuboids = modelInner.getA();
                    listOfFaces = modelInner.getB();
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, listOfFaces[0][0], listOfFaces[0][1], listOfFaces[0][2], listOfFaces[0][3], listOfFaces[0][4], listOfFaces[0][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, listOfFaces[1][0], listOfFaces[1][1], listOfFaces[1][2], listOfFaces[1][3], listOfFaces[1][4], listOfFaces[1][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, listOfFaces[2][0], listOfFaces[2][1], listOfFaces[2][2], listOfFaces[2][3], listOfFaces[2][4], listOfFaces[2][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, listOfFaces[3][0], listOfFaces[3][1], listOfFaces[3][2], listOfFaces[3][3], listOfFaces[3][4], listOfFaces[3][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, listOfFaces[4][0], listOfFaces[4][1], listOfFaces[4][2], listOfFaces[4][3], listOfFaces[4][4], listOfFaces[4][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, listOfFaces[5][0], listOfFaces[5][1], listOfFaces[5][2], listOfFaces[5][3], listOfFaces[5][4], listOfFaces[5][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, listOfFaces[6][0], listOfFaces[6][1], listOfFaces[6][2], listOfFaces[6][3], listOfFaces[6][4], listOfFaces[6][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, listOfFaces[7][0], listOfFaces[7][1], listOfFaces[7][2], listOfFaces[7][3], listOfFaces[7][4], listOfFaces[7][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, listOfFaces[8][0], listOfFaces[8][1], listOfFaces[8][2], listOfFaces[8][3], listOfFaces[8][4], listOfFaces[8][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, listOfFaces[9][0], listOfFaces[9][1], listOfFaces[9][2], listOfFaces[9][3], listOfFaces[9][4], listOfFaces[9][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, listOfFaces[10][0], listOfFaces[10][1], listOfFaces[10][2], listOfFaces[10][3], listOfFaces[10][4], listOfFaces[10][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, listOfFaces[11][0], listOfFaces[11][1], listOfFaces[11][2], listOfFaces[11][3], listOfFaces[11][4], listOfFaces[11][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, listOfFaces[12][0], listOfFaces[12][1], listOfFaces[12][2], listOfFaces[12][3], listOfFaces[12][4], listOfFaces[12][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, listOfFaces[13][0], listOfFaces[13][1], listOfFaces[13][2], listOfFaces[13][3], listOfFaces[13][4], listOfFaces[13][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, listOfFaces[14][0], listOfFaces[14][1], listOfFaces[14][2], listOfFaces[14][3], listOfFaces[14][4], listOfFaces[14][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, listOfFaces[15][0], listOfFaces[15][1], listOfFaces[15][2], listOfFaces[15][3], listOfFaces[15][4], listOfFaces[15][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, listOfFaces[16][0], listOfFaces[16][1], listOfFaces[16][2], listOfFaces[16][3], listOfFaces[16][4], listOfFaces[16][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[17][0], listOfCuboids[17][3], listOfCuboids[17][1], listOfCuboids[17][4], listOfCuboids[17][2], listOfCuboids[17][5], texture, tintIndex, listOfFaces[17][0], listOfFaces[17][1], listOfFaces[17][2], listOfFaces[17][3], listOfFaces[17][4], listOfFaces[17][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[18][0], listOfCuboids[18][3], listOfCuboids[18][1], listOfCuboids[18][4], listOfCuboids[18][2], listOfCuboids[18][5], texture, tintIndex, listOfFaces[18][0], listOfFaces[18][1], listOfFaces[18][2], listOfFaces[18][3], listOfFaces[18][4], listOfFaces[18][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[19][0], listOfCuboids[19][3], listOfCuboids[19][1], listOfCuboids[19][4], listOfCuboids[19][2], listOfCuboids[19][5], texture, tintIndex, listOfFaces[19][0], listOfFaces[19][1], listOfFaces[19][2], listOfFaces[19][3], listOfFaces[19][4], listOfFaces[19][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[20][0], listOfCuboids[20][3], listOfCuboids[20][1], listOfCuboids[20][4], listOfCuboids[20][2], listOfCuboids[20][5], texture, tintIndex, listOfFaces[20][0], listOfFaces[20][1], listOfFaces[20][2], listOfFaces[20][3], listOfFaces[20][4], listOfFaces[20][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[21][0], listOfCuboids[21][3], listOfCuboids[21][1], listOfCuboids[21][4], listOfCuboids[21][2], listOfCuboids[21][5], texture, tintIndex, listOfFaces[21][0], listOfFaces[21][1], listOfFaces[21][2], listOfFaces[21][3], listOfFaces[21][4], listOfFaces[21][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[22][0], listOfCuboids[22][3], listOfCuboids[22][1], listOfCuboids[22][4], listOfCuboids[22][2], listOfCuboids[22][5], texture, tintIndex, listOfFaces[22][0], listOfFaces[22][1], listOfFaces[22][2], listOfFaces[22][3], listOfFaces[22][4], listOfFaces[22][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[23][0], listOfCuboids[23][3], listOfCuboids[23][1], listOfCuboids[23][4], listOfCuboids[23][2], listOfCuboids[23][5], texture, tintIndex, listOfFaces[23][0], listOfFaces[23][1], listOfFaces[23][2], listOfFaces[23][3], listOfFaces[23][4], listOfFaces[23][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[24][0], listOfCuboids[24][3], listOfCuboids[24][1], listOfCuboids[24][4], listOfCuboids[24][2], listOfCuboids[24][5], texture, tintIndex, listOfFaces[24][0], listOfFaces[24][1], listOfFaces[24][2], listOfFaces[24][3], listOfFaces[24][4], listOfFaces[24][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[25][0], listOfCuboids[25][3], listOfCuboids[25][1], listOfCuboids[25][4], listOfCuboids[25][2], listOfCuboids[25][5], texture, tintIndex, listOfFaces[25][0], listOfFaces[25][1], listOfFaces[25][2], listOfFaces[25][3], listOfFaces[25][4], listOfFaces[25][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[26][0], listOfCuboids[26][3], listOfCuboids[26][1], listOfCuboids[26][4], listOfCuboids[26][2], listOfCuboids[26][5], texture, tintIndex, listOfFaces[26][0], listOfFaces[26][1], listOfFaces[26][2], listOfFaces[26][3], listOfFaces[26][4], listOfFaces[26][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[27][0], listOfCuboids[27][3], listOfCuboids[27][1], listOfCuboids[27][4], listOfCuboids[27][2], listOfCuboids[27][5], texture, tintIndex, listOfFaces[27][0], listOfFaces[27][1], listOfFaces[27][2], listOfFaces[27][3], listOfFaces[27][4], listOfFaces[27][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[28][0], listOfCuboids[28][3], listOfCuboids[28][1], listOfCuboids[28][4], listOfCuboids[28][2], listOfCuboids[28][5], texture, tintIndex, listOfFaces[28][0], listOfFaces[28][1], listOfFaces[28][2], listOfFaces[28][3], listOfFaces[28][4], listOfFaces[28][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[29][0], listOfCuboids[29][3], listOfCuboids[29][1], listOfCuboids[29][4], listOfCuboids[29][2], listOfCuboids[29][5], texture, tintIndex, listOfFaces[29][0], listOfFaces[29][1], listOfFaces[29][2], listOfFaces[29][3], listOfFaces[29][4], listOfFaces[29][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[30][0], listOfCuboids[30][3], listOfCuboids[30][1], listOfCuboids[30][4], listOfCuboids[30][2], listOfCuboids[30][5], texture, tintIndex, listOfFaces[30][0], listOfFaces[30][1], listOfFaces[30][2], listOfFaces[30][3], listOfFaces[30][4], listOfFaces[30][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[31][0], listOfCuboids[31][3], listOfCuboids[31][1], listOfCuboids[31][4], listOfCuboids[31][2], listOfCuboids[31][5], texture, tintIndex, listOfFaces[31][0], listOfFaces[31][1], listOfFaces[31][2], listOfFaces[31][3], listOfFaces[31][4], listOfFaces[31][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[32][0], listOfCuboids[32][3], listOfCuboids[32][1], listOfCuboids[32][4], listOfCuboids[32][2], listOfCuboids[32][5], texture, tintIndex, listOfFaces[32][0], listOfFaces[32][1], listOfFaces[32][2], listOfFaces[32][3], listOfFaces[32][4], listOfFaces[32][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[33][0], listOfCuboids[33][3], listOfCuboids[33][1], listOfCuboids[33][4], listOfCuboids[33][2], listOfCuboids[33][5], texture, tintIndex, listOfFaces[33][0], listOfFaces[33][1], listOfFaces[33][2], listOfFaces[33][3], listOfFaces[33][4], listOfFaces[33][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[34][0], listOfCuboids[34][3], listOfCuboids[34][1], listOfCuboids[34][4], listOfCuboids[34][2], listOfCuboids[34][5], texture, tintIndex, listOfFaces[34][0], listOfFaces[34][1], listOfFaces[34][2], listOfFaces[34][3], listOfFaces[34][4], listOfFaces[34][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[35][0], listOfCuboids[35][3], listOfCuboids[35][1], listOfCuboids[35][4], listOfCuboids[35][2], listOfCuboids[35][5], texture, tintIndex, listOfFaces[35][0], listOfFaces[35][1], listOfFaces[35][2], listOfFaces[35][3], listOfFaces[35][4], listOfFaces[35][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[36][0], listOfCuboids[36][3], listOfCuboids[36][1], listOfCuboids[36][4], listOfCuboids[36][2], listOfCuboids[36][5], texture, tintIndex, listOfFaces[36][0], listOfFaces[36][1], listOfFaces[36][2], listOfFaces[36][3], listOfFaces[36][4], listOfFaces[36][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[37][0], listOfCuboids[37][3], listOfCuboids[37][1], listOfCuboids[37][4], listOfCuboids[37][2], listOfCuboids[37][5], texture, tintIndex, listOfFaces[37][0], listOfFaces[37][1], listOfFaces[37][2], listOfFaces[37][3], listOfFaces[37][4], listOfFaces[37][5]));
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[38][0], listOfCuboids[38][3], listOfCuboids[38][1], listOfCuboids[38][4], listOfCuboids[38][2], listOfCuboids[38][5], texture, tintIndex, listOfFaces[38][0], listOfFaces[38][1], listOfFaces[38][2], listOfFaces[38][3], listOfFaces[38][4], listOfFaces[38][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[39][0], listOfCuboids[39][3], listOfCuboids[39][1], listOfCuboids[39][4], listOfCuboids[39][2], listOfCuboids[39][5], texture, tintIndex, listOfFaces[39][0], listOfFaces[39][1], listOfFaces[39][2], listOfFaces[39][3], listOfFaces[39][4], listOfFaces[39][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[40][0], listOfCuboids[40][3], listOfCuboids[40][1], listOfCuboids[40][4], listOfCuboids[40][2], listOfCuboids[40][5], texture, tintIndex, listOfFaces[40][0], listOfFaces[40][1], listOfFaces[40][2], listOfFaces[40][3], listOfFaces[40][4], listOfFaces[40][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[41][0], listOfCuboids[41][3], listOfCuboids[41][1], listOfCuboids[41][4], listOfCuboids[41][2], listOfCuboids[41][5], texture, tintIndex, listOfFaces[41][0], listOfFaces[41][1], listOfFaces[41][2], listOfFaces[41][3], listOfFaces[41][4], listOfFaces[41][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[42][0], listOfCuboids[42][3], listOfCuboids[42][1], listOfCuboids[42][4], listOfCuboids[42][2], listOfCuboids[42][5], texture, tintIndex, listOfFaces[42][0], listOfFaces[42][1], listOfFaces[42][2], listOfFaces[42][3], listOfFaces[42][4], listOfFaces[42][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[43][0], listOfCuboids[43][3], listOfCuboids[43][1], listOfCuboids[43][4], listOfCuboids[43][2], listOfCuboids[43][5], texture, tintIndex, listOfFaces[43][0], listOfFaces[43][1], listOfFaces[43][2], listOfFaces[43][3], listOfFaces[43][4], listOfFaces[43][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[44][0], listOfCuboids[44][3], listOfCuboids[44][1], listOfCuboids[44][4], listOfCuboids[44][2], listOfCuboids[44][5], texture, tintIndex, listOfFaces[44][0], listOfFaces[44][1], listOfFaces[44][2], listOfFaces[44][3], listOfFaces[44][4], listOfFaces[44][5]));      
                	quads.addAll(ModelHelper.createCuboid16(listOfCuboids[45][0], listOfCuboids[45][3], listOfCuboids[45][1], listOfCuboids[45][4], listOfCuboids[45][2], listOfCuboids[45][5], texture, tintIndex, listOfFaces[45][0], listOfFaces[45][1], listOfFaces[45][2], listOfFaces[45][3], listOfFaces[45][4], listOfFaces[45][5]));      
                    break;
                case OUTER_RIGHT:
                    switch (state.get(StairsBlock.HALF)) {
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                            case NORTH:
                            	modelOuter = ModelCuboidsHelper.mirrorZ(modelOuter);
                                break;
                            case SOUTH:
                            	modelOuter = ModelCuboidsHelper.mirrorX(modelOuter);
                                break;
                            case WEST:
                            	modelOuter = ModelCuboidsHelper.mirrorZ(ModelCuboidsHelper.mirrorX(modelOuter));
                                break;
							default:
								break;
                            }
                            break;
                        case BOTTOM:
                        	modelOuter = ModelCuboidsHelper.mirrorY(modelOuter);
                            switch (state.get(StairsBlock.FACING)) {
                            case NORTH:
                            	modelOuter = ModelCuboidsHelper.mirrorZ(modelOuter);
                                break;
                            case SOUTH:
                            	modelOuter = ModelCuboidsHelper.mirrorX(modelOuter);
                                break;
                            case WEST:
                            	modelOuter = ModelCuboidsHelper.mirrorZ(ModelCuboidsHelper.mirrorX(modelOuter));
                                break;
							default:
								break;
                            }
                            break;
                    }
                    listOfCuboids = modelOuter.getA();
                    listOfFaces = modelOuter.getB();
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, listOfFaces[0][0], listOfFaces[0][1], listOfFaces[0][2], listOfFaces[0][3], listOfFaces[0][4], listOfFaces[0][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, listOfFaces[1][0], listOfFaces[1][1], listOfFaces[1][2], listOfFaces[1][3], listOfFaces[1][4], listOfFaces[1][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, listOfFaces[2][0], listOfFaces[2][1], listOfFaces[2][2], listOfFaces[2][3], listOfFaces[2][4], listOfFaces[2][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, listOfFaces[3][0], listOfFaces[3][1], listOfFaces[3][2], listOfFaces[3][3], listOfFaces[3][4], listOfFaces[3][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, listOfFaces[4][0], listOfFaces[4][1], listOfFaces[4][2], listOfFaces[4][3], listOfFaces[4][4], listOfFaces[4][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, listOfFaces[5][0], listOfFaces[5][1], listOfFaces[5][2], listOfFaces[5][3], listOfFaces[5][4], listOfFaces[5][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, listOfFaces[6][0], listOfFaces[6][1], listOfFaces[6][2], listOfFaces[6][3], listOfFaces[6][4], listOfFaces[6][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, listOfFaces[7][0], listOfFaces[7][1], listOfFaces[7][2], listOfFaces[7][3], listOfFaces[7][4], listOfFaces[7][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, listOfFaces[8][0], listOfFaces[8][1], listOfFaces[8][2], listOfFaces[8][3], listOfFaces[8][4], listOfFaces[8][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, listOfFaces[9][0], listOfFaces[9][1], listOfFaces[9][2], listOfFaces[9][3], listOfFaces[9][4], listOfFaces[9][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, listOfFaces[10][0], listOfFaces[10][1], listOfFaces[10][2], listOfFaces[10][3], listOfFaces[10][4], listOfFaces[10][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, listOfFaces[11][0], listOfFaces[11][1], listOfFaces[11][2], listOfFaces[11][3], listOfFaces[11][4], listOfFaces[11][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, listOfFaces[12][0], listOfFaces[12][1], listOfFaces[12][2], listOfFaces[12][3], listOfFaces[12][4], listOfFaces[12][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, listOfFaces[13][0], listOfFaces[13][1], listOfFaces[13][2], listOfFaces[13][3], listOfFaces[13][4], listOfFaces[13][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, listOfFaces[14][0], listOfFaces[14][1], listOfFaces[14][2], listOfFaces[14][3], listOfFaces[14][4], listOfFaces[14][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, listOfFaces[15][0], listOfFaces[15][1], listOfFaces[15][2], listOfFaces[15][3], listOfFaces[15][4], listOfFaces[15][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, listOfFaces[16][0], listOfFaces[16][1], listOfFaces[16][2], listOfFaces[16][3], listOfFaces[16][4], listOfFaces[16][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[17][0], listOfCuboids[17][3], listOfCuboids[17][1], listOfCuboids[17][4], listOfCuboids[17][2], listOfCuboids[17][5], texture, tintIndex, listOfFaces[17][0], listOfFaces[17][1], listOfFaces[17][2], listOfFaces[17][3], listOfFaces[17][4], listOfFaces[17][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[18][0], listOfCuboids[18][3], listOfCuboids[18][1], listOfCuboids[18][4], listOfCuboids[18][2], listOfCuboids[18][5], texture, tintIndex, listOfFaces[18][0], listOfFaces[18][1], listOfFaces[18][2], listOfFaces[18][3], listOfFaces[18][4], listOfFaces[18][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[19][0], listOfCuboids[19][3], listOfCuboids[19][1], listOfCuboids[19][4], listOfCuboids[19][2], listOfCuboids[19][5], texture, tintIndex, listOfFaces[19][0], listOfFaces[19][1], listOfFaces[19][2], listOfFaces[19][3], listOfFaces[19][4], listOfFaces[19][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[20][0], listOfCuboids[20][3], listOfCuboids[20][1], listOfCuboids[20][4], listOfCuboids[20][2], listOfCuboids[20][5], texture, tintIndex, listOfFaces[20][0], listOfFaces[20][1], listOfFaces[20][2], listOfFaces[20][3], listOfFaces[20][4], listOfFaces[20][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[21][0], listOfCuboids[21][3], listOfCuboids[21][1], listOfCuboids[21][4], listOfCuboids[21][2], listOfCuboids[21][5], texture, tintIndex, listOfFaces[21][0], listOfFaces[21][1], listOfFaces[21][2], listOfFaces[21][3], listOfFaces[21][4], listOfFaces[21][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[22][0], listOfCuboids[22][3], listOfCuboids[22][1], listOfCuboids[22][4], listOfCuboids[22][2], listOfCuboids[22][5], texture, tintIndex, listOfFaces[22][0], listOfFaces[22][1], listOfFaces[22][2], listOfFaces[22][3], listOfFaces[22][4], listOfFaces[22][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[23][0], listOfCuboids[23][3], listOfCuboids[23][1], listOfCuboids[23][4], listOfCuboids[23][2], listOfCuboids[23][5], texture, tintIndex, listOfFaces[23][0], listOfFaces[23][1], listOfFaces[23][2], listOfFaces[23][3], listOfFaces[23][4], listOfFaces[23][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[24][0], listOfCuboids[24][3], listOfCuboids[24][1], listOfCuboids[24][4], listOfCuboids[24][2], listOfCuboids[24][5], texture, tintIndex, listOfFaces[24][0], listOfFaces[24][1], listOfFaces[24][2], listOfFaces[24][3], listOfFaces[24][4], listOfFaces[24][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[25][0], listOfCuboids[25][3], listOfCuboids[25][1], listOfCuboids[25][4], listOfCuboids[25][2], listOfCuboids[25][5], texture, tintIndex, listOfFaces[25][0], listOfFaces[25][1], listOfFaces[25][2], listOfFaces[25][3], listOfFaces[25][4], listOfFaces[25][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[26][0], listOfCuboids[26][3], listOfCuboids[26][1], listOfCuboids[26][4], listOfCuboids[26][2], listOfCuboids[26][5], texture, tintIndex, listOfFaces[26][0], listOfFaces[26][1], listOfFaces[26][2], listOfFaces[26][3], listOfFaces[26][4], listOfFaces[26][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[27][0], listOfCuboids[27][3], listOfCuboids[27][1], listOfCuboids[27][4], listOfCuboids[27][2], listOfCuboids[27][5], texture, tintIndex, listOfFaces[27][0], listOfFaces[27][1], listOfFaces[27][2], listOfFaces[27][3], listOfFaces[27][4], listOfFaces[27][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[28][0], listOfCuboids[28][3], listOfCuboids[28][1], listOfCuboids[28][4], listOfCuboids[28][2], listOfCuboids[28][5], texture, tintIndex, listOfFaces[28][0], listOfFaces[28][1], listOfFaces[28][2], listOfFaces[28][3], listOfFaces[28][4], listOfFaces[28][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[29][0], listOfCuboids[29][3], listOfCuboids[29][1], listOfCuboids[29][4], listOfCuboids[29][2], listOfCuboids[29][5], texture, tintIndex, listOfFaces[29][0], listOfFaces[29][1], listOfFaces[29][2], listOfFaces[29][3], listOfFaces[29][4], listOfFaces[29][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[30][0], listOfCuboids[30][3], listOfCuboids[30][1], listOfCuboids[30][4], listOfCuboids[30][2], listOfCuboids[30][5], texture, tintIndex, listOfFaces[30][0], listOfFaces[30][1], listOfFaces[30][2], listOfFaces[30][3], listOfFaces[30][4], listOfFaces[30][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[31][0], listOfCuboids[31][3], listOfCuboids[31][1], listOfCuboids[31][4], listOfCuboids[31][2], listOfCuboids[31][5], texture, tintIndex, listOfFaces[31][0], listOfFaces[31][1], listOfFaces[31][2], listOfFaces[31][3], listOfFaces[31][4], listOfFaces[31][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[32][0], listOfCuboids[32][3], listOfCuboids[32][1], listOfCuboids[32][4], listOfCuboids[32][2], listOfCuboids[32][5], texture, tintIndex, listOfFaces[32][0], listOfFaces[32][1], listOfFaces[32][2], listOfFaces[32][3], listOfFaces[32][4], listOfFaces[32][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[33][0], listOfCuboids[33][3], listOfCuboids[33][1], listOfCuboids[33][4], listOfCuboids[33][2], listOfCuboids[33][5], texture, tintIndex, listOfFaces[33][0], listOfFaces[33][1], listOfFaces[33][2], listOfFaces[33][3], listOfFaces[33][4], listOfFaces[33][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[34][0], listOfCuboids[34][3], listOfCuboids[34][1], listOfCuboids[34][4], listOfCuboids[34][2], listOfCuboids[34][5], texture, tintIndex, listOfFaces[34][0], listOfFaces[34][1], listOfFaces[34][2], listOfFaces[34][3], listOfFaces[34][4], listOfFaces[34][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[35][0], listOfCuboids[35][3], listOfCuboids[35][1], listOfCuboids[35][4], listOfCuboids[35][2], listOfCuboids[35][5], texture, tintIndex, listOfFaces[35][0], listOfFaces[35][1], listOfFaces[35][2], listOfFaces[35][3], listOfFaces[35][4], listOfFaces[35][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[36][0], listOfCuboids[36][3], listOfCuboids[36][1], listOfCuboids[36][4], listOfCuboids[36][2], listOfCuboids[36][5], texture, tintIndex, listOfFaces[36][0], listOfFaces[36][1], listOfFaces[36][2], listOfFaces[36][3], listOfFaces[36][4], listOfFaces[36][5]));
                    break;
                case OUTER_LEFT:
                	modelOuter = ModelCuboidsHelper.mirrorX(modelOuter);
                    switch (state.get(StairsBlock.HALF)) {
                        case TOP:
                            switch (state.get(StairsBlock.FACING)) {
                            case NORTH:
                            	modelOuter = ModelCuboidsHelper.mirrorZ(modelOuter);
                                break;
                            case SOUTH:
                            	modelOuter = ModelCuboidsHelper.mirrorX(modelOuter);
                                break;
                            case EAST:
                            	modelOuter = ModelCuboidsHelper.mirrorZ(ModelCuboidsHelper.mirrorX(modelOuter));
                                break;
							default:
								break;
                            }
                            break;
                        case BOTTOM:
                        	modelOuter = ModelCuboidsHelper.mirrorY(modelOuter);
                            switch (state.get(StairsBlock.FACING)) {
                            case NORTH:
                            	modelOuter = ModelCuboidsHelper.mirrorZ(modelOuter);
                                break;
                            case SOUTH:
                            	modelOuter = ModelCuboidsHelper.mirrorX(modelOuter);
                                break;
                            case EAST:
                            	modelOuter = ModelCuboidsHelper.mirrorZ(ModelCuboidsHelper.mirrorX(modelOuter));
                                break;
							default:
								break;
                            }
                            break;
                    }
                    listOfCuboids = modelOuter.getA();
                    listOfFaces = modelOuter.getB();
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[0][0], listOfCuboids[0][3], listOfCuboids[0][1], listOfCuboids[0][4], listOfCuboids[0][2], listOfCuboids[0][5], texture, tintIndex, listOfFaces[0][0], listOfFaces[0][1], listOfFaces[0][2], listOfFaces[0][3], listOfFaces[0][4], listOfFaces[0][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[1][0], listOfCuboids[1][3], listOfCuboids[1][1], listOfCuboids[1][4], listOfCuboids[1][2], listOfCuboids[1][5], texture, tintIndex, listOfFaces[1][0], listOfFaces[1][1], listOfFaces[1][2], listOfFaces[1][3], listOfFaces[1][4], listOfFaces[1][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[2][0], listOfCuboids[2][3], listOfCuboids[2][1], listOfCuboids[2][4], listOfCuboids[2][2], listOfCuboids[2][5], texture, tintIndex, listOfFaces[2][0], listOfFaces[2][1], listOfFaces[2][2], listOfFaces[2][3], listOfFaces[2][4], listOfFaces[2][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[3][0], listOfCuboids[3][3], listOfCuboids[3][1], listOfCuboids[3][4], listOfCuboids[3][2], listOfCuboids[3][5], texture, tintIndex, listOfFaces[3][0], listOfFaces[3][1], listOfFaces[3][2], listOfFaces[3][3], listOfFaces[3][4], listOfFaces[3][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[4][0], listOfCuboids[4][3], listOfCuboids[4][1], listOfCuboids[4][4], listOfCuboids[4][2], listOfCuboids[4][5], texture, tintIndex, listOfFaces[4][0], listOfFaces[4][1], listOfFaces[4][2], listOfFaces[4][3], listOfFaces[4][4], listOfFaces[4][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[5][0], listOfCuboids[5][3], listOfCuboids[5][1], listOfCuboids[5][4], listOfCuboids[5][2], listOfCuboids[5][5], texture, tintIndex, listOfFaces[5][0], listOfFaces[5][1], listOfFaces[5][2], listOfFaces[5][3], listOfFaces[5][4], listOfFaces[5][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[6][0], listOfCuboids[6][3], listOfCuboids[6][1], listOfCuboids[6][4], listOfCuboids[6][2], listOfCuboids[6][5], texture, tintIndex, listOfFaces[6][0], listOfFaces[6][1], listOfFaces[6][2], listOfFaces[6][3], listOfFaces[6][4], listOfFaces[6][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[7][0], listOfCuboids[7][3], listOfCuboids[7][1], listOfCuboids[7][4], listOfCuboids[7][2], listOfCuboids[7][5], texture, tintIndex, listOfFaces[7][0], listOfFaces[7][1], listOfFaces[7][2], listOfFaces[7][3], listOfFaces[7][4], listOfFaces[7][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[8][0], listOfCuboids[8][3], listOfCuboids[8][1], listOfCuboids[8][4], listOfCuboids[8][2], listOfCuboids[8][5], texture, tintIndex, listOfFaces[8][0], listOfFaces[8][1], listOfFaces[8][2], listOfFaces[8][3], listOfFaces[8][4], listOfFaces[8][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[9][0], listOfCuboids[9][3], listOfCuboids[9][1], listOfCuboids[9][4], listOfCuboids[9][2], listOfCuboids[9][5], texture, tintIndex, listOfFaces[9][0], listOfFaces[9][1], listOfFaces[9][2], listOfFaces[9][3], listOfFaces[9][4], listOfFaces[9][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[10][0], listOfCuboids[10][3], listOfCuboids[10][1], listOfCuboids[10][4], listOfCuboids[10][2], listOfCuboids[10][5], texture, tintIndex, listOfFaces[10][0], listOfFaces[10][1], listOfFaces[10][2], listOfFaces[10][3], listOfFaces[10][4], listOfFaces[10][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[11][0], listOfCuboids[11][3], listOfCuboids[11][1], listOfCuboids[11][4], listOfCuboids[11][2], listOfCuboids[11][5], texture, tintIndex, listOfFaces[11][0], listOfFaces[11][1], listOfFaces[11][2], listOfFaces[11][3], listOfFaces[11][4], listOfFaces[11][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[12][0], listOfCuboids[12][3], listOfCuboids[12][1], listOfCuboids[12][4], listOfCuboids[12][2], listOfCuboids[12][5], texture, tintIndex, listOfFaces[12][0], listOfFaces[12][1], listOfFaces[12][2], listOfFaces[12][3], listOfFaces[12][4], listOfFaces[12][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[13][0], listOfCuboids[13][3], listOfCuboids[13][1], listOfCuboids[13][4], listOfCuboids[13][2], listOfCuboids[13][5], texture, tintIndex, listOfFaces[13][0], listOfFaces[13][1], listOfFaces[13][2], listOfFaces[13][3], listOfFaces[13][4], listOfFaces[13][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[14][0], listOfCuboids[14][3], listOfCuboids[14][1], listOfCuboids[14][4], listOfCuboids[14][2], listOfCuboids[14][5], texture, tintIndex, listOfFaces[14][0], listOfFaces[14][1], listOfFaces[14][2], listOfFaces[14][3], listOfFaces[14][4], listOfFaces[14][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[15][0], listOfCuboids[15][3], listOfCuboids[15][1], listOfCuboids[15][4], listOfCuboids[15][2], listOfCuboids[15][5], texture, tintIndex, listOfFaces[15][0], listOfFaces[15][1], listOfFaces[15][2], listOfFaces[15][3], listOfFaces[15][4], listOfFaces[15][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[16][0], listOfCuboids[16][3], listOfCuboids[16][1], listOfCuboids[16][4], listOfCuboids[16][2], listOfCuboids[16][5], texture, tintIndex, listOfFaces[16][0], listOfFaces[16][1], listOfFaces[16][2], listOfFaces[16][3], listOfFaces[16][4], listOfFaces[16][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[17][0], listOfCuboids[17][3], listOfCuboids[17][1], listOfCuboids[17][4], listOfCuboids[17][2], listOfCuboids[17][5], texture, tintIndex, listOfFaces[17][0], listOfFaces[17][1], listOfFaces[17][2], listOfFaces[17][3], listOfFaces[17][4], listOfFaces[17][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[18][0], listOfCuboids[18][3], listOfCuboids[18][1], listOfCuboids[18][4], listOfCuboids[18][2], listOfCuboids[18][5], texture, tintIndex, listOfFaces[18][0], listOfFaces[18][1], listOfFaces[18][2], listOfFaces[18][3], listOfFaces[18][4], listOfFaces[18][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[19][0], listOfCuboids[19][3], listOfCuboids[19][1], listOfCuboids[19][4], listOfCuboids[19][2], listOfCuboids[19][5], texture, tintIndex, listOfFaces[19][0], listOfFaces[19][1], listOfFaces[19][2], listOfFaces[19][3], listOfFaces[19][4], listOfFaces[19][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[20][0], listOfCuboids[20][3], listOfCuboids[20][1], listOfCuboids[20][4], listOfCuboids[20][2], listOfCuboids[20][5], texture, tintIndex, listOfFaces[20][0], listOfFaces[20][1], listOfFaces[20][2], listOfFaces[20][3], listOfFaces[20][4], listOfFaces[20][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[21][0], listOfCuboids[21][3], listOfCuboids[21][1], listOfCuboids[21][4], listOfCuboids[21][2], listOfCuboids[21][5], texture, tintIndex, listOfFaces[21][0], listOfFaces[21][1], listOfFaces[21][2], listOfFaces[21][3], listOfFaces[21][4], listOfFaces[21][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[22][0], listOfCuboids[22][3], listOfCuboids[22][1], listOfCuboids[22][4], listOfCuboids[22][2], listOfCuboids[22][5], texture, tintIndex, listOfFaces[22][0], listOfFaces[22][1], listOfFaces[22][2], listOfFaces[22][3], listOfFaces[22][4], listOfFaces[22][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[23][0], listOfCuboids[23][3], listOfCuboids[23][1], listOfCuboids[23][4], listOfCuboids[23][2], listOfCuboids[23][5], texture, tintIndex, listOfFaces[23][0], listOfFaces[23][1], listOfFaces[23][2], listOfFaces[23][3], listOfFaces[23][4], listOfFaces[23][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[24][0], listOfCuboids[24][3], listOfCuboids[24][1], listOfCuboids[24][4], listOfCuboids[24][2], listOfCuboids[24][5], texture, tintIndex, listOfFaces[24][0], listOfFaces[24][1], listOfFaces[24][2], listOfFaces[24][3], listOfFaces[24][4], listOfFaces[24][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[25][0], listOfCuboids[25][3], listOfCuboids[25][1], listOfCuboids[25][4], listOfCuboids[25][2], listOfCuboids[25][5], texture, tintIndex, listOfFaces[25][0], listOfFaces[25][1], listOfFaces[25][2], listOfFaces[25][3], listOfFaces[25][4], listOfFaces[25][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[26][0], listOfCuboids[26][3], listOfCuboids[26][1], listOfCuboids[26][4], listOfCuboids[26][2], listOfCuboids[26][5], texture, tintIndex, listOfFaces[26][0], listOfFaces[26][1], listOfFaces[26][2], listOfFaces[26][3], listOfFaces[26][4], listOfFaces[26][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[27][0], listOfCuboids[27][3], listOfCuboids[27][1], listOfCuboids[27][4], listOfCuboids[27][2], listOfCuboids[27][5], texture, tintIndex, listOfFaces[27][0], listOfFaces[27][1], listOfFaces[27][2], listOfFaces[27][3], listOfFaces[27][4], listOfFaces[27][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[28][0], listOfCuboids[28][3], listOfCuboids[28][1], listOfCuboids[28][4], listOfCuboids[28][2], listOfCuboids[28][5], texture, tintIndex, listOfFaces[28][0], listOfFaces[28][1], listOfFaces[28][2], listOfFaces[28][3], listOfFaces[28][4], listOfFaces[28][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[29][0], listOfCuboids[29][3], listOfCuboids[29][1], listOfCuboids[29][4], listOfCuboids[29][2], listOfCuboids[29][5], texture, tintIndex, listOfFaces[29][0], listOfFaces[29][1], listOfFaces[29][2], listOfFaces[29][3], listOfFaces[29][4], listOfFaces[29][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[30][0], listOfCuboids[30][3], listOfCuboids[30][1], listOfCuboids[30][4], listOfCuboids[30][2], listOfCuboids[30][5], texture, tintIndex, listOfFaces[30][0], listOfFaces[30][1], listOfFaces[30][2], listOfFaces[30][3], listOfFaces[30][4], listOfFaces[30][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[31][0], listOfCuboids[31][3], listOfCuboids[31][1], listOfCuboids[31][4], listOfCuboids[31][2], listOfCuboids[31][5], texture, tintIndex, listOfFaces[31][0], listOfFaces[31][1], listOfFaces[31][2], listOfFaces[31][3], listOfFaces[31][4], listOfFaces[31][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[32][0], listOfCuboids[32][3], listOfCuboids[32][1], listOfCuboids[32][4], listOfCuboids[32][2], listOfCuboids[32][5], texture, tintIndex, listOfFaces[32][0], listOfFaces[32][1], listOfFaces[32][2], listOfFaces[32][3], listOfFaces[32][4], listOfFaces[32][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[33][0], listOfCuboids[33][3], listOfCuboids[33][1], listOfCuboids[33][4], listOfCuboids[33][2], listOfCuboids[33][5], texture, tintIndex, listOfFaces[33][0], listOfFaces[33][1], listOfFaces[33][2], listOfFaces[33][3], listOfFaces[33][4], listOfFaces[33][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[34][0], listOfCuboids[34][3], listOfCuboids[34][1], listOfCuboids[34][4], listOfCuboids[34][2], listOfCuboids[34][5], texture, tintIndex, listOfFaces[34][0], listOfFaces[34][1], listOfFaces[34][2], listOfFaces[34][3], listOfFaces[34][4], listOfFaces[34][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[35][0], listOfCuboids[35][3], listOfCuboids[35][1], listOfCuboids[35][4], listOfCuboids[35][2], listOfCuboids[35][5], texture, tintIndex, listOfFaces[35][0], listOfFaces[35][1], listOfFaces[35][2], listOfFaces[35][3], listOfFaces[35][4], listOfFaces[35][5]));
                    quads.addAll(ModelHelper.createCuboid16(listOfCuboids[36][0], listOfCuboids[36][3], listOfCuboids[36][1], listOfCuboids[36][4], listOfCuboids[36][2], listOfCuboids[36][5], texture, tintIndex, listOfFaces[36][0], listOfFaces[36][1], listOfFaces[36][2], listOfFaces[36][3], listOfFaces[36][4], listOfFaces[36][5]));
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