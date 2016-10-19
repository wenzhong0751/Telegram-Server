/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl.L57;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.*;
import org.telegram.tl.L57.*;

public class InvokeAfterMsgs extends TLObject {

    public static final int ID = 0x3dc4b4f0;

    public TLVector<Long> msg_ids;
    public TLObject query;

    public InvokeAfterMsgs() {
        this.msg_ids = new TLVector<>();
    }

    public InvokeAfterMsgs(TLObject X, TLVector<Long> msg_ids, TLObject query) {
        this.msg_ids = msg_ids;
        this.query = query;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        msg_ids = (TLVector<Long>) buffer.readTLObject(APIContext.getInstance());
        query = buffer.readTLObject(APIContext.getInstance());
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeTLObject(msg_ids);
        buff.writeTLObject(query);
    }


    public int getConstructor() {
        return ID;
    }
}