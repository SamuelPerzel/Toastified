package samuelperzel.toastified.world.biome;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import samuelperzel.toastified.Toastified;

public class ModBiomes {
    public static final RegistryKey<Biome> CRYSTAl_FIELDS = register("crystal_fields");

    private static RegistryKey<Biome> register(String name)
    {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(Toastified.MOD_ID, name));
    }
}
