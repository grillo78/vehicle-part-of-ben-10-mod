package com.example.examplemod.client.entity;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entities.MaxVanVehicle;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mrcrayfish.vehicle.client.SpecialModels;
import com.mrcrayfish.vehicle.client.render.AbstractRenderVehicle;
import com.mrcrayfish.vehicle.client.render.Axis;
import com.mrcrayfish.vehicle.common.ItemLookup;
import com.mrcrayfish.vehicle.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class MaxVanRenderer extends AbstractRenderVehicle<MaxVanVehicle> {


    @Override
    public void render(MaxVanVehicle maxVanVehicle, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, float partialTicks, int light) {
        renderWheel(maxVanVehicle, matrixStack, iRenderTypeBuffer, true, 1.5F, -0.55F, -5.3F, 1.75F, partialTicks, light);
        renderWheel(maxVanVehicle, matrixStack, iRenderTypeBuffer, false, -1.5F, -0.55F, -5.3F, 1.75F, partialTicks, light);

        matrixStack.push();
        matrixStack.scale(4, 4, 4);
        matrixStack.translate(0, -0.08F, -1);
        this.renderDamagedPart(maxVanVehicle, Minecraft.getInstance().getModelManager().getModel(new ResourceLocation(ExampleMod.MOD_ID, "vehicle/max_van_body")), matrixStack, iRenderTypeBuffer, light);

        matrixStack.pop();
        matrixStack.push();
        matrixStack.translate(1.06D, 0.75D, 1.275D);
        matrixStack.rotate(Axis.POSITIVE_X.rotationDegrees(-67.5F));
        matrixStack.translate(0.0D, 0.025D, 0.0D);
        matrixStack.scale(0.75F, 0.75F, 0.75F);
        float wheelAngle = maxVanVehicle.prevRenderWheelAngle + (maxVanVehicle.renderWheelAngle - maxVanVehicle.prevRenderWheelAngle) * partialTicks;
        float wheelAngleNormal = wheelAngle / 45.0F;
        float turnRotation = wheelAngleNormal * 25.0F;
        matrixStack.rotate(Axis.POSITIVE_Y.rotationDegrees(turnRotation));
        RenderUtil.renderColoredModel(SpecialModels.GO_KART_STEERING_WHEEL.getModel(), ItemCameraTransforms.TransformType.NONE, false, matrixStack, iRenderTypeBuffer, -1, light, OverlayTexture.NO_OVERLAY);
        matrixStack.pop();

    }

    protected void renderWheel(MaxVanVehicle van, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, boolean right, float offsetX, float offsetY, float offsetZ, float wheelScale, float partialTicks, int light) {
        matrixStack.push();
        matrixStack.translate(offsetX, offsetY, offsetZ);
        if (right) {
            matrixStack.rotate(Vector3f.YP.rotationDegrees(180F));
        }
        float wheelRotation = van.prevRearWheelRotation + (van.rearWheelRotation - van.prevRearWheelRotation) * partialTicks;
        matrixStack.rotate(Vector3f.XP.rotationDegrees(right ? wheelRotation : -wheelRotation));
        matrixStack.scale(wheelScale, wheelScale, wheelScale);
        RenderUtil.renderColoredModel(RenderUtil.getModel(ItemLookup.getWheel(van)), ItemCameraTransforms.TransformType.NONE, false, matrixStack, renderTypeBuffer, -1, light, OverlayTexture.NO_OVERLAY);
        matrixStack.pop();
    }
}
