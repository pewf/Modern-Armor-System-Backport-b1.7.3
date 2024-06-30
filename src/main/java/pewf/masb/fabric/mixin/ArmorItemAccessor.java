package pewf.masb.fabric.mixin;

import net.minecraft.world.item.ArmorItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ArmorItem.class)
public interface ArmorItemAccessor {
    @Accessor("HEALTH_PER_SLOT")
    static int[] getHealthPerSlot() {
        throw new AssertionError();
    }
}
