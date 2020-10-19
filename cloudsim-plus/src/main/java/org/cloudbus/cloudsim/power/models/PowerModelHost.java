package org.cloudbus.cloudsim.power.models;

import org.cloudbus.cloudsim.hosts.Host;

/**
 * Abstract implementation of a host power model.
 * @since CloudSim Plus 6.0.0
 */
public abstract class PowerModelHost extends PowerModel {
    private Host host;

    /**
     * Gets the Host this PowerModel is collecting power consumption measurements from.
     * @return
     */
    public Host getHost() {
        return host;
    }

    /**
     * Sets the Host this PowerModel will collect power consumption measurements from.
     * @param host the Host to set
     * @return
     */
    public void setHost(Host host) {
        this.host = host;
    }

    /**
     * Computes the hosts power usage in Watts (W) at a certain degree of utilization.
     * Mainly for backwards compatibility.
     *
     * @param utilizationFraction the utilization percentage (between [0 and 1]) of the host.
     * @return the power supply in Watts (W)
     * @throws IllegalArgumentException if utilizationFraction is not between [0 and 1]
     */
    public abstract double getPower(double utilizationFraction) throws IllegalArgumentException;

}
