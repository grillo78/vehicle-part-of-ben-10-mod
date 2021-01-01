package com.example.examplemod.entities;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.util.VehicleCommonUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            ExampleMod.MOD_ID);

    public static RegistryObject<EntityType<? extends Entity>> MAX_VAN;
    static{
        if(ModList.get().isLoaded("vehicle")) {
            VehicleCommonUtil.registerVehicles();
        }
    }

}
