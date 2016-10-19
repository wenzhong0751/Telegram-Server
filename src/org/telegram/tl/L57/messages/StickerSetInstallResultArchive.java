package org.telegram.tl.L57.messages;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class StickerSetInstallResultArchive extends org.telegram.tl.messages.TLStickerSetInstallResult {

    public static final int ID = 0x35e410a8;

    public TLVector<org.telegram.tl.TLStickerSetCovered> sets;

    public StickerSetInstallResultArchive() {
        this.sets = new TLVector<>();
    }

    public StickerSetInstallResultArchive(TLVector<org.telegram.tl.TLStickerSetCovered> sets) {
        this.sets = sets;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        sets = (TLVector<org.telegram.tl.TLStickerSetCovered>) buffer.readTLObject(APIContext.getInstance());
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(12);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeTLObject(sets);
    }


    public int getConstructor() {
        return ID;
    }
}