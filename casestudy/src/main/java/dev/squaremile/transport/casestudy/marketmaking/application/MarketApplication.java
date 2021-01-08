package dev.squaremile.transport.casestudy.marketmaking.application;

import dev.squaremile.asynctcp.api.transport.app.OnDuty;
import dev.squaremile.transport.casestudy.marketmaking.domain.MarketMessage;

public interface MarketApplication extends OnDuty
{
    void onMessage(MarketMessage marketMessage);
}
