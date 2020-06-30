package com;

import com.sun.jna.Library;

interface LibFunction extends Library
{
    // PortHandler functions
    public int portHandler(String str);

    public Boolean openPort                (int port_num);
    public void    closePort               (int port_num);
    public void    clearPort               (int port_num);

    public void    setPortName             (int port_num, String port_name);
    public String  getPortName             (int port_num);

    public Boolean setBaudRate             (int port_num, int baudrate);
    public int     getBaudRate             (int port_num);

    public int     readPort                (int port_num, byte[] packet, int length);
    public int     writePort               (int port_num, byte[] packet, int length);

    public void    setPacketTimeout        (int port_num, short packet_length);
    public void    setPacketTimeoutMSec    (int port_num, double msec);
    public Boolean isPacketTimeout         (int port_num);

    // PacketHandler functions
    public void    packetHandler           ();

    public String  getTxRxResult           (int protocol_version, int result);
    public String  getRxPacketError        (int protocol_version, byte error);

    public int     getLastTxRxResult       (int port_num, int protocol_version);
    public byte    getLastRxPacketError    (int port_num, int protocol_version);

    public void    setDataWrite            (int port_num, int protocol_version, short data_length, short data_pos, int data);
    public int     getDataRead             (int port_num, int protocol_version, short data_length, short data_pos);

    public void    txPacket                (int port_num, int protocol_version);

    public void    rxPacket                (int port_num, int protocol_version);

    public void    txRxPacket              (int port_num, int protocol_version);

    public void    ping                    (int port_num, int protocol_version, byte id);

    public int     pingGetModelNum         (int port_num, int protocol_version, byte id);

    // broadcastPing
    public void    broadcastPing           (int port_num, int protocol_version);
    public Boolean getBroadcastPingResult  (int port_num, int protocol_version, int id);

    public void    reboot                  (int port_num, int protocol_version, byte id);

    public void    clearMultiTurn          (int port_num, int protocol_version, byte id);

    public void    factoryReset            (int port_num, int protocol_version, byte id, byte option);

    public void    readTx                  (int port_num, int protocol_version, byte id, short address, short length);
    public void    readRx                  (int port_num, int protocol_version, short length);
    public void    readTxRx                (int port_num, int protocol_version, byte id, short address, short length);

    public void    read1ByteTx             (int port_num, int protocol_version, byte id, short address);
    public byte    read1ByteRx             (int port_num, int protocol_version);
    public byte    read1ByteTxRx           (int port_num, int protocol_version, byte id, short address);

    public void    read2ByteTx             (int port_num, int protocol_version, byte id, short address);
    public short   read2ByteRx             (int port_num, int protocol_version);
    public short   read2ByteTxRx           (int port_num, int protocol_version, byte id, short address);

    public void    read4ByteTx             (int port_num, int protocol_version, byte id, short address);
    public int     read4ByteRx             (int port_num, int protocol_version);
    public int     read4ByteTxRx           (int port_num, int protocol_version, byte id, short address);

    public void    writeTxOnly             (int port_num, int protocol_version, byte id, short address, short length);
    public void    writeTxRx               (int port_num, int protocol_version, byte id, short address, short length);

    public void    write1ByteTxOnly        (int port_num, int protocol_version, byte id, short address, byte data);
    public void    write1ByteTxRx          (int port_num, int protocol_version, byte id, short address, byte data);

    public void    write2ByteTxOnly        (int port_num, int protocol_version, byte id, short address, short data);
    public void    write2ByteTxRx          (int port_num, int protocol_version, byte id, short address, short data);

    public void    write4ByteTxOnly        (int port_num, int protocol_version, byte id, short address, int data);
    public void    write4ByteTxRx          (int port_num, int protocol_version, byte id, short address, int data);

    public void    regWriteTxOnly          (int port_num, int protocol_version, byte id, short address, short length);
    public void    regWriteTxRx            (int port_num, int protocol_version, byte id, short address, short length);

    public void    syncReadTx              (int port_num, int protocol_version, short start_address, short data_length, short param_length);
    // syncReadRx   -> GroupSyncRead
    // syncReadTxRx -> GroupSyncRead

    public void    syncWriteTxOnly         (int port_num, int protocol_version, short start_address, short data_length, short param_length);

    public void    bulkReadTx              (int port_num, int protocol_version, short param_length);
    // bulkReadRx   -> GroupBulkRead
    // bulkReadTxRx -> GroupBulkRead

    public void    bulkWriteTxOnly         (int port_num, int protocol_version, short param_length);

    // GroupBulkRead
    public int     groupBulkRead               (int port_num, int protocol_version);

    public Boolean groupBulkReadAddParam       (int group_num, byte id, short start_address, short data_length);
    public void    groupBulkReadRemoveParam    (int group_num, byte id);
    public void    groupBulkReadClearParam     (int group_num);

    public void    groupBulkReadTxPacket       (int group_num);
    public void    groupBulkReadRxPacket       (int group_num);
    public void    groupBulkReadTxRxPacket     (int group_num);

    public Boolean groupBulkReadIsAvailable    (int group_num, byte id, short address, short data_length);
    public int     groupBulkReadGetData        (int group_num, byte id, short address, short data_length);

    // GroupBulkWrite
    public int     groupBulkWrite              (int port_num, int protocol_version);

    public Boolean groupBulkWriteAddParam      (int group_num, byte id, short start_address, short data_length, int data, short input_length);
    public void    groupBulkWriteRemoveParam   (int group_num, byte id);
    public Boolean groupBulkWriteChangeParam   (int group_num, byte id, short start_address, short data_length, int data, short input_length, short data_pos);
    public void    groupBulkWriteClearParam    (int group_num);

    public void    groupBulkWriteTxPacket      (int group_num);

    // GroupSyncRead
    public int     groupSyncRead               (int port_num, int protocol_version, short start_address, short data_length);

    public Boolean groupSyncReadAddParam       (int group_num, byte id);
    public void    groupSyncReadRemoveParam    (int group_num, byte id);
    public void    groupSyncReadClearParam     (int group_num);

    public void    groupSyncReadTxPacket       (int group_num);
    public void    groupSyncReadRxPacket       (int group_num);
    public void    groupSyncReadTxRxPacket     (int group_num);

    public Boolean groupSyncReadIsAvailable    (int group_num, byte id, short address, short data_length);
    public int     groupSyncReadGetData        (int group_num, byte id, short address, short data_length);

    // groupSyncWrite
    public int     groupSyncWrite              (int port_num, int protocol_version, short start_address, short data_length);

    public Boolean groupSyncWriteAddParam      (int group_num, byte id, int data, short data_length);
    public void    groupSyncWriteRemoveParam   (int group_num, byte id);
    public Boolean groupSyncWriteChangeParam   (int group_num, byte id, int data, short data_length, short data_pos);
    public void    groupSyncWriteClearParam    (int group_num);

    public void    groupSyncWriteTxPacket      (int group_num);
}
