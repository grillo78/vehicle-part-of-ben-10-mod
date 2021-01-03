package com.example.examplemod.util;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.client.entity.MaxVanRenderer;
import com.example.examplemod.entities.ModEntities;
import com.mrcrayfish.vehicle.client.EntityRayTracer;
import com.mrcrayfish.vehicle.client.ISpecialModel;
import com.mrcrayfish.vehicle.client.SpecialModels;
import com.mrcrayfish.vehicle.client.render.RenderEntityVehicle;
import com.mrcrayfish.vehicle.client.render.RenderLandVehicleWrapper;
import com.mrcrayfish.vehicle.client.render.RenderVehicleWrapper;
import com.mrcrayfish.vehicle.client.render.VehicleRenderRegistry;
import com.mrcrayfish.vehicle.entity.VehicleEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class VehicleClientUtil {

    public static void registerRayTraceConstructors() {
        EntityRayTracer.instance().registerTransforms((EntityType<? extends VehicleEntity>) ModEntities.MAX_VAN.get(), (entityRayTracer, transforms, parts) ->
        {
            EntityRayTracer.createTransformListForPart(new ISpecialModel() {
                                                           @Override
                                                           public IBakedModel getModel() {
                                                               return Minecraft.getInstance().getModelManager().getModel(new ResourceLocation(ExampleMod.MOD_ID,
                                                                       "vehicle/max_van_body"));
                                                           }
                                                       }, parts, transforms,
                    EntityRayTracer.MatrixTransformation.createScale(4F),
                    EntityRayTracer.MatrixTransformation.createTranslation(0F, -0.08F, -1F));
            EntityRayTracer.createFuelPartTransforms((EntityType<? extends VehicleEntity>) ModEntities.MAX_VAN.get(), SpecialModels.FUEL_DOOR_CLOSED, parts, transforms);
            EntityRayTracer.createKeyPortTransforms((EntityType<? extends VehicleEntity>) ModEntities.MAX_VAN.get(), parts, transforms);
        });
    }
    public static void registerVehicleRenderers()
    {
        EntityType type = ModEntities.MAX_VAN.get();
        RenderVehicleWrapper wrapper = new RenderLandVehicleWrapper<>(new MaxVanRenderer());
        RenderingRegistry.registerEntityRenderingHandler(type, manager -> new RenderEntityVehicle<>(manager, wrapper));
        VehicleRenderRegistry.registerRenderWrapper(type, wrapper);
    }
}
