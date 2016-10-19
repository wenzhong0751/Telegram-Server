package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class ChatInvite extends org.telegram.tl.TLChatInvite {

    public static final int ID = 0xdb74f558;

    public int flags;
    public String title;
    public org.telegram.tl.TLChatPhoto photo;
    public int participants_count;
    public TLVector<org.telegram.tl.TLUser> participants;

    public ChatInvite() {
        this.participants = new TLVector<>();
    }

    public ChatInvite(int flags, String title, org.telegram.tl.TLChatPhoto photo, int participants_count, TLVector<org.telegram.tl.TLUser> participants) {
        this.flags = flags;
        this.title = title;
        this.photo = photo;
        this.participants_count = participants_count;
        this.participants = participants;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        flags = buffer.readInt();
        title = buffer.readString();
        photo = (org.telegram.tl.TLChatPhoto) buffer.readTLObject(APIContext.getInstance());
        participants_count = buffer.readInt();
        if ((flags & (1 << 4)) != 0) {
            participants = (TLVector<org.telegram.tl.TLUser>) buffer.readTLVector(org.telegram.tl.TLUser.class);
        }
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(68);
        setFlags();
        serializeTo(buffer);
        return buffer;
    }

    public void setFlags() {
        if (participants != null) {
            flags |= (1 << 4);
        }
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(flags);
        buff.writeString(title);
        buff.writeTLObject(photo);
        buff.writeInt(participants_count);
        if ((flags & (1 << 4)) != 0) {
            buff.writeTLObject(participants);
        }
    }

    public boolean is_channel() {
        return (flags & (1 << 0)) != 0;
    }

    public void set_channel(boolean v) {
        if (v) {
            flags |= (1 << 0);
        } else {
            flags &= ~(1 << 0);
        }
    }

    public boolean is_broadcast() {
        return (flags & (1 << 1)) != 0;
    }

    public void set_broadcast(boolean v) {
        if (v) {
            flags |= (1 << 1);
        } else {
            flags &= ~(1 << 1);
        }
    }

    public boolean is_public() {
        return (flags & (1 << 2)) != 0;
    }

    public void set_public(boolean v) {
        if (v) {
            flags |= (1 << 2);
        } else {
            flags &= ~(1 << 2);
        }
    }

    public boolean is_megagroup() {
        return (flags & (1 << 3)) != 0;
    }

    public void set_megagroup(boolean v) {
        if (v) {
            flags |= (1 << 3);
        } else {
            flags &= ~(1 << 3);
        }
    }

    public int getConstructor() {
        return ID;
    }
}