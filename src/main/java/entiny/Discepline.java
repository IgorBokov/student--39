package entiny;

public class Discepline {
    private int id;
    private String discepline;
    private int status = 1;

    public Discepline() {
    }

    public Discepline(int id, String discepline, int status) {
        this.id = id;
        this.discepline = discepline;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscepline() {
        return discepline;
    }

    public void setDiscepline(String discepline) {
        this.discepline = discepline;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discepline that = (Discepline) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (discepline != null ? !discepline.equals(that.discepline) : that.discepline != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (discepline != null ? discepline.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }

    @Override
    public String toString() {
        return "Discepline{" +
                "id=" + id +
                ", discepline='" + discepline + '\'' +
                ", status=" + status +
                '}';
    }
}
