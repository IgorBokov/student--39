package entiny;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Term {     //семестр
    private int id;
    private String duration;   // длительность
    private int status = 1;
    private List<Discepline> disceplines = new ArrayList<>();

    public Term() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTerm(String term) {
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Discepline> getDisceplines() {
        return disceplines;
    }

    public void setDisceplines(List<Discepline> disceplines) {
        this.disceplines = disceplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term = (Term) o;

        if (id != term.id) return false;
        if (status != term.status) return false;
        if (!Objects.equals(duration, term.duration)) return false;
        return Objects.equals(disceplines, term.disceplines);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (disceplines != null ? disceplines.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disceplines=" + disceplines +
                '}';
    }
}
