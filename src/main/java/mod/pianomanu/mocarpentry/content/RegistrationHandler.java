package mod.pianomanu.mocarpentry.content;

import mod.pianomanu.blockcarpentry.tileentity.FrameBlockTile;
import mod.pianomanu.mocarpentry.MoCarpentry;
import mod.pianomanu.mocarpentry.content.blocks.PillarFrame;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static mod.pianomanu.blockcarpentry.setup.Registration.FRAMEBLOCK;

/**
 * just some standard registration class
 * @author KiroTheBlueFox
 * @author PianoManu
 * @version 1.1 09/15/20
 */
@EventBusSubscriber(modid = MoCarpentry.MODID, bus=Bus.MOD)
public class RegistrationHandler {

	//TODO do we really need those two subscribe events? I prefer using Deferred Registers
	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> block) {
		block.getRegistry().registerAll(
				//new PillarFrame(AbstractBlock.Properties.from(Registration.FRAMEBLOCK.get())).setRegistryName(loc("pillar_frame"))
		);
	}
	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> item) {
		item.getRegistry().registerAll(
				//new BlockItem(ModBlocks.pillarFrame, new Item.Properties()).setRegistryName(loc("pillar_frame")) //.group(MoCarpentry.MoCarpentryItemGroup.MO_CARPENTRY)
		);
	}
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
        MoCarpentryPacketHandler.registerMessages();
	}

	private static ResourceLocation loc(String name) {
		return new ResourceLocation(MoCarpentry.MODID, name);
	}

	//Trying with deferred registers
	private static final Logger LOGGER = LogManager.getLogger();

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoCarpentry.MODID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoCarpentry.MODID);
	private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MoCarpentry.MODID);

	public static void init() {
		LOGGER.info("Registering blocks from MoCarpentry");
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("Registering items from MoCarpentry");
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info("Registering tiles from MoCarpentry");
		TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final RegistryObject<PillarFrame> PILLAR_FRAME = BLOCKS.register("pillar_frame", () -> new PillarFrame(Block.Properties.from(FRAMEBLOCK.get())));
	public static final RegistryObject<Item> PILLAR_FRAME_ITEM = ITEMS.register("pillar_frame", () -> new BlockItem(PILLAR_FRAME.get(), new Item.Properties().group(MoCarpentry.MoCarpentryItemGroup.MO_CARPENTRY)));
	public static final RegistryObject<TileEntityType<FrameBlockTile>> PILLAR_FRAME_TILE = TILES.register("pillar_frame", () -> TileEntityType.Builder.create(FrameBlockTile::new, PILLAR_FRAME.get()).build(null));

}
//========SOLI DEO GLORIA========//