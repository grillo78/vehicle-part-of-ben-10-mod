package com.example.examplemod.entities;

import com.mrcrayfish.vehicle.client.EntityRayTracer;
import com.mrcrayfish.vehicle.client.EntityRayTracer.RayTracePart;
import com.mrcrayfish.vehicle.client.EntityRayTracer.RayTraceResultRotated;
import com.mrcrayfish.vehicle.client.EntityRayTracer.TriangleRayTraceList;
import com.mrcrayfish.vehicle.entity.EngineType;
import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxVanVehicle extends LandVehicleEntity{

    private static RayTracePart CHEST_BOX = new RayTracePart(new AxisAlignedBB(-1.5, 0, -6.2, 1.5, 2, -5.2));
    private static final Map<RayTracePart, TriangleRayTraceList> interactionBoxMapStatic = DistExecutor.callWhenOn(Dist.CLIENT, () -> () ->
    {
        Map<RayTracePart, TriangleRayTraceList> map = new HashMap<>();
        map.put(CHEST_BOX, EntityRayTracer.boxToTriangles(CHEST_BOX.getBox(), null));
        return map;
    });

    public MaxVanVehicle(World worldIn) {
        this(ModEntities.MAX_VAN.get(), worldIn);
    }

    public MaxVanVehicle(EntityType<?> entityType, World worldIn) {
        super(entityType, worldIn);
    }


    @Override
    public void onClientUpdate() {
        super.onClientUpdate();
    }

    @Override
    public boolean canBeColored() {
        return false;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return super.getRenderBoundingBox().grow(5);
    }

    @Override
    public List<RayTracePart> getApplicableInteractionBoxes() {
        ArrayList<RayTracePart> parts = new ArrayList();
        parts.add(CHEST_BOX);
        return parts;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean processHit(RayTraceResultRotated result, boolean rightClick) {
        if (rightClick && result.getPartHit() == CHEST_BOX) {
            //TODO sleep logic
            return true;
        }
        return super.processHit(result, rightClick);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public Map<RayTracePart, TriangleRayTraceList> getStaticInteractionBoxMap()
    {
        return interactionBoxMapStatic;
    }

    @Override
    public SoundEvent getMovingSound() {
        return ModSounds.MINI_BUS_ENGINE_STEREO.get();
    }

    @Override
    public SoundEvent getRidingSound() {
        return ModSounds.MINI_BUS_ENGINE_MONO.get();
    }

    @Override
    public EngineType getEngineType() {
        return EngineType.LARGE_MOTOR;
    }

    @Override
    public FuelPortType getFuelPortType() {
        return FuelPortType.SMALL;
    }


    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compound = new CompoundNBT();
        return compound;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
    }
}
