package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class UpdateContactLink extends org.telegram.tl.TLUpdate {

    public static final int ID = 0x9d2e67c5;

    public int user_id;
    public org.telegram.tl.TLContactLink my_link;
    public org.telegram.tl.TLContactLink foreign_link;

    public UpdateContactLink() {
    }

    public UpdateContactLink(int user_id, org.telegram.tl.TLContactLink my_link, org.telegram.tl.TLContactLink foreign_link) {
        this.user_id = user_id;
        this.my_link = my_link;
        this.foreign_link = foreign_link;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        user_id = buffer.readInt();
        my_link = (org.telegram.tl.TLContactLink) buffer.readTLObject(APIContext.getInstance());
        foreign_link = (org.telegram.tl.TLContactLink) buffer.readTLObject(APIContext.getInstance());
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
        buff.writeInt(user_id);
        buff.writeTLObject(my_link);
        buff.writeTLObject(foreign_link);
    }


    public int getConstructor() {
        return ID;
    }
}