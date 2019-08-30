package org.batfish.representation.cisco;

import org.batfish.common.Warnings;
import org.batfish.datamodel.Configuration;
import org.batfish.datamodel.routing_policy.expr.NextHopExpr;
import org.batfish.datamodel.routing_policy.expr.PeerAddressNextHop;

public class RoutePolicyNextHopPeerAddress extends RoutePolicyNextHop {

  @Override
  public NextHopExpr toNextHopExpr(CiscoConfiguration cc, Configuration c, Warnings w) {
    return PeerAddressNextHop.getInstance();
  }
}