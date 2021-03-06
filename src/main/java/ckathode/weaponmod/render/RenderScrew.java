package ckathode.weaponmod.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import ckathode.weaponmod.WeaponModResources;
import ckathode.weaponmod.entity.projectile.EntityScrew;

public class RenderScrew extends Render
{
	public void renderDynamite(EntityScrew entityarrow, double d, double d1, double d2, float f, float f1)
	{
		bindEntityTexture(entityarrow);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		GL11.glRotatef((entityarrow.prevRotationYaw + (entityarrow.rotationYaw - entityarrow.prevRotationYaw) * f1) - 90F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(entityarrow.prevRotationPitch + (entityarrow.rotationPitch - entityarrow.prevRotationPitch) * f1, 0.0F, 0.0F, 1.0F);
		Tessellator tessellator = Tessellator.instance;
		int i = 0;
		float f2 = 0.0F;
		float f3 = 0.3125F;//(10/32)
		float f4 = (0 + i * 10) / 32F;
		float f5 = (5 + i * 10) / 32F;
		float f6 = 0.0F;
		float f7 = 0.15625F;//(5/32)
		float f8 = (5 + i * 10) / 32F;
		float f9 = (10 + i * 10) / 32F;
		float f10 = 0.05625F;
		GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
		float f11 = -f1;
		if (f11 > 0.0F)
		{
			float f12 = -MathHelper.sin(f11 * 3F) * f11;
			GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
		}
		GL11.glRotatef(45F, 1.0F, 0.0F, 0.0F);//将旋转矩阵与当前矩阵相乘
		GL11.glScalef(f10, f10, f10);//将一般的比例矩阵与当前矩阵相乘
		GL11.glTranslatef(-4F, 0.0F, 0.0F);//将变换矩阵与当前矩阵相乘
		GL11.glNormal3f(f10, 0.0F, 0.0F);//法向量
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-5D, -2D, -2D, f6, f8);//纹理(0,5/32)
		tessellator.addVertexWithUV(-5D, -2D, 2D, f7, f8);//纹理(5/32,5/32)
		tessellator.addVertexWithUV(-5D, 2D, 2D, f7, f9);//纹理(5/32,10/32)
		tessellator.addVertexWithUV(-5D, 2D, -2D, f6, f9);//纹理(0,10/32)
		tessellator.draw();//钉子钝面
		GL11.glNormal3f(-f10, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-5D, 2D, -2D, f6, f8);
		tessellator.addVertexWithUV(-5D, 2D, 2D, f7, f8);
		tessellator.addVertexWithUV(-5D, -2D, 2D, f7, f9);
		tessellator.addVertexWithUV(-5D, -2D, -2D, f6, f9);
		tessellator.draw();
		for (int j = 0; j < 4; j++)
		{
			GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f10);
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-5D, -2D, 0.0D, f2, f4);//纹理(0,0)
			tessellator.addVertexWithUV(5D, -2D, 0.0D, f3, f4);//纹理(10/32,0)
			tessellator.addVertexWithUV(5D, 2D, 0.0D, f3, f5);//纹理(10/32,5/32)
			tessellator.addVertexWithUV(-5D, 2D, 0.0D, f2, f5);//纹理(0,5/32)
			tessellator.draw();//钉子的4个面？
		}
		
		GL11.glDisable(32826 /*GL_RESCALE_NORMAL_EXT*/);
		GL11.glPopMatrix();
	}
	
	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		renderDynamite((EntityScrew) entity, d, d1, d2, f, f1);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return WeaponModResources.Textures.SCREW;
	}
}
