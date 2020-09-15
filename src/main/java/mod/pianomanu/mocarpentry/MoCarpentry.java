package mod.pianomanu.mocarpentry;

import mod.pianomanu.blockcarpentry.BlockCarpentryMain;
import mod.pianomanu.blockcarpentry.setup.Registration;
import mod.pianomanu.mocarpentry.content.ModBlocks;
import mod.pianomanu.mocarpentry.content.RegistrationHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;

/**
 * Main mod class
 * @author KiroTheBlueFox
 * @author PianoManu
 * @version 1.0 09/14/20
 */
@Mod(MoCarpentry.MODID)
public class MoCarpentry {
    public static final String MODID = "mocarpentry";

    
    public MoCarpentry() {
        RegistrationHandler.init();
    }
    
    public void commonSetup(FMLCommonSetupEvent event) {
    }

    public static class MoCarpentryItemGroup extends ItemGroup {

        public static final MoCarpentry.MoCarpentryItemGroup MO_CARPENTRY = new MoCarpentry.MoCarpentryItemGroup(ItemGroup.GROUPS.length,"mocarpentry");
        private MoCarpentryItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        @Nonnull
        public ItemStack createIcon() {
            return new ItemStack(RegistrationHandler.PILLAR_FRAME_ITEM.get());
        }
    }
}
//========SOLI DEO GLORIA========//