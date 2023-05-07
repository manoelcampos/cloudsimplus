package org.cloudsimplus.core;

/**
 * An entity that can its start and shutdown delayed.
 * @author Manoel Campos da Silva Filho
 * @since CloudSim Plus 8.3.0
 */
public interface ExecDelayable extends Startable {
    /**
     * Get the time (in seconds) for the entity to finish starting up
     * or {@link #NOT_ASSIGNED} if not set (meaning the entity starts up rightaway).
     * @see #setStartupDelay(double)
     * @see #hasStartupDelay()
     */
    double getStartupDelay();

    /**
     * {@return true or false} whether the entity is starting up or not.
     */
    default boolean isStartingUp(){
        final double timeToCompleteStartup = getStartupCompletionTime();
        return hasStarted() && getSimulation().clock() < timeToCompleteStartup;
    }

    /**
     * {@return the relative time the entity is expected to finish starting up}.
     * If the entity hasn't started yet, returns only the relative time after
     * the entity starts it's expected to complete startup.
     */
    default double getStartupCompletionTime() {
        return Math.max(0, getStartTime()) + getStartupDelay();
    }

    /**
     * Set the time (in seconds) for the entity to finish starting up.
     * @see #getStartupDelay()
     */
    ExecDelayable setStartupDelay(double delay);

    /**
     *
     * {@return the remaining startup time} which indicates how much longer the startup process
     * will take (or zero if no startup delay was set or the startup has already completed).
     */
    default double getRemainingStartupTime(){
        final double readyTime = getStartupCompletionTime();
        final double remainingTime = Math.max(readyTime - getSimulation().clock(), 0);
        return hasStartupDelay() ? remainingTime : 0;
    }

    /** {@return true or false} whether the entity has a startup delay set or not.
     * @see #getStartupDelay()
     */
    default boolean hasStartupDelay(){
        return getStartupDelay() > 0;
    }

    /** {@return true or false} whether the entity shutdown is delayed or not. */
    default boolean isShutDownDelayed(){
        return getShutDownDelay() > 0;
    }

    /**
     * Get the time (in seconds) for the entity to finish shuting down
     * or {@link #NOT_ASSIGNED} if not set (meaning the entity shuts down rightaway).
     * @see #setShutDownDelay(double)
     */
    double getShutDownDelay();

    /**
     * Set the time (in seconds) for the entity to finish shuting down.
     * @see #getShutDownDelay()
     */
    ExecDelayable setShutDownDelay(double delay);
}
