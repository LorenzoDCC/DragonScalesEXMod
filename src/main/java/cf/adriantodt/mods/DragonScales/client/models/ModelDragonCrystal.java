package cf.adriantodt.mods.DragonScales.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDragonCrystal extends ModelBase
{
	//fields
		ModelRenderer Shape1;
		ModelRenderer Shape2;
		ModelRenderer Shape3;
		ModelRenderer Shape4;
		ModelRenderer Shape5;
		ModelRenderer Shape6;
		ModelRenderer Shape7;
		ModelRenderer Shape8;
		ModelRenderer Shape9;
		ModelRenderer Shape10;
		ModelRenderer Shape11;
		ModelRenderer Shape12;
		ModelRenderer Shape13;
		ModelRenderer Shape14;
		ModelRenderer Shape15;
		ModelRenderer Shape16;
		ModelRenderer Shape17;
		ModelRenderer Shape18;
		ModelRenderer Shape19;
	
	public ModelDragonCrystal()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		Shape1 = new ModelRenderer(this, 8, 0);
		Shape1.addBox(0F, 0F, 0F, 3, 12, 3);
		Shape1.setRotationPoint(-1F, 12F, -1F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 20, 0);
		Shape2.addBox(0F, 0F, 0F, 3, 1, 2);
		Shape2.setRotationPoint(-1F, 11F, -1F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 30, 0);
		Shape3.addBox(0F, 0F, 0F, 2, 6, 2);
		Shape3.setRotationPoint(0F, 24F, 2F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 2.086546F, 1.264073F, 0.4833219F);
		Shape4 = new ModelRenderer(this, 38, 0);
		Shape4.addBox(0F, 0F, 0F, 2, 4, 2);
		Shape4.setRotationPoint(0F, 22F, 0F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 1.062999F, 3.141593F, 3.141593F);
		Shape5 = new ModelRenderer(this, 38, 0);
		Shape5.addBox(0F, 0F, 0F, 2, 4, 2);
		Shape5.setRotationPoint(0F, 23F, 1F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, -2.320255F, 1.561502F, 0.3346075F);
		Shape6 = new ModelRenderer(this, 30, 0);
		Shape6.addBox(-1F, 0F, 0F, 2, 6, 2);
		Shape6.setRotationPoint(0F, 24F, 1F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 2.289893F, -0.1858931F, 0.4833219F);
		Shape7 = new ModelRenderer(this, 20, 3);
		Shape7.addBox(0F, 0F, 0F, 2, 1, 2);
		Shape7.setRotationPoint(-1F, 10F, -1F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 20, 6);
		Shape8.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape8.setRotationPoint(-1F, 11F, 1F);
		Shape8.setTextureSize(64, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 24, 6);
		Shape9.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape9.setRotationPoint(-1F, 8F, 0F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 20, 3);
		Shape10.addBox(0F, -1F, 0F, 2, 1, 2);
		Shape10.setRotationPoint(0F, 17F, 3F);
		Shape10.setTextureSize(64, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 1.570796F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 20, 3);
		Shape11.addBox(0F, 0F, 0F, 2, 1, 2);
		Shape11.setRotationPoint(2F, 13F, 1F);
		Shape11.setTextureSize(64, 32);
		Shape11.mirror = true;
		setRotation(Shape11, 1.570796F, 1.570796F, 1.570796F);
		Shape12 = new ModelRenderer(this, 20, 3);
		Shape12.addBox(0F, 0F, 0F, 2, 1, 2);
		Shape12.setRotationPoint(-1F, 16F, 0F);
		Shape12.setTextureSize(64, 32);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 1.570796F);
		Shape13 = new ModelRenderer(this, 20, 8);
		Shape13.addBox(0F, 0F, 0F, 1, 3, 1);
		Shape13.setRotationPoint(0F, 16F, 0F);
		Shape13.setTextureSize(64, 32);
		Shape13.mirror = true;
		setRotation(Shape13, 1.062999F, -2.259943F, 3.141593F);
		Shape14 = new ModelRenderer(this, 24, 9);
		Shape14.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape14.setRotationPoint(0F, 19F, 2F);
		Shape14.setTextureSize(64, 32);
		Shape14.mirror = true;
		setRotation(Shape14, 1.062999F, -1.840341F, 3.141593F);
		Shape15 = new ModelRenderer(this, 20, 12);
		Shape15.addBox(0F, 0F, 0F, 1, 3, 1);
		Shape15.setRotationPoint(0F, 20F, 2F);
		Shape15.setTextureSize(64, 32);
		Shape15.mirror = true;
		setRotation(Shape15, 1.062999F, -0.6984415F, 3.141593F);
		Shape16 = new ModelRenderer(this, 24, 14);
		Shape16.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape16.setRotationPoint(2F, 19F, 0F);
		Shape16.setTextureSize(64, 32);
		Shape16.mirror = true;
		setRotation(Shape16, 1.570796F, 0F, 0F);
		Shape17 = new ModelRenderer(this, 20, 3);
		Shape17.addBox(0F, 0F, 0F, 2, 1, 2);
		Shape17.setRotationPoint(-1F, 20F, -2F);
		Shape17.setTextureSize(64, 32);
		Shape17.mirror = true;
		setRotation(Shape17, 1.570796F, 0F, 0F);
		Shape18 = new ModelRenderer(this, 20, 17);
		Shape18.addBox(0F, 0F, 0F, 2, 2, 2);
		Shape18.setRotationPoint(0F, 12F, -2F);
		Shape18.setTextureSize(64, 32);
		Shape18.mirror = true;
		setRotation(Shape18, 0F, 0F, 1.570796F);
		Shape19 = new ModelRenderer(this, 0, 0);
		Shape19.addBox(0F, 0F, 0F, 1, 3, 1);
		Shape19.setRotationPoint(2F, 19F, 0F);
		Shape19.setTextureSize(64, 32);
		Shape19.mirror = true;
		setRotation(Shape19, -0.7587535F, -1.033049F, 3.141593F);
	}	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
		Shape14.render(f5);
		Shape15.render(f5);
		Shape16.render(f5);
		Shape17.render(f5);
		Shape18.render(f5);
		Shape19.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
