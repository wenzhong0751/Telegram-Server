package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class InputMediaContact extends org.telegram.tl.TLInputMedia {

    public static final int ID = 0xa6e45987;

    public String phone_number;
    public String first_name;
    public String last_name;

    public InputMediaContact() {
    }

    public InputMediaContact(String phone_number, String first_name, String last_name) {
        this.phone_number = phone_number;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        phone_number = buffer.readString();
        first_name = buffer.readString();
        last_name = buffer.readString();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(28);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeString(phone_number);
        buff.writeString(first_name);
        buff.writeString(last_name);
    }


    public int getConstructor() {
        return ID;
    }
}