package pewf.masb.fabric.mixin;

import net.minecraft.world.ItemInstance;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ArmorItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Inventory.class)
public class InventoryMixin {

    @Shadow
    public ItemInstance[] armor;

    /*
     * Replaces the calculations b1.7.3 uses for armor points with the modern one that simply adds up all the protection values
     */
    @Overwrite
    public int getArmorValue() {
        int totalArmorValue = 0;
        for (int i = 0; i < this.armor.length; ++i) {
            if (this.armor[i] != null && this.armor[i].getItem() instanceof ArmorItem) {
                int armorPieceValue = ((ArmorItem)this.armor[i].getItem()).protection;
                totalArmorValue += armorPieceValue;
            }
        }
        return totalArmorValue;
    }
}
