package pewf.masb.fabric;

import net.minecraft.world.item.ArmorItem;
import pewf.masb.fabric.mixin.ArmorItemAccessor;

public enum EnumArmorMaterial {
    CLOTH(5, new int[]{1, 3, 2, 1}),
    CHAIN(15, new int[]{2, 5, 4, 1}),
    IRON(15, new int[]{2, 6, 5, 2}),
    GOLD(7, new int[]{2, 5, 3, 1}),
    DIAMOND(33, new int[]{3, 8, 6, 3});

    private int maxDamageFactor;
    private int[] damageReductionAmountArray;

    EnumArmorMaterial(int var3, int[] var4) {
        this.maxDamageFactor = var3;
        this.damageReductionAmountArray = var4;
    }

    public int getDurability(int var1) {
        return ArmorItemAccessor.getHealthPerSlot()[var1] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(int var1) {
        return damageReductionAmountArray[var1];
    }
}
