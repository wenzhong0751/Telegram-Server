package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class KeyboardButtonRow extends org.telegram.tl.TLKeyboardButtonRow {

    public static final int ID = 0x77608b83;

    public TLVector<org.telegram.tl.TLKeyboardButton> buttons;

    public KeyboardButtonRow() {
        this.buttons = new TLVector<>();
    }

    public KeyboardButtonRow(TLVector<org.telegram.tl.TLKeyboardButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        buttons = (TLVector<org.telegram.tl.TLKeyboardButton>) buffer.readTLObject(APIContext.getInstance());
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
        buff.writeTLObject(buttons);
    }


    public int getConstructor() {
        return ID;
    }
}