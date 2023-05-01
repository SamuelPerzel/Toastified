package samuelperzel.toastified.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import samuelperzel.toastified.Toastified;

import java.awt.*;

public class ModDimensions {
    public static final RegistryKey<World> LUMEN_DIMENSION_KEY = RegistryKey.of(RegistryKeys.WORLD, new Identifier(Toastified.MOD_ID, "lumen"));
    public static final RegistryKey<DimensionType> LUMEN_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, LUMEN_DIMENSION_KEY.getValue());

    public static void registerPortals() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.GLASS)
                .destDimID(LUMEN_DIMENSION_KEY.getValue())
                .tintColor(255, 231, 173)
                .lightWithItem(Items.AMETHYST_SHARD)
                .onlyLightInOverworld()
                .registerPortal();
    }

    public static void registerDimensions() {
        Toastified.LOGGER.info("Registering mod dimensions for " + Toastified.MOD_ID);

        registerPortals();
    }
}
