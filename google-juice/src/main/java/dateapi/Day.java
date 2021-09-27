package dateapi;

import lombok.experimental.Accessors;

import java.time.LocalDate;

@Accessors(fluent = true)
public final class Day implements Timed {
    private final LocalDate date;

    Day(LocalDate date) {
        this.date = date;
    }

    public static DayBuilder builder() {
        return new DayBuilder();
    }

    public LocalDate date() {
        return this.date;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Day)) return false;
        final Day other = (Day) o;
        final Object this$date = this.date();
        final Object other$date = other.date();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $date = this.date();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        return result;
    }

    public String toString() {
        return "Day(date=" + this.date() + ")";
    }

    public static class DayBuilder {
        private LocalDate date;

        DayBuilder() {
        }

        public DayBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Day build() {
            return new Day(date);
        }

        public String toString() {
            return "Day.DayBuilder(date=" + this.date + ")";
        }
    }
}
