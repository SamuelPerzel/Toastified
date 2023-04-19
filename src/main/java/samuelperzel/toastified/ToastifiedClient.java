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
                        new Identifier("toastified:block/liquified_light_still"),
                        new Identifier("toastified:block/liquified_light_flow"),
                        new Color(255, 246, 186).getRGB() // butter milk yellow
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_LIQUIFIED_LIGHT, ModFluids.FLOWING_LIQUIFIED_LIGHT);
    }
}
