package org.batfish.specifier;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import java.util.Objects;
import javax.annotation.Nonnull;

/** Identifies the {@link Location} of the link of an interface in the network. */
public final class InterfaceLinkLocation implements Location {
  private static final String PROP_INTERFACE_NAME = "interfaceName";
  private static final String PROP_NODE_NAME = "nodeName";

  @Nonnull private final String _interfaceName;

  @Nonnull private final String _nodeName;

  @JsonCreator
  public InterfaceLinkLocation(
      @JsonProperty(PROP_NODE_NAME) @Nonnull String nodeName,
      @JsonProperty(PROP_INTERFACE_NAME) @Nonnull String interfaceName) {
    _nodeName = nodeName;
    _interfaceName = interfaceName;
  }

  @Override
  public <T> T accept(LocationVisitor<T> visitor) {
    return visitor.visitInterfaceLinkLocation(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InterfaceLinkLocation)) {
      return false;
    }
    InterfaceLinkLocation that = (InterfaceLinkLocation) o;
    return _interfaceName.equals(that._interfaceName) && _nodeName.equals(that._nodeName);
  }

  @JsonProperty(PROP_INTERFACE_NAME)
  @Nonnull
  public String getInterfaceName() {
    return _interfaceName;
  }

  @Override
  @JsonProperty(PROP_NODE_NAME)
  @Nonnull
  public String getNodeName() {
    return _nodeName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(_interfaceName, _nodeName);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(getClass())
        .add(PROP_NODE_NAME, _nodeName)
        .add(PROP_INTERFACE_NAME, _interfaceName)
        .toString();
  }
}
