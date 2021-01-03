package com.example.examplemod.util;

import com.example.examplemod.entities.ModEntities;
import com.mrcrayfish.vehicle.client.render.Wheel;
import com.mrcrayfish.vehicle.common.Seat;
import com.mrcrayfish.vehicle.common.entity.PartPosition;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.vector.Vector3d;

public class VehicleProperties {

    public static void register(){
        com.mrcrayfish.vehicle.entity.VehicleProperties properties = new com.mrcrayfish.vehicle.entity.VehicleProperties();
        properties.setAxleOffset(1.0F);
        properties.setWheelOffset(4.5F);
        properties.setBodyPosition(new PartPosition(1.3D));
        properties.setFuelPortPosition(new PartPosition(-25.5D, 8.0D, -8.75D, 0.0D, -90.0D, 0.0D, 0.25D));
        properties.setKeyPortPosition(new PartPosition(5,15,23.5, -67.5D, 0.0D, 0.0D, 0.5D));
        properties.setHeldOffset(new Vector3d(0.0D, 3.5D, 0.0D));
        properties.setTowBarPosition(new Vector3d(0.0D, 0.0D, -33.0D));
        properties.setDisplayPosition(new PartPosition(1.0D));
        properties.addWheel(Wheel.Side.LEFT, Wheel.Position.FRONT, 22.0F, 0.0F, 13.5F, 1.5F, 1.9F, 1.9F, true, true);
        properties.addWheel(Wheel.Side.RIGHT, Wheel.Position.FRONT, 22.0F, 0.0F, 13.5F, 1.5F, 1.9F, 1.9F, true, true);
        properties.addWheel(Wheel.Side.LEFT, Wheel.Position.REAR, 22.0F, 0.0F, -65.5F, 1.5F, 1.9F, 1.9F, true, true);
        properties.addWheel(Wheel.Side.RIGHT, Wheel.Position.REAR, 22.0F, 0.0F, -65.5F, 1.5F, 1.9F, 1.9F, true, true);
        properties.setFrontAxelVec(0.0D, 14.5D);
        properties.setRearAxelVec(0.0D, -14.5D);
        properties.addSeat(new Seat(new Vector3d(-17.0D,10.0D, 15.0D), true));
        properties.addSeat(new Seat(new Vector3d(17.0D,10.0D, 15.0D)));
        properties.addSeat(new Seat(new Vector3d(15.0D,10.0D, -3.0D), 180));
        properties.addSeat(new Seat(new Vector3d(15.0D,10.0D, -25.0D)));
        com.mrcrayfish.vehicle.entity.VehicleProperties.setProperties((EntityType) ModEntities.MAX_VAN.get(), properties);
    }
}
