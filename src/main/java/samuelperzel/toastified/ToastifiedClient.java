package samuelperzel.toastified;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import samuelperzel.toastified.fluid.ModFluids;

import java.awt.Color;

public class ToastifiedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_LIQUIFIED_LIGHT, ModFluids.FLOWING_LIQUIFIED_LIGHT,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        //0xA1FFDF80
                        new Color(255, 223, 128, 100).getRGB()
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIQUIFIED_LIGHT, ModFluids.FLOWING_LIQUIFIED_LIGHT);
    }
}
