package com.github.thelonedevil.DynamicMobs.entity;


import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;



public class ExtendedPlayer implements IExtendedEntityProperties {

    public static String ID = "RPGO";

    public double xp = 0;
    private boolean hasChanges;

    public static ExtendedPlayer get(Entity entity) {
        if (entity != null) {
            return (ExtendedPlayer) entity.getExtendedProperties(ID);
        }

        return null;
    }

    public static void register(Entity entity) {
        entity.registerExtendedProperties(ID, new ExtendedPlayer());
    }

    @Override
    public void saveNBTData(NBTTagCompound tag) {
        tag.setTag("rpgoData", createNBTTagCompound());
    }

    @Override
    public void loadNBTData(NBTTagCompound tag) {
        readFromNBT(tag.getCompoundTag("rpgoData"), true);
    }

    @Override
    public void init(Entity entity, World world) {

    }

    public void readFromNBT(NBTTagCompound tag, boolean fromPacket) {
       xp = tag.getDouble("xp");

        if (fromPacket) {
            hasChanges = true;
        }
    }

    public void writeToNBT(NBTTagCompound tag) {

        tag.setDouble("xp", xp);
    }

    public NBTTagCompound createNBTTagCompound() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        writeToNBT(tagCompound);
        return tagCompound;
    }

    public int getLevel() {
        return MathHelper.floor_double(Math.pow(xp / 100.0, 0.6));
    }
    public double getXp(){
        return xp;
    }

    public void addXp(double xp) {
        int oldlvl = this.getLevel();
        this.xp += xp;
        int newlvl = this.getLevel();
        if (newlvl > oldlvl) {
            levelUp(newlvl);
        }
    }

    private void levelUp(int newLvl) {
    }



}
