package co.rsk.net.messages;

import org.ethereum.util.RLP;

import java.math.BigInteger;

/**
 * Created by ajlopez on 24/08/2017.
 */
public class GetBlockByHashMessage extends Message {
    private long id;
    private byte[] hash;

    public GetBlockByHashMessage(long id, byte[] hash) {
        this.id = id;
        this.hash = hash;
    }

    public long getId() { return this.id; }

    public byte[] getBlockHash() {
        return this.hash;
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.GET_BLOCK_BY_HASH_MESSAGE;
    }

    @Override
    public byte[] getEncodedMessage() {
        byte[] rlpId = RLP.encodeBigInteger(BigInteger.valueOf(this.id));
        byte[] rlpHash = RLP.encodeElement(this.hash);

        return RLP.encodeList(rlpId, rlpHash);
    }
}