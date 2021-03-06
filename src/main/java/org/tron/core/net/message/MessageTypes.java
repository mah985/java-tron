package org.tron.core.net.message;

import java.util.HashMap;
import java.util.Map;

public enum MessageTypes {

  FIRST(0x00),

  TRX(0x01),

  BLOCK(0x02),

  TRXS(0x03),

  BLOCKS(0x04),

  BLOCKHEADERS(0x05),

  INVENTORY(0x06),

  FETCH_INV_DATA(0x07),

  SYNC_BLOCK_CHAIN(0x08),

  BLOCK_CHAIN_INVENTORY(0x09),

  ITEM_NOT_FOUND(0x10),

  FETCH_BLOCK_HEADERS(0x11),

  BLOCK_INVENTORY(0x12),

  TRX_INVENTORY(0x13),

  LAST(0xFF);

  private final int type;

  private static final Map<Integer, MessageTypes> intToTypeMap = new HashMap<>();

  static {
    for (MessageTypes type : MessageTypes.values()) {
      intToTypeMap.put(type.type, type);
    }
  }

  private MessageTypes(int type) {
    this.type = type;
  }

  public static MessageTypes fromByte(byte i) {
    return intToTypeMap.get((int) i);
  }

  public static boolean inRange(byte code) {
    return code < LAST.asByte();
  }

  public byte asByte() {
    return (byte) (type);
  }

  @Override
  public String toString() {
    switch (type) {
      case 1:
        return "TRX";
      case 2:
        return "BLOCK";
      case 6:
        return "INVENTORY";
      case 7:
        return "FETCH_INV_DATA";
      case 8:
        return "SYNC_BLOCK_CHAIN";
      case 11:
        return "BLOCK_INVENTORY";
    }
    return super.toString();
  }
}


