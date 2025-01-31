package me.vlod.pinto.networking.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import me.vlod.pinto.Utils;
import me.vlod.pinto.networking.NetworkHandler;

public class PacketContactRequest implements Packet {
    public String contactName;

    public PacketContactRequest() { }
    
    public PacketContactRequest(String contactName) {
    	this.contactName = contactName;
    }
    
	@Override
	public void read(DataInputStream stream) throws IOException {
		this.contactName = Utils.readPintoStringFromStream(stream, NetworkHandler.USERNAME_MAX);
	}
	
	@Override
	public void write(DataOutputStream stream) throws IOException {
		Utils.writePintoStringToStream(stream, this.contactName, NetworkHandler.USERNAME_MAX);
	}

	@Override
	public int getID() {
		return 9;
	}

	@Override
	public void handle(NetworkHandler netHandler) {
		netHandler.handleContactRequestPacket(this);
	}
}
