package mod.pianomanu.mocarpentry.utils;

import java.util.Arrays;

import net.minecraft.util.Direction.Axis;

public class ModelCuboidsHelper {
	private static int dm = 8;
	
	private static Tuple2<int[][], boolean[][]> mirror(Tuple2<int[][], boolean[][]> tuple, int offset) {
		int[][] cuboidList = tuple.getA();
		boolean[][] faces = tuple.getB();
		if (cuboidList[0].length != 6) {
			System.err.println("Invalid Cuboid List !");
			return tuple;
		}
		int[][] newList = new int[cuboidList.length][6];
		boolean[][] newFaces = new boolean[faces.length][6];
		for (int i = 0; i < cuboidList.length; i++) {
			newList[i] = Arrays.copyOf(cuboidList[i], 6);
			newFaces[i] = Arrays.copyOf(faces[i], 6);
			int value1 = newList[i][offset],
					value2 = newList[i][offset+3],
					distance1 = value1 - dm,
					distance2 = value2 - dm;
	        value1 -= 2*distance1;
	        value2 -= 2*distance2;
	        int tempValue = value1;
	        value1 = value2;
	        value2 = tempValue;
	        newList[i][offset] = value1;
	        newList[i][offset+3] = value2;
	        int boolOffset = offset;
	        if (offset == 1) {
	        	boolOffset = 4;
	        }
	        boolean tempBool = newFaces[i][boolOffset];
	        newFaces[i][boolOffset] = newFaces[i][boolOffset+1];
	        newFaces[i][boolOffset+1] = tempBool;
		}
		return new Tuple2<int[][], boolean[][]>(newList, newFaces);
	}
	
	public static Tuple2<int[][], boolean[][]> mirrorX(Tuple2<int[][], boolean[][]> tuple) {
		return ModelCuboidsHelper.mirror(tuple, 0);
	}
	
	public static Tuple2<int[][], boolean[][]> mirrorY(Tuple2<int[][], boolean[][]> tuple) {
		return ModelCuboidsHelper.mirror(tuple, 1);
	}
	
	public static Tuple2<int[][], boolean[][]> mirrorZ(Tuple2<int[][], boolean[][]> tuple) {
		return ModelCuboidsHelper.mirror(tuple, 2);
	}
	
	public static Tuple2<int[][], boolean[][]> mirror(Tuple2<int[][], boolean[][]> tuple, Axis... allAxis) {
		int[][] cuboidList = tuple.getA();
		boolean[][] faces = tuple.getB();
		for (Axis axis : allAxis) {
			switch (axis) {
			case X:
				cuboidList = ModelCuboidsHelper.mirrorX(tuple).getA();
				faces = ModelCuboidsHelper.mirrorX(tuple).getB();
				break;
			case Y:
				cuboidList = ModelCuboidsHelper.mirrorY(tuple).getA();
				faces = ModelCuboidsHelper.mirrorY(tuple).getB();
				break;
			case Z:
				cuboidList = ModelCuboidsHelper.mirrorZ(tuple).getA();
				faces = ModelCuboidsHelper.mirrorZ(tuple).getB();
				break;
			}
		}
		return new Tuple2<int[][], boolean[][]>(cuboidList, faces);
	}
	
	
	private static Tuple2<int[][], boolean[][]> flip(Tuple2<int[][], boolean[][]> tuple, int offsetA, int offsetB) {
		int[][] cuboidList = tuple.getA();
		boolean[][] faces = tuple.getB();
		if (cuboidList[0].length != 6) {
			System.err.println("Invalid Cuboid List !");
			return tuple;
		}
		int[][] newList = new int[cuboidList.length][6];
		boolean[][] newFaces = new boolean[faces.length][6];
		for (int i = 0; i < cuboidList.length; i++) {
			newList[i] = Arrays.copyOf(cuboidList[i], 6);
			newFaces[i] = Arrays.copyOf(faces[i], 6);
            int valueA1 = newList[i][offsetA],
        			valueA2 = newList[i][offsetA+3],
        			valueB1 = newList[i][offsetB],
        			valueB2 = newList[i][offsetB+3],
        			tempValue1 = valueA1;
            valueA1 = valueB1;
            valueB1 = tempValue1;
            int tempValue2 = valueA2;
            valueA2 = valueB2;
            valueB2 = tempValue2;
            newList[i][offsetA] = valueA1;
            newList[i][offsetA+3] = valueA2;
            newList[i][offsetB] = valueB1;
            newList[i][offsetB+3] = valueB2;
	        int boolOffsetA, boolOffsetB;
	        if (offsetA == 0) {
	        	boolOffsetA = 0;
	        } else if (offsetA == 1) {
	        	boolOffsetA = 4;
	        } else {
	        	boolOffsetA = 2;
	        }
	        if (offsetB == 0) {
	        	boolOffsetB = 0;
	        } else if (offsetB == 1) {
	        	boolOffsetB = 4;
	        } else {
	        	boolOffsetB = 2;
	        }
            boolean tempBool1 = newFaces[i][boolOffsetA+1],
            		tempBool2 = newFaces[i][boolOffsetA];
            newFaces[i][boolOffsetA] = newFaces[i][boolOffsetB+1];
            newFaces[i][boolOffsetA+1] = newFaces[i][boolOffsetB];
            newFaces[i][boolOffsetB] = tempBool1;
            newFaces[i][boolOffsetB+1] = tempBool2;
		}
		return new Tuple2<int[][], boolean[][]>(newList, newFaces);
	}
	
	public static Tuple2<int[][], boolean[][]> flipXY(Tuple2<int[][], boolean[][]> tuple) {
		return ModelCuboidsHelper.flip(tuple, 0, 1);
	}
	
	public static Tuple2<int[][], boolean[][]> flipYZ(Tuple2<int[][], boolean[][]> tuple) {
		return ModelCuboidsHelper.flip(tuple, 1, 2);
	}
	
	public static Tuple2<int[][], boolean[][]> flipXZ(Tuple2<int[][], boolean[][]> tuple) {
		return ModelCuboidsHelper.flip(tuple, 0, 2);
	}
	
	public static Tuple2<int[][], boolean[][]> copyOf(Tuple2<int[][], boolean[][]> tuple) {
		int[][] cuboidList = tuple.getA();
		boolean[][] faces = tuple.getB();
		int[][] newList = new int[cuboidList.length][6];
		boolean[][] newFaces = new boolean[faces.length][6];
		for (int i = 0; i < cuboidList.length; i++) {
			newList[i] = Arrays.copyOf(cuboidList[i], 6);
			newFaces[i] = Arrays.copyOf(faces[i], 6);
		}
		return new Tuple2<int[][], boolean[][]>(newList, newFaces);
	}
}
