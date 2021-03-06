package org.batfish.representation.palo_alto;

import javax.annotation.Nullable;

/** Configurations specific to NSSA type OSPF area */
public class OspfAreaNssa implements OspfAreaTypeSettings {
  public enum DefaultRouteType {
    EXT_1,
    EXT_2
  }

  /** If not appearing in the config then default route is not disabled. */
  private static final boolean DEFAULT_DEFAULT_ROUTE_DISABLE = false;

  public OspfAreaNssa() {
    _defaultRouteDisable = DEFAULT_DEFAULT_ROUTE_DISABLE;
  }

  @Override
  public <T> T accept(OspfAreaTypeSettingsVisitor<T> visitor) {
    return visitor.visitOspfAreaNssa(this);
  }

  /**
   * If set then default route will not be advertised from this area
   *
   * @return true if no default route will be advertised from this area
   */
  public boolean isDefaultRouteDisable() {
    return _defaultRouteDisable;
  }

  public void setDefaultRouteDisable(boolean defaultRouteDisable) {
    _defaultRouteDisable = defaultRouteDisable;
  }

  @Nullable
  public Integer getDefaultRouteMetric() {
    return _defaultRouteMetric;
  }

  public void setDefaultRouteMetric(@Nullable Integer defaultRouteMetric) {
    _defaultRouteMetric = defaultRouteMetric;
  }

  @Nullable
  public DefaultRouteType getDefaultRouteType() {
    return _defaultRouteType;
  }

  public void setDefaultRouteType(@Nullable DefaultRouteType defaultRouteType) {
    _defaultRouteType = defaultRouteType;
  }

  @Nullable
  public Boolean getAcceptSummary() {
    return _acceptSummary;
  }

  public void setAcceptSummary(@Nullable Boolean acceptSummary) {
    _acceptSummary = acceptSummary;
  }

  //////////////////////////////////////////
  ///// Private implementation details /////
  //////////////////////////////////////////

  private boolean _defaultRouteDisable;
  @Nullable private Integer _defaultRouteMetric;
  @Nullable private DefaultRouteType _defaultRouteType;
  @Nullable private Boolean _acceptSummary;
}
