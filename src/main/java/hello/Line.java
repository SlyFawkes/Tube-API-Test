package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Line {
    private String id;

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
}
