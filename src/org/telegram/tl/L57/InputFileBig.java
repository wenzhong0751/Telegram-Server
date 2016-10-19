package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class InputFileBig extends org.telegram.tl.TLInputFile {

    public static final int ID = 0xfa4f0bb5;

    public long id;
    public int parts;
    public String name;

    public InputFileBig() {
    }

    public InputFileBig(long id, int parts, String name) {
        this.id = id;
        this.parts = parts;
        this.name = name;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        id = buffer.readLong();
        parts = buffer.readInt();
        name = buffer.readString();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(24);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeLong(id);
        buff.writeInt(parts);
        buff.writeString(name);
    }


    public int getConstructor() {
        return ID;
    }
}