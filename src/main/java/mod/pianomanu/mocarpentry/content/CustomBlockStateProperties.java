package mod.pianomanu.mocarpentry.content;

import net.minecraft.state.IntegerProperty;

public class CustomBlockStateProperties {
	public static final IntegerProperty HORIZONTAL_SIDES = IntegerProperty.create("sides", 0, 0b1111);
	public static final IntegerProperty SIDES = IntegerProperty.create("sides", 0, 0b111111);
	public static final IntegerProperty SIDES_NO_TOP = IntegerProperty.create("sides", 0, 0b11111);

}
