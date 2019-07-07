package roito.cultivage.client.event.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import roito.cultivage.registry.ItemsRegistry;

@Mod.EventBusSubscriber
public final class EventHandlerOverlay
{
	public final static ThermometerBarRenderer bar0 = new ThermometerBarRenderer(Minecraft.getMinecraft());
	public final static RainGaugeBarRenderer bar1 = new RainGaugeBarRenderer(Minecraft.getMinecraft());


	@SubscribeEvent(receiveCanceled = true)
	public static void onEvent(RenderGameOverlayEvent.Pre event)
	{
		EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().player;
		if (entityPlayerSP == null)
		{
			return;
		}
		else if (!entityPlayerSP.getHeldItemMainhand().isEmpty())
		{
			if (entityPlayerSP.getHeldItemMainhand().getItem().equals(ItemsRegistry.THERMOMETER))
			{
				bar0.renderStatusBar(event.getResolution().getScaledWidth(), event.getResolution().getScaledHeight(), entityPlayerSP.getEntityWorld().getBiome(entityPlayerSP.getPosition()).getTemperature(entityPlayerSP.getPosition()));
			}
			else if (entityPlayerSP.getHeldItemMainhand().getItem().equals(ItemsRegistry.RAIN_GAUGE))
			{
				bar1.renderStatusBar(event.getResolution().getScaledWidth(), event.getResolution().getScaledHeight(), entityPlayerSP.getEntityWorld().getBiome(entityPlayerSP.getPosition()).getRainfall());
			}
		}
	}
}