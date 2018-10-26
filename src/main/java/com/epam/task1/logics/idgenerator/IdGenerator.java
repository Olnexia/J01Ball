package com.epam.task1.logics.idgenerator;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

public class IdGenerator {
    public long getId() {
        long value;
        do {
            UUID uid = UUID.randomUUID();
            ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
            buffer.putLong(uid.getLeastSignificantBits());
            buffer.putLong(uid.getMostSignificantBits());
            BigInteger bi = new BigInteger(buffer.array());
            value = bi.longValue();
        } while (value < 0);
        return value;
    }
}
