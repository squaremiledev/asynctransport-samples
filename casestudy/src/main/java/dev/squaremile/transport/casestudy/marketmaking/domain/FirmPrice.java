package dev.squaremile.transport.casestudy.marketmaking.domain;

public class FirmPrice implements MarketMessage
{
    private long correlationId;
    private long updateTime;
    private long bidPrice;
    private int bidQuantity;
    private long askPrice;
    private int askQuantity;

    public FirmPrice(final long updateTime, final long bidPrice, final int bidQuantity, final long askPrice, final int askQuantity)
    {
        this(0, updateTime, bidPrice, bidQuantity, askPrice, askQuantity);
    }

    public FirmPrice(
            final int correlationId,
            final long updateTime,
            final long bidPrice,
            final int bidQuantity,
            final long askPrice,
            final int askQuantity
    )
    {
        this.correlationId = correlationId;
        this.updateTime = updateTime;
        this.bidPrice = bidPrice;
        this.bidQuantity = bidQuantity;
        this.askPrice = askPrice;
        this.askQuantity = askQuantity;
    }

    public static FirmPrice createNoPrice()
    {
        return new FirmPrice(0, 0, 0, 0, 0);
    }

    public static FirmPrice spreadFirmPrice(final long updateTime, final int quantity, final long basePrice, final int spread)
    {
        return new FirmPrice(updateTime, basePrice - spread, quantity, basePrice + spread, quantity);
    }

    public FirmPrice update(
            final long correlationId,
            final long updateTime,
            final long bidPrice,
            final int bidQuantity,
            final long askPrice,
            final int askQuantity
    )
    {
        this.correlationId = correlationId;
        this.updateTime = updateTime;
        this.bidPrice = bidPrice;
        this.bidQuantity = bidQuantity;
        this.askPrice = askPrice;
        this.askQuantity = askQuantity;
        return this;
    }

    public FirmPrice update(final long currentTime, final FirmPrice source)
    {
        this.correlationId = source.correlationId;
        this.askPrice = source.askPrice;
        this.askQuantity = source.askQuantity;
        this.bidPrice = source.bidPrice;
        this.bidQuantity = source.bidQuantity;
        this.updateTime = currentTime;
        return this;
    }

    public boolean execute(final long currentTime, final Order order, final Order executedOrderResult)
    {
        if (order.askQuantity() < 0 || order.bidQuantity() < 0 || (order.askQuantity() == 0 && order.bidQuantity() == 0))
        {
            return false;
        }
        if (order.bidQuantity() > 0 && (order.bidQuantity() > askQuantity || order.bidPrice() < askPrice))
        {
            return false;
        }
        if (order.askQuantity() > 0 && (order.askQuantity() > bidQuantity || order.askPrice() > bidPrice))
        {
            return false;
        }
        switch (order.side())
        {
            case BID:
                this.askQuantity -= order.bidQuantity();
                executedOrderResult.withBid(askPrice, order.bidQuantity());
                break;
            case ASK:
                this.bidQuantity -= order.askQuantity();
                executedOrderResult.withAsk(bidPrice, order.askQuantity());
                break;
            default:
                throw new IllegalArgumentException(order.side().name());
        }
        this.updateTime = currentTime;
        return true;
    }

    public long correlationId()
    {
        return correlationId;
    }

    public long updateTime()
    {
        return updateTime;
    }

    public long askPrice()
    {
        return askPrice;
    }

    public int askQuantity()
    {
        return askQuantity;
    }

    public long bidPrice()
    {
        return bidPrice;
    }

    public int bidQuantity()
    {
        return bidQuantity;
    }

    @Override
    public String toString()
    {
        return "FirmPrice{" +
               "correlationId=" + correlationId +
               ", updateTime=" + updateTime +
               ", bidPrice=" + bidPrice +
               ", bidQuantity=" + bidQuantity +
               ", askPrice=" + askPrice +
               ", askQuantity=" + askQuantity +
               '}';
    }
}
