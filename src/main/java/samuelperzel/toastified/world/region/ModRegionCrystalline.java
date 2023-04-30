package samuelperzel.toastified.world.region;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import samuelperzel.toastified.world.biome.ModBiomes;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

import terrablender.api.ParameterUtils.*;

public class ModRegionCrystalline extends Region {

    public ModRegionCrystalline(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper)
    {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterPointListBuilder()
                .temperature(Temperature.span(Temperature.WARM, Temperature.HOT))
                .humidity(Humidity.span(Humidity.NEUTRAL, Humidity.HUMID))
                .continentalness(Continentalness.MID_INLAND, Continentalness.FAR_INLAND)
                .erosion(Erosion.EROSION_0)
                .depth(Depth.SURFACE)
                .offset((long) 0)
                .build().forEach(point -> builder.add(point, ModBiomes.CRYSTAl_FIELDS));

        builder.build().forEach(mapper::accept);


    }
}
