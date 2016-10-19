package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class ChatFull extends org.telegram.tl.messages.TLChatFull {

    public static final int ID = 0x2e02a614;

    public int id;
    public org.telegram.tl.TLChatParticipants participants;
    public org.telegram.tl.photos.TLPhoto chat_photo;
    public org.telegram.tl.TLPeerNotifySettings notify_settings;
    public org.telegram.tl.TLExportedChatInvite exported_invite;
    public TLVector<org.telegram.tl.TLBotInfo> bot_info;

    public ChatFull() {
        this.bot_info = new TLVector<>();
    }

    public ChatFull(int id, org.telegram.tl.TLChatParticipants participants, org.telegram.tl.photos.TLPhoto chat_photo, org.telegram.tl.TLPeerNotifySettings notify_settings, org.telegram.tl.TLExportedChatInvite exported_invite, TLVector<org.telegram.tl.TLBotInfo> bot_info) {
        this.id = id;
        this.participants = participants;
        this.chat_photo = chat_photo;
        this.notify_settings = notify_settings;
        this.exported_invite = exported_invite;
        this.bot_info = bot_info;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        id = buffer.readInt();
        participants = (org.telegram.tl.TLChatParticipants) buffer.readTLObject(APIContext.getInstance());
        chat_photo = (org.telegram.tl.photos.TLPhoto) buffer.readTLObject(APIContext.getInstance());
        notify_settings = (org.telegram.tl.TLPeerNotifySettings) buffer.readTLObject(APIContext.getInstance());
        exported_invite = (org.telegram.tl.TLExportedChatInvite) buffer.readTLObject(APIContext.getInstance());
        bot_info = (TLVector<org.telegram.tl.TLBotInfo>) buffer.readTLObject(APIContext.getInstance());
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(48);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(id);
        buff.writeTLObject(participants);
        buff.writeTLObject(chat_photo);
        buff.writeTLObject(notify_settings);
        buff.writeTLObject(exported_invite);
        buff.writeTLObject(bot_info);
    }


    public int getConstructor() {
        return ID;
    }
}