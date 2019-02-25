package fr.octo.craft.ddd;

import java.util.Objects;
import java.util.UUID;

public abstract class AggregateId {

    protected final String id;

    protected AggregateId() {
        this(UUID.randomUUID().toString());
    }

    protected AggregateId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AggregateId that = (AggregateId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
