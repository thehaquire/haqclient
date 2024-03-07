package com.haq.haqclient.feature

import com.haq.haqclient.util.Sender
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.inventory.GuiChest
import net.minecraft.inventory.ContainerChest
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent


class Terminals {


    @SubscribeEvent
    fun onGuiOpen(event: InitGuiEvent.Post) {
        if (event.gui != null && event.gui is GuiChest) {
            var cont: ContainerChest = event.gui.inventorySlots as ContainerChest
            if (cont.lowerChestInventory.displayName.unformattedText == "Click the button on time!") {
                rCmd("/pc melody!")
            }
        }
    }
}
private fun rCmd(st: String) {
    Minecraft.getMinecraft().thePlayer.sendChatMessage(st)
}
