package mizurin.shieldmod.entities;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.net.entity.ITrackedEntry;
import net.minecraft.core.net.entity.IVehicleEntry;
import net.minecraft.core.net.packet.Packet23VehicleSpawn;
import net.minecraft.core.world.World;
import net.minecraft.server.entity.EntityTracker;
import net.minecraft.server.entity.EntityTrackerEntry;
import org.jetbrains.annotations.NotNull;

//This is used to render custom entities on servers
//Entity Thrown Shield.
public class NetShieldEntry
	implements IVehicleEntry<EntityShield>,
	ITrackedEntry<EntityShield> {
	@Override
	@NotNull
	public Class<EntityShield> getAppliedClass() {
		return EntityShield.class;
	}

	@Override
	public int getTrackingDistance() {
		return 64;
	}

	@Override
	public int getPacketDelay() {
		return 20;
	}

	@Override
	public boolean sendMotionUpdates() {
		return false;
	}

	@Override
	public void onEntityTracked(EntityTracker tracker, EntityTrackerEntry trackerEntry, EntityShield trackedObject) {
	}

	@Override
	public Entity getEntity(World world, double x, double y, double z, int metadata, boolean hasVelocity, double xd, double yd, double zd, Entity owner) {
		if (owner instanceof EntityLiving) {
			return new EntityShield(world, (EntityLiving) owner);
		} else {
			return new EntityShield(world, x, y, z);
		}
	}

	@Override
	public Packet23VehicleSpawn getSpawnPacket(EntityTrackerEntry tracker, EntityShield trackedObject) {
		System.out.println("SHIELD");
		EntityLiving entityliving = trackedObject.owner;
		return new Packet23VehicleSpawn(trackedObject, 0, entityliving == null ? -1 : entityliving.id, trackedObject.xd, trackedObject.yd, trackedObject.zd);
	}
}
