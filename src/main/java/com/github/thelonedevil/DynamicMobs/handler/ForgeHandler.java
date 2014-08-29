package com.github.thelonedevil.DynamicMobs.handler;

import com.github.thelonedevil.DynamicMobs.DMMain;
import com.github.thelonedevil.DynamicMobs.entity.ExtendedMob;
import com.github.thelonedevil.DynamicMobs.entity.ExtendedPlayer;
import com.github.thelonedevil.DynamicMobs.network.SyncEEP;
import com.github.thelonedevil.DynamicMobs.utlitiy.LogHelper;
import com.github.thelonedevil.DynamicMobs.utlitiy.Util;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Random;
import java.util.UUID;

/**
 * Created by justin on 14/08/2014.
 */
public class ForgeHandler {

    @SubscribeEvent
    public void onConstruction(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            ExtendedPlayer.register(event.entity);
        }
        if (event.entity instanceof EntityMob || event.entity instanceof EntitySlime || event.entity instanceof EntityGhast || event.entity instanceof EntityDragon) {
            if(ExtendedMob.get(event.entity) == null)
            ExtendedMob.register(event.entity);
        }
    }

    @SubscribeEvent
    public void onJoinWorld(EntityJoinWorldEvent event) {
        if (!event.entity.worldObj.isRemote) {
            if (event.entity instanceof EntityPlayer) {
                DMMain.network.sendTo(new SyncEEP((EntityPlayer) event.entity), (EntityPlayerMP) event.entity);

            }
            if (event.entity instanceof EntityMob) {
                int diff;
                switch (event.world.difficultySetting) {
                    case PEACEFUL:
                        diff = 0;
                        break;
                    case EASY:
                        diff = 1;
                        break;
                    case NORMAL:
                        diff = 2;
                        break;
                    case HARD:
                        diff = 3;
                        break;
                    default:
                        diff = 1;
                        break;
                }
                ExtendedMob mob = ExtendedMob.get(event.entity);
                EntityPlayer player = event.entity.worldObj.getClosestPlayerToEntity(event.entity, 128D);
                if (ConfigurationHandler.difficulty) {
                    mob.setDifficulty(diff);
                }
                if (player != null) {
                    if(ConfigurationHandler.players.contains(player.getCommandSenderName())){
                        return;
                    }
                    int level = ExtendedPlayer.get(player).getLevel();
                    int level1 = level + 3;
                    mob.setLevel(level1);
                    //LogHelper.info("MobLevel = " + level1);

                    double health = ((EntityMob) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();
                    ((EntityMob) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(((level1 * 0.8) * 3 + (health)));
                    ((EntityMob) event.entity).setHealth((float) (((level1 * 0.8) * 3 + (health))));
                    /*double damage = ((EntityMob) event.entity).getEntityAttribute(SharedMonsterAttributes.attackDamage).getBaseValue();
                    ((EntityMob) event.entity).getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((level1 * 0.8) * 1.6 + damage);*/
                } else {
                    mob.setLevel(3);
                }
            }
            if (event.entity instanceof EntitySlime) {
                int diff;
                switch (event.world.difficultySetting) {
                    case PEACEFUL:
                        diff = 0;
                        break;
                    case EASY:
                        diff = 1;
                        break;
                    case NORMAL:
                        diff = 2;
                        break;
                    case HARD:
                        diff = 3;
                        break;
                    default:
                        diff = 1;
                        break;
                }
                ExtendedMob mob = ExtendedMob.get(event.entity);
                EntityPlayer player = event.entity.worldObj.getClosestPlayerToEntity(event.entity, 128D);
                if (ConfigurationHandler.difficulty) {
                    mob.setDifficulty(diff);
                }
                if (player != null) {
                    int level = ExtendedPlayer.get(player).getLevel();
                    int level1 = level + 3;
                    mob.setLevel(level1);
                    double health = ((EntitySlime) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();

                            ((EntitySlime) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(((level1 * 0.8) * 3 + (health)));
                            ((EntitySlime) event.entity).setHealth((float) (((level1 * 0.8) * 3 + (health))));

                } else {
                    mob.setLevel(3);
                }
            }
            if (event.entity instanceof EntityGhast) {
                int diff;
                switch (event.world.difficultySetting) {
                    case PEACEFUL:
                        diff = 0;
                        break;
                    case EASY:
                        diff = 1;
                        break;
                    case NORMAL:
                        diff = 2;
                        break;
                    case HARD:
                        diff = 3;
                        break;
                    default:
                        diff = 1;
                        break;
                }
                ExtendedMob mob = ExtendedMob.get(event.entity);
                EntityPlayer player = event.entity.worldObj.getClosestPlayerToEntity(event.entity, 128D);
                if (ConfigurationHandler.difficulty) {
                    mob.setDifficulty(diff);
                }
                if (player != null) {
                    if(ConfigurationHandler.players.contains(player.getCommandSenderName())){
                        return;
                    }
                    int level = ExtendedPlayer.get(player).getLevel();
                    int level1 = level + 3;
                    mob.setLevel(level1);
                    double health = ((EntityGhast) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();


                            ((EntityGhast) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(((level1 * 0.8) * 3 + (health)));
                            ((EntityGhast) event.entity).setHealth((float) (((level1 * 0.8) * 3 + (health))));

                } else {
                    mob.setLevel(3);
                }
            }
            if (event.entity instanceof EntityDragon) {
                int diff;
                switch (event.world.difficultySetting) {
                    case PEACEFUL:
                        diff = 0;
                        break;
                    case EASY:
                        diff = 1;
                        break;
                    case NORMAL:
                        diff = 2;
                        break;
                    case HARD:
                        diff = 3;
                        break;
                    default:
                        diff = 1;
                        break;
                }
                ExtendedMob mob = ExtendedMob.get(event.entity);
                EntityPlayer player = event.entity.worldObj.getClosestPlayerToEntity(event.entity, 128D);
                if (ConfigurationHandler.difficulty) {
                    mob.setDifficulty(diff);
                }
                if (player != null) {
                    if(ConfigurationHandler.players.contains(player.getCommandSenderName())){
                        return;
                    }
                    int level = ExtendedPlayer.get(player).getLevel();
                    int level1 = level + 3;
                    mob.setLevel(level1);
                    double health = ((EntityDragon) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue();

                            ((EntityDragon) event.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(((level1 * 0.8) * 3 + (health)));
                            ((EntityDragon) event.entity).setHealth((float) (((level1 * 0.8) * 3 + (health))));

                } else {
                    mob.setLevel(3);
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerKill(LivingDeathEvent event) {
        DamageSource source = event.source;
        if (source.getSourceOfDamage() instanceof EntityPlayer) {
            if(ConfigurationHandler.players.contains(source.getSourceOfDamage().getCommandSenderName())){
                return;
            }
            EntityLivingBase e = event.entityLiving;
            if (e instanceof EntityMob || e instanceof EntitySlime || e instanceof EntityGhast || e instanceof EntityDragon) {
                ExtendedMob mob = ExtendedMob.get(e);
                int moblevel = mob.getLevel();
                int difficulty;
                if (ConfigurationHandler.difficulty) {
                    difficulty = mob.getDifficulty();
                } else {
                    difficulty = 1;
                }
                //LogHelper.info("mob level=" + moblevel);
                double xp = 0.0;
                if (e instanceof EntityCreeper) {
                    xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.creeperxp) * difficulty;
                } else if (e instanceof EntityZombie) {
                    xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.zombiexp) * difficulty;
                    if (e instanceof EntityPigZombie) {
                        xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.pigZombiexp) * difficulty;
                    }
                } else if (e instanceof EntitySkeleton) {
                    xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.skelexp) * difficulty;
                } else if (e instanceof EntitySpider) {
                    xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.spiderxp) * difficulty;
                    if (e instanceof EntityCaveSpider) {
                        xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.caveSpiderxp) * difficulty;
                    }
                } else if (e instanceof EntityEnderman) {
                    xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.endermanxp) * difficulty;

                } else if (e instanceof EntityGhast) {
                    xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.ghastxp) * difficulty;
                } else if (e instanceof EntityBlaze) {
                    xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.blazexp) * difficulty;
                } else if (e instanceof EntitySlime) {
                    if (e instanceof EntityMagmaCube) {
                        xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.magmaCubexp) * difficulty;
                    } else
                        xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.slimexp) * difficulty;
                } else if (e instanceof EntityWitch) {
                    xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.witchxp) * difficulty;
                } else if (e instanceof EntitySilverfish) {
                    xp = (((Math.pow(moblevel, 0.6))) * ConfigurationHandler.silverfishxp) * difficulty;
                }
                if (xp > 0) {
                    if (!source.getSourceOfDamage().worldObj.isRemote) {
                        UUID uuid = source.getSourceOfDamage().getUniqueID();
                        EntityPlayerMP epmp = Util.getPlayerFromUUID(uuid);
                        ExtendedPlayer.get(epmp).addXp(xp);
                        DMMain.network.sendTo(new SyncEEP((EntityPlayer) source.getSourceOfDamage()), epmp);
                    }

                }
            }

        }
    }
}
