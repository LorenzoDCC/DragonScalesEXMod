package cf.adriantodt.mods.DragonScales.common.blocks;

import java.util.List;
import java.util.Random;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import cf.adriantodt.mods.DragonScales.DragonScales;
import cf.adriantodt.mods.DragonScales.Lib;
import cf.adriantodt.mods.DragonScales.common.CauldronAPIHandler;
import cf.adriantodt.mods.DragonScales.common.DragonScalesHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockModCauldron extends Block {
	@SideOnly(Side.CLIENT)
    private IIcon innerIcon;
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon bottomIcon;
    @SideOnly(Side.CLIENT)
    private IIcon essenceLiquid;

    public BlockModCauldron()
    {
        super(Material.iron);
    	//super();
        this.setHardness(2.0F).setBlockName("cauldron").setBlockTextureName("cauldron");
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.topIcon : (side == 0 ? this.bottomIcon : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.innerIcon = iconRegister.registerIcon(this.getTextureName() + "_" + "inner");
        this.topIcon = iconRegister.registerIcon(this.getTextureName() + "_top");
        this.bottomIcon = iconRegister.registerIcon(this.getTextureName() + "_" + "bottom");
        this.blockIcon = iconRegister.registerIcon(this.getTextureName() + "_side");
        this.essenceLiquid = iconRegister.registerIcon(Lib.TEXTURE_PATH + "dragonEssence");
    }

    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    public void addCollisionBoxesToList(World theWorld, int x, int y, int z, AxisAlignedBB mask, List list, Entity collidingEntity)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.addCollisionBoxesToList(theWorld, x, y, z, mask, list, collidingEntity);
        float f = 0.125F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(theWorld, x, y, z, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(theWorld, x, y, z, mask, list, collidingEntity);
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(theWorld, x, y, z, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(theWorld, x, y, z, mask, list, collidingEntity);
        this.setBlockBoundsForItemRender();
    }

    @SideOnly(Side.CLIENT)
    public static IIcon getCauldronIcon(String iconName)
    {
        return
        		iconName.equals("inner") ?
        				((BlockModCauldron) DragonScalesHandler.modCauldron).innerIcon :
        		iconName.equals("bottom") ?
        				((BlockModCauldron) DragonScalesHandler.modCauldron).bottomIcon :
        		iconName.equals("liquid") ?
        	    		((BlockModCauldron) DragonScalesHandler.modCauldron).essenceLiquid :null;
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Items.cauldron;
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Items.cauldron;
    }

    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
    public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_)
    {
        int i1 = p_149736_1_.getBlockMetadata(p_149736_2_, p_149736_3_, p_149736_4_);
        return func_150027_b(i1);
    }

    public static int func_150027_b(int p_150027_0_)
    {
        return p_150027_0_;
    }

    @SideOnly(Side.CLIENT)
    public static float getRenderLiquidLevel(int p_150025_0_)
    {
        int j = MathHelper.clamp_int(p_150025_0_, 0, 3);
        return (float)(6 + 3 * j) / 16.0F;
    }
    
	/**
	 * Overrides for Dragon Essentia
	 */
	public boolean onBlockActivated(World world, int  x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
		return CauldronAPIHandler.performCauldronInteraction(this, world, x, y, z, player, side, hitX, hitY, hitZ);
    }

	
	public static void setMetadataProperly(World theWorld, int x, int y, int z, int meta, Block block)
    {
		if (meta < 1)
		{
			theWorld.setBlock(x, y, z, Blocks.cauldron, 0, 3);
		}
		else
		{
			theWorld.setBlockMetadataWithNotify(x, y, z, MathHelper.clamp_int(meta, 0, 3), 3);
        	theWorld.func_147453_f(x, y, z, block);
		}
    }
	
	public int getRenderType()
	{
		return DragonScales.proxy.getRenderType("modCauldron");
	}
}
