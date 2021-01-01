package com.example.examplemod.util;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entities.MaxVanVehicle;
import com.example.examplemod.entities.ModEntities;
import com.mrcrayfish.vehicle.util.EntityUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

public class VehicleCommonUtil {
    public static void registerVehicles() {
        EntityType type = EntityUtil.buildVehicleType(new ResourceLocation(ExampleMod.MOD_ID,"max_van"), MaxVanVehicle::new, 4.0F, 4.0F, true);
        ModEntities.MAX_VAN = ModEntities.ENTITIES.register("max_van", () -> type);
    }
}
