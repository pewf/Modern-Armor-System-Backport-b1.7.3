package pewf.masb.fabric.mixin;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pewf.masb.fabric.EnumArmorMaterial;
import pewf.masb.fabric.MASB;

@Mixin(ArmorItem.class)
public class ArmorItemMixin extends Item {
    @Unique
    public EnumArmorMaterial armorMaterial;
    @Shadow @Final @Mutable
    public int protection;

    public ArmorItemMixin() {
        super(0);
    }

    @Inject(method = "<init>(IIII)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;<init>(I)V", shift = At.Shift.AFTER))
    void ArmorItemHead(int id, int tier, int layer, int slot, CallbackInfo ci) {
        switch (tier) {
            case 0:
                this.armorMaterial = EnumArmorMaterial.CLOTH;
                break;
            case 1:
                if (layer == 1) {
                    this.armorMaterial = EnumArmorMaterial.CHAIN;
                    break;
                }
                this.armorMaterial = EnumArmorMaterial.GOLD;
                break;
            case 2:
                this.armorMaterial = EnumArmorMaterial.IRON;
                break;
            default:
                this.armorMaterial = EnumArmorMaterial.DIAMOND;
                break;
        }
    }

    @Inject(method = "<init>(IIII)V", at = @At("RETURN"))
    void armorItemReturn(int id, int tier, int layer, int slot, CallbackInfo ci) {
        protection = this.armorMaterial.getDamageReductionAmount(slot);
        setDurability(this.armorMaterial.getDurability(slot));
    }
}
