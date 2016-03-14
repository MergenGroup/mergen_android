package com.boun.mergen.util;

import com.squareup.otto.Bus;

public final class BusProvider {

    private static BusProvider INSTANCE;

    public static BusProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BusProvider();
        }
        return INSTANCE;
    }

    private final Bus bus;

    private BusProvider() {
        this.bus = new Bus();
    }

    /**
     * Posts an event to all registered handlers.  This method will return successfully after the event has been posted to
     * all handlers, and regardless of any exceptions thrown by handlers.
     * <p/>
     * <p>If no handlers have been subscribed for {@code event}'s class, and {@code event} is not already a
     * {@link com.squareup.otto.DeadEvent}, it will be wrapped in a DeadEvent and reposted.
     *
     * @param event event to post.
     * @throws NullPointerException if the event is null.
     */
    public void post(Object event) {
        bus.post(event);
    }

    /**
     * Registers all handler methods on {@code object} to receive events and producer methods to provide events.
     * <p/>
     * If any subscribers are registering for types which already have a producer they will be called immediately
     * with the result of calling that producer.
     * <p/>
     * If any producers are registering for types which already have subscribers, each subscriber will be called with
     * the value from the result of calling the producer.
     *
     * @param object object whose handler methods should be registered.
     * @throws NullPointerException if the object is null.
     */
    public void register(Object object) {
        bus.register(object);
    }

    /**
     * Unregisters all producer and handler methods on a registered {@code object}.
     *
     * @param object object whose producer and handler methods should be unregistered.
     * @throws IllegalArgumentException if the object was not previously registered.
     * @throws NullPointerException     if the object is null.
     */
    public void unregister(Object object) {
        bus.unregister(object);
    }
}
