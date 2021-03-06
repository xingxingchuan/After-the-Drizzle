package cloud.lemonslice.afterthedrizzle.common.network;

import cloud.lemonslice.afterthedrizzle.AfterTheDrizzle;
import cloud.lemonslice.afterthedrizzle.common.capability.CapabilityPlayerTemperature;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PlayerTemperatureMessage implements INormalMessage
{
    int playerTemperature;
    int up;

    public PlayerTemperatureMessage(int temp, int up)
    {
        this.playerTemperature = temp;
        this.up = up;
    }

    public PlayerTemperatureMessage(PacketBuffer buf)
    {
        playerTemperature = buf.readInt();
        up = buf.readInt();
    }

    @Override
    public void toBytes(PacketBuffer buf)
    {
        buf.writeInt(playerTemperature);
        buf.writeInt(up);
    }

    @Override
    public void process(Supplier<NetworkEvent.Context> context)
    {
        context.get().enqueueWork(() ->
        {
            if (context.get().getDirection() == NetworkDirection.PLAY_TO_CLIENT)
                AfterTheDrizzle.proxy.getClientPlayer().getCapability(CapabilityPlayerTemperature.PLAYER_TEMP).ifPresent(t ->
                {
                    t.setPlayerTemperature(playerTemperature);
                    t.setHotterOrColder(up);
                });
        });
    }
}
