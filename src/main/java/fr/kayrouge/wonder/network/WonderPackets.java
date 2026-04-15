package fr.kayrouge.wonder.network;

import fr.kayrouge.wonder.network.serverbound.ServerboundOpenPlayerMenuPacket;

public class WonderPackets {

    public static void register() {
        ServerboundOpenPlayerMenuPacket.register();
    }

}
