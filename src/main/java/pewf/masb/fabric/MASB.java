package pewf.masb.fabric;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MASB implements ModInitializer {

    public static Logger LOGGER = LoggerFactory.getLogger("Modern Armor System Backport");

    @Override
    public void onInitialize() {
        LOGGER.info("Mod loaded");
    }
}
