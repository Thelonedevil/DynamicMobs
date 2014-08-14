package com.github.thelonedevil.DynamicMobs;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedMob implements IExtendedEntityProperties {
	public final static String EXT_PROP_NAME = Ref.MODID + "ExtendedMob";

	private final Entity Mob;
	private int lvl = 1;
    private int diff = 1;

	public ExtendedMob(Entity mob) {
		this.Mob = mob;
	}

	public static final void register(Entity mob) {
		mob.registerExtendedProperties(ExtendedMob.EXT_PROP_NAME, new ExtendedMob(mob));
	}

	public static final ExtendedMob get(Entity mob) {
		return (ExtendedMob) mob.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("level", lvl);
		compound.setTag(EXT_PROP_NAME, properties);

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.lvl = properties.getInteger("level");

	}

	public void setLevel(int level) {
		this.lvl = level;
	}

	public int getLevel() {
		return this.lvl;
	}

    public void setDifficulty(int diff){ this.diff = diff;}

    public int getDifficulty(){return  this.diff;}

	@Override
	public void init(Entity entity, World world) {
		// TODO Auto-generated method stub

	}

}
